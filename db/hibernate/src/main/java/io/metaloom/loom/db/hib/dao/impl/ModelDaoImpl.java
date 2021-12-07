package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.model.Model;
import io.metaloom.loom.db.model.model.ModelDao;
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
	public Single<? extends Model> createModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteModel(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateModel(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Model> loadModel(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
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
