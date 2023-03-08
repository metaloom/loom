package io.metaloom.loom.db.jooq.dao.asset;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqAssetBinarieDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqAssetBinarie;
import io.metaloom.loom.db.model.asset.LoomAssetBinary;
import io.metaloom.loom.db.model.asset.LoomAssetBinaryDao;

@Singleton
public class LoomAssetBinaryDaoImpl extends AbstractJooqDao<JooqAssetBinarieDao> implements LoomAssetBinaryDao {

	@Inject
	public LoomAssetBinaryDaoImpl(JooqAssetBinarieDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public LoomAssetBinary createBinary(String sha512sum, long size) {
		JooqAssetBinarie binary = new JooqAssetBinarie();
		binary.setUuid(UUID.randomUUID());
		binary.setSha512sum(sha512sum);
		binary.setSize(size);
		return wrap(binary);
	}

	@Override
	public void storeBinary(LoomAssetBinary binary) {
		JooqAssetBinarie jooq = unwrap(binary);
		dao().insert(jooq);
	}

	@Override
	public void updateBinary(LoomAssetBinary binary) {
		JooqAssetBinarie jooq = unwrap(binary);
		dao().update(jooq);
	}

	@Override
	public void deleteBinary(LoomAssetBinary binary) {
		dao().deleteById(binary.getUuid());
	}

	@Override
	public LoomAssetBinary loadBinary(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	@Override
	public LoomAssetBinary loadBinary(String sha512sum) {
		List<JooqAssetBinarie> result = dao().fetchBySha512sum(sha512sum);
		if (result.isEmpty()) {
			return null;
		} else {
			return wrap(result.get(0));
		}
	}

}
