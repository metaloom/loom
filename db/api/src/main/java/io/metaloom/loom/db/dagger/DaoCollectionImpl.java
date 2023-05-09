package io.metaloom.loom.db.dagger;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.model.annotation.AnnotationDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.binary.BinaryDao;
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

@Singleton
public class DaoCollectionImpl implements DaoCollection {

	private final Lazy<UserDao> userDao;
	private final Lazy<GroupDao> groupDao;
	private final Lazy<RoleDao> roleDao;
	private final Lazy<AssetDao> assetDao;
	private final Lazy<PermissionDao> permissionDao;
	private final Lazy<BinaryDao> binaryDao;
	private final Lazy<WebhookDao> webhookDao;
	private final Lazy<CollectionDao> collectionDao;
	private final Lazy<LibraryDao> libraryDao;
	private final Lazy<ProjectDao> projectDao;
	private final Lazy<BlacklistDao> blacklistDao;
	private final Lazy<TaskDao> taskDao;
	private final Lazy<ReactionDao> reactionDao;
	private final Lazy<AnnotationDao> annotationDao;
	private final Lazy<CommentDao> commentDao;
	private final Lazy<EmbeddingDao> embeddingDao;
	private final Lazy<ClusterDao> clusterDao;
	private final Lazy<TokenDao> tokenDao;
	private final Lazy<TagDao> tagDao;

	@Inject
	public DaoCollectionImpl(Lazy<UserDao> userDao, Lazy<PermissionDao> permissionDao,
		Lazy<RoleDao> roleDao, Lazy<GroupDao> groupDao, Lazy<AssetDao> assetDao, Lazy<BinaryDao> binaryDao,
		Lazy<WebhookDao> webhookDao, Lazy<CollectionDao> collectionDao, Lazy<LibraryDao> libraryDao,
		Lazy<AnnotationDao> annotationDao, Lazy<TaskDao> taskDao, Lazy<ReactionDao> reactionDao,
		Lazy<BlacklistDao> blacklistDao, Lazy<CommentDao> commentDao, Lazy<ProjectDao> projectDao,
		Lazy<ClusterDao> clusterDao, Lazy<EmbeddingDao> embeddingDao, Lazy<TokenDao> tokenDao,
		Lazy<TagDao> tagDao) {
		this.userDao = userDao;
		this.groupDao = groupDao;
		this.roleDao = roleDao;
		this.assetDao = assetDao;
		this.permissionDao = permissionDao;
		this.binaryDao = binaryDao;
		this.webhookDao = webhookDao;
		this.libraryDao = libraryDao;
		this.collectionDao = collectionDao;
		this.annotationDao = annotationDao;
		this.taskDao = taskDao;
		this.reactionDao = reactionDao;
		this.blacklistDao = blacklistDao;
		this.commentDao = commentDao;
		this.projectDao = projectDao;
		this.clusterDao = clusterDao;
		this.embeddingDao = embeddingDao;
		this.tokenDao = tokenDao;
		this.tagDao = tagDao;
	}

	@Override
	public AssetDao assetDao() {
		return assetDao.get();
	}

	@Override
	public BinaryDao binaryDao() {
		return binaryDao.get();
	}

	@Override
	public WebhookDao webhookDao() {
		return webhookDao.get();
	}

	@Override
	public UserDao userDao() {
		return userDao.get();
	}

	@Override
	public GroupDao groupDao() {
		return groupDao.get();
	}

	@Override
	public RoleDao roleDao() {
		return roleDao.get();
	}

	@Override
	public PermissionDao permissionDao() {
		return permissionDao.get();
	}

	@Override
	public LibraryDao libraryDao() {
		return libraryDao.get();
	}

	@Override
	public CollectionDao collectionDao() {
		return collectionDao.get();
	}

	@Override
	public AnnotationDao annotationDao() {
		return annotationDao.get();
	}

	@Override
	public ReactionDao reactionDao() {
		return reactionDao.get();
	}

	@Override
	public TaskDao taskDao() {
		return taskDao.get();
	}

	@Override
	public BlacklistDao blacklistDao() {
		return blacklistDao.get();
	}

	@Override
	public CommentDao commentDao() {
		return commentDao.get();
	}

	@Override
	public ProjectDao projectDao() {
		return projectDao.get();
	}

	@Override
	public ClusterDao clusterDao() {
		return clusterDao.get();
	}

	@Override
	public EmbeddingDao embeddingDao() {
		return embeddingDao.get();
	}

	@Override
	public TokenDao tokenDao() {
		return tokenDao.get();
	}

	@Override
	public TagDao tagDao() {
		return tagDao.get();
	}
}
