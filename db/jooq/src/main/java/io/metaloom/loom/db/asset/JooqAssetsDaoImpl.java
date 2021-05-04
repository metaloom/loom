package io.metaloom.loom.db.asset;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.AssetDao;
import io.reactivex.Maybe;

public class JooqAssetsDaoImpl extends AbstractJooqDao implements AssetsDao {

	private final AssetDao delegate;

	protected JooqType getType() {
		return JooqType.ASSET;
	}

	public JooqAssetsDaoImpl(AssetDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Asset> loadAsset(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqAssetImpl.class);
	}

	@Override
	public void deleteAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		delegate.deleteById(asset.getUuid());
	}

	@Override
	public Asset createAsset() {
		io.metaloom.loom.db.jooq.tables.pojos.Asset asset = new io.metaloom.loom.db.jooq.tables.pojos.Asset();
		delegate.insert(asset);
		return new JooqAssetImpl(asset);
	}

	@Override
	public void updateAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Asset jooqAsset = unwrap(asset);
		delegate.update(jooqAsset);
	}

	@Override
	public void storeAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		delegate.update(unwrap(asset));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
