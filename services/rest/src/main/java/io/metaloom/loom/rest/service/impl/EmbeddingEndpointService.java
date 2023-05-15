package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_EMBEDDING;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_EMBEDDING;
import static io.metaloom.loom.db.model.perm.Permission.READ_EMBEDDING;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_EMBEDDING;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.embedding.EmbeddingType;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.embedding.EmbeddingCreateRequest;
import io.metaloom.loom.rest.model.embedding.EmbeddingUpdateRequest;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;
import io.metaloom.utils.FloatUtils;

@Singleton
public class EmbeddingEndpointService extends AbstractCRUDEndpointService<EmbeddingDao, Embedding> {

	@Inject
	public EmbeddingEndpointService(EmbeddingDao embeddingDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(embeddingDao, daos, modelBuilder, validator);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID uuid) {
		delete(lrc, DELETE_EMBEDDING, uuid);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_EMBEDDING, () -> {
			return dao().loadPage(null, 0);
		}, page -> {
			return modelBuilder.toEmbeddingList(page);
		});
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID uuid) {
		load(lrc, READ_EMBEDDING, () -> {
			return dao().load(uuid);
		}, embedding -> {
			return modelBuilder.toResponse(embedding);
		});
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_EMBEDDING, () -> {
			EmbeddingCreateRequest request = lrc.requestBody(EmbeddingCreateRequest.class);
			validator.validate(request);

			Float[] data = request.getData();
			EmbeddingType type = request.getType() == null ? null : EmbeddingType.valueOf(request.getType().name());
			Long id = request.getId();
			UUID assetUuid = request.getAssetUuid();
			return dao().createEmbedding(lrc.userUuid(), assetUuid, data, type, id);
		}, embedding -> {
			return modelBuilder.toResponse(embedding);
		});
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		create(lrc, UPDATE_EMBEDDING, () -> {
			EmbeddingUpdateRequest request = lrc.requestBody(EmbeddingUpdateRequest.class);
			validator.validate(request);

			Embedding embedding = dao().load(uuid);
			UUID assetUuid = request.getAssetUuid();
			embedding.setAssetUuid(assetUuid);
			Float[] data = request.getData();
			embedding.setData(data);
			EmbeddingType type = request.getType() == null ? null : EmbeddingType.valueOf(request.getType().name());
			if (type != null) {
				embedding.setType(type);
			}
			Long id = request.getId();
			return dao().update(embedding);
		}, embedding -> {
			return modelBuilder.toResponse(embedding);
		});
	}
}
