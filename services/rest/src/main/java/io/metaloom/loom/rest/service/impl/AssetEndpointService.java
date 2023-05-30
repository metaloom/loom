package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.READ_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_ASSET;

import java.util.UUID;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetModel;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;
import io.metaloom.loom.rest.model.asset.info.AudioInfo;
import io.metaloom.loom.rest.model.asset.info.ConsistencyInfo;
import io.metaloom.loom.rest.model.asset.info.DocumentInfo;
import io.metaloom.loom.rest.model.asset.info.FileInfo;
import io.metaloom.loom.rest.model.asset.info.GeoLocationInfo;
import io.metaloom.loom.rest.model.asset.info.HashInfo;
import io.metaloom.loom.rest.model.asset.info.ImageInfo;
import io.metaloom.loom.rest.model.asset.info.MediaInfo;
import io.metaloom.loom.rest.model.asset.info.VideoInfo;
import io.metaloom.loom.rest.model.asset.location.AssetS3Meta;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;
import io.metaloom.utils.FloatUtils;
import io.metaloom.utils.UUIDUtils;
import io.metaloom.utils.hash.SHA512Sum;
import io.metaloom.video4j.fingerprint.v2.MultiSectorFingerprint;

@Singleton
public class AssetEndpointService extends AbstractCRUDEndpointService<AssetDao, Asset> {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpointService.class);

	@Inject
	public AssetEndpointService(AssetDao assetDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(assetDao, daos, modelBuilder, validator);
	}

	public void delete(LoomRoutingContext lrc, String sha512orUUID) {
		if (UUIDUtils.isUUID(sha512orUUID)) {
			delete(lrc, UUID.fromString(sha512orUUID));
		} else {
			SHA512Sum sha512 = SHA512Sum.fromString(sha512orUUID);
			delete(lrc, DELETE_ASSET, () -> {
				return dao().loadBySHA512(sha512);
			});
		}
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_ASSET, id);
	}

	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_ASSET, modelBuilder::toAssetList);
	}

	public void load(LoomRoutingContext lrc, String sha512orUUID) {
		if (UUIDUtils.isUUID(sha512orUUID)) {
			load(lrc, UUID.fromString(sha512orUUID));
		} else {
			SHA512Sum sha512 = SHA512Sum.fromString(sha512orUUID);
			load(lrc, () -> {
				return dao().loadBySHA512(sha512);
			});
		}
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID uuid) {
		load(lrc, () -> {
			return dao().load(uuid);
		});
	}

	private void load(LoomRoutingContext lrc, Supplier<Asset> loader) {
		load(lrc, READ_ASSET, () -> {
			return loader.get();
		}, modelBuilder::toResponse);
	}

	public void update(LoomRoutingContext lrc, String sha512orUUID) {
		if (UUIDUtils.isUUID(sha512orUUID)) {
			update(lrc, UUID.fromString(sha512orUUID));
		} else {
			update(lrc, () -> {
				return dao().loadBySHA512(SHA512Sum.fromString(sha512orUUID));
			});
		}
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		update(lrc, () -> {
			return dao().load(uuid);
		});
	}

	protected void update(LoomRoutingContext lrc, Supplier<Asset> loader) {
		update(lrc, UPDATE_ASSET, () -> {
			AssetUpdateRequest request = lrc.requestBody(AssetUpdateRequest.class);
			validator.validate(request);

			UUID userUuid = lrc.userUuid();
			Asset asset = loader.get();

			AssetS3Meta s3Info = request.getS3();
			if (s3Info != null) {
				update(s3Info::getBucket, asset::setS3BucketName);
				update(s3Info::getObjectPath, asset::setS3ObjectPath);
			}

			update(request, asset);

			setEditor(asset, userUuid);
			return asset;
		}, modelBuilder::toResponse);
	}

	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_ASSET, () -> {
			AssetCreateRequest request = lrc.requestBody(AssetCreateRequest.class);
			validator.validate(request);

			UUID userUuid = lrc.userUuid();
			HashInfo hashes = request.getHashes();

			// Mandatory fields
			String sha512sumStr = hashes.getSha512();
			SHA512Sum sha512sum = SHA512Sum.fromString(sha512sumStr);
			String mimeType = request.getFile().getMimeType();
			String filename = request.getFile().getFilename();
			String origin = request.getFile().getOrigin();
			Long size = request.getFile().getSize();

			Asset asset = dao().createAsset(userUuid, sha512sum, mimeType, filename, origin, size);
			update(request, asset);

			// Create initial embedding for asset
			if (request.getVideo() != null && request.getVideo().getFingerprint() != null) {
				MultiSectorFingerprint fp = MultiSectorFingerprint.of(request.getVideo().getFingerprint());
				Float[] vectorData = FloatUtils.floatToFloat(fp.vector());
				Embedding embedding = daos().embeddingDao().createEmbedding(userUuid, asset.getUuid(), vectorData,
					EmbeddingType.VIDEO4J_FINGERPRINT_V1, 0L);
			}
			// if (request.getAudio() != null && request.getAudio().getFingerprint() != null) {
			// Embedding embedding = daos().embeddingDao().createEmbedding(userUuid, asset.getUuid(), null, 0);
			// }

			return asset;
		}, modelBuilder::toResponse);
	}

	private void update(AssetModel<?> model, Asset asset) {
		update(model::getMeta, asset::setMeta);

		// update(request::getOrigin, asset::setInitialOrigin);
		// update(request::getZeroChunkCount, asset::setZeroChunkCount);
		// License
		// author
		// Annotations?
		// Tasks?
		// Reactions?
		// tags
		// lastSeen?
		// firstSeen? - created?
		// Collections
		// kind?
		// procesStatus?
		// views?
		FileInfo fileInfo = model.getFile();
		if (fileInfo != null) {
			update(fileInfo::getFirstSeen, asset::setFirstSeen);
			update(fileInfo::getFilename, asset::setFilename);
			update(fileInfo::getOrigin, asset::setInitialOrigin);
			update(fileInfo::getMimeType, asset::setMimeType);
			update(fileInfo::getSize, asset::setSize);
		}

		HashInfo hashes = model.getHashes();
		if (hashes != null) {
			update(hashes::getMD5, asset::setMD5);
			update(hashes::getSha256, asset::setSHA256);
			update(hashes::getSha512, asset::setSHA512);
		}

		ConsistencyInfo consistency = model.getConsistency();
		if (consistency != null) {
			update(consistency::getZeroChunkCount, asset::setZeroChunkCount);
		}

		ImageInfo imageInfo = model.getImage();
		if (imageInfo != null) {
			update(imageInfo::getDominantColor, asset::setDominantColor);
		}

		MediaInfo mediaInfo = model.getMedia();
		if (mediaInfo != null) {
			update(mediaInfo::getDuration, asset::setMediaDuration);
			update(mediaInfo::getHeight, asset::setMediaHeight);
			update(mediaInfo::getWidth, asset::setMediaWidth);
		}

		VideoInfo videoInfo = model.getVideo();
		if (videoInfo != null) {
			update(videoInfo::getFingerprint, asset::setVideoFingerprint);
			update(videoInfo::getEncoding, asset::setVideoEncoding);
			update(videoInfo::getBitrate, asset::setVideoBitrate);
		}

		AudioInfo audioInfo = model.getAudio();
		if (audioInfo != null) {
			update(audioInfo::getEncoding, asset::setAudioEncoding);
			update(audioInfo::getSamplingRate, asset::setAudioSampleRate);
			update(audioInfo::getBpm, asset::setAudioBPM);
			update(audioInfo::getChannels, asset::setAudioChannels);
			update(audioInfo::getFingerprint, asset::setAudioFingerprint);
			update(audioInfo::getBitrate, asset::setAudioBitrate);
		}

		GeoLocationInfo geoInfo = model.getGeo();
		if (geoInfo != null) {
			update(geoInfo::getLon, asset::setGeoLon);
			update(geoInfo::getLat, asset::setGeoLat);
			update(geoInfo::getAlias, asset::setGeoAlias);
		}

		DocumentInfo docInfo = model.getDocument();
		if (docInfo != null) {
			update(docInfo::getWordCount, asset::setDocumentWordCount);
		}

	}

}
