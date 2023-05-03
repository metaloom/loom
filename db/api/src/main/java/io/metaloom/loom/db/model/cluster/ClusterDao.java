package io.metaloom.loom.db.model.cluster;

import io.metaloom.loom.db.CRUDDao;

public interface ClusterDao extends CRUDDao<Cluster> {

	Cluster createCluster(String name);

}
