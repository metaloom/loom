package io.metaloom.loom.db.model.extension;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface ExtensionDao extends LoomDao {

	Single<? extends Extension> createExtension();

	Maybe<? extends Extension> loadExtension(UUID uuid);

	Completable updateExtension(Extension extension);

	Completable deleteExtension(Extension extension);

}
