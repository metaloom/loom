package io.metaloom.loom.db.extension;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoomExtensionDao extends LoomDao {

	Single<? extends LoomExtension> createExtension();

	Maybe<? extends LoomExtension> loadExtension(UUID uuid);

	Completable updateExtension(LoomExtension extension);

	Completable deleteExtension(LoomExtension extension);

	Completable storeExtension(LoomExtension extension);
}
