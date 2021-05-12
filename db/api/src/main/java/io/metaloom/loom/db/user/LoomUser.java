package io.metaloom.loom.db.user;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;

public interface LoomUser extends CUDElement, MetaElement {

	/**
	 * Return the username.
	 * 
	 * @return
	 */
	String getUsername();

	/**
	 * Set the username
	 * 
	 * @param username
	 * @return Fluent API
	 */
	LoomUser setUsername(String username);

	String getPasswordHash();

	LoomUser setPasswordHash(String hash);

	/**
	 * Return the SSO flag for the user.
	 * 
	 * @return
	 */
	boolean isSSO();

	/**
	 * Set the SSO flag of the user.
	 * 
	 * @param flag
	 * @return
	 */
	LoomUser setSSO(boolean flag);

	boolean isEnabled();

	LoomUser setEnabled(boolean flag);

	default LoomUser enable() {
		setEnabled(true);
		return this;
	}

	default LoomUser disable() {
		setEnabled(false);
		return this;
	}

	/**
	 * Return the email of the user.
	 * 
	 * @return
	 */
	String getEmail();

	/**
	 * Set the email of the user
	 * 
	 * @param email
	 * @return Fluent API
	 */
	LoomUser setEmail(String email);

	/**
	 * Return the firstname of the user.
	 * 
	 * @return
	 */
	String getFirstname();

	/**
	 * Set the firstname of the user.
	 * 
	 * @param firstname
	 * @return Fluent API
	 */
	LoomUser setFirstname(String firstname);

	/**
	 * Return the lastname of the user.
	 * 
	 * @return
	 */
	String getLastname();

	/**
	 * Set the lastname of the user.
	 * 
	 * @param lastname
	 * @return Fluent API.
	 */
	LoomUser setLastname(String lastname);
}
