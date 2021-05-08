package io.metaloom.loom.db.asset;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.AssetDao;
import io.metaloom.loom.db.jooq.tables.pojos.Asset;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqAssetDaoImpl extends AssetDao implements LoomAssetDao {

	@Inject
	public JooqAssetDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ASSET;
	// }

	@Override
	public Maybe<? extends LoomAsset> loadAsset(UUID uuid) {
		return wrap(findOneById(uuid), JooqAssetImpl.class);
	}

	@Override
	public void deleteAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		deleteById(asset.getUuid());
	}

	@Override
	public LoomAsset createAsset() {
		Asset asset = new Asset();
		insert(asset);
		return new JooqAssetImpl(asset);
	}

	@Override
	public void updateAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		Asset jooqAsset = unwrap(asset);
		update(jooqAsset);
	}

	@Override
	public void storeAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		update(unwrap(asset));
	}

	@Override
	public Observable<LoomTag> loadTags(LoomAsset asset) {
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
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
