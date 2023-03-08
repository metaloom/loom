package io.metaloom.loom.db.jooq;

import javax.sql.DataSource;

import org.junit.ClassRule;
import org.junit.Rule;

import io.metaloom.loom.db.jooq.test.dagger.JooqTestContext;
import io.metaloom.loom.db.model.asset.LoomAssetBinaryDao;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.user.LoomUserDao;

public abstract class AbstractJooqTest {

	public static final String DUMMY_SHA512SUM = "0e3e75234abc68f4378a86b3f4b32a198ba301845b0cd6e50106e874345700cc6663a86c1ea125dc5e92be17c98f9a0f85ca9d5f595db2012f7cc3571945c123";

	@Rule
	@ClassRule
	public static JooqTestContext context = new JooqTestContext();

	protected DataSource dataSource() {
		return context.dataSource();
	}

	protected LoomUserDao userDao() {
		return context.userDao();
	}

	protected LoomAssetBinaryDao binaryDao() {
		return context.binaryDao();
	}

	protected LoomAssetDao assetDao() {
		return context.assetDao();
	}

	protected LoomGroupDao groupDao() {
		return context.groupDao();
	}

	protected LoomNamespaceDao namespaceDao() {
		return context.namespaceDao();
	}

}
