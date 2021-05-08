package io.metaloom.loom.db.extension;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface LoomExtensionDao extends LoomDao {

	LoomExtension createExtension();

	Maybe<? extends LoomExtension> loadExtension(UUID uuid);

	void updateExtension(LoomExtension extension);

	void deleteExtension(LoomExtension extension);

	void storeExtension(LoomExtension extension);
}
