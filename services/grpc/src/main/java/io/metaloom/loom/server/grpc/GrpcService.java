package io.metaloom.loom.server.grpc;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.service.AbstractService;
import io.metaloom.loom.server.grpc.impl.GrpcAssetLoader;
import io.vertx.core.Vertx;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;

public class GrpcService extends AbstractService {

	public static final Logger log = LoggerFactory.getLogger(GrpcService.class);
	
	private final GrpcAssetLoader assetLoader;

	@Inject
	public GrpcService(Vertx vertx, LoomOptions options, GrpcAssetLoader assetLoader) {
		super(vertx, options);
		this.assetLoader = assetLoader;
	}

	public void start() throws IOException {
		int port = options().getServer().getGrpcPort();
		String host = options().getServer().getBindAddress();
		VertxServer rpcServer = VertxServerBuilder
			.forAddress(vertx(), host, port)
			.addService(assetLoader)
			.build();

		log.info("Starting gRPC server on {}:{}", host, port);
		rpcServer.start();
	}
}
