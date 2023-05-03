package io.metaloom.loom.db.model.cluster;

import io.metaloom.loom.db.CUDElement;

public interface Cluster extends CUDElement<Cluster> {

	String getName();

	Cluster setName(String name);

	ClusterType getType();

	Cluster setType(ClusterType type);

}
