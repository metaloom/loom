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
import io.reactivex.Single;
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
	public Completable deleteAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		return deleteById(asset.getUuid()).ignoreElement();
	}

	@Override
	public Single<? extends LoomAsset> createAsset() {
		Asset asset = new Asset();
		insert(asset);
		return insertReturningPrimary(asset).map(pk -> new JooqAssetImpl(asset.setUuid(pk)));
	}

	@Override
	public Completable updateAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		Asset jooqAsset = unwrap(asset);
		return update(jooqAsset).ignoreElement();
	}

	@Override
	public Observable<LoomTag> loadTags(LoomAsset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
