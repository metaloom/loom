package io.metaloom.loom.db.model.user;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomMetaElement;

public interface LoomUser extends CUDElement, LoomMetaElement {

	/**
	 * Return the username.
	 * 
	 * @return
	 */
	String getUsername();

	/**
	 * Set the username.
	 * 
	 * @param username
	 * @return Fluent API
	 */
	LoomUser setUsername(String username);

	/**
	 * Return the stored password hash for the user.
	 * 
	 * @return
	 */
	String getPasswordHash();

	/**
	 * Set the password hash.
	 * 
	 * @param hash
	 * @return Fluent API
	 */
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

	/**
	 * Check whether the user is enabled.
	 * 
	 * @return
	 */
	boolean isEnabled();

	/**
	 * Set the enabled flag for the user.
	 * 
	 * @param flag
	 * @return Fluent API
	 */
	LoomUser setEnabled(boolean flag);

	/**
	 * Enable the user. This will enable login.
	 * 
	 * @return
	 */
	default LoomUser enable() {
		setEnabled(true);
		return this;
	}

	/**
	 * Disable the user. This will prevent login.
	 * 
	 * @return
	 */
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
