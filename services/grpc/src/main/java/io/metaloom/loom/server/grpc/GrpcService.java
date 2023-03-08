package io.metaloom.loom.server.grpc;

import java.io.IOException;

import javax.inject.Inject;

import io.metaloom.loom.proto.AssetRequest;
import io.metaloom.loom.proto.AssetResponse;
import io.metaloom.loom.proto.VertxAssetLoaderGrpc;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;

public class GrpcService {

	private Vertx vertx;

	@Inject
	public GrpcService(Vertx vertx) {
		this.vertx = vertx;
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
		};

		VertxServer rpcServer = VertxServerBuilder
			.forPort(vertx, 4444)
			.addService(service)
			.build();

		rpcServer.start();
	}
}
