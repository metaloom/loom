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
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class EmbeddingEndpointService extends AbstractCRUDEndpointService<EmbeddingDao, Embedding> {

	@Inject
	public EmbeddingEndpointService(EmbeddingDao embeddingDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(embeddingDao, daos, modelBuilder);
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
			UUID assetUuid = null;
			float[] data = null;
			EmbeddingType type = null;
			Long id = null;
			return dao().createEmbedding(lrc.userUuid(), assetUuid, data, type, id);
		}, embedding -> {
			return modelBuilder.toResponse(embedding);
		});
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		create(lrc, UPDATE_EMBEDDING, () -> {
			Embedding embedding = dao().load(uuid);
			UUID assetUuid = null;
			float[] data = null;
			EmbeddingType type = null;
			Long id = null;
			return dao().update(embedding);
		}, embedding -> {
			return modelBuilder.toResponse(embedding);
		});
	}
}
