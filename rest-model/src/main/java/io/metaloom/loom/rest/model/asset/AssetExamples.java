package io.metaloom.loom.rest.model.asset;

import io.metaloom.loom.rest.model.asset.info.AudioInfo;
import io.metaloom.loom.rest.model.asset.info.ConsistencyInfo;
import io.metaloom.loom.rest.model.asset.info.FileInfo;
import io.metaloom.loom.rest.model.asset.info.ImageInfo;
import io.metaloom.loom.rest.model.asset.info.MediaInfo;
import io.metaloom.loom.rest.model.asset.location.AssetLocationExamples;
import io.metaloom.loom.rest.model.example.ExampleValues;

public interface AssetExamples extends ExampleValues, AssetLocationExamples {

	default AssetResponse assetResponse() {
		AssetResponse model = new AssetResponse();
		setCreatorEditor(model);
		model.setUuid(uuidA());
		model.setFile(assetFileInfo());
		// model.getLicenses().add(new LicenseInfo().setName("license-name").setVersion("v1"));
		model.setMeta(meta());
		model.addLocation(locationReference());
		model.setGeo(assetGeoLocation())
			.setAnnotations(assetAnnotations());

		model.setImage(new ImageInfo().setDominantColor("#FFFF00"));
		model.setMedia(new MediaInfo().setDuration(20000L).setWidth(4000).setHeight(2250));
		model.setAudio(new AudioInfo().setBpm(120).setChannels(2).setSamplingRate(48000).setEncoding("mp3"));
		model.setMeta(meta());
		model.setHashes(assetHashes());

		model.getTags().add(tagReferenceA());
		// .setLocalPath("/opt/movies/bigbuckbunny-4k.mp4")
		// .setS3(new AssetS3Meta().setBucket("big_bucket").setKey("themovie"))
		// .setMimeType("video/mp4")
		return model;
	}

	default AssetReference assetReference() {
		AssetReference model = new AssetReference();
		model.setUuid(uuidA());
		model.setSha512sum(sha512sum());
		return model;
	}

	default AssetListResponse assetListResponse() {
		AssetListResponse model = new AssetListResponse();
		model.add(assetResponse());
		model.add(assetResponse());
		model.setMetainfo(pagingInfo());
		return model;
	}

	default AssetUpdateRequest assetUpdateRequest() {
		AssetUpdateRequest model = new AssetUpdateRequest();
		model.setImage(assetImageInfo())
			.setMeta(meta())
			.setFile(assetFileInfo())
			.setGeo(assetGeoLocation())
			.setTimeline(assetAnnotations());
		return model;
	}

	default ImageInfo assetImageInfo() {
		ImageInfo info = new ImageInfo();
		info.setDominantColor("#FFFF00");
		return info;
	}

	default AssetCreateRequest assetCreateRequest() {
		AssetCreateRequest model = new AssetCreateRequest();
		model.setImage(assetImageInfo())
			.setMeta(meta())
			.setGeo(assetGeoLocation())
			.setTimeline(assetAnnotations())
			.setFile(assetFileInfo());
		return model;
	}

	default ConsistencyInfo assetConsistencyInfo() {
		ConsistencyInfo info = new ConsistencyInfo();
		info.setZeroChunkCount(42L);
		return info;
	}

	default FileInfo assetFileInfo() {
		FileInfo info = new FileInfo();
		info.setSize(42L * 1000 * 1000);
		info.setFilename("bigbuckbunny-4k.mp4");
		info.setMimeType("video/mp4");
		info.setOrigin("https://www.youtube.com/watch?v=aqz-KE-bpKQ");
		info.setFirstSeen(DATE_OLD);
		return info;
	}

}
