package io.metaloom.loom.db.jooq;

import javax.sql.DataSource;

import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.db.jooq.test.dagger.JooqTestContext;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.user.LoomUserDao;

public abstract class AbstractJooqTest implements JooqTestHelper {

	@RegisterExtension
	public static JooqTestContext context = new JooqTestContext();

	@Override
	public DataSource dataSource() {
		return context.dataSource();
	}

	@Override
	public LoomUserDao userDao() {
		return context.userDao();
	}

	@Override
	public AssetBinaryDao binaryDao() {
		return context.binaryDao();
	}

	@Override
	public AssetDao assetDao() {
		return context.assetDao();
	}

	@Override
	public LoomGroupDao groupDao() {
		return context.groupDao();
	}

	@Override
	public LoomNamespaceDao namespaceDao() {
		return context.namespaceDao();
	}

	@Override
	public PermissionDao permissionDao() {
		return context.permissionDao();
	}

}
