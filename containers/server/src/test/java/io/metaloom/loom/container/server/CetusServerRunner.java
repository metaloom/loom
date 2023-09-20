package io.metaloom.loom.container.server;
import io.metaloom.loom.api.Loom;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.options.OptionsLoader;

public class CetusServerRunner {

	public static void main(String[] args) throws Exception {
		LoomOptions options = OptionsLoader.createOrloadOptions();
		options.getDatabase().setHost("cetus.sky");
		options.getDatabase().setPort(5432);
		options.getDatabase().setDatabaseName("loom");
		options.getDatabase().setUsername("sa").setPassword("sa");
		Loom loom = Loom.create(options);
		loom.run();
	}
}
