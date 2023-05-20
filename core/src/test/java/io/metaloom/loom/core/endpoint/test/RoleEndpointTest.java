package io.metaloom.loom.core.endpoint.test;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.api.sort.LoomSortKey;
import io.metaloom.loom.api.sort.SortDirection;
import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.rest.model.role.RoleCreateRequest;
import io.metaloom.loom.rest.model.role.RoleListResponse;
import io.metaloom.loom.rest.model.role.RoleResponse;

public class RoleEndpointTest extends AbstractEndpointTest {

	@Test
	public void testSortByName() throws HttpErrorException {
		try (LoomHttpClient client = loom.httpClient()) {
			loginAdmin(client);

			for (int i = 0; i < 100; i++) {
				RoleCreateRequest request = new RoleCreateRequest();
				request.setName("role_" + i);
				client.createRole(request).sync();
			}

			RoleListResponse pageResponse = client.listRoles()
				.addLimit(10)
				.sortBy(LoomSortKey.NAME)
				.sortDirection(SortDirection.ASCENDING)
				.sync();

			for (RoleResponse element : pageResponse.getData()) {
				System.out.println(element.getName());
			}
		}
	}
}
