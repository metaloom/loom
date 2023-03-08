package io.metaloom.loom.core.boot;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.server.grpc.GrpcService;

@Singleton
public class BootstrapInitializer {

	public static final Logger log = LoggerFactory.getLogger(BootstrapInitializer.class);

	private final GrpcService grpcService;

	@Inject
	public BootstrapInitializer(GrpcService grpcService) {
		this.grpcService = grpcService;
	}

	public void init() throws IOException {
		log.info("Starting gRPC service");
		grpcService.start();
		
		// TODO REST
	}

	public void deinit() {
		// TODO Auto-generated method stub

	}
}
