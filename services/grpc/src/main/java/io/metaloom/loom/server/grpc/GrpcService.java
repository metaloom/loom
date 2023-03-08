package io.metaloom.loom.server.grpc;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.service.AbstractService;
import io.metaloom.loom.proto.AssetRequest;
import io.metaloom.loom.proto.AssetResponse;
import io.metaloom.loom.proto.VertxAssetLoaderGrpc;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;

public class GrpcService extends AbstractService {

	public static final Logger log = LoggerFactory.getLogger(GrpcService.class);

	@Inject
	public GrpcService(Vertx vertx, LoomOptions options) {
		super(vertx, options);
	}

	public void start() throws IOException {
		VertxAssetLoaderGrpc.AssetLoaderVertxImplBase service = new VertxAssetLoaderGrpc.AssetLoaderVertxImplBase() {
			@Override
			public Future<AssetResponse> store(AssetRequest request) {
				return Future.succeededFuture(
					AssetResponse.newBuilder()
						.setChunkHash("Reply with " + request.getFingerprint())
						.build());
			}

			@Override
			public Future<AssetResponse> load(AssetRequest request) {
				return Future.succeededFuture(
					AssetResponse.newBuilder()
						.setChunkHash("Reply with " + request.getFingerprint())
						.build());
			}

		};

		int port = options().getServer().getGrpcPort();
		String host = options().getServer().getBindAddress();
		VertxServer rpcServer = VertxServerBuilder
			.forAddress(vertx(), host, port)
			.addService(service)
			.build();

		log.info("Starting gRPC server on {}:{}", host, port);

		rpcServer.start();
	}
}
