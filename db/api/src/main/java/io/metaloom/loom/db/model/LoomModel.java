package io.metaloom.loom.db.model;

import io.metaloom.loom.db.CUDElement;

public interface LoomModel extends CUDElement {

	String getName();

	LoomModel setName(String name);
}
