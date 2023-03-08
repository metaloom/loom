package io.metaloom.loom.db.jooq.dao.model;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqModelDao;
import io.metaloom.loom.db.model.model.LoomModel;
import io.metaloom.loom.db.model.model.LoomModelDao;
import io.metaloom.loom.db.model.tag.LoomTag;

public class LoomModelDaoImpl extends AbstractJooqDao<JooqModelDao> implements LoomModelDao {

	@Inject
	public LoomModelDaoImpl(JooqModelDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public LoomModel loadModel(UUID uuid) {
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
	public Stream<LoomTag> loadTags(LoomModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(LoomModel model, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(LoomModel model, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public LoomModel createModel(String name, Consumer<LoomModel> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModel(LoomModel model) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateModel(LoomModel model) {
		// TODO Auto-generated method stub
	}

}
