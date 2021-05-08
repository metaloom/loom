package io.metaloom.loom.db.role;

import io.metaloom.loom.db.CUDElement;

public interface LoomRole extends CUDElement {

	String getName();

	LoomRole setName(String name);
}
