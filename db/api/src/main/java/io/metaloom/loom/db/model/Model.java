package io.metaloom.loom.db.model;

import io.metaloom.loom.db.CUDElement;

public interface Model extends CUDElement {

	String getName();

	Model setName(String name);
}
