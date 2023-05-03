package io.metaloom.loom.core.db.fixture;

import io.metaloom.loom.core.dagger.LoomCoreComponent;
import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.annotation.AnnotationType;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.model.blacklist.Blacklist;
import io.metaloom.loom.db.model.cluster.Cluster;
import io.metaloom.loom.db.model.cluster.ClusterType;
import io.metaloom.loom.db.model.collection.Collection;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingType;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.perm.Permission;
import io.metaloom.loom.db.model.project.Project;
import io.metaloom.loom.db.model.reaction.Reaction;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.token.Token;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.metaloom.utils.StringUtils;

public class TestFixtureProvider extends AbstractFixtureProvider {

	public TestFixtureProvider(LoomCoreComponent component) {
		super(component);

	}

	public void setup() {

		User user = setupACL();

		// Add library
		Library library = createLibrary(user, "4k B-roll");

		// Add Assets to library
		Binary binary = createBinary(library, user);
		Asset asset = createAsset(library, binary, user);

		// Tag assets
		Tag assetTag = tagAsset(user, asset, "red");

		// Annotate asset
		Annotation annotation = annotateAsset(asset, user);
		Tag annotationTag = tagAnnotation(user, annotation, "important");

		// Store embedding + cluster
		Embedding embedding1 = createEmbedding(user, binary);
		Embedding embedding2 = createEmbedding(user, binary);
		Embedding embedding3 = createEmbedding(user, binary);
		Cluster cluster = clusterEmbeddings(user, embedding1, embedding2, embedding3);

		// Create project
		Project project = createProject(user);

		// Group assets into collection and assign collection to project
		Collection collection = createCollection("Collection1", project, user, asset);

		// Create task
		Task task = createTask(user);
		Reaction reaction1 = reactOnTask(user, task);
		Reaction reaction2 = reactOnAsset(user, asset);
		Reaction reaction3 = reactOnBinary(user, binary);

		// Create blacklist with multiple entries
		Blacklist blacklist = createBlacklist(user, binary, "blocked");

		// Register webhook
		Webhook webhook = createWebhook(user, "http://localhost:9090/trigger");

	}

	private Webhook createWebhook(User user, String url) {
		Webhook webhook = webhookDao.createWebhook(user, url);
		webhookDao.store(webhook);
		return webhook;
	}

	private Blacklist createBlacklist(User user, Binary binary, String name) {
		Blacklist blacklist = blacklistDao.createBlacklist(user, binary, name);
		blacklistDao.store(blacklist);
		return blacklist;
	}

	private Reaction reactOnBinary(User user, Binary binary) {
		Reaction reaction = reactionDao.createReaction(user, "thumbsup");
		reactionDao.store(reaction);
		reactionDao.link(reaction, binary);
		return reaction;
	}

	private Reaction reactOnAsset(User user, Asset asset) {
		Reaction reaction = reactionDao.createReaction(user, "thumbsup");
		reactionDao.store(reaction);
		reactionDao.link(reaction, asset);
		return reaction;
	}

	private Reaction reactOnTask(User user, Task task) {
		Reaction reaction = reactionDao.createReaction(user, "thumbsup");
		reactionDao.store(reaction);
		reactionDao.link(reaction, task);
		return reaction;
	}

	private Task createTask(User user) {
		Task task = taskDao.createTask(user, "job1");
		taskDao.store(task);
		return task;
	}

	private Collection createCollection(String name, Project project, User user, Asset asset) {
		Collection collection = collectionDao.createCollection(user, name);
		collectionDao.store(collection);
		collectionDao.link(collection, asset);
		return collection;
	}

	private Project createProject(User user) {
		Project project = projectDao.createProject(user, "test-project");
		projectDao.store(project);
		return project;
	}

	private Cluster clusterEmbeddings(User user, Embedding... embeddings) {
		Cluster cluster = clusterDao.createCluster(user, "Cats", ClusterType.PERSON);
		clusterDao.store(cluster);
		for (Embedding embedding : embeddings) {
			clusterDao.link(cluster, embedding);
		}
		return cluster;
	}

	private Embedding createEmbedding(User user, Binary binary) {
		Embedding embedding = embeddingDao.createEmbedding(user, binary, VECTOR_DATA, EmbeddingType.DLIB_FACE_RESNET_v1, VECTOR_ID);
		embeddingDao.store(embedding);
		return embedding;
	}

	private Tag tagAnnotation(User user, Annotation annotation, String tagName) {
		Tag tag = tagDao.createTag(user, tagName, "feedback");
		tagDao.store(tag);
		tagDao.tagAnnotation(tag, annotation);
		return tag;
	}

	private Annotation annotateAsset(Asset asset, User user) {
		Annotation annotation = annotationDao.createAnnotation(user, asset, "feedback here", AnnotationType.FEEDBACK);
		annotationDao.store(annotation);
		return annotation;
	}

	private Tag tagAsset(User user, Asset asset, String name) {
		Tag tag = tagDao.createTag(user, name, "colors");
		tagDao.store(tag);
		tagDao.tagAsset(tag, asset);
		return tag;
	}

	private Binary createBinary(Library library, User user) {
		Binary binary = binaryDao.createBinary(user, SHA512SUM, IMAGE_MIMETYPE, DUMMY_IMAGE_ORIGIN, 42L);
		binaryDao.store(binary);
		return binary;
	}

	private Asset createAsset(Library library, Binary binary, User user) {
		Asset asset = assetDao.createAsset("blume.mp4", binary.getUuid(), user.getUuid(), library.getUuid());
		assetDao.store(asset);
		return asset;
	}

	private Library createLibrary(User user, String name) {
		Library library = libraryDao.createLibrary(user, name);
		libraryDao.store(library);
		return library;
	}

	private User setupACL() {

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
		String tokenValue = StringUtils.randomHumanString(6);
		Token token = tokenDao.createToken("test_toke", tokenValue);
		tokenDao.store(token);

		return joeDoeUser;
	}

}
