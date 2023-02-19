package io.metaloom.loom.db.jooq.dao.asset;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class AssetDaoImpl extends AbstractDao implements AssetDao {

	@Inject
	public AssetDaoImpl() {
	}

	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Asset> createAsset(Consumer<Asset> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteAsset(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateAsset(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Asset> loadAsset(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Tag> loadTags(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(Asset asset, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable removeTag(Asset asset, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
