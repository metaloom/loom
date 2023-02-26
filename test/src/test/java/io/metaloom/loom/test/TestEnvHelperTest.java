package io.metaloom.loom.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

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
