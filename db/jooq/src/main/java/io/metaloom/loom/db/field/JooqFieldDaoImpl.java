package io.metaloom.loom.db.field;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.reactivex.Maybe;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqFieldDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.FieldDao implements FieldDao {

	@Inject
	public JooqFieldDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.FIELD;
	// }

	@Override
	public Maybe<? extends Field> loadField(UUID uuid) {
		return wrap(findOneById(uuid), JooqFieldImpl.class);
	}

	@Override
	public void deleteField(Field content) {
		Objects.requireNonNull(content, "Field must not be null");
		deleteById(content.getUuid());
	}

	@Override
	public Field createField() {
		io.metaloom.loom.db.jooq.tables.pojos.Field content = new io.metaloom.loom.db.jooq.tables.pojos.Field();
		insert(content);
		return new JooqFieldImpl(content);
	}

	@Override
	public void updateField(Field content) {
		Objects.requireNonNull(content, "Field must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Field jooqField = unwrap(content);
		update(jooqField);
	}

	@Override
	public void storeField(Field content) {
		Objects.requireNonNull(content, "Field must not be null");
		update(unwrap(content));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
