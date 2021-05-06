package io.metaloom.loom.db.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface AssetDao extends LoomDao {

	Asset createAsset();

	void deleteAsset(Asset asset);

	void updateAsset(Asset asset);

	Maybe<? extends Asset> loadAsset(UUID uuid);

	void storeAsset(Asset asset);

	Observable<Tag> loadTags(Asset asset);

	void addTag(Asset asset, Tag tag);

	void removeTag(Asset asset, Tag tag);
}
