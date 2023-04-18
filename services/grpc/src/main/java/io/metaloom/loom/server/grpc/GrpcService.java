package io.metaloom.loom.server.grpc;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.Metadata;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.service.AbstractService;
import io.metaloom.loom.server.grpc.auth.AuthInterceptor;
import io.metaloom.loom.server.grpc.impl.GrpcAssetLoader;
import io.vertx.core.Vertx;
import io.vertx.grpc.BlockingServerInterceptor;
import io.vertx.grpc.ContextServerInterceptor;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;

@Singleton
public class GrpcService extends AbstractService {

	public static final Logger log = LoggerFactory.getLogger(GrpcService.class);

	private VertxServer server;

	private final GrpcAssetLoader assetLoader;

	private final AuthInterceptor authInterceptor;

	@Inject
	public GrpcService(Vertx vertx, LoomOptions options, GrpcAssetLoader assetLoader, AuthInterceptor authInterceptor) {
		super(vertx, options);
		this.assetLoader = assetLoader;
		this.authInterceptor = authInterceptor;
	}

	public void start() throws IOException {
		int port = options().getServer().getGrpcPort();
		String host = options().getServer().getBindAddress();

		ServerInterceptor wrappedAuthInterceptor = BlockingServerInterceptor.wrap(vertx(), authInterceptor);

		ServerInterceptor contextInterceptor = new ContextServerInterceptor() {
			@Override
			public void bind(Metadata metadata) {
				Metadata.Key<String> SESSION_ID_METADATA_KEY = Metadata.Key.of("test", Metadata.ASCII_STRING_MARSHALLER);
				put("sessionId", metadata.get(SESSION_ID_METADATA_KEY));
			}
		};

		server = VertxServerBuilder
			.forAddress(vertx(), host, port)
			.addService(ServerInterceptors.intercept(assetLoader, wrappedAuthInterceptor))
			.addService(ServerInterceptors.intercept(assetLoader, contextInterceptor))
			.build();

		log.info("Starting gRPC server on {}:{}", host, port);
		server.start();
	}

	public void stop() {
		if (server != null) {
			log.info("Shuting down gRPC server");
			server.shutdown();
		}
	}

	public VertxServer getServer() {
		return server;
	}
	
}
