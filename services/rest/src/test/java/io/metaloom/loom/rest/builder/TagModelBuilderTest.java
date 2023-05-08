package io.metaloom.loom.rest.builder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.tag.TagListResponse;

public class TagModelBuilderTest extends AbstractModelBuilderTest {

	@Override
	void testResponseModel() throws IOException {
		Tag tag = mockTag("red");
		User user = mockUser("joedoe");
		assertWithModel(builder().toResponse(tag, user, user), "tag.response");
	}

	@Override
	void testListResponseModel() throws IOException {
		Tag tag1 = mockTag("red");
		Tag tag2 = mockTag("blue");
		Page<Tag> page = mockPage(tag1, tag2);
		TagListResponse list = builder().toTagList(page);
		assertWithModel(list, "tag.list_response");

	}

	private Tag mockTag(String name) {
		Tag tag = mock(Tag.class);
		when(tag.getName()).thenReturn(name);
		return tag;
	}

}
