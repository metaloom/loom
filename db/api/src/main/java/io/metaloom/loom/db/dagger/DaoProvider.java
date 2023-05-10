package io.metaloom.loom.db.dagger;

import io.metaloom.loom.db.model.annotation.AnnotationDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.AssetLocationDao;
import io.metaloom.loom.db.model.blacklist.BlacklistDao;
import io.metaloom.loom.db.model.cluster.ClusterDao;
import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.db.model.comment.CommentDao;
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

public interface DaoProvider extends DaoCollection {

	DaoCollection daos();

	// ACL

	default UserDao userDao() {
		return daos().userDao();
	}

	default GroupDao groupDao() {
		return daos().groupDao();
	}

	default RoleDao roleDao() {
		return daos().roleDao();
	}

	default PermissionDao permissionDao() {
		return daos().permissionDao();
	}

	default TokenDao tokenDao() {
		return daos().tokenDao();
	}

	// Connectivity

	default WebhookDao webhookDao() {
		return daos().webhookDao();
	}

	// Asset

	default AssetLocationDao assetDao() {
		return daos().assetDao();
	}

	default AssetDao binaryDao() {
		return daos().binaryDao();
	}

	// Management

	default ProjectDao projectDao() {
		return daos().projectDao();
	}

	default LibraryDao libraryDao() {
		return daos().libraryDao();
	}

	default CollectionDao collectionDao() {
		return daos().collectionDao();
	}

	default BlacklistDao blacklistDao() {
		return daos().blacklistDao();
	}

	// Tagging

	default TagDao tagDao() {
		return daos().tagDao();
	}

	// Embedding

	default EmbeddingDao embeddingDao() {
		return daos().embeddingDao();
	}

	default ClusterDao clusterDao() {
		return daos().clusterDao();
	}

	// Social

	default TaskDao taskDao() {
		return daos().taskDao();
	}

	default AnnotationDao annotationDao() {
		return daos().annotationDao();
	}

	default ReactionDao reactionDao() {
		return daos().reactionDao();
	}

	default CommentDao commentDao() {
		return daos().commentDao();
	}

}
