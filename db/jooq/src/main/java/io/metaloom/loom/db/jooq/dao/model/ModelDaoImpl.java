package io.metaloom.loom.db.jooq.dao.model;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqModelDao;
import io.metaloom.loom.db.model.model.Model;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.tag.Tag;

public class ModelDaoImpl extends AbstractJooqDao<JooqModelDao> implements ModelDao {

	@Inject
	public ModelDaoImpl(JooqModelDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Model loadModel(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	// @Override
	// public Completable deleteModel(LoomModel model) {
	// Objects.requireNonNull(model, "Model must not be null");
	// return deleteById(model.getUuid()).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomModel> createModel() {
	// Model model = new Model();
	// return insertReturningPrimary(model).map(pk -> new LoomModelImpl(model.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateModel(LoomModel model) {
	// Objects.requireNonNull(model, "Model must not be null");
	// Model jooqModel = unwrap(model);
	// return update(jooqModel).ignoreElement();
	// }

	@Override
	public Stream<Tag> loadTags(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Model model, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(Model model, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public Model createModel(String name, Consumer<Model> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModel(Model model) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateModel(Model model) {
		// TODO Auto-generated method stub
	}

}
