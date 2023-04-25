package io.metaloom.loom.api.error;

import java.io.IOException;

public class LoomRestException extends RuntimeException {

	private static final long serialVersionUID = -4086888737127388941L;
	private int code;
	private String message;

	public LoomRestException(int httpErrorCode, String message, IOException e) {
		super(e);
		this.code = httpErrorCode;
		this.message = message;
	}

	public LoomRestException(int httpErrorCode, String message) {
		this.code = httpErrorCode;
		this.message = message;
	}

	public int httpCode() {
		return code;
	}
	

}
