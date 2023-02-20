package io.metaloom.loom.db.model.asset;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface LoomAssetDao extends LoomDao {

	default Single<? extends LoomAsset> createAsset() {
		return createAsset(null);
	}

	Single<? extends LoomAsset> createAsset(Consumer<LoomAsset> modifier);

	Completable deleteAsset(LoomAsset asset);

	Completable updateAsset(LoomAsset asset);

	Maybe<? extends LoomAsset> loadAsset(UUID uuid);

	Observable<LoomTag> loadTags(LoomAsset asset);

	Completable addTag(LoomAsset asset, LoomTag tag);

	Completable removeTag(LoomAsset asset, LoomTag tag);
}
