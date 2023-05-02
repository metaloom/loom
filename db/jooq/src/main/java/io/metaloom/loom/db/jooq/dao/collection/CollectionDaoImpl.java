package io.metaloom.loom.db.jooq.dao.collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqCollection;
import io.metaloom.loom.db.model.collection.Collection;
import io.metaloom.loom.db.model.collection.CollectionDao;

@Singleton
public class CollectionDaoImpl extends AbstractJooqDao<Collection> implements CollectionDao {

	@Inject
	public CollectionDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqCollection.COLLECTION;
	}

	@Override
	protected Class<? extends Collection> getPojoClass() {
		return CollectionImpl.class;
	}

}
