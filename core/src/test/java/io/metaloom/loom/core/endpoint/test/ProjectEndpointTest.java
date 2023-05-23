package io.metaloom.loom.core.endpoint.test;

import static io.metaloom.loom.rest.model.assertj.Assertions.assertThat;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.model.project.ProjectCreateRequest;
import io.metaloom.loom.rest.model.project.ProjectListResponse;
import io.metaloom.loom.rest.model.project.ProjectResponse;
import io.metaloom.loom.rest.model.project.ProjectUpdateRequest;

public class ProjectEndpointTest extends AbstractCRUDEndpointTest {

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		ProjectResponse project = client.loadProject(PROJECT_UUID).sync();
		assertThat(project).isValid();
	}

	@Override
	protected void testCreate(LoomHttpClient client) throws HttpErrorException {
		ProjectCreateRequest request = new ProjectCreateRequest();
		request.setName("dummy name");
		ProjectResponse project = client.createProject(request).sync();
		assertThat(project).isValid();

		ProjectResponse project2 = client.loadProject(project.getUuid()).sync();
		assertThat(project).matches(project2);
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteProject(PROJECT_UUID).sync();
		expect(404, "Not Found", client.loadProject(PROJECT_UUID));
	}

	@Override
	protected void testUpdate(LoomHttpClient client) throws HttpErrorException {
		ProjectUpdateRequest update = new ProjectUpdateRequest();
		update.setName("updated-name");
		ProjectResponse response = client.updateProject(PROJECT_UUID, update).sync();
		assertThat(response).isValid();
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws HttpErrorException {
		for (int i = 0; i < 100; i++) {
			ProjectCreateRequest request = new ProjectCreateRequest();
			request.setName("dummy name");
			client.createProject(request).sync();
		}
		ProjectListResponse list = client.listProjects().sync();
		assertThat(list).isValid().hasSize(25).hasPerPage(25);
	}

}
