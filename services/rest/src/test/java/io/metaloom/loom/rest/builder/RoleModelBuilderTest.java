package io.metaloom.loom.rest.builder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.role.RoleListResponse;

public class RoleModelBuilderTest extends AbstractModelBuilderTest {

	@Test
	@Override
	void testResponseModel() throws IOException {
		Role role = mockRole();
		User user = mockUser("joedoe");
		assertWithModel(builder().toResponse(role, user, user), "role.response");
	}

	@Test
	@Override
	void testListResponseModel() throws IOException {
		Role role = mockRole();
		Page<Role> page = mockPage(role, role);
		RoleListResponse list = builder().toRoleList(page);
		assertWithModel(list, "role.list_response");
	}

	private Role mockRole() {
		Role role = mock(Role.class);
		when(role.getName()).thenReturn("the_role_name");
		return role;
	}

}
