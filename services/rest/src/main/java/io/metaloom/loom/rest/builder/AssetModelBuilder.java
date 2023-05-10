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
import io.metaloom.loom.rest.model.asset.location.HashInfo;
import io.metaloom.loom.rest.model.asset.location.LocationReference;
import io.metaloom.loom.rest.model.asset.location.license.LicenseInfo;
import io.metaloom.loom.rest.model.binary.AssetGeoLocation;
import io.metaloom.loom.rest.model.binary.AssetListResponse;
import io.metaloom.loom.rest.model.binary.AssetResponse;
import io.metaloom.loom.rest.model.binary.AudioInfo;
import io.metaloom.loom.rest.model.binary.DocumentInfo;
import io.metaloom.loom.rest.model.binary.ImageInfo;
import io.metaloom.loom.rest.model.binary.VideoInfo;
import io.metaloom.loom.rest.model.tag.TagReference;

public interface AssetModelBuilder extends ModelBuilder, UserModelBuilder, LocationModelBuilder, TagModelBuilder, AnnotationModelBuilder  {



	default List<LicenseInfo> assetLicense(Asset asset) {
		List<LicenseInfo> info = new ArrayList<>();
		return info;
	}

	default AssetGeoLocation assetGeoLocation(Asset binary) {
		AssetGeoLocation location = new AssetGeoLocation();
		Double lat = binary.getGeoLat() == null ? null : binary.getGeoLat().doubleValue();
		Double lon = binary.getGeoLon() == null ? null : binary.getGeoLon().doubleValue();
		location.setLat(lat);
		location.setLon(lon);
		location.setAlias(binary.getGeoAlias());
		return location;
	}

	default List<TagReference> assetTags(Asset asset) {
		List<Tag> tags = daos().tagDao().assetTags(asset);
		return tags.stream().map(tag -> toReference(tag)).collect(Collectors.toList());
	}

	default AssetResponse toResponse(Asset asset) {
		AssetResponse response = new AssetResponse();
		response.setUuid(asset.getUuid());
		response.setMeta(asset.getMeta());
		response.setMimeType(asset.getMimeType());
		response.setHashes(binaryHasheInfo(asset));
		response.setSize(asset.getSize());
		response.setImage(binaryImageInfo(asset));
		response.setVideo(binaryVideoInfo(asset));
		response.setAudio(binaryAudioInfo(asset));
		response.setDocument(binaryDocumentInfo(asset));
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
		// response.setSocial();
		response.setCollections(null);

		return response;
	}

	default HashInfo binaryHasheInfo(Asset binary) {
		HashInfo hashes = new HashInfo();
		hashes.setSha512(binary.getSHA512());
		hashes.setSha256(binary.getSHA256());
		hashes.setMD5(binary.getMD5());
		return hashes;
	}

	default DocumentInfo binaryDocumentInfo(Asset binary) {
		DocumentInfo info = new DocumentInfo();
		info.setWordCount(binary.getDocumentWordCount());
		return info;
	}

	default AudioInfo binaryAudioInfo(Asset binary) {
		AudioInfo info = new AudioInfo();
		info.setBpm(binary.getAudioBPM());
		info.setChannels(binary.getAudioChannels());
		info.setDuration(binary.getMediaDuration());
		info.setEncoding(binary.getAudioEncoding());
		info.setFingerprint(binary.getAudioFingerprint());
		info.setSamplingRate(binary.getAudioSamplingRate());
		return info;
	}

	default VideoInfo binaryVideoInfo(Asset binary) {
		VideoInfo info = new VideoInfo();
		info.setDuration(binary.getMediaDuration());
		// TODO use dedicated /binary/:uuid/embeddings endpoint for this
		//info.setEmbeddings();
		info.setEncoding(binary.getVideoEncoding());
		info.setFingerprint(binary.getVideoFingerprint());
		info.setHeight(binary.getMediaHeight());
		info.setWidth(binary.getMediaWidth());
		return info;
	}

	default ImageInfo binaryImageInfo(Asset binary) {
		ImageInfo info = new ImageInfo();
		info.setDominantColor(binary.getDominantColor());
		info.setHeight(binary.getMediaHeight());
		info.setWidth(binary.getMediaWidth());
		return info;
	}

	default AssetListResponse toAssetList(Page<Asset> page) {
		return setPage(new AssetListResponse(), page, binary -> {
			return toResponse(binary);
		});
	}
}
