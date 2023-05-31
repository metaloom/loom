package io.metaloom.loom.server.grpc.impl;

import java.util.UUID;

import javax.inject.Inject;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.proto.AssetRequest;
import io.metaloom.loom.proto.AssetResponse;
import io.metaloom.loom.proto.VertxAssetLoaderGrpc.AssetLoaderVertxImplBase;
import io.metaloom.utils.hash.SHA512Sum;
import io.vertx.core.Future;

public class GrpcAssetLoader extends AssetLoaderVertxImplBase {

	private final DaoCollection daos;

	@Inject
	public GrpcAssetLoader(DaoCollection daos) {
		this.daos = daos;
	}

	@Override
	public Future<AssetResponse> store(AssetRequest request) {
		//String uuid = request.getUuid();
		
		String fingerprint = request.getFingerprint();
		String chunkHash = request.getChunkHash();
		long zeroChunkCount = request.getZeroChunkCount();
		String sha256sum = request.getSha256Sum();
		String sha512sumStr = request.getSha512Sum();
		SHA512Sum sha512sum = SHA512Sum.fromString(sha512sumStr);
		String mimeType = request.getMimeType();
		long size = request.getSize();
		String initialOrigin = request.getInitialOrigin();
		String filename = request.getFilename();

		User user = null;
		Asset asset = daos.assetDao().loadBySHA512(sha512sum);
		if (asset == null) {
			asset = daos.assetDao().createAsset(user, sha512sum, mimeType, filename, initialOrigin, size);
		}

		asset.setSHA256(sha256sum);
		asset.setZeroChunkCount(zeroChunkCount);
		asset.setChunkHash(chunkHash);
		daos.assetDao().store(asset);

		User creator = daos.userDao().createUser("test");
		daos.userDao().store(creator);
		
		Library library = daos.libraryDao().createLibrary(user, "test");
		AssetLocation assetLocation = daos.assetLocationDao().createAssetLocation(filename, asset.getUuid(), creator.getUuid(), library.getUuid());
		daos.assetLocationDao().store(assetLocation);

		UUID uuid = asset.getUuid();

		return Future.succeededFuture(
			AssetResponse.newBuilder()
				.setUuid(uuid.toString())
				.setSize(size)
				.setFilename(filename)
				.setChunkHash(chunkHash)
				.setSha256Sum(sha256sum)
				.setSha512Sum(sha512sum.toString())
				.setFingerprint(fingerprint)
				.setZeroChunkCount(zeroChunkCount)
				.build());
	}

	@Override
	public Future<AssetResponse> load(AssetRequest request) {
		return Future.succeededFuture(
			AssetResponse.newBuilder()
				.setChunkHash("Reply with " + request.getFingerprint())
				.build());
	}

}
