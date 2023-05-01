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
import io.metaloom.loom.db.jooq.tables.daos.JooqAssetDao;
import static io.metaloom.loom.db.jooq.tables.JooqAsset.*;
import io.metaloom.loom.db.jooq.tables.pojos.JooqAsset;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.page.Page;

@Singleton
public class AssetDaoImpl extends AbstractJooqDao<JooqAssetDao> implements AssetDao {

	@Inject
	public AssetDaoImpl(JooqAssetDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Asset loadAsset(UUID uuid) {
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
	public Tag loadTags(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Asset asset, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(Asset asset, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public Asset createAsset(String filename, UUID binaryUuid, UUID creatorUuid, UUID libraryUuid) {
		Objects.requireNonNull(creatorUuid, "Creator uuid must not be null");
		Objects.requireNonNull(libraryUuid, "Library uuid must not be null");
		Objects.requireNonNull(binaryUuid, "Binary uuid must not be null");
		JooqAsset asset = new JooqAsset();
		UUID newUuid = UUID.randomUUID();
		asset.setUuid(newUuid);
		asset.setPath(filename);
		asset.setCreated(LocalDateTime.now());
		asset.setCreatorUuid(creatorUuid);
		asset.setBinaryUuid(binaryUuid);
		return wrap(asset);
	}

	@Override
	public void storeAsset(Asset asset) {
		JooqAsset jooq = unwrap(asset);
		dao().insert(jooq);
	}

	@Override
	public void deleteAsset(Asset asset) {
		if (asset instanceof AssetImpl li) {
			dao().delete(li.delegate());
		} else {
			throw new LoomJooqException("Invalid type encountered.");
		}
	}

	@Override
	public void updateAsset(Asset asset) {
		JooqAsset jooq = unwrap(asset);
		dao().update(jooq);
	}

	@Override
	public Page<Asset> loadAssets(UUID fromUuid, int pageSize) {
		SelectSeekStep1<Record3<UUID, String, UUID>, UUID> query = dao().ctx()
			.select(ASSET.UUID, ASSET.PATH, ASSET.BINARY_UUID)
			.from(ASSET)
			.orderBy(ASSET.UUID);
		if (fromUuid != null) {
			query.seek(fromUuid);
		}
		List<Asset> list = query
			.limit(pageSize)
			.fetchStreamInto(JooqAsset.class)
			.map(AssetImpl::new)
			.collect(Collectors.toList());
		return new Page<>(list);
	}

}
