package io.metaloom.loom.db.model.group;

import java.util.List;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;
import io.metaloom.loom.db.model.user.LoomUser;

public interface Group extends CUDElement, MetaElement {

	/**
	 * Return the name of the group.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Set the name of the group.
	 * 
	 * @param name
	 * @return
	 */
	Group setName(String name);

	List<LoomUser> getUsers();

	Group setUsers(List<LoomUser> users);

}
