package io.metaloom.loom.core.endpoint;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;

public abstract class AbstractCRUDEndpointTest extends AbstractEndpointTest implements CRUDEndpointTestcases {

	@Test
	@Override
	public void testRead() throws HttpErrorException {
		try (LoomHttpClient client = loom.httpClient()) {
			loginAdmin(client);
			testRead(client);
		}
	}

	protected abstract void testRead(LoomHttpClient client) throws HttpErrorException;

	@Test
	@Override
	public void testCreate() throws HttpErrorException {
		try (LoomHttpClient client = loom.httpClient()) {
			loginAdmin(client);
			testCreate(client);
		}
	}

	protected abstract void testCreate(LoomHttpClient client) throws HttpErrorException;

	@Test
	@Override
	public void testDelete() throws HttpErrorException {
		try (LoomHttpClient client = loom.httpClient()) {
			loginAdmin(client);
			testDelete(client);
		}
	}

	protected abstract void testDelete(LoomHttpClient client) throws HttpErrorException;

	@Test
	@Override
	public void testUpdate() throws HttpErrorException {
		try (LoomHttpClient client = loom.httpClient()) {
			loginAdmin(client);
			testUpate(client);
		}
	}

	protected abstract void testUpate(LoomHttpClient client) throws HttpErrorException;

	@Test
	@Override
	public void testReadPaged() throws HttpErrorException {
		try (LoomHttpClient client = loom.httpClient()) {
			loginAdmin(client);
			testReadPage(client);
		}
	}

	protected abstract void testReadPage(LoomHttpClient client) throws HttpErrorException;

}
