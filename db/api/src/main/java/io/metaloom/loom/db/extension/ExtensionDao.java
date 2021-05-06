package io.metaloom.loom.db.extension;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface ExtensionDao extends LoomDao {

	Extension createExtension();

	Maybe<? extends Extension> loadExtension(UUID uuid);

	void updateExtension(Extension extension);

	void deleteExtension(Extension extension);

	void storeExtension(Extension extension);
}
