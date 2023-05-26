package io.metaloom.loom.core.endpoint.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.model.assertj.Assertions;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;
import io.metaloom.loom.rest.model.asset.info.AudioInfo;
import io.metaloom.loom.rest.model.asset.info.DocumentInfo;
import io.metaloom.loom.rest.model.asset.info.FileInfo;
import io.metaloom.loom.rest.model.asset.info.GeoLocationInfo;
import io.metaloom.loom.rest.model.asset.info.HashInfo;
import io.metaloom.loom.rest.model.asset.info.ImageInfo;
import io.metaloom.loom.rest.model.asset.info.VideoInfo;

public class AssetEndpointTest extends AbstractCRUDEndpointTest {

	@Override
	protected void testCreate(LoomHttpClient client) throws HttpErrorException {
		AssetCreateRequest request = new AssetCreateRequest();
		request.setLocalPath("/tmp/test.png");
		request.setMeta(meta());
		request.setOrigin(INITIAL_ORIGIN);

		FileInfo fileInfo = new FileInfo();
		fileInfo.setMimeType(IMAGE_MIMETYPE);
		fileInfo.setFilename("test.png");
		fileInfo.setSize(42L * 1024);
		request.setFile(fileInfo);

		HashInfo hashes = new HashInfo();
		hashes.setSha256(SHA256SUM);
		hashes.setMD5(MD5SUM);
		hashes.setSha512(SHA512SUM);
		request.setHashes(hashes);

		AudioInfo audioInfo = new AudioInfo();
		audioInfo.setBpm(140);
		audioInfo.setDuration(242L);
		audioInfo.setBitrate(320 * 1024);
		audioInfo.setChannels(2);
		audioInfo.setEncoding("FLAC");
		audioInfo.setFingerprint(AUDIO_FINGERPRINT);
		audioInfo.setSamplingRate(44100);
		request.setAudio(audioInfo);

		VideoInfo videoInfo = new VideoInfo();
		videoInfo.setBitrate(40_000);
		videoInfo.setDuration(242L);
		videoInfo.setWidth(800);
		videoInfo.setHeight(600);
		videoInfo.setFingerprint(VIDEO_FINGERPRINT);
		videoInfo.setEncoding("H265");
		request.setVideo(videoInfo);

		DocumentInfo docInfo = new DocumentInfo();
		docInfo.setWordCount(42L);
		request.setDocument(docInfo);

		ImageInfo imageInfo = new ImageInfo();
		imageInfo.setDominantColor(DOMINANT_COLOR);
		imageInfo.setWidth(800);
		imageInfo.setHeight(600);
		request.setImage(imageInfo);

		GeoLocationInfo geoInfo = new GeoLocationInfo();
		geoInfo.setAlias("Zoo");
		geoInfo.setLat(42.0);
		geoInfo.setLon(41.0);
		request.setGeo(geoInfo);

		AssetResponse response = client.storeAsset(request).sync();
		Assertions.assertThat(response).matches(request);
	}

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		AssetResponse response = client.loadAsset(ASSET_UUID).sync();
		assertNotNull(response);
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteAsset(ASSET_UUID).sync();
		expect(404, "Not Found", client.loadAsset(ASSET_UUID));
	}

	@Override
	protected void testUpdate(LoomHttpClient client) throws HttpErrorException {
		final String NEW_NAME = "the_new_local_path.jpg";
		AssetUpdateRequest request = new AssetUpdateRequest();
		request.setLocalPath(NEW_NAME);
		AssetResponse response = client.updateAsset(ASSET_UUID, request).sync();
		assertEquals(NEW_NAME, response.getLocations().get(0).getPath());

		AssetResponse loadResponse = client.loadAsset(ASSET_UUID).sync();
		assertEquals(NEW_NAME, loadResponse.getLocations().get(0).getPath());
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws HttpErrorException {
		for (int i = 0; i < 100; i++) {
			AssetCreateRequest request = new AssetCreateRequest();
			request.getFile().setFilename("test_" + i + ".png");
			request.setLocalPath("/tmp/test_" + i + ".png");
			client.storeAsset(request).sync();
		}

		AssetListResponse response = client.listAssets().sync();
		assertNotNull(response);
	}

}