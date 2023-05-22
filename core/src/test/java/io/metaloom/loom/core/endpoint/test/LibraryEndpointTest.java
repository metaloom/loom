package io.metaloom.loom.core.endpoint.test;

import static io.metaloom.loom.rest.model.assertj.Assertions.assertThat;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.model.library.LibraryCreateRequest;
import io.metaloom.loom.rest.model.library.LibraryListResponse;
import io.metaloom.loom.rest.model.library.LibraryResponse;
import io.metaloom.loom.rest.model.library.LibraryUpdateRequest;

public class LibraryEndpointTest extends AbstractCRUDEndpointTest {

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		LibraryResponse library = client.loadLibrary(LIBRARY_UUID).sync();
		assertThat(library).isValid();
	}

	@Override
	protected void testCreate(LoomHttpClient client) throws HttpErrorException {
		LibraryCreateRequest request = new LibraryCreateRequest();
		request.setName("dummy name");
		LibraryResponse library = client.createLibrary(request).sync();
		assertThat(library).isValid();

		LibraryResponse library2 = client.loadLibrary(library.getUuid()).sync();
		assertThat(library).matches(library2);
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteLibrary(LIBRARY_UUID).sync();
		expect(404, "Not Found", client.loadLibrary(LIBRARY_UUID));
	}

	@Override
	protected void testUpate(LoomHttpClient client) throws HttpErrorException {
		LibraryUpdateRequest update = new LibraryUpdateRequest();
		update.setName("updated-name");
		LibraryResponse response = client.updateLibrary(LIBRARY_UUID, update).sync();
		assertThat(response).isValid();
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws HttpErrorException {
		for (int i = 0; i < 100; i++) {
			LibraryCreateRequest request = new LibraryCreateRequest();
			request.setName("dummy name");
			client.createLibrary(request).sync();
		}
		LibraryListResponse list = client.listLibraries().sync();
		assertThat(list).isValid().hasSize(25).hasPerPage(25);
	}

}
