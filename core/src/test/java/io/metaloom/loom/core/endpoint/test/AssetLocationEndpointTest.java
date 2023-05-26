package io.metaloom.loom.core.endpoint.test;

import static io.metaloom.loom.rest.model.assertj.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.model.asset.location.AssetLocationCreateRequest;
import io.metaloom.loom.rest.model.asset.location.AssetLocationFilesystemInfo;
import io.metaloom.loom.rest.model.asset.location.AssetLocationListResponse;
import io.metaloom.loom.rest.model.asset.location.AssetLocationResponse;
import io.metaloom.loom.rest.model.asset.location.AssetLocationUpdateRequest;

public class AssetLocationEndpointTest extends AbstractCRUDEndpointTest {

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		AssetLocationResponse assetLocation = client.loadLocation(ASSET_LOCATION_UUID).sync();
		assertThat(assetLocation).isValid();
	}

	@Override
	protected void testCreate(LoomHttpClient client) throws HttpErrorException {
		AssetLocationCreateRequest request = new AssetLocationCreateRequest();
		request.setFilesystem(new AssetLocationFilesystemInfo().setPath("/dummy/path"));
		request.setLibraryUuid(LIBRARY_UUID);
		request.setAssetUuid(ASSET_UUID);
		AssetLocationResponse assetLocation = client.createLocation(request).sync();
		assertThat(assetLocation).isValid();

		AssetLocationResponse assetLocation2 = client.loadLocation(assetLocation.getUuid()).sync();
		assertThat(assetLocation).matches(assetLocation2);
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteLocation(ASSET_LOCATION_UUID).sync();
		expect(404, "Not Found", client.loadLocation(ASSET_LOCATION_UUID));
	}

	@Override
	protected void testUpdate(LoomHttpClient client) throws HttpErrorException {
		AssetLocationUpdateRequest update = new AssetLocationUpdateRequest();
		update.setFilesystem(new AssetLocationFilesystemInfo().setPath("updated-path"));
		AssetLocationResponse response = client.updateLocation(ASSET_LOCATION_UUID, update).sync();
		assertThat(response).isValid().hasPath("updated-path");
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws HttpErrorException {
		for (int i = 0; i < 100; i++) {
			AssetLocationCreateRequest request = new AssetLocationCreateRequest();
			request.setAssetUuid(ASSET_UUID);
			request.setLibraryUuid(LIBRARY_UUID);
			request.setFilesystem(new AssetLocationFilesystemInfo().setPath("dummy path " + i));
			client.createLocation(request).sync();
		}
		AssetLocationListResponse list = client.listLocations().sync();
		assertThat(list).isValid().hasSize(25).hasPerPage(25);
	}

}
