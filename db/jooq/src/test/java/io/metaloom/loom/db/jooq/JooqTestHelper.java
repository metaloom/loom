package io.metaloom.loom.db.jooq;

import javax.sql.DataSource;

import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.asset.LoomAssetBinary;
import io.metaloom.loom.db.model.asset.LoomAssetBinaryDao;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;

public interface JooqTestHelper {

	public static final String DUMMY_SHA512SUM = "0e3e75234abc68f4378a86b3f4b32a198ba301845b0cd6e50106e874345700cc6663a86c1ea125dc5e92be17c98f9a0f85ca9d5f595db2012f7cc3571945c123";

	default LoomUser createUser(String username) {
		LoomUser user = userDao().createUser(username);
		userDao().storeUser(user);
		return user;
	}

	default LoomAsset createAsset(String filename, LoomUser user, LoomNamespace namespace) {
		LoomAssetBinary binary = createBinary();
		return assetDao().createAsset(filename, binary.getUuid(), user, namespace.getUuid());
	}

	default LoomNamespace createNamespace(String name) {
		LoomNamespace namespace = namespaceDao().createNamespace(name);
		namespaceDao().storeNamespace(namespace);
		return namespace;
	}

	default LoomAssetBinary createBinary() {
		LoomAssetBinary binary = binaryDao().createBinary(DUMMY_SHA512SUM, 42L);
		binaryDao().storeBinary(binary);
		return binary;
	}

	DataSource dataSource();

	LoomNamespaceDao namespaceDao();

	LoomGroupDao groupDao();

	LoomAssetDao assetDao();

	LoomAssetBinaryDao binaryDao();

	LoomUserDao userDao();
}
