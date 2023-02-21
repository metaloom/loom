package io.metaloom.worker.action;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import io.metaloom.utils.FilterHelper;
import io.metaloom.utils.hash.HashUtils;
import io.metaloom.worker.fs.impl.XAttrHelper;

public class ProcessableMediaImpl extends AbstractFilesystemMedia {

	public static final String SHA512_ATTR_KEY = "sha512sum";

	private Path path;

	private Map<String, String> attrCache = new HashMap<>();

	public ProcessableMediaImpl(Path path) {
		this.path = path;
	}

	@Override
	public Path path() {
		return path;
	}

	@Override
	public boolean isVideo() {
		return FilterHelper.isVideo(path());
	}

	@Override
	public boolean isImage() {
		return FilterHelper.isImage(path());
	}

	@Override
	public boolean isAudio() {
		return FilterHelper.isAudio(path());
	}

	@Override
	public boolean exists() {
		return file().exists();
	}

	@Override
	public File file() {
		return path.toFile();
	}

	@Override
	public String absolutePath() {
		return file().getAbsolutePath();
	}

	@Override
	public String readAttrStr(String attrKey) {
		return attrCache.computeIfAbsent(attrKey, key -> {
			return XAttrHelper.readAttrStr(path(), attrKey);
		});
	}

	@Override
	public Long readAttrLong(String attrKey) {
		String strValue = attrCache.computeIfAbsent(attrKey, key -> {
			return XAttrHelper.readAttrStr(path(), attrKey);
		});
		return Long.parseLong(strValue);
	}

	@Override
	public ProcessableMedia writeAttr(String attrKey, String value) {
		String cacheValue = attrCache.get(attrKey);
		// No need to do anything if the cache is still valid
		if (value == null && cacheValue == null || value.equals(cacheValue)) {
			return this;
		}
		XAttrHelper.writeAttr(path(), attrKey, value);
		attrCache.put(attrKey, value);
		return this;
	}

	@Override
	public ProcessableMedia writeAttr(String attrKey, Long value) {
		writeAttr(attrKey, String.valueOf(value));
		return this;
	}

	@Override
	public String getHash512() {
		String hashSum512 = readAttrStr(SHA512_ATTR_KEY);
		if (hashSum512 == null) {
			hashSum512 = HashUtils.computeSHA512(file());
			writeAttr(SHA512_ATTR_KEY, hashSum512);
		}
		return hashSum512;
	}

}
