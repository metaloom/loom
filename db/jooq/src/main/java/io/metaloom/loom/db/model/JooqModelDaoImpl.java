package io.metaloom.loom.db.model;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.ModelDao;
import io.metaloom.loom.db.jooq.tables.pojos.Model;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqModelDaoImpl extends ModelDao implements LoomModelDao {

	@Inject
	public JooqModelDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public Maybe<? extends LoomModel> loadModel(UUID uuid) {
		return wrap(findOneById(uuid), JooqModelImpl.class);
	}

	@Override
	public Completable deleteModel(LoomModel model) {
		Objects.requireNonNull(model, "Model must not be null");
		return deleteById(model.getUuid()).ignoreElement();
	}

	@Override
	public Single<? extends LoomModel> createModel() {
		Model model = new Model();
		return insertReturningPrimary(model).map(pk -> new JooqModelImpl(model.setUuid(pk)));
	}

	@Override
	public Completable updateModel(LoomModel model) {
		Objects.requireNonNull(model, "Model must not be null");
		Model jooqModel = unwrap(model);
		return update(jooqModel).ignoreElement();
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

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}
}
