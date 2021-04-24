package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ContentExamples.tagReferenceList;

import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetReference;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetS3Meta;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;

public class AssetExamples extends AbstractExamples {

	public static AssetResponse assetResponse() {
		AssetResponse model = new AssetResponse();
		setCreatorEditor(model);
		model.setDuration(20000)
			.setDominantColor("#FFFF00")
			.setSize(2005225)
			.setWidth(4000)
			.setHeight(2250)
			.setHashes(assetHashes())
			.setLocalPath("/opt/movies/bigbuckbunny-4k.mp4")
			.setS3(new AssetS3Meta().setBucket("big_bucket").setKey("themovie"))
			.setMeta(meta())
			.setMimeType("video/mp4")
			.setLocation(assetLocation())
			.setTags(tagReferenceList())
			.setTimeline(assetTimeline())
			.setFilename("bigbuckbunny-4k.mp4");
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
			.setLocation(assetLocation())
			.setTags(tagReferenceList())
			.setTimeline(assetTimeline());
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
			.setLocation(assetLocation())
			.setTags(tagReferenceList())
			.setTimeline(assetTimeline());
		return model;
	}

	public static AssetReference assetReference() {
		AssetReference model = new AssetReference();
		model.setUuid(uuidC());
		return model;
	}
}
