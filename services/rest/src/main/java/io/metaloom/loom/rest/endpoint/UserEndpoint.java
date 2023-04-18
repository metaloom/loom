package io.metaloom.loom.rest.endpoint;

import javax.inject.Inject;
import javax.inject.Named;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class UserEndpoint extends AbstractRESTEndpoint {

	@Inject
	public UserEndpoint(@Named("restRouter") Router router) {
		super(router);
		register();
	}

	@Override
	public void register() {
		System.out.println("USER ENDPOINT");
		router.route("/users").handler(rc -> {
			System.out.println("Users");
			JsonObject json = new JsonObject();
			json.put("username", "joedoe");
			rc.response().end(json.toBuffer());
		});
	}

}
