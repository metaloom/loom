package io.metaloom.loom.db.jooq.dao.model;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.ModelDao;
import io.metaloom.loom.db.model.model.LoomModel;
import io.metaloom.loom.db.model.model.LoomModelDao;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;

public class LoomModelDaoImpl extends AbstractDao implements LoomModelDao {

	private final ModelDao dao;

	@Inject
	public LoomModelDaoImpl(ModelDao dao, DSLContext ctx) {
		super(ctx);
		this.dao = dao;
	}

	@Override
	public LoomModel loadModel(UUID uuid) {
		return wrap(dao.findById(uuid), LoomModelImpl.class);
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
	public void clear() {
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
