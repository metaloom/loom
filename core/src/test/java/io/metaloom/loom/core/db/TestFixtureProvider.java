package io.metaloom.loom.core.db;

import io.metaloom.loom.auth.AuthenticationService;
import io.metaloom.loom.core.dagger.LoomCoreComponent;
import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.cluster.ClusterDao;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.Permission;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.task.TaskDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;

public class TestFixtureProvider {

	public static void setup(LoomCoreComponent component) {
		DaoCollection daos = component.daos();
		LibraryDao libraryDao = daos.libraryDao();
		AssetDao assetDao = daos.assetDao();
		BinaryDao binaryDao = daos.binaryDao();
		TaskDao taskDao = daos.taskDao();
		ClusterDao clusterDao = daos.clusterDao();

		setupACL(component);
		
		// Add library 
		// Add Assets to library
		
		// Tag assets
		// Annotate asset

		// Store embedding
		// Cluster embeddings together
		
		
		// Group assets into collection

		// Create project
		// Assign collection to project
		
		// Create task
		// React upon task
		// React upon asset
		// React upon binary
		
		// Create blacklist with multiple entries
		
		// Register webhook
		

	}

	private static void setupACL(LoomCoreComponent component) {
		DaoCollection daos = component.daos();
		GroupDao groupDao = daos.groupDao();
		UserDao userDao = daos.userDao();
		RoleDao roleDao = daos.roleDao();
		PermissionDao permissionDao = daos.permissionDao();
		AuthenticationService authService = component.authService();

		// User
		User adminUser = userDao.createUser("admin");
		adminUser.setPasswordHash(authService.encodePassword("finger"));
		userDao.store(adminUser);

		// Group + Assign User to Group
		Group group = groupDao.create("test-group");
		groupDao.store(group);
		groupDao.addUserToGroup(group, adminUser);

		// Role + Assign Role to Group + Role Permission
		Role role = roleDao.createRole("test-role", adminUser.getUuid());
		roleDao.store(role);
		groupDao.addRoleToGroup(group, role);
		permissionDao.grantRolePermission(role.getUuid(), Permission.READ_USER, "test");

		// Second user
		User joeDoeUser = userDao.createUser("joedoe");
		joeDoeUser.setPasswordHash(authService.encodePassword("finger"));
		userDao.store(joeDoeUser);
		permissionDao.grantUserPermission(joeDoeUser.getUuid(), Permission.READ_USER, "test");
		
		// Create token + Permissions

	}

}
