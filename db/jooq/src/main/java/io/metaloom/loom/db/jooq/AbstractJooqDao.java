package io.metaloom.loom.db.jooq;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SortField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableRecord;
import org.jooq.UniqueKey;
import org.jooq.UpdatableRecord;

import io.metaloom.filter.Filter;
import io.metaloom.loom.api.sort.SortDirection;
import io.metaloom.loom.api.sort.SortKey;
import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.CUDElement;
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

	abstract protected Table<? extends TableRecord<?>> getTable();

	public Field<UUID> getIdField() {
		return (Field<UUID>) getTable().field("uuid", UUID.class);
	}

	private Field<UUID> getField(SortKey sortBy) {
		return getTable().field(sortBy.getName(), UUID.class);
	}

	public Field<UUID> getUuidField() {
		// return JooqAsset.ASSET.UUID;
		return getTable().field("uuid", UUID.class);
	}

	abstract protected Class<? extends T> getPojoClass();

	public <PK> Condition pkSelect(PK pk) {
		TableField<? extends TableRecord<?>, PK> field = (TableField<? extends TableRecord<?>, PK>) getTable().getPrimaryKey().getFieldsArray()[0];
		return field.eq(pk);
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
		TableRecord<?> reco = ctx().newRecord(getTable(), element);
		if (element.getUuid() == null) {
			reco.reset("uuid");
		}
		UUID uuid = ctx().insertInto(getTable())
			.set(reco)
			.returning(getTable().field("uuid", UUID.class))
			.fetchOne("uuid", UUID.class);
		if (uuid == null) {
			throw new RuntimeException("Key null!!");
		}
		element.setUuid(uuid);
		System.out.println("Element: " + element);
	}

	@Override
	public void delete(UUID id) {
		Field<?>[] pk = pk();

		if (pk != null) {
			ctx().delete(getTable())
				.where(pkSelect(id))
				.execute();
		}
	}

	@Override
	public Stream<? extends T> findAll() {
		return ctx().select(getTable()).fetchStreamInto(getPojoClass());
	}

	@Override
	public T load(UUID id) {
		return ctx()
			.select(getTable())
			.from(getTable())
			.where(getIdField().eq(id))
			.fetchOneInto(getPojoClass());
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
		UpdatableRecord<?> reco = (UpdatableRecord<?>) ctx().newRecord(getTable(), element);
		ctx().executeUpdate(reco);
		return element;
	}

	@Override
	public Page<T> loadPage(UUID fromId, int pageSize, List<Filter> filters, SortKey sortBy, SortDirection sortDirection) {
		// SelectSeekStep1<Record3<UUID, String, UUID>, UUID>
		SelectJoinStep<?> query = ctx()
			.select(getTable())
			.from(getTable());

		// Filtering
		if (filters != null) {
			for (Filter filter : filters) {
				applyFilter(query, filter);
			}
		}

		// Sorting
		SelectSeekStep1<?, UUID> query2;
		if (sortBy == null) {
			query2 = query.orderBy(getIdField());
		} else {
			SortField<UUID> field;
			if (sortDirection == SortDirection.DESCENDING) {
				field = getField(sortBy).desc();
			} else {
				field = getField(sortBy).asc();
			}
			query2 = query.orderBy(field);
		}

		// Seeking
		if (fromId != null) {
			query2.seek(fromId);
		}
		List<T> list = query2
			.limit(pageSize)
			.fetchStreamInto(getPojoClass())
			.collect(Collectors.toList());
		return new Page<>(pageSize, list);
	}

	private void applyFilter(SelectJoinStep<?> query, Filter filter) {
		query.where(getTable().field(filter.filterKey().key(), String.class).eq(filter.value().toString()));
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

	protected void setCreatorEditor(CUDElement<?> element, UUID userUuid) {
		element.setCreatorUuid(userUuid);
		element.setEditorUuid(userUuid);
		element.setCreated(Instant.now());
		element.setEdited(Instant.now());
	}

}
