package io.metaloom.loom.server.grpc;

import java.util.UUID;

import javax.inject.Inject;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.asset.LoomAssetBinary;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.proto.AssetRequest;
import io.metaloom.loom.proto.AssetResponse;
import io.metaloom.loom.proto.VertxAssetLoaderGrpc.AssetLoaderVertxImplBase;
import io.vertx.core.Future;

public class GrpcAssetLoader extends AssetLoaderVertxImplBase {

	private final LoomDaoCollection daos;

	@Inject
	public GrpcAssetLoader(LoomDaoCollection daos) {
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

		LoomNamespace namespace = daos.namespaceDao().createNamespace("test");
		LoomAssetBinary binary = daos.assetBinaryDao().createBinary(sha512sum, size);
		binary.setSHA256(sha256sum);
		binary.setFingerprint(fingerprint);
		binary.setZeroChunkCount(zeroChunkCount);
		binary.setChunkHash(chunkHash);
		LoomUser creator = daos.userDao().createUser("test");
		daos.assetBinaryDao().storeBinary(binary);
		LoomAsset asset = daos.assetDao().createAsset(path, binary.getUuid(), creator, namespace.getUuid());
		daos.assetDao().storeAsset(asset);

		UUID uuid = asset.getUuid();

		return Future.succeededFuture(
			AssetResponse.newBuilder()
				.setChunkHash("Reply with " + request.getFingerprint())
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
