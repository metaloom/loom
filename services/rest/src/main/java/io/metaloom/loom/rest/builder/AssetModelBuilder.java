package io.metaloom.loom.rest.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.binary.Binary;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.AssetFilesystemLocation;
import io.metaloom.loom.rest.model.asset.AssetGeoLocation;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.binary.BinaryResponse;
import io.metaloom.loom.rest.model.tag.TagReference;

public interface AssetModelBuilder extends ModelBuilder, BinaryModelBuilder, TagModelBuilder, AnnotationModelBuilder {

	default AssetResponse toResponse(Asset asset) {
		AssetResponse response = new AssetResponse();
		Binary binary = daos().binaryDao().loadByUuid(asset.getBinaryUuid());
		BinaryResponse binaryResponse = toResponse(binary);
		response.setUuid(asset.getUuid());
		setStatus(asset, binaryResponse);
		response.setBinary(binaryResponse);
		response.setMeta(asset.getMeta());
		response.setLocation(assetLocation(asset));

		// TODO
		response.setTags(assetTags(asset));
		List<Annotation> annotations = daos().annotationDao().loadForAsset(asset.getUuid());
		List<AnnotationResponse> restAnnotations = annotations.stream().map(this::toResponse).collect(Collectors.toList());
		response.setAnnotations(restAnnotations);

		response.setGeo(assetGeoLocation(binary));
		response.setLicenses(null);
		response.setKind(null);
		response.setMimeType(null);
		response.setFilename(null);
		// response.setViews();
		// response.setSocial();
		response.setCollections(null);

		return response;
	}

	default AssetGeoLocation assetGeoLocation(Binary binary) {
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

	default AssetFilesystemLocation assetLocation(Asset asset) {
		AssetFilesystemLocation location = new AssetFilesystemLocation();
		location.setLastSeen(null);
		location.setPath(asset.getPath());
		location.setFilekey(null);
		return location;
	}

	default AssetListResponse toAssetList(Page<Asset> page) {
		return setPage(new AssetListResponse(), page, asset -> {
			return toResponse(asset);
		});
	}

}
