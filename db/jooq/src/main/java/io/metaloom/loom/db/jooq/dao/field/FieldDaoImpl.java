package io.metaloom.loom.db.jooq.dao.field;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.field.Field;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqFieldDao;

@Singleton
public class FieldDaoImpl extends AbstractJooqDao<JooqFieldDao> implements FieldDao {


	@Inject
	public FieldDaoImpl(JooqFieldDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	// protected JooqType getType() {
	// return JooqType.FIELD;
	// }

	// @Override
	// public Maybe<? extends LoomField> loadField(UUID uuid) {
	// return wrapMaybe(dao.findById(uuid), LoomFieldImpl.class);
	// }
	//
	// @Override
	// public Completable deleteField(LoomField content) {
	// Objects.requireNonNull(content, "Field must not be null");
	// return deleteById(content.getUuid()).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomField> createField() {
	// Field content = new Field();
	// insert(content);
	// return Single.just(new LoomFieldImpl(content));
	// }
	//
	// @Override
	// public Completable updateField(LoomField content) {
	// Objects.requireNonNull(content, "Field must not be null");
	// Field jooqField = unwrap(content);
	// return update(jooqField).ignoreElement();
	// }

	@Override
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public Field createField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteField(Field content) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateField(Field content) {
		// TODO Auto-generated method stub
	}

	@Override
	public Field loadField(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
