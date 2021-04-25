package io.metaloom.loom.db.model;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Taggable;

public interface Model extends CUDElement, Taggable {

	String getName();

	Model setName(String name);
}
