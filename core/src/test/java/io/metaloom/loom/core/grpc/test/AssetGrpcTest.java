package io.metaloom.loom.core.grpc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.proto.AssetResponse;

public class AssetGrpcTest extends AbstractEndpointTest {

	@Test
	public void testAssetLoad() {
		try (LoomGRPCClient client = loom.grpcClient()) {
			//client.setToken(generateJWT());
			AssetResponse response = client.loadAsset(SHA512SUM).sync();
			assertNotNull(response);
		}
	}
}
