package io.metaloom.loom.test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Testdata {

	private File root;

	public Testdata(File root) {
		this.root = root;
	}

	public File root() {
		return root;
	}

	public Path sampleVideoPath() {
		return Paths.get(root.getAbsolutePath(), "folderA/folderB/pexels-jack-sparrow-5977265.mp4");
	}

	public String sampleVideoSHA512() {
		return "dbf5dae6e3825ac5b2b595a37b3945a91bb67e9dad85c1e4ff5c3fdb2948b1100d71dc4e1ebd9a854928c34c5f71a81cd0f258f4652aee3aa2345742177ba3e7";
	}

	public String sampleVideoChunkHash() {
		return "41e705d6dc411b7444d760ceba3765d3d47397dbef3deb3260a86f0eecb41e94";
	}

	public String sampleVideoSHA256() {
		return "d7e2763589f1c2f393cc44414c5c7595cd711ba9c3284894227b0304c8c29e57";
	}

	public Path sampleVideo2Path() {
		return Paths.get(root.getAbsolutePath(), "folderA/folderB/pexels-mikhail-nilov-7626566.mp4");
	}

	public Path sampleVideo3Path() {
		return Paths.get(root.getAbsolutePath(), "folderA/folderC/pexels-fauxels-group-of-friends-smiling-3248275.mp4");
	}

}
