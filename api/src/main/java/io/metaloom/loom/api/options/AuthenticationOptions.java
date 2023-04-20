package io.metaloom.loom.api.options;

public class AuthenticationOptions {

	private static final String DEFAULT_KEYSTORE_PATH = "keystore.jceks";

	private String keystorePath = DEFAULT_KEYSTORE_PATH;

	private String keystorePassword = null;

	public String getKeystorePath() {
		return keystorePath;
	}

	public AuthenticationOptions setKeystorePath(String keystorePath) {
		this.keystorePath = keystorePath;
		return this;
	}

	public String getKeystorePassword() {
		return keystorePassword;
	}

	public AuthenticationOptions setKeystorePassword(String keystorePassword) {
		this.keystorePassword = keystorePassword;
		return this;
	}
}
