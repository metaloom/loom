package io.metaloom.loom.core.db.fixture;

import io.metaloom.loom.auth.AuthenticationService;
import io.metaloom.loom.core.dagger.LoomCoreComponent;
import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.annotation.AnnotationDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.blacklist.BlacklistDao;
import io.metaloom.loom.db.model.cluster.ClusterDao;
import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.project.ProjectDao;
import io.metaloom.loom.db.model.reaction.ReactionDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.db.model.task.TaskDao;
import io.metaloom.loom.db.model.token.TokenDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;
import io.metaloom.loom.test.TestValues;

public abstract class AbstractFixtureProvider implements TestValues {

	// Asset
	protected final AssetDao assetDao;
	protected final BinaryDao binaryDao;

	// Managemet
	protected final LibraryDao libraryDao;
	protected final ProjectDao projectDao;
	protected final TagDao tagDao;
	protected final CollectionDao collectionDao;

	// Feedback / Social
	protected final TaskDao taskDao;
	protected final ReactionDao reactionDao;
	protected final AnnotationDao annotationDao;

	// Embedding
	protected final EmbeddingDao embeddingDao;
	protected final ClusterDao clusterDao;

	// ACL
	protected final GroupDao groupDao;
	protected final UserDao userDao;
	protected final TokenDao tokenDao;
	protected final RoleDao roleDao;
	protected final PermissionDao permissionDao;
	protected final AuthenticationService authService;

	// Other
	protected final DaoCollection daos;
	protected final WebhookDao webhookDao;
	protected final BlacklistDao blacklistDao;

	public AbstractFixtureProvider(LoomCoreComponent component) {
		this.daos = component.daos();
		this.libraryDao = daos.libraryDao();
		this.projectDao = daos.projectDao();
		this.assetDao = daos.assetDao();
		this.binaryDao = daos.binaryDao();
		this.taskDao = daos.taskDao();
		this.clusterDao = daos.clusterDao();
		this.collectionDao = daos.collectionDao();
		this.groupDao = daos.groupDao();
		this.userDao = daos.userDao();
		this.tokenDao = daos.tokenDao();
		this.tagDao = daos.tagDao();
		this.roleDao = daos.roleDao();
		this.reactionDao = daos.reactionDao();
		this.embeddingDao = daos.embeddingDao();
		this.webhookDao = daos.webhookDao();
		this.permissionDao = daos.permissionDao();
		this.annotationDao = daos.annotationDao();
		this.blacklistDao = daos.blacklistDao();
		this.authService = component.authService();
	}

}
