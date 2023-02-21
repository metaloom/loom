package io.metaloom.loom.client.grpc;

import io.metaloom.loom.client.ClientSettings;
import io.metaloom.loom.proto.AssetLoaderGrpc;
import io.metaloom.loom.proto.VertxAssetLoaderGrpc;

public final class InternalGrpcUtil {

	private InternalGrpcUtil() {
	}

	public static AssetLoaderGrpc.AssetLoaderBlockingStub assetsStub(ClientSettings client) {
		return AssetLoaderGrpc.newBlockingStub(client.channel());
	}

	public static VertxAssetLoaderGrpc.AssetLoaderVertxStub assetsVertxStub(ClientSettings client) {
		return VertxAssetLoaderGrpc.newVertxStub(client.channel());
	}

}