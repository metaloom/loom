package io.metaloom.loom.db.jooq.dao.asset;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqAsset;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.user.User;
import io.vertx.core.json.JsonObject;

@Singleton
public class AssetDaoImpl extends AbstractJooqDao<Asset> implements AssetDao {

	@Inject
	public AssetDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqAsset.ASSET;
	}

	@Override
	protected Class<? extends Asset> getPojoClass() {
		return AssetImpl.class;
	}

	@Override
	public Asset createAsset(UUID userUuid, String sha512sum, String mimeType, String initialOrigin, long size) {
		Objects.requireNonNull(sha512sum, "Binary sha512sum must not be null");
		Asset asset = new AssetImpl();
		asset.setSHA512(sha512sum);
		asset.setSize(size);
		asset.setMimeType(mimeType);
		asset.setInitialOrigin(initialOrigin);
		setCreatorEditor(asset, userUuid);
		return asset;
	}

	@Override
	public Asset loadBySHA512Sum(String sha512sum) {
		return ctx()
			.select(getTable())
			.where(JooqAsset.ASSET.SHA512SUM.eq(sha512sum))
			.fetchOneInto(getPojoClass());
	}

	@Override
	public Asset loadByUuid(UUID uuid) {
		return load(uuid);
	}

	@Override
	public void storeUserMeta(User user, Asset asset, JsonObject meta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserMeta(User user, Asset asset) {
		// TODO Auto-generated method stub

	}

	@Override
	public JsonObject readUserMeta(User user, Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

}
