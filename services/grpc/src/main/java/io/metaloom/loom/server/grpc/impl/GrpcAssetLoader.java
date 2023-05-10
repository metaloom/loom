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
import io.vertx.core.Future;

public class GrpcAssetLoader extends AssetLoaderVertxImplBase {

	private final DaoCollection daos;

	@Inject
	public GrpcAssetLoader(DaoCollection daos) {
		this.daos = daos;
	}

	@Override
	public Future<AssetResponse> store(AssetRequest request) {
		String fingerprint = request.getFingerprint();
		String chunkHash = request.getChunkHash();
		long zeroChunkCount = request.getZeroChunkCount();
		String sha256sum = request.getSha256Sum();
		String sha512sum = request.getSha512Sum();
		String mimeType = request.getMimeType();
		long size = request.getSize();
		String path = request.getPath();
		String initialOrigin = request.getInitialOrigin();

		User user = null;
		Asset binary = daos.binaryDao().loadBySHA512Sum(sha512sum);
		if (binary == null) {
			binary = daos.binaryDao().createAsset(user, sha512sum, mimeType, initialOrigin, size);
		}

		binary.setSHA256(sha256sum);
		binary.setVideoFingerprint(fingerprint);
		binary.setZeroChunkCount(zeroChunkCount);
		binary.setChunkHash(chunkHash);
		daos.binaryDao().store(binary);

		User creator = daos.userDao().createUser("test");
		daos.userDao().store(creator);
		
		Library library = daos.libraryDao().createLibrary(user, "test");
		AssetLocation asset = daos.assetDao().createAssetLocation(path, binary.getUuid(), creator.getUuid(), library.getUuid());
		daos.assetDao().store(asset);

		UUID uuid = asset.getUuid();

		return Future.succeededFuture(
			AssetResponse.newBuilder()
				.setUuid(uuid.toString())
				.setSize(size)
				.setPath(path)
				.setChunkHash(chunkHash)
				.setSha256Sum(sha256sum)
				.setSha512Sum(sha512sum)
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
