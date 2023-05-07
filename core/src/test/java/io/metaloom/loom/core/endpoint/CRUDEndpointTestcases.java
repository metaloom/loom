package io.metaloom.loom.core.endpoint;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.impl.HttpErrorException;

public interface CRUDEndpointTestcases extends EndpointTest {

	@Test
	void testRead() throws HttpErrorException;

	@Test
	void testCreate() throws HttpErrorException;

	@Test
	void testDelete() throws HttpErrorException;

	@Test
	void testUpdate() throws HttpErrorException;

	@Test
	void testReadPaged() throws HttpErrorException;
}
