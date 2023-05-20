package io.metaloom.loom.rest.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.AssetGeoLocation;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AudioInfo;
import io.metaloom.loom.rest.model.asset.DocumentInfo;
import io.metaloom.loom.rest.model.asset.ImageInfo;
import io.metaloom.loom.rest.model.asset.VideoInfo;
import io.metaloom.loom.rest.model.asset.location.HashInfo;
import io.metaloom.loom.rest.model.asset.location.LocationReference;
import io.metaloom.loom.rest.model.asset.location.license.LicenseInfo;
import io.metaloom.loom.rest.model.asset.location.social.SocialInfo;
import io.metaloom.loom.rest.model.tag.TagReference;

public interface AssetModelBuilder extends ModelBuilder, UserModelBuilder, AssetLocationModelBuilder, TagModelBuilder, AnnotationModelBuilder {

	default List<LicenseInfo> assetLicense(Asset asset) {
		List<LicenseInfo> info = new ArrayList<>();
		return info;
	}

	default AssetGeoLocation assetGeoLocation(Asset asset) {
		AssetGeoLocation location = new AssetGeoLocation();
		Double lat = asset.getGeoLat() == null ? null : asset.getGeoLat().doubleValue();
		Double lon = asset.getGeoLon() == null ? null : asset.getGeoLon().doubleValue();
		location.setLat(lat);
		location.setLon(lon);
		location.setAlias(asset.getGeoAlias());
		return location;
	}

	default List<TagReference> assetTags(Asset asset) {
		List<Tag> tags = daos().tagDao().assetTags(asset);
		return tags.stream().map(tag -> toReference(tag)).collect(Collectors.toList());
	}

	default AssetResponse toResponse(Asset asset) {
		AssetResponse response = new AssetResponse();
		//response.setProcessStatus(null)
		//response.setKind(null)
		//response.setViews

		response.setUuid(asset.getUuid());
		response.setMeta(asset.getMeta());
		response.setMimeType(asset.getMimeType());
		response.setSize(asset.getSize());
		response.setHashes(assetHasheInfo(asset));
		response.setImage(assetImageInfo(asset));
		response.setVideo(assetVideoInfo(asset));
		response.setAudio(assetAudioInfo(asset));
		response.setDocument(assetDocumentInfo(asset));
		response.setSocial(assetSocialInfo(asset));
		response.setGeo(assetGeoLocation(asset));
		response.setLicenses(assetLicense(asset));
		response.setOrigin(asset.getInitialOrigin());
		response.setMeta(asset.getMeta());
		setStatus(asset, response);

		List<AssetLocation> locations = new ArrayList<>();
		List<LocationReference> locationRefs = locations.stream().map(this::toReference).collect(Collectors.toList());
		response.setLocations(locationRefs);

		response.setTags(assetTags(asset));
		List<Annotation> annotations = daos().annotationDao().loadForAsset(asset.getUuid());
		List<AnnotationResponse> restAnnotations = annotations.stream().map(this::toResponse).collect(Collectors.toList());
		response.setAnnotations(restAnnotations);

		response.setKind(null);
		// response.setViews();
		response.setCollections(null);

		return validator().validate(response);
	}

	default SocialInfo assetSocialInfo(Asset asset) {
		SocialInfo social = new SocialInfo();
		//daos().reactionDao()
		//social.setRating(rating)
		//social.setReactions(null);
		return social;
	}

	default HashInfo assetHasheInfo(Asset asset) {
		HashInfo hashes = new HashInfo();
		hashes.setSha512(asset.getSHA512());
		hashes.setSha256(asset.getSHA256());
		hashes.setMD5(asset.getMD5());
		return hashes;
	}

	default DocumentInfo assetDocumentInfo(Asset asset) {
		DocumentInfo info = new DocumentInfo();
		info.setWordCount(asset.getDocumentWordCount());
		return info;
	}

	default AudioInfo assetAudioInfo(Asset asset) {
		AudioInfo info = new AudioInfo();
		info.setBpm(asset.getAudioBPM());
		info.setChannels(asset.getAudioChannels());
		info.setDuration(asset.getMediaDuration());
		info.setEncoding(asset.getAudioEncoding());
		info.setFingerprint(asset.getAudioFingerprint());
		info.setSamplingRate(asset.getAudioSamplingRate());
		return info;
	}

	default VideoInfo assetVideoInfo(Asset asset) {
		VideoInfo info = new VideoInfo();
		info.setDuration(asset.getMediaDuration());
		// TODO use dedicated /asset/:uuid/embeddings endpoint for this
		// info.setEmbeddings();
		info.setEncoding(asset.getVideoEncoding());
		info.setFingerprint(asset.getVideoFingerprint());
		info.setHeight(asset.getMediaHeight());
		info.setWidth(asset.getMediaWidth());
		return info;
	}

	default ImageInfo assetImageInfo(Asset asset) {
		ImageInfo info = new ImageInfo();
		info.setDominantColor(asset.getDominantColor());
		info.setHeight(asset.getMediaHeight());
		info.setWidth(asset.getMediaWidth());
		return info;
	}

	default AssetListResponse toAssetList(Page<Asset> page) {
		return setPage(new AssetListResponse(), page, this::toResponse);
	}
}
