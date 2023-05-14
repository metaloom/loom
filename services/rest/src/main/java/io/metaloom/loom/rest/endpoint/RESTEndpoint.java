package io.metaloom.loom.rest.endpoint;

public interface RESTEndpoint {

	/**
	 * Name of the endpoint
	 * 
	 * @return
	 */
	String name();

	void register();
}
