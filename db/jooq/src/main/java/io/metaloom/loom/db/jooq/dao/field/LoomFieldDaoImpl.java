package io.metaloom.loom.db.jooq.dao.field;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.field.LoomField;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.FieldDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class LoomFieldDaoImpl extends AbstractDao implements LoomFieldDao {

	private final FieldDao dao;

	@Inject
	public LoomFieldDaoImpl(FieldDao dao, DSLContext ctx) {
		super(ctx);
		this.dao = dao;
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
	public LoomField createField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteField(LoomField content) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateField(LoomField content) {
		// TODO Auto-generated method stub
	}

	@Override
	public LoomField loadField(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
