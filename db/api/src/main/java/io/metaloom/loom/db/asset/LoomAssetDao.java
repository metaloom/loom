package io.metaloom.loom.db.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LoomAssetDao extends LoomDao {

	Single<? extends LoomAsset> createAsset();

	Completable deleteAsset(LoomAsset asset);

	Completable updateAsset(LoomAsset asset);

	Maybe<? extends LoomAsset> loadAsset(UUID uuid);

	Observable<LoomTag> loadTags(LoomAsset asset);

	Completable addTag(LoomAsset asset, LoomTag tag);

	Completable removeTag(LoomAsset asset, LoomTag tag);
}
