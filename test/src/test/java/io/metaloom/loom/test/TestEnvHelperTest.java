package io.metaloom.loom.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

public class TestEnvHelperTest {

	@Test
	public void testHelper() throws IOException {
		File expectedPath = new File("target", "test-env-postfix");
		if (expectedPath.exists()) {
			FileUtils.deleteDirectory(expectedPath);
		}
		Testdata data = TestEnvHelper.prepareTestdata("postfix");
		assertTrue(data.root().exists());
		assertEquals(expectedPath.getAbsolutePath(), data.root().getAbsolutePath());
	}

}
