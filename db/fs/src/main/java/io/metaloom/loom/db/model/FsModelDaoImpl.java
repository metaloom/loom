package io.metaloom.loom.db.model;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.model.Model;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsModelDaoImpl extends AbstractFSDao implements ModelDao {

	@Inject
	public FsModelDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.MODEL;
	}

	@Override
	public Maybe<? extends Model> loadModel(UUID uuid) {
		return load(uuid, FsModelImpl.class);
	}

	@Override
	public Completable deleteModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		return delete(model.getUuid());
	}

	@Override
	public Single<? extends Model> createModel(String name, Consumer<Model> modifier) {
		Model model = new FsModelImpl();
		model.setUuid(UUIDUtil.randomUUID());
		if (modifier != null) {
			modifier.accept(model);
		}
		return store(model);
	}

	@Override
	public Completable updateModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		return store(model).ignoreElement();
	}

	@Override
	public Observable<Tag> loadTags(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(Model model, Tag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(Model model, Tag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
