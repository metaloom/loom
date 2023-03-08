package io.metaloom.loom.test.integration;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import io.metaloom.api.Loom;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.test.TestEnvHelper;
import io.metaloom.loom.test.Testdata;
import io.metaloom.loom.test.container.LoomPostgreSQLContainer;
import io.metaloom.loom.worker.cli.LoomWorkerCLI;

public class BasicIntegrationTest {

	@Rule
	@ClassRule
	public static LoomPostgreSQLContainer postgres = new LoomPostgreSQLContainer();

	@Test
	public void testIntegration() throws Exception {
		LoomOptions options = new LoomOptions();
		options.setDatabase(postgres.getOptions());

		Loom loom = Loom.create(options);
		loom.run(false);

		Testdata data = TestEnvHelper.prepareTestdata("integration-test");
		String path = data.root().getAbsolutePath();
		LoomWorkerCLI.execute("--hostname", "localhost",
			"--port", String.valueOf(options.getServer().getGrpcPort()),
			"p", "analyze", path);
		loom.shutdown();
	}
}
