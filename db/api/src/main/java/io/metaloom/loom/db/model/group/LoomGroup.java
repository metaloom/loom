package io.metaloom.loom.db.model.group;

import java.util.List;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomMetaElement;
import io.metaloom.loom.db.model.user.LoomUser;

public interface LoomGroup extends CUDElement, LoomMetaElement {

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
	LoomGroup setName(String name);

	List<LoomUser> getUsers();

	LoomGroup setUsers(List<LoomUser> users);

}
