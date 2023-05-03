package io.metaloom.loom.db.jooq;

import static io.metaloom.loom.db.jooq.tables.JooqAsset.ASSET;
import static io.metaloom.loom.db.jooq.tables.JooqUser.USER;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.SelectSeekStep1;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableRecord;
import org.jooq.UniqueKey;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.Element;
import io.metaloom.loom.db.page.Page;

/**
 * 
 * @param <T>
 *            Pojo type
 */
public abstract class AbstractJooqDao<T extends Element<T>> implements JooqDao, CRUDDao<T> {

	private final DSLContext ctx;

	public AbstractJooqDao(DSLContext ctx) {
		this.ctx = ctx;
	}

	protected DSLContext ctx() {
		return ctx;
	}

	protected long count(Table<?> table) {
		return ctx()
			.selectCount()
			.from(table)
			.fetchOne(0, Long.class);
	}

	abstract protected Table<? extends TableRecord<?>> getTable();

	abstract protected Class<? extends T> getPojoClass();

	public <PK> Condition pkSelect(PK pk) {
		TableField<? extends TableRecord<?>, PK> field2 = (TableField<? extends TableRecord<?>, PK>) getTable().getPrimaryKey().getFieldsArray()[0];
		return field2.eq(pk);
	}

	@Override
	public void clear() {
		// ctx().truncate(getTable()).cascade().execute();
		ctx().deleteFrom(getTable()).execute();
	}

	@Override
	public long count() {
		return ctx()
			.selectCount()
			.from(getTable())
			.fetchOne(0, Long.class);
	}

	@Override
	public void store(T element) {
		// Record elementRecord = ctx().newRecord(getTable(), element);
		TableRecord<?> reco = ctx().newRecord(getTable(), element);
		T result = ctx().insertInto(getTable())
			.set(reco)
			.returning(getTable().getPrimaryKey().getFields())
			.fetchOneInto(getPojoClass());
		element.setUuid(result.getUuid());
		// TODO check whether it can be merged
	}

	@Override
	public void delete(UUID uuid) {
		Field<?>[] pk = pk();

		if (pk != null) {
			ctx().delete(getTable())
				.where(pkSelect(uuid))
				.execute();
		}
	}

	@Override
	public Stream<? extends T> findAll() {
		return ctx().select(getTable()).fetchStreamInto(getPojoClass());
	}

	@Override
	public T load(UUID uuid) {
		return ctx().fetchSingle(getTable(), USER.UUID.equal(uuid)).into(getPojoClass());
		// return ctx().selectFrom(USER)
		// .where(USER.UUID.equal(uuid))
		// .fetchOneInto(User.class);

		// JooqUser user = dao().findById(uuid);
		// if (user == null) {
		// return null;
		// }
		// return new UserImpl(user);

	}

	@Override
	public T update(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> loadPage(UUID fromUuid, int pageSize) {
		SelectSeekStep1<Record3<UUID, String, UUID>, UUID> query = ctx()
			.select(ASSET.UUID, ASSET.PATH, ASSET.BINARY_UUID)
			.from(ASSET)
			.orderBy(ASSET.UUID);
		if (fromUuid != null) {
			query.seek(fromUuid);
		}
		List<T> list = query
			.limit(pageSize)
			.fetchStreamInto(getPojoClass())
			.collect(Collectors.toList());
		return new Page<>(list);
	}

	public T findByUUID(UUID id) {
		Field<?>[] pk = pk();

		if (pk != null) {
			return ctx().selectFrom(getTable())
				.where(pkSelect(id))
				.fetchOneInto(getPojoClass());
		}
		return null;
	}
	//
	// @Override
	// public <Z> List<P> fetchRange(Field<Z> field, Z lowerInclusive, Z upperInclusive) {
	// return ctx()
	// .selectFrom(table)
	// .where(
	// lowerInclusive == null
	// ? upperInclusive == null
	// ? noCondition()
	// : field.le(upperInclusive)
	// : upperInclusive == null
	// ? field.ge(lowerInclusive)
	// : field.between(lowerInclusive, upperInclusive))
	// .fetch(mapper());
	// }
	//
	// @Override
	// public /* non-final */ void insert(Collection<P> objects) {
	//
	// // Execute a batch INSERT
	// if (objects.size() > 1)
	//
	// // [#2536] [#3327] We cannot batch INSERT RETURNING calls yet
	// if (!FALSE.equals(settings().isReturnRecordToPojo()))
	// for (R record : records(objects, false))
	// record.insert();
	// else
	// ctx().batchInsert(records(objects, false)).execute();
	//
	// // Execute a regular INSERT
	// else if (objects.size() == 1)
	// records(objects, false).get(0).insert();
	// }
	//
	// @Override
	// public /* non-final */ void update(Collection<P> objects) {
	//
	// // Execute a batch UPDATE
	// if (objects.size() > 1)
	//
	// // [#2536] [#3327] We cannot batch UPDATE RETURNING calls yet
	// if (!FALSE.equals(settings().isReturnRecordToPojo()) &&
	// TRUE.equals(settings().isReturnAllOnUpdatableRecord()))
	// for (R record : records(objects, true))
	// record.update();
	// else
	// ctx().batchUpdate(records(objects, true)).execute();
	//
	// // Execute a regular UPDATE
	// else if (objects.size() == 1)
	// records(objects, true).get(0).update();
	// }
	//

	protected void deleteCrossTableEntry(TableField<?, UUID> aField, UUID a, TableField<?, UUID> bField, UUID b) {
		ctx().deleteFrom(aField.getTable())
			.where(aField.eq(a)
				.and(bField.eq(b)))
			.execute();
	}

	private /* non-final */ Field<?>[] pk() {
		UniqueKey<?> key = getTable().getPrimaryKey();
		return key == null ? null : key.getFieldsArray();
	}

	private <PK> TableField<?, PK> pkField() {
		return (TableField<?, PK>) getTable().getPrimaryKey();
	}

	// String json = meta.encode();
	// delegate().setMeta(JSONB.jsonbOrNull(json));
	// return this;

}
