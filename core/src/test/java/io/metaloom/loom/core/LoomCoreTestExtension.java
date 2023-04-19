package io.metaloom.loom.core;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.api.options.ServerOptions;
import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.core.dagger.DaggerLoomCoreComponent;
import io.metaloom.loom.core.dagger.LoomCoreComponent;
import io.metaloom.loom.test.LoomProviderExtension;
import io.metaloom.test.container.provider.model.DatabaseAllocationResponse;

public class LoomCoreTestExtension implements BeforeEachCallback, AfterEachCallback {

	@RegisterExtension
	public static LoomProviderExtension ext = LoomProviderExtension.create();

	private LoomCoreComponent loomInternal;

	public LoomHttpClient httpClient() {
		return LoomHttpClient.builder()
			.setHostname("localhost")
			.setPort(loomInternal.boot().getRestService().getServer().actualPort())
			.build();
	}

	public LoomGRPCClient grpcClient() {
		return LoomGRPCClient.builder()
			.setHostname("localhost")
			.setPort(loomInternal.boot().getGrpcService().getServer().getPort())
			.build();
	}

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		ext.beforeEach(context);
		LoomOptions options = new LoomOptions();
		DatabaseOptions dbOptions = new DatabaseOptions();
		DatabaseAllocationResponse db = ext.db();
		dbOptions.setHost(db.getHost());
		dbOptions.setPort(db.getPort());
		dbOptions.setUsername(db.getUsername());
		dbOptions.setPassword(db.getPassword());
		dbOptions.setDatabaseName(db.getDatabaseName());
		options.setDatabase(dbOptions);
		ServerOptions serverOptions = options.getServer();
		serverOptions.setBindAddress("localhost");
		serverOptions.setRestPort(0);
		serverOptions.setGrpcPort(0);
		loomInternal = DaggerLoomCoreComponent.builder().configuration(options).build();
		loomInternal.boot().init(false);

	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		ext.afterEach(context);
		if (loomInternal != null) {
			loomInternal.boot().deinit();
		}
	}

}
