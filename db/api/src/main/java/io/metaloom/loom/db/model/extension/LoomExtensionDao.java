package io.metaloom.loom.db.model.extension;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;

public interface LoomExtensionDao extends LoomDao {

	default LoomExtension createExtension(String url) {
		return createExtension(url, null);
	}

	LoomExtension createExtension(String url, Consumer<LoomExtension> modifier);

	LoomExtension loadExtension(UUID uuid);

	void updateExtension(LoomExtension extension);

	void deleteExtension(LoomExtension extension);

}
