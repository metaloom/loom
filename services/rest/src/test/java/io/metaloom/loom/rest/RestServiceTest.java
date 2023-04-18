package io.metaloom.loom.rest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.rest.endpoint.UserEndpoint;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class RestServiceTest {

	@Test
	public void testContractCreation() throws Exception {
		Vertx vertx = Vertx.vertx();
		LoomOptions options = new LoomOptions();
		options.getServer();
		Router router = Router.router(vertx);
		UserEndpoint  userEndpoint = new UserEndpoint(router);
		userEndpoint.register();
		RESTService service = new RESTService(vertx, options, router);
		HttpServer server = service.start();
		assertNotNull(server);
		System.out.println("Server on port " +  server.actualPort());
	}
}
