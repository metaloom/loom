package io.metaloom.loom.db.namespace;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Taggable;

public interface LoomNamespace extends CUDElement, Taggable {

	String getName();

	LoomNamespace setName(String name);

}
