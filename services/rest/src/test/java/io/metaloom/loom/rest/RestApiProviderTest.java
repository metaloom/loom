package io.metaloom.loom.rest;

import org.junit.jupiter.api.Test;

public class RestApiProviderTest {

	@Test
	public void testContractCreation() {
		new RestApiProvider().loadContract();
	}
}
