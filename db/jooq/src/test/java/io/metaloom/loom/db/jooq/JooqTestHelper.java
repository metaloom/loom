package io.metaloom.loom.db.jooq;

import javax.sql.DataSource;

import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;

public interface JooqTestHelper {

	public static final String DUMMY_SHA512SUM = "0e3e75234abc68f4378a86b3f4b32a198ba301845b0cd6e50106e874345700cc6663a86c1ea125dc5e92be17c98f9a0f85ca9d5f595db2012f7cc3571945c123";

	public static final String DUMMY_LIBRARY_NAME = "test-library";

	default User createUser(String username) {
		User user = userDao().createUser(username);
		userDao().store(user);
		return user;
	}

	default Asset createAsset(String filename, User user) {
		Binary binary = createBinary();
		Library library = createLibrary(DUMMY_LIBRARY_NAME);
		return assetDao().createAsset(filename, binary.getUuid(), user.getUuid(), library.getUuid());
	}

	default Library createLibrary(String name) {
		Library library = libraryDao().createLibrary(name);
		libraryDao().store(library);
		return library;
	}

	default Binary createBinary() {
		Binary binary = binaryDao().createBinary(DUMMY_SHA512SUM, 42L);
		binaryDao().store(binary);
		return binary;
	}

	DataSource dataSource();

	GroupDao groupDao();

	AssetDao assetDao();

	BinaryDao binaryDao();

	UserDao userDao();

	LibraryDao libraryDao();

	PermissionDao permissionDao();
}
