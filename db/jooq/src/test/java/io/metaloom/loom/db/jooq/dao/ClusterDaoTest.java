package io.metaloom.loom.db.jooq.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDaoTestcases;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.cluster.Cluster;
import io.metaloom.loom.db.model.cluster.ClusterDao;
import io.metaloom.loom.db.model.cluster.ClusterType;
import io.metaloom.loom.db.model.user.User;

public class ClusterDaoTest extends AbstractJooqTest implements CRUDDaoTestcases<ClusterDao, Cluster, UUID> {

	@Override
	public ClusterDao getDao() {
		return clusterDao();
	}

	@Override
	public Cluster createElement(User user, int i) {
		return getDao().createCluster(user, "cluster_name_" + i, ClusterType.PERSON);
	}

	@Override
	public void assertUpdate(Cluster updatedElement) {
		assertEquals("new_name", updatedElement.getName());
	}

	@Override
	public void updateElement(Cluster cluster) {
		cluster.setName("new_name");
	}

}
