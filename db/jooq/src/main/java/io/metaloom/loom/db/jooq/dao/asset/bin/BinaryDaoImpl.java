package io.metaloom.loom.db.jooq.dao.asset.bin;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqBinaryDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqBinary;
import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.model.asset.BinaryDao;

@Singleton
public class BinaryDaoImpl extends AbstractJooqDao<JooqBinaryDao> implements BinaryDao {

	@Inject
	public BinaryDaoImpl(JooqBinaryDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Binary createBinary(String sha512sum, long size) {
		JooqBinary binary = new JooqBinary();
		binary.setSha512sum(sha512sum);
		binary.setSize(size);
		return wrap(binary);
	}

	@Override
	public void storeBinary(Binary binary) {
		JooqBinary jooq = unwrap(binary);
		dao().insert(jooq);
	}

	@Override
	public void updateBinary(Binary binary) {
		JooqBinary jooq = unwrap(binary);
		dao().update(jooq);
	}

	@Override
	public void deleteBinary(Binary binary) {
		dao().deleteById(binary.getSHA512());
	}

	@Override
	public Binary loadBinaryBySHA512Sum(String sha512sum) {
		return wrap(dao().findById(sha512sum));
	}

	@Override
	public Binary loadBinaryByUuid(UUID uuid) {
		return wrap(dao().fetchByJooqUuid(uuid));
	}

}
