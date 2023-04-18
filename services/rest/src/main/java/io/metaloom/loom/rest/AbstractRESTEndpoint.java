package io.metaloom.loom.rest;

import io.metaloom.loom.rest.endpoint.RESTEndpoint;
import io.vertx.ext.web.Router;

public abstract class AbstractRESTEndpoint implements RESTEndpoint {

	protected Router router;

	public AbstractRESTEndpoint(Router router) {
		this.router = router;
	}

}
