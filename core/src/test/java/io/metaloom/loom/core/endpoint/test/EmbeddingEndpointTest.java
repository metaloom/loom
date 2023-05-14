package io.metaloom.loom.core.endpoint.test;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.core.endpoint.CRUDEndpointTestcases;
import io.metaloom.loom.rest.model.embedding.EmbeddingCreateRequest;
import io.metaloom.loom.rest.model.embedding.EmbeddingResponse;
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
			EmbeddingCreateRequest request = new EmbeddingCreateRequest();
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
