package io.metaloom.loom.core.boot;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.auth.AuthenticationService;
import io.metaloom.loom.rest.RESTService;
import io.metaloom.loom.server.grpc.GrpcService;

@Singleton
public class BootstrapInitializer {

	public static final Logger log = LoggerFactory.getLogger(BootstrapInitializer.class);

	private final GrpcService grpcService;

	private final RESTService restService;

	private final AuthenticationService authService;

	private final Flyway flyway;

	@Inject
	public BootstrapInitializer(GrpcService grpcService, RESTService restService, AuthenticationService authService, Flyway flyway) {
		this.grpcService = grpcService;
		this.restService = restService;
		this.authService = authService;
		this.flyway = flyway;
	}

	public void init(boolean migrate) throws IOException {
		if (migrate) {
			try {
				log.info("Invoking database migration check");
				flyway.migrate();
			} catch (Exception e) {
				throw new RuntimeException("Error while invoking database migration", e);
			}
		}

		try {
			authService.init();
		} catch (Exception e) {
			throw new RuntimeException("Error while initializing the authentication service", e);
		}

		try {
			log.info("Starting gRPC service");
			grpcService.start();
		} catch (Exception e) {
			throw new RuntimeException("Error while starting gRPC service", e);
		}

		try {
			log.info("Starting REST service");
			restService.start();
		} catch (Exception e) {
			throw new RuntimeException("Error while starting rest service", e);
		}
	}

	public RESTService getRestService() {
		return restService;
	}

	public GrpcService getGrpcService() {
		return grpcService;
	}

	public void deinit() {
		grpcService.stop();
		restService.stop();
	}
}
