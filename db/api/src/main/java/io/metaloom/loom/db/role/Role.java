package io.metaloom.loom.db.role;

import io.metaloom.loom.db.CUDElement;

public interface Role extends CUDElement {

	String getName();

	Role setName(String name);
}
