package io.metaloom.loom.db.model;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqModelDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.ModelDao implements ModelDao {

	@Inject
	public JooqModelDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public Maybe<? extends Model> loadModel(UUID uuid) {
		return wrap(findOneById(uuid), JooqModelImpl.class);
	}

	@Override
	public void deleteModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		deleteById(model.getUuid());
	}

	@Override
	public Model createModel() {
		io.metaloom.loom.db.jooq.tables.pojos.Model model = new io.metaloom.loom.db.jooq.tables.pojos.Model();
		insert(model);
		return new JooqModelImpl(model);
	}

	@Override
	public void updateModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Model jooqModel = unwrap(model);
		update(jooqModel);
	}

	@Override
	public void storeModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		update(unwrap(model));
	}

	@Override
	public Observable<Tag> loadTags(Model model) {
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
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
