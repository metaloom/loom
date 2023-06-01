package io.metaloom.loom.core.endpoint.test;

import static io.metaloom.loom.rest.model.assertj.Assertions.assertThat;

import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.model.embedding.EmbeddingCreateRequest;
import io.metaloom.loom.rest.model.embedding.EmbeddingListResponse;
import io.metaloom.loom.rest.model.embedding.EmbeddingResponse;
import io.metaloom.loom.rest.model.embedding.EmbeddingUpdateRequest;

public class EmbeddingEndpointTest extends AbstractCRUDEndpointTest {

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		EmbeddingResponse embedding = client.loadEmbedding(EMBEDDING_UUID).sync();
		assertThat(embedding).isValid();
	}

	@Override
	protected void testCreate(LoomHttpClient client) throws HttpErrorException {
		EmbeddingCreateRequest request = new EmbeddingCreateRequest();
		request.setVector(new Float[] { 0.42f, 0.24f });
		request.setType(EmbeddingType.VIDEO4J_FINGERPRINT_V1);
		request.setAssetUuid(ASSET_UUID);
		EmbeddingResponse response = client.createEmbedding(request).sync();
		assertThat(response).isValid();
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteEmbedding(EMBEDDING_UUID).sync();
		expect(404, "Not Found", client.loadEmbedding(EMBEDDING_UUID));
	}

	@Override
	protected void testUpdate(LoomHttpClient client) throws HttpErrorException {
		EmbeddingUpdateRequest request = new EmbeddingUpdateRequest();
		client.updateEmbedding(EMBEDDING_UUID, request).sync();
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws HttpErrorException {
		EmbeddingListResponse response = client.listEmbeddings().sync();
	}

}
