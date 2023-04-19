package io.metaloom.loom.rest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.rest.endpoint.impl.UserEndpoint;
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
		new UserEndpoint(router);
		RESTService service = new RESTService(vertx, options, router);
		HttpServer server = service.start();
		assertNotNull(server);
		System.out.println("Server on port " + server.actualPort());
	}
}
