package io.metaloom.loom.core.endpoint.test;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.core.endpoint.CRUDEndpointTestcases;
import io.metaloom.loom.rest.model.embedding.EmbeddingCreateRequest;
import io.metaloom.loom.rest.model.embedding.EmbeddingResponse;
import io.metaloom.loom.rest.model.embedding.EmbeddingType;
import io.metaloom.loom.rest.model.embedding.EmbeddingUpdateRequest;

public class EmbeddingEndpointTest extends AbstractEndpointTest implements CRUDEndpointTestcases {

	@Test
	@Override
	public void testRead() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			loginAdmin(client);
			EmbeddingResponse response = client.loadEmbedding(EMBEDDING_UUID).sync();
		}

	}

	@Test
	@Override
	public void testCreate() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			loginAdmin(client);
			EmbeddingCreateRequest request = new EmbeddingCreateRequest();
			request.setId(42L);
			request.setData(new Float[] { 0.42f, 0.24f });
			request.setType(EmbeddingType.VIDEO4J_FINGERPRINT_V1);
			request.setAssetUuid(ASSET_UUID);
			EmbeddingResponse response = client.createEmbedding(request).sync();
		}

	}

	@Test
	@Override
	public void testDelete() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			loginAdmin(client);
			client.deleteEmbedding(EMBEDDING_UUID).sync();
		}
	}

	@Test
	@Override
	public void testUpdate() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			loginAdmin(client);
			EmbeddingUpdateRequest request = new EmbeddingUpdateRequest();
			client.updateEmbedding(EMBEDDING_UUID, request).sync();
		}
	}

	@Test
	@Override
	public void testReadPaged() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			loginAdmin(client);
			client.listEmbeddings().sync();
		}

	}

}
