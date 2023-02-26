package io.metaloom.worker.action.api;

import java.util.List;

public enum ProcessableMediaMeta {

	SHA_512("sha512", true, String.class),

	SHA_256("sha256", true, String.class),

	ZERO_CHUNK_COUNT("zero_chunk_count", true, Long.class),

	FACES("faces", false, List.class),

	CHUNK_HASH("chun_hash", true, String.class),

	THUMBNAIL_FLAGS("thumbnail_flags", true, String.class),

	FINGERPRINT("fingerprint", true, String.class);

	private String name;

	private boolean persisted;

	private Class<?> type;

	private ProcessableMediaMeta(String name, boolean persisted, Class<?> type) {
		this.name = name;
		this.persisted = persisted;
		this.type = type;
	}

	public String key() {
		String PREFIX = "loom";
		String VERSION = "1_0";
		return PREFIX + "_" + VERSION + "_" + name;
	}

	public boolean isPersisted() {
		return persisted;
	}

	public Class<?> type() {
		return type;
	}

}
