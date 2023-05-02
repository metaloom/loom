package io.metaloom.loom.db.jooq.dao.asset.bin;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqBinary;
import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.model.asset.BinaryDao;

@Singleton
public class BinaryDaoImpl extends AbstractJooqDao<Binary> implements BinaryDao {

	@Inject
	public BinaryDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqBinary.BINARY;
	}

	@Override
	protected Class<? extends Binary> getPojoClass() {
		return BinaryImpl.class;
	}

	@Override
	public Binary createBinary(String sha512sum, long size) {
		Binary binary = new BinaryImpl();
		binary.setSHA256(sha512sum);
		binary.setSize(size);
		return binary;
	}

	@Override
	public Binary loadBySHA512Sum(String sha512sum) {
		return ctx()
			.select(getTable())
			.where(JooqBinary.BINARY.SHA512SUM.eq(sha512sum))
			.fetchOneInto(getPojoClass());
	}

	@Override
	public Binary loadByUuid(UUID uuid) {
		return load(uuid);
	}

}
