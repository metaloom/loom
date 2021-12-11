package io.metaloom.loom.db.hib.dao.model;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.model.Model;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.model.impl.ModelImpl;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class ModelDaoImpl extends AbstractDao implements ModelDao {

	public static final String TYPE_NAME = "Model";

	@Inject
	public ModelDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends Model> createModel(String name, Consumer<Model> modifier) {
		return Single.defer(() -> {
			if (name== null) {
				return Single.error(new NullPointerException("Name must be set"));
			}
			Model model = new ModelImpl(name);
			if (modifier != null) {
				modifier.accept(model);
			}
			return persistAndReturnElement(model);
		});
	}

	@Override
	public Completable deleteModel(Model model) {
		return deleteElement(model);
	}

	@Override
	public Completable updateModel(Model model) {
		return persistElement(model);
	}

	@Override
	public Maybe<? extends Model> loadModel(UUID uuid) {
		return loadByUuid(ModelImpl.class, uuid);
	}

	@Override
	public Completable removeTag(Model model, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(Model model, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Tag> loadTags(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
