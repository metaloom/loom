package io.metaloom.loom.rest;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.error.LoomRestException;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.service.AbstractService;
import io.metaloom.loom.rest.dagger.RESTEndpoints;
import io.metaloom.loom.rest.endpoint.RESTEndpoint;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

@Singleton
public class RESTService extends AbstractService {

	private static final Logger log = LoggerFactory.getLogger(RESTService.class);

	private Router router;
	private HttpServer server;

	private Set<RESTEndpoint> endpoints;

	@Inject
	public RESTService(Vertx vertx, LoomOptions options, @Named("restRouter") Router router, @RESTEndpoints Set<RESTEndpoint> endpoints) {
		super(vertx, options);
		this.router = router;
		this.endpoints = endpoints;
	}

	public HttpServer start() throws InterruptedException, ExecutionException {
		int port = options().getServer().getRestPort();
		String host = options().getServer().getBindAddress();

		log.info("Starting REST server on {}:{}", host, port);
		HttpServerOptions httpOptions = new HttpServerOptions();
		httpOptions.setHost(host);
		httpOptions.setPort(port);

		setupRouter();

		this.server = vertx().createHttpServer(httpOptions);
		server.requestHandler(router);
		server.listen().toCompletionStage().toCompletableFuture().get();
		return server;
	}

	private void setupRouter() {
		router.route().handler(BodyHandler.create());

		for (RESTEndpoint endpoint : endpoints) {
			endpoint.register();
		}
		// endpoints.register();
		router.errorHandler(404, rc -> {
			log.error("Request failed {}", rc.normalizedPath(), rc.failure());
			GenericMessageResponse error = new GenericMessageResponse();
			error.setMessage("Not Found " + rc.statusCode() + " " + rc.normalizedPath());
			rc.response().setStatusCode(500).end(Json.encodeToBuffer(error));
		});
		router.route().failureHandler(rc -> {
			log.error("Request failed {}", rc.normalizedPath(), rc.failure());
			GenericMessageResponse error = new GenericMessageResponse();
			// TODO Don't expose error details
			if (rc.failure() instanceof LoomRestException lre) {
				GenericMessageResponse errorResponse = new GenericMessageResponse();
				errorResponse.setMessage(lre.getMessage());
				rc.response().setStatusCode(lre.httpCode()).end(Json.encodeToBuffer(errorResponse));
			} else {
				error.setMessage("Internal Server Error " + rc.failure().getMessage());
				rc.response().setStatusCode(400).end(Json.encodeToBuffer(error));
			}
		});

	}

	public void stop() {
		if (server != null) {
			log.info("Shuting down REST server");
			server.close();
		}
	}

	public HttpServer getServer() {
		return server;
	}
}
