package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface AssetDao extends LoomDao {

	Single<? extends Asset> createAsset();

	Completable deleteAsset(Asset asset);

	Completable updateAsset(Asset asset);

	Maybe<? extends Asset> loadAsset(UUID uuid);

	Observable<Tag> loadTags(Asset asset);

	Completable addTag(Asset asset, Tag tag);

	Completable removeTag(Asset asset, Tag tag);
}
