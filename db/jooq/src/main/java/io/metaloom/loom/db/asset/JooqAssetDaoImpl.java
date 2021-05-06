package io.metaloom.loom.db.asset;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqAssetDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.AssetDao implements AssetDao {

	@Inject
	public JooqAssetDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ASSET;
	// }

	@Override
	public Maybe<? extends Asset> loadAsset(UUID uuid) {
		return wrap(findOneById(uuid), JooqAssetImpl.class);
	}

	@Override
	public void deleteAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		deleteById(asset.getUuid());
	}

	@Override
	public Asset createAsset() {
		io.metaloom.loom.db.jooq.tables.pojos.Asset asset = new io.metaloom.loom.db.jooq.tables.pojos.Asset();
		insert(asset);
		return new JooqAssetImpl(asset);
	}

	@Override
	public void updateAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Asset jooqAsset = unwrap(asset);
		update(jooqAsset);
	}

	@Override
	public void storeAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		update(unwrap(asset));
	}

	@Override
	public Observable<Tag> loadTags(Asset asset) {
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
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
