package io.metaloom.loom.db.jooq.dao.cluster;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.cluster.Cluster;
import io.metaloom.loom.db.model.cluster.ClusterType;

public class ClusterImpl extends AbstractEditableElement<Cluster> implements Cluster {

	private String name;

	private ClusterType type;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Cluster setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ClusterType getType() {
		return type;
	}

	@Override
	public Cluster setType(ClusterType type) {
		this.type = type;
		return this;
	}

}
