package io.metaloom.loom.db.jooq.dao.model;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.model.Model;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ModelDaoImpl extends AbstractDao implements ModelDao{

	@Inject
	public ModelDaoImpl() {
	}
	
	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Model> createModel(String name, Consumer<Model> modifier) {
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
