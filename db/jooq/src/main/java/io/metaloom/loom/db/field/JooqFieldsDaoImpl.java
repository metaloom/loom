package io.metaloom.loom.db.field;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.FieldDao;
import io.reactivex.Maybe;

public class JooqFieldsDaoImpl extends AbstractJooqDao implements FieldsDao {

	private final FieldDao delegate;

	protected JooqType getType() {
		return JooqType.FIELD;
	}

	public JooqFieldsDaoImpl(FieldDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Field> loadField(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqFieldImpl.class);
	}

	@Override
	public void deleteField(Field content) {
		Objects.requireNonNull(content, "Field must not be null");
		delegate.deleteById(content.getUuid());
	}

	@Override
	public Field createField() {
		io.metaloom.loom.db.jooq.tables.pojos.Field content = new io.metaloom.loom.db.jooq.tables.pojos.Field();
		delegate.insert(content);
		return new JooqFieldImpl(content);
	}

	@Override
	public void updateField(Field content) {
		Objects.requireNonNull(content, "Field must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Field jooqField = unwrap(content);
		delegate.update(jooqField);
	}

	@Override
	public void storeField(Field content) {
		Objects.requireNonNull(content, "Field must not be null");
		delegate.update(unwrap(content));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
