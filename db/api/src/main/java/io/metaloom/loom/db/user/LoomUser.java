package io.metaloom.loom.db.user;

import io.metaloom.loom.db.CUDElement;

public interface LoomUser extends CUDElement {

	String getUsername();

	LoomUser setUsername(String username);

	String getEmail();

	LoomUser setEmail(String email);

	String getFirstname();

	LoomUser setFirstname(String firstname);

	String getLastname();

	LoomUser setLastname(String lastname);
}
