package io.metaloom.loom.test;

import java.io.File;
import java.nio.file.Path;

public class Testdata {

	private File root;

	public Testdata(File root) {
		this.root = root;
	}

	public File root() {
		return root;
	}

	public Path sampleVideoPath() {
		return new File(root, "folderA/folderB/pexels-jack-sparrow-5977265.mp4").toPath();
	}

}
