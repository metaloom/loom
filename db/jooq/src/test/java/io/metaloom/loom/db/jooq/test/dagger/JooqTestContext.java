package io.metaloom.loom.db.jooq.test.dagger;

import static io.metaloom.loom.db.jooq.user.LoomExtensionHelper.toOptions;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.test.LoomProviderExtension;

public class JooqTestContext implements BeforeEachCallback, AfterEachCallback {

	public static final Logger log = LoggerFactory.getLogger(JooqTestContext.class);

	private LoomProviderExtension dbProvider;

	private TestComponent component;

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		log.info("Starting test context");

		log.info("Preparing env");
		dbProvider = LoomProviderExtension.create();
		dbProvider.beforeEach(context);
		DatabaseOptions options = toOptions(dbProvider.db());

		component = DaggerTestComponent.builder().configuration(options).build();

	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		log.info("Stopping test context");
		if (dbProvider != null) {
			dbProvider.afterEach(context);
		}

	}

	public DataSource dataSource() {
		return component.dataSource();
	}

	public UserDao userDao() {
		return component.userDao();
	}

	public AssetDao assetDao() {
		return component.assetDao();
	}

	public GroupDao groupDao() {
		return component.groupDao();
	}

	public NamespaceDao namespaceDao() {
		return component.namespaceDao();
	}

	public DSLContext context() {
		return component.context();
	}

	public AssetBinaryDao binaryDao() {
		return component.binaryDao();
	}

	public PermissionDao permissionDao() {
		return component.permissionDao();
	}

}
