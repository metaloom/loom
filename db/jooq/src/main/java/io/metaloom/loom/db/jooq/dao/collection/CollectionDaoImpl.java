package io.metaloom.loom.db.jooq.dao.collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqCollectionDao;
import io.metaloom.loom.db.model.collection.CollectionDao;

@Singleton
public class CollectionDaoImpl extends AbstractJooqDao<JooqCollectionDao> implements CollectionDao {

	@Inject
	public CollectionDaoImpl(JooqCollectionDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

}
