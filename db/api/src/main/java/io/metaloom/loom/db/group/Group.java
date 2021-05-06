package io.metaloom.loom.db.group;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;

public interface Group extends CUDElement, LoomElement {

	String getName();

	Group setName(String name);

}
