package io.metaloom.loom.db.model.extension;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface ExtensionDao extends LoomDao {

	default Single<? extends Extension> createExtension(String url) {
		return createExtension(url, null);
	}

	Single<? extends Extension> createExtension(String url, Consumer<Extension> modifier);

	Maybe<? extends Extension> loadExtension(UUID uuid);

	Completable updateExtension(Extension extension);

	Completable deleteExtension(Extension extension);

}
