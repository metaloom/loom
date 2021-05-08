package io.metaloom.loom.db.group;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;

public interface LoomGroup extends CUDElement, LoomElement {

	String getName();

	LoomGroup setName(String name);

}
