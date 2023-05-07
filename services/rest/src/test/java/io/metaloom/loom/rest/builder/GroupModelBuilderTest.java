package io.metaloom.loom.rest.builder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.rest.model.group.GroupListResponse;

public class GroupModelBuilderTest extends AbstractModelBuilderTest {

	@Test
	public void testResponseModel() throws IOException {
		Group group = mockGroup();
		User user = mockUser("joedoe");
		assertWithModel(builder().toResponse(group, user, user), "group.response");
	}

	private User mockUser(String username) {
		User user = mock(User.class);
		when(user.getUuid()).thenReturn(USER_UUID);
		when(user.getUsername()).thenReturn(username);
		return user;
	}

	@Test
	public void testListResponseModel() throws IOException {
		Group group = mockGroup();
		User user = mockUser("joedoe");
		GroupListResponse list = new GroupListResponse();
		list.add(builder().toResponse(group, user, user));
		list.add(builder().toResponse(group, user, user));
		assertWithModel(list, "group.list_response");
	}

	private Group mockGroup() {
		Group group = mock(Group.class);
		when(group.getName()).thenReturn("group_name");
		mockMeta(group);
		mockCreatorEditor(group);
		return group;
	}


}
