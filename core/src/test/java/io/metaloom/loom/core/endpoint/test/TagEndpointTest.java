package io.metaloom.loom.core.endpoint.test;

import static io.metaloom.loom.rest.model.assertj.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.model.tag.TagCreateRequest;
import io.metaloom.loom.rest.model.tag.TagListResponse;
import io.metaloom.loom.rest.model.tag.TagResponse;
import io.metaloom.loom.rest.model.tag.TagUpdateRequest;

public class TagEndpointTest extends AbstractCRUDEndpointTest {

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		TagResponse tag = client.loadTag(TAG_UUID).sync();
		assertThat(tag).isValid();
	}

	@Override
	protected void testCreate(LoomHttpClient client) throws HttpErrorException {
		TagCreateRequest request = new TagCreateRequest();
		request.setName("dummy name");
		request.setCollection("test");
		TagResponse tag = client.createTag(request).sync();
		assertThat(tag).isValid();

		TagResponse tag2 = client.loadTag(tag.getUuid()).sync();
		assertThat(tag2).matches(tag2);
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteTag(TAG_UUID).sync();
		expect(404, "Not Found", client.loadTag(TAG_UUID));
	}

	@Override
	protected void testUpate(LoomHttpClient client) throws HttpErrorException {
		TagUpdateRequest update = new TagUpdateRequest();
		update.setName("updated-name");
		TagResponse response = client.updateTag(TAG_UUID, update).sync();
		assertThat(response).isValid();
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws HttpErrorException {
		for (int i = 0; i < 100; i++) {
			TagCreateRequest request = new TagCreateRequest();
			request.setName("dummy title " + i);
			request.setCollection("test");
			client.createTag(request).sync();
		}
		TagListResponse list = client.listTags().sync();
		assertThat(list).isValid().hasSize(25).hasPerPage(25);
	}

}
