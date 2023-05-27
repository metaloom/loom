package io.metaloom.loom.db.jooq.dao.asset;

import static io.metaloom.loom.db.jooq.tables.JooqAsset.ASSET;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.SelectJoinStep;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.filter.Filter;
import io.metaloom.filter.Operation;
import io.metaloom.filter.value.impl.range.SizeRangeFilterValue;
import io.metaloom.loom.api.filter.LoomFilterKey;
import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqAsset;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.utils.UUIDUtils;
import io.metaloom.utils.hash.SHA512Sum;
import io.vertx.core.json.JsonObject;

@Singleton
public class AssetDaoImpl extends AbstractJooqDao<Asset> implements AssetDao {

	@Inject
	public AssetDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	public String getTypeName() {
		return "Assets";
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
	public Asset createAsset(UUID userUuid, SHA512Sum sha512sum, String mimeType, String filename, String initialOrigin, long size) {
		Objects.requireNonNull(sha512sum, "Binary sha512sum must not be null");
		Asset asset = new AssetImpl();
		asset.setSHA512(sha512sum.toString());
		asset.setSize(size);
		asset.setMimeType(mimeType);
		asset.setFilename(filename);
		asset.setInitialOrigin(initialOrigin);
		setCreatorEditor(asset, userUuid);
		return asset;
	}

	@Override
	public Asset load(UUID uuid) {
		return ctx()
			.select(getTable())
			.from(getTable())
			.where(JooqAsset.ASSET.UUID.eq(uuid))
			.fetchOneInto(getPojoClass());
	}

	@Override
	public Asset loadBySHA512(SHA512Sum sha512sum) {
		return ctx()
			.select(getTable())
			.from(getTable())
			.where(JooqAsset.ASSET.SHA512SUM.eq(sha512sum.toString()))
			.fetchOneInto(getPojoClass());
	}

	@Override
	public Asset loadBySHA512OrUuid(String sha512sumOrUuid) {
		if (UUIDUtils.isUUID(sha512sumOrUuid)) {
			return load(UUID.fromString(sha512sumOrUuid));
		} else {
			SHA512Sum sha512 = SHA512Sum.fromString(sha512sumOrUuid);
			return loadBySHA512(sha512);
		}
	}

	@Override
	public void deleteBySHA512(SHA512Sum sha512sum) {
		ctx().delete(getTable())
			.where(ASSET.SHA512SUM.eq(sha512sum.toString()))
			.execute();
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

	@Override
	protected SelectConditionStep<?> applyFilter(SelectJoinStep<?> query, Filter filter) {
		if (filter.matches(LoomFilterKey.FILE_SIZE, Operation.RANGE)) {
			return filter.apply(SizeRangeFilterValue.class, sv -> {
				return query.where(ASSET.SIZE.ge(sv.getFrom())).and(ASSET.SIZE.le(sv.getTo()));
			});
		}
		return super.applyFilter(query, filter);
	}

}
