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
import io.metaloom.loom.test.TestValues;

public interface JooqTestHelper extends TestValues {

	default User createUser(String username) {
		User user = userDao().createUser(username);
		userDao().store(user);
		return user;
	}

	default Asset createAsset(String filename, User user) {
		Binary binary = createBinary(user);
		Library library = createLibrary(user, LIBRARY_NAME);
		return assetDao().createAsset(filename, binary.getUuid(), user.getUuid(), library.getUuid());
	}

	default Library createLibrary(User user, String name) {
		Library library = libraryDao().createLibrary(user, name);
		libraryDao().store(library);
		return library;
	}

	default Binary createBinary(User user) {
		Binary binary = binaryDao().createBinary(user, SHA512SUM, IMAGE_MIMETYPE, DUMMY_IMAGE_ORIGIN, 42L);
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
