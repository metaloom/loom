package io.metaloom.loom.rest;

import org.junit.Test;

public class RestApiProviderTest {

	@Test
	public void testContractCreation() {
		new RestApiProvider().loadContract();
	}
}
