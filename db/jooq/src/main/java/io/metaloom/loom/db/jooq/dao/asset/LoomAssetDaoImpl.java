package io.metaloom.loom.db.jooq.dao.asset;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.SelectSeekStep1;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.LoomJooqException;
import io.metaloom.loom.db.jooq.tables.Asset;
import io.metaloom.loom.db.jooq.tables.daos.JooqAssetDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqAsset;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.page.Page;

@Singleton
public class LoomAssetDaoImpl extends AbstractJooqDao<JooqAssetDao> implements LoomAssetDao {

	@Inject
	public LoomAssetDaoImpl(JooqAssetDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public LoomAsset loadAsset(UUID uuid) {
		JooqAsset element = dao().findById(uuid);
		if (element == null) {
			return null;
		}
		return wrap(element);
	}

	// @Override
	// public Completable deleteAsset(LoomAsset asset) {
	// Objects.requireNonNull(asset, "Asset must not be null");
	// return deleteById(asset.getUuid()).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomAsset> createAsset() {
	// Asset asset = new Asset();
	// insert(asset);
	// return insertReturningPrimary(asset).map(pk -> new LoomAssetImpl(asset.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateAsset(LoomAsset asset) {
	// Objects.requireNonNull(asset, "Asset must not be null");
	// Asset jooqAsset = unwrap(asset);
	// return update(jooqAsset).ignoreElement();
	// }

	@Override
	public LoomTag loadTags(LoomAsset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public LoomAsset createAsset(String filename, UUID binaryUuid, LoomUser creator, UUID namespaceUuid) {
		Objects.requireNonNull(creator, "Creator must not be null");
		JooqAsset asset = new JooqAsset();
		UUID newUuid = UUID.randomUUID();
		asset.setUuid(newUuid);
		asset.setFilename(filename);
		asset.setCreated(LocalDateTime.now());
		asset.setCreatorUuid(creator.getUuid());
		asset.setAssetBinariesUuid(binaryUuid);
		asset.setNamespaceUuid(namespaceUuid);
		return wrap(asset);
	}

	@Override
	public void storeAsset(LoomAsset asset) {
		JooqAsset jooq = unwrap(asset);
		dao().insert(jooq);
	}

	@Override
	public void deleteAsset(LoomAsset asset) {
		if (asset instanceof LoomAssetImpl li) {
			dao().delete(li.delegate());
		} else {
			throw new LoomJooqException("Invalid type encountered.");
		}
	}

	@Override
	public void updateAsset(LoomAsset asset) {
		JooqAsset jooq = unwrap(asset);
		dao().update(jooq);
	}

	@Override
	public Page<LoomAsset> loadAssets(UUID fromUuid, int pageSize) {
		SelectSeekStep1<Record3<UUID, String, UUID>, UUID> query = dao().ctx()
			.select(Asset.ASSET.UUID, Asset.ASSET.FILENAME, Asset.ASSET.ASSET_BINARIES_UUID)
			.from(Asset.ASSET)
			.orderBy(Asset.ASSET.UUID);
		if (fromUuid != null) {
			query.seek(fromUuid);
		}
		List<LoomAsset> list = query
			.limit(pageSize)
			.fetchStreamInto(JooqAsset.class)
			.map(LoomAssetImpl::new)
			.collect(Collectors.toList());
		return new Page<>(list);
	}

}
