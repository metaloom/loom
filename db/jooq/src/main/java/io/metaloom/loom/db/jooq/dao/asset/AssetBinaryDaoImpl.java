package io.metaloom.loom.db.jooq.dao.asset;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqAssetBinarieDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqAssetBinarie;
import io.metaloom.loom.db.model.asset.AssetBinary;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;

@Singleton
public class AssetBinaryDaoImpl extends AbstractJooqDao<JooqAssetBinarieDao> implements AssetBinaryDao {

	@Inject
	public AssetBinaryDaoImpl(JooqAssetBinarieDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public AssetBinary createBinary(String sha512sum, long size) {
		JooqAssetBinarie binary = new JooqAssetBinarie();
		binary.setUuid(UUID.randomUUID());
		binary.setSha512sum(sha512sum);
		binary.setSize(size);
		return wrap(binary);
	}

	@Override
	public void storeBinary(AssetBinary binary) {
		JooqAssetBinarie jooq = unwrap(binary);
		dao().insert(jooq);
	}

	@Override
	public void updateBinary(AssetBinary binary) {
		JooqAssetBinarie jooq = unwrap(binary);
		dao().update(jooq);
	}

	@Override
	public void deleteBinary(AssetBinary binary) {
		dao().deleteById(binary.getUuid());
	}

	@Override
	public AssetBinary loadBinary(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	@Override
	public AssetBinary loadBinary(String sha512sum) {
		List<JooqAssetBinarie> result = dao().fetchByJooqSha512sum(sha512sum);
		if (result.isEmpty()) {
			return null;
		} else {
			return wrap(result.get(0));
		}
	}

}
