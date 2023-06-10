import org.junit.jupiter.api.Test;

import io.metaloom.loom.api.Loom;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.options.OptionsLoader;

public class ServerRunnerTest {

	@Test
	public void testRunner() throws Exception {
		LoomOptions options = OptionsLoader.createOrloadOptions();
		options.getDatabase().setPort(15432);
		options.getDatabase().setDatabaseName("postgres");
		options.getDatabase().setUsername("sa").setPassword("sa");
		Loom loom = Loom.create(options);
		loom.run();
	}
}
