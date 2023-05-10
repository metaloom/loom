package io.metaloom.loom.db;

import io.metaloom.loom.db.dagger.DaoProvider;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.test.TestValues;

public interface DatabaseTest extends TestValues, DaoProvider {

	default User createUser(String username) {
		User user = userDao().createUser(username);
		userDao().store(user);
		return user;
	}

	default AssetLocation createAsset(String filename, User user) {
		Asset binary = createBinary(user);
		Library library = createLibrary(user, LIBRARY_NAME);
		return assetDao().createAssetLocation(filename, binary.getUuid(), user.getUuid(), library.getUuid());
	}

	default Library createLibrary(User user, String name) {
		Library library = libraryDao().createLibrary(user, name);
		libraryDao().store(library);
		return library;
	}

	default Asset createBinary(User user) {
		Asset binary = binaryDao().createAsset(user, SHA512SUM, IMAGE_MIMETYPE, DUMMY_IMAGE_ORIGIN, 42L);
		binaryDao().store(binary);
		return binary;
	}

}
