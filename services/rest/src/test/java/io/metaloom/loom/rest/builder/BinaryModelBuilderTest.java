package io.metaloom.loom.rest.builder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.binary.Binary;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.binary.BinaryListResponse;

public class BinaryModelBuilderTest extends AbstractModelBuilderTest {

	@Test
	@Override
	void testResponseModel() throws IOException {
		Binary binary = mockBinary("primary");
		assertWithModel(builder().toResponse(binary), "binary.response");
	}

	@Test
	@Override
	void testListResponseModel() throws IOException {
		Binary binary1 = mockBinary("primary");
		Binary binary2 = mockBinary("secondary");
		Page<Binary> page = mockPage(binary1, binary2);
		BinaryListResponse list = builder().toBinaryList(page);
		assertWithModel(list, "binary.list_response");
	}

	private Binary mockBinary(String title) {
		Binary binary = mock(Binary.class);
		when(binary.getUuid()).thenReturn(TASK_UUID);
		when(binary.getSHA512()).thenReturn(SHA512SUM);
		when(binary.getSHA256()).thenReturn(SHA256SUM);
		when(binary.getMD5()).thenReturn(MD5SUM);
		return binary;
	}

}
