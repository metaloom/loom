package io.metaloom.worker.fs.impl;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public final class XAttrHelper {

	private XAttrHelper() {
	}

	public static String readAttrStr(Path path, String key) {
		try {
			UserDefinedFileAttributeView userDefinedFAView = Files
				.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			if (!userDefinedFAView.list().contains(key)) {
				return null;
			}
			int size = userDefinedFAView.size(key);
			if (size == -1) {
				return null;
			}
			ByteBuffer buffer = ByteBuffer.allocate(size);
			userDefinedFAView.read(key, buffer);
			return new String(buffer.array());
		} catch (Exception e) {
			throw new RuntimeException("Could not read property " + key, e);
		}
	}

	public static Long readAttrLong(Path path, String key) {
		return Long.valueOf(readAttrStr(path, key));
	}

	public static void writeAttr(Path path, String key, String value) {
		try {
			UserDefinedFileAttributeView userDefinedFAView = Files
				.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			userDefinedFAView.write(key, Charset.defaultCharset().encode(value));
		} catch (Exception e) {
			throw new RuntimeException("Failed to write attr to file {" + path + "}", e);
		}
	}

	public static void writeAttr(Path path, String key, Long value) {
		writeAttr(path, key, String.valueOf(value));
	}

}
