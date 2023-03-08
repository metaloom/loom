package io.metaloom.loom.rest;

import io.vertx.core.Vertx;
import io.vertx.ext.web.openapi.RouterBuilder;

public class RestApiProvider {

	public void loadContract() {
		Vertx vertx = Vertx.vertx();

		RouterBuilder.create(vertx, "src/main/resources/api-contract.yaml").onComplete(ar -> {
			if (ar.succeeded()) {
				System.out.println("Loaded");

				// Spec loaded with success
				RouterBuilder routerBuilder = ar.result();
			} else {
				// Something went wrong during router builder initialization
				Throwable exception = ar.cause();
			}
		});
	}
}
