package io.metaloom.loom.db.namespace;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsNamespaceImpl extends AbstractFSCUDElement implements LoomNamespace {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoomNamespace setName(String name) {
		this.name = name;
		return this;
	}

}
