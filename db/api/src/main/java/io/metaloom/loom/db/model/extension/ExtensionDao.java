package io.metaloom.loom.db.model.extension;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.Dao;

public interface ExtensionDao extends Dao {

	default Extension createExtension(String url) {
		return createExtension(url, null);
	}

	Extension createExtension(String url, Consumer<Extension> modifier);

	Extension loadExtension(UUID uuid);

	void updateExtension(Extension extension);

	void deleteExtension(Extension extension);

}
