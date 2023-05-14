package io.metaloom.loom.core.endpoint.test;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.core.endpoint.CRUDEndpointTestcases;
import io.metaloom.loom.rest.model.auth.AuthLoginResponse;
import io.metaloom.loom.rest.model.embedding.EmbeddingCreateRequest;
import io.metaloom.loom.rest.model.embedding.EmbeddingResponse;
import io.metaloom.loom.rest.model.embedding.EmbeddingType;
import io.metaloom.loom.rest.model.embedding.EmbeddingUpdateRequest;

public class EmbeddingEndpointTest extends AbstractEndpointTest implements CRUDEndpointTestcases {

	@Test
	@Override
	public void testRead() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			EmbeddingResponse response = client.loadEmbedding(EMBEDDING_UUID).sync();
		}

	}

	@Test
	@Override
	public void testCreate() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			AuthLoginResponse loginResponse = client.login("admin", "finger").sync();
			client.setToken(loginResponse.getToken());
			EmbeddingCreateRequest request = new EmbeddingCreateRequest();
			request.setId(42L);
			request.setData(new float[] { 0.42f, 0.24f });
			request.setType(EmbeddingType.VIDEO4J_FINGERPRINT_V1);
			request.setAssetUuid(ASSET_UUID);
			EmbeddingResponse response = client.createEmbedding(request).sync();
		}

	}

	@Test
	@Override
	public void testDelete() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			client.deleteEmbedding(EMBEDDING_UUID).sync();
		}
	}

	@Test
	@Override
	public void testUpdate() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			EmbeddingUpdateRequest request = new EmbeddingUpdateRequest();
			client.updateEmbedding(EMBEDDING_UUID, request).sync();
		}
	}

	@Test
	@Override
	public void testReadPaged() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			client.listEmbeddings(null, 25).sync();
		}

	}

}
