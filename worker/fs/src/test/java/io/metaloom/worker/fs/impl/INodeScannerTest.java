package io.metaloom.worker.fs.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

public class INodeScannerTest {
	record FileInfo(String path, long inode, long size, long modTime) {
	}

	@Test
	public void testScanInodes() throws IOException {
		long inode = INodeUtils.loadInode(new File("pom.xml"));
		System.out.println("inode: " + inode);
	}

	@Test
	public void testScanFolder() throws IOException {
		new File("db").mkdirs();
		File mapFile = new File("db/map.dat");
		Path sourcePath = Paths.get(".");
		Stream<FileInfo> stream = Files.walk(sourcePath)
			.filter(Files::isRegularFile)
			.map(p -> {
				try {
					String path = p.toAbsolutePath().toString();
					long inode = INodeUtils.loadInode(p);
					long size = Files.size(p);
					long modTime = INodeUtils.loadModificationEpochSecond(p);
					return new FileInfo(path, inode, size, modTime);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});

		//DB db = DBMaker.fileDB(mapFile).fileMmapEnable().make();
		//Map<String, String> loadedMapFiles = db.hashMap("mappedFiles", Serializer.STRING, Serializer.STRING).createOrOpen();
		//System.out.println("Loaded: " + loadedMapFiles.size());

//		Map<String, String> freshMapFiles = new HashMap<>();
//		AtomicLong count = new AtomicLong(0);
//		stream.forEach(info -> {
//			freshMapFiles.put(info.path(), info.inode() + "," + info.size() + "," + info.modTime());
//			count.incrementAndGet();
//		});
//		System.out.println("Added: " + count.toString());
//		MapDifference<String, String> d = Maps.difference(loadedMapFiles, freshMapFiles);
//		Map<String, ValueDifference<String>> delta = d.entriesDiffering();

		
		// Added
		// Modified
		// Removed
		// Moved
//		
//		System.out.println("Delta:");
//		delta.keySet().forEach(e -> {
//			System.out.println("Diff: " + e);
//			loadedMapFiles.remove(e);
//			loadedMapFiles.put(e, freshMapFiles.get(e));
//		});
//
//		db.close();

	}
}
