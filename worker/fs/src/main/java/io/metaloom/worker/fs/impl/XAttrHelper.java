package io.metaloom.worker.fs.impl;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

public final class XAttrHelper {

	private XAttrHelper() {
	}

	public static <T> T readAttr(Path path, String key, Class<T> classOfT) {
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
			return ByteBufferUtils.convertFromByteBuffer(buffer, classOfT);
		} catch (Exception e) {
			throw new RuntimeException("Could not read property " + key, e);
		}
	}

	public static void writeAttr(Path path, String key, Object value) {
		try {
			UserDefinedFileAttributeView userDefinedFAView = Files
				.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			ByteBuffer buffer = ByteBufferUtils.convertToByteBuffer(value);
			userDefinedFAView.write(key, buffer);
		} catch (Exception e) {
			throw new RuntimeException("Failed to write attr {" + key + "} to file {" + path + "}", e);
		}
	}

	public static void writeAttr(Path path, String key, Long value) {
		writeAttr(path, key, String.valueOf(value));
	}

	public static List<String> listAttr(Path path) {
		try {
			UserDefinedFileAttributeView userDefinedFAView = Files
				.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			return userDefinedFAView.list();
		} catch (Exception e) {
			throw new RuntimeException("Failed to list attr for file {" + path + "}", e);
		}
	}

}
