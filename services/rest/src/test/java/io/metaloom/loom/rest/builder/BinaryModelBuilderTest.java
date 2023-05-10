package io.metaloom.loom.rest.builder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.binary.AssetListResponse;

public class BinaryModelBuilderTest extends AbstractModelBuilderTest {

	@Test
	@Override
	void testResponseModel() throws IOException {
		Asset binary = mockBinary("primary");
		assertWithModel(builder().toResponse(binary), "binary.response");
	}

	@Test
	@Override
	void testListResponseModel() throws IOException {
		Asset binary1 = mockBinary("primary");
		Asset binary2 = mockBinary("secondary");
		Page<Asset> page = mockPage(binary1, binary2);
		AssetListResponse list = builder().toAssetList(page);
		assertWithModel(list, "binary.list_response");
	}

	private Asset mockBinary(String title) {
		Asset binary = mock(Asset.class);
		when(binary.getUuid()).thenReturn(TASK_UUID);
		when(binary.getSHA512()).thenReturn(SHA512SUM);
		when(binary.getSHA256()).thenReturn(SHA256SUM);
		when(binary.getMD5()).thenReturn(MD5SUM);
		return binary;
	}

}
