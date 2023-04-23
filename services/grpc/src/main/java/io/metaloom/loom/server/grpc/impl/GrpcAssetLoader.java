package io.metaloom.loom.server.grpc.impl;

import java.util.UUID;

import javax.inject.Inject;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetBinary;
import io.metaloom.loom.db.model.namespace.Namespace;
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
		long size = request.getSize();
		String path = request.getPath();

		AssetBinary binary = daos.assetBinaryDao().loadBinary(sha512sum);
		if (binary == null) {
			binary = daos.assetBinaryDao().createBinary(sha512sum, size);
		}

		binary.setSHA256(sha256sum);
		binary.setFingerprint(fingerprint);
		binary.setZeroChunkCount(zeroChunkCount);
		binary.setChunkHash(chunkHash);
		daos.assetBinaryDao().storeBinary(binary);

		User creator = daos.userDao().createUser("test");
		daos.userDao().storeUser(creator);
		
		Namespace namespace = daos.namespaceDao().createNamespace("test");
		Asset asset = daos.assetDao().createAsset(path, binary.getUuid(), creator.getUuid(), namespace.getUuid());
		daos.assetDao().storeAsset(asset);

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
