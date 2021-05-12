package io.metaloom.loom.db.model;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.tag.LoomTag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsModelDaoImpl extends AbstractFSDao implements LoomModelDao {

	@Inject
	public FsModelDaoImpl(LoomDaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.MODEL;
	}

	@Override
	public Maybe<? extends LoomModel> loadModel(UUID uuid) {
		return load(uuid, FsModelImpl.class);
	}

	@Override
	public Completable deleteModel(LoomModel model) {
		Objects.requireNonNull(model, "Model must not be null");
		return delete(model.getUuid());
	}

	@Override
	public Single<? extends LoomModel> createModel() {
		LoomModel model = new FsModelImpl();
		model.setUuid(UUIDUtil.randomUUID());
		return store(model);
	}

	@Override
	public Completable updateModel(LoomModel model) {
		Objects.requireNonNull(model, "Model must not be null");
		return store(model).ignoreElement();
	}

	@Override
	public Observable<LoomTag> loadTags(LoomModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(LoomModel model, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(LoomModel model, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
