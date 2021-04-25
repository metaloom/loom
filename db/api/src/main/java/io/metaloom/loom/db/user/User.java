package io.metaloom.loom.db.user;

import io.metaloom.loom.db.CUDElement;

public interface User extends CUDElement {

	String getUsername();

	User setUsername(String username);

	String getEmail();

	User setEmail(String email);

	String getFirstname();

	User setFirstname(String firstname);

	String getLastname();

	User setLastname(String lastname);
}
