package io.metaloom.worker.action.media;

import static io.metaloom.worker.action.api.ProcessableMediaMeta.SHA_512;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.metaloom.utils.FilterHelper;
import io.metaloom.utils.hash.HashUtils;
import io.metaloom.worker.action.api.ProcessableMedia;
import io.metaloom.worker.fs.impl.XAttrHelper;

public class ProcessableMediaImpl extends AbstractFilesystemMedia {

	private Path path;

	private Map<String, Object> attrCache = new HashMap<>();

	private Boolean complete;

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
	public List<String> listXAttr() {
		return XAttrHelper.listAttr(path());
	}

	private <T> T readAttr(String attrKey, Class<T> classOfT) {
		return XAttrHelper.readAttr(path(), attrKey, classOfT);
	}

	private ProcessableMedia writeAttr(String attrKey, Object value) {
		XAttrHelper.writeAttr(path(), attrKey, value);
		attrCache.put(attrKey, value);
		return this;
	}

	@Override
	public String getHash512() {
		String hashSum512 = get(SHA_512);
		if (hashSum512 == null) {
			hashSum512 = HashUtils.computeSHA512(file());
			put(SHA_512, hashSum512);
		}
		return hashSum512;
	}

	@Override
	public Boolean isComplete() {
		return complete;
	}

	@Override
	public <T> T get(String key, Class<T> classOfT) {
		return classOfT.cast(attrCache.computeIfAbsent(key, attrKey -> {
			Object cacheValue = attrCache.get(attrKey);
			if (cacheValue == null) {
				return readAttr(key, classOfT);
			}
			return null;
		}));
	}

	@Override
	public ProcessableMedia put(String key, Object value, boolean writeToXattr) {
		Object cacheValue = attrCache.get(key);
		// No need to do anything if the cache is still valid
		if (value == null && cacheValue == null || value.equals(cacheValue)) {
			return this;
		}

		if (writeToXattr) {
			writeAttr(key, value);
		} else {
			attrCache.put(key, value);
		}
		return this;
	}
}
