package io.metaloom.loom.rest.model.example;

import java.util.UUID;

import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetFilesystemLocation;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetReference;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetS3Meta;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;
import io.metaloom.loom.rest.model.asset.FileKey;
import io.metaloom.loom.rest.model.asset.license.LicenseInfo;
import io.metaloom.loom.rest.model.binary.AudioInfo;
import io.metaloom.loom.rest.model.binary.BinaryResponse;
import io.metaloom.loom.rest.model.binary.ImageInfo;
import io.metaloom.loom.rest.model.binary.VideoInfo;

public class AssetExamples extends AbstractExamples {

	public static AssetResponse assetResponse() {
		AssetResponse model = new AssetResponse();
		setCreatorEditor(model);
		model.setUuid(UUID.randomUUID());
		model.getLicenses().add(new LicenseInfo().setName("license-name").setVersion("v1"));
		model.setMeta(meta());
		model.setLocation(new AssetFilesystemLocation().setFilekey(new FileKey().setInode(42).setStDev(12)).setLastSeen(DATE_NEW)
			.setPath("/the-current-path/bigbuckbunny-4k.mp4"));
		model.setGeo(assetGeoLocation())
			.setAnnotations(assetAnnotations())
			.setFilename("bigbuckbunny-4k.mp4");

		BinaryResponse bin = model.getBinary();
		bin.setImage(new ImageInfo().setWidth(800).setHeight(600).setDominantColor("#FFFF00"));
		bin.setVideo(new VideoInfo().setDuration(20000).setWidth(4000).setHeight(2250));
		bin.setAudio(new AudioInfo().setBpm(120).setChannels(2).setDuration(240).setSamplingRate(48000).setEncoding("mp3"));
		bin.setMeta(meta2())
			.setHashes(assetHashes())
			.setSize(2005225)
			.setFirstSeen(DATE_OLD)
			.setOrigin("/initialPath/bigbuckbunny-4k.mp4");

		// .setLocalPath("/opt/movies/bigbuckbunny-4k.mp4")
		// .setS3(new AssetS3Meta().setBucket("big_bucket").setKey("themovie"))
		// .setMimeType("video/mp4")
		return model;
	}

	public static AssetListResponse assetListResponse() {
		AssetListResponse model = new AssetListResponse();
		model.setMetainfo(pagingInfo());
		model.add(assetResponse());
		model.add(assetResponse());
		return model;
	}

	public static AssetCreateRequest assetCreateRequest() {
		AssetCreateRequest model = new AssetCreateRequest();
		model.setFilename("bigbuckbunny-4k.mp4")
			.setDominantColor("#FFFF00")
			.setLocalPath("/opt/movies/bigbuckbunny-4k.mp4")
			.setS3(new AssetS3Meta().setBucket("big_bucket").setKey("themovie"))
			.setMeta(meta())
			.setMimeType("video/mp4")
			.setLocation(assetGeoLocation())
			.setTimeline(assetAnnotations());
		return model;
	}

	public static AssetUpdateRequest assetUpdateRequest() {
		AssetUpdateRequest model = new AssetUpdateRequest();
		model.setFilename("bigbuckbunny-4k.mp4")
			.setDominantColor("#FFFF00")
			.setLocalPath("/opt/movies/bigbuckbunny-4k.mp4")
			.setS3(new AssetS3Meta().setBucket("big_bucket").setKey("themovie"))
			.setMeta(meta())
			.setMimeType("video/mp4")
			.setLocation(assetGeoLocation())
			.setTimeline(assetAnnotations());
		return model;
	}

	public static AssetReference assetReference() {
		AssetReference model = new AssetReference();
		model.setUuid(uuidC());
		return model;
	}
}
