package io.metaloom.loom.db.jooq.dao.cluster;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqCluster;
import io.metaloom.loom.db.model.cluster.Cluster;
import io.metaloom.loom.db.model.cluster.ClusterDao;

@Singleton
public class ClusterDaoImpl extends AbstractJooqDao<Cluster> implements ClusterDao {

	@Inject
	public ClusterDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqCluster.CLUSTER;
	}

	@Override
	protected Class<? extends Cluster> getPojoClass() {
		return ClusterImpl.class;
	}

	@Override
	public Cluster createCluster(String name) {
		Cluster cluster = new ClusterImpl();
		cluster.setName(name);
		return cluster;
	}

}
