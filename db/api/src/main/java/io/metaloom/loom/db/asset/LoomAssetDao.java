package io.metaloom.loom.db.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface LoomAssetDao extends LoomDao {

	LoomAsset createAsset();

	void deleteAsset(LoomAsset asset);

	void updateAsset(LoomAsset asset);

	Maybe<? extends LoomAsset> loadAsset(UUID uuid);

	void storeAsset(LoomAsset asset);

	Observable<LoomTag> loadTags(LoomAsset asset);

	void addTag(LoomAsset asset, LoomTag tag);

	void removeTag(LoomAsset asset, LoomTag tag);
}
