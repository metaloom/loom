package io.metaloom.loom.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public final class TestEnvHelper {

	private TestEnvHelper() {
	}

	public static Testdata prepareTestdata(String name) throws IOException {
		File source = new File("src/test/resources/test-fs");
		File dest = new  File("target", "test-env-" + name);
		FileUtils.copyDirectory(source, dest);
		return new Testdata(dest);
	}
}
