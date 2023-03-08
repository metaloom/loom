package io.metaloom.loom.core.boot;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.server.grpc.GrpcService;

@Singleton
public class BootstrapInitializer {

	public static final Logger log = LoggerFactory.getLogger(BootstrapInitializer.class);

	private final GrpcService grpcService;

	private final Flyway flyway;

	@Inject
	public BootstrapInitializer(GrpcService grpcService, Flyway flyway) {
		this.grpcService = grpcService;
		this.flyway = flyway;
	}

	public void init() throws IOException {
		try {
			log.info("Starting gRPC service");
			grpcService.start();
		} catch (Exception e) {
			throw new RuntimeException("Error while starting grpc service", e);
		}

		try {
			log.info("Invoking database migration check");
			flyway.migrate();
		} catch (Exception e) {
			throw new RuntimeException("Error while invoking database migration", e);
		}

		// TODO REST
	}

	public void deinit() {
		// TODO Auto-generated method stub

	}
}
