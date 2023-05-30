package io.metaloom.loom.core.db.fixture;

import java.time.Instant;
import java.util.UUID;

import io.metaloom.loom.api.attachment.AttachmentType;
import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.core.dagger.LoomCoreComponent;
import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.annotation.AnnotationType;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.model.attachment.Attachment;
import io.metaloom.loom.db.model.blacklist.Blacklist;
import io.metaloom.loom.db.model.cluster.Cluster;
import io.metaloom.loom.db.model.collection.Collection;
import io.metaloom.loom.db.model.embedding.Embedding;
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
import io.metaloom.utils.hash.SHA512Sum;

public class TestFixtureProvider extends AbstractFixtureProvider {

	public TestFixtureProvider(LoomCoreComponent component) {
		super(component);

	}

	public void setup() {

		User user = setupACL();

		// Add library
		Library library = createLibrary(user, "4k B-roll");

		// Add Assets to library
		Asset asset = createAsset(library, user);
		AssetLocation assetLocation = createAssetLocation(library, asset, user);

		// Tag assets
		Tag assetTag = tagAsset(user, asset, "red");

		// Annotate asset
		Annotation annotation = annotateAsset(asset, user);
		Tag annotationTag = tagAnnotation(user, annotation, "important");

		// Store embedding + cluster
		Embedding embedding1 = createEmbedding(EMBEDDING_UUID, user, asset);
		Embedding embedding2 = createEmbedding(UUID.randomUUID(), user, asset);
		Embedding embedding3 = createEmbedding(UUID.randomUUID(), user, asset);
		Cluster cluster = clusterEmbeddings(user, embedding1, embedding2, embedding3);

		// Attachment for embedding
		Attachment attachment1 = createAttachment(ATTACHMENT_UUID, embedding1, user);

		// Create project
		Project project = createProject(user);

		// Group assets into collection and assign collection to project
		Collection collection = createCollection("Collection1", project, user, asset);

		// Create task
		Task task = createTask(user);
		Reaction reaction1 = reactOnTask(user, task);
		Reaction reaction2 = reactOnAsset(user, asset);

		// Create blacklist with multiple entries
		Blacklist blacklist = createBlacklist(user, asset, "blocked");

		// Register webhook
		Webhook webhook = createWebhook(user, "http://localhost:9090/trigger");

	}

	private Webhook createWebhook(User user, String url) {
		Webhook webhook = webhookDao().createWebhook(user, url);
		webhook.setUuid(WEBHOOK_UUID);
		webhookDao().store(webhook);
		return webhook;
	}

	private Blacklist createBlacklist(User user, Asset asset, String name) {
		Blacklist blacklist = blacklistDao().createBlacklist(user, asset, name);
		blacklist.setUuid(BLACKLIST_UUID);
		blacklistDao().store(blacklist);
		return blacklist;
	}

	private Reaction reactOnAsset(User user, Asset asset) {
		Reaction reaction = reactionDao().createReaction(user, "thumbsup");
		reaction.setUuid(REACTION_UUID);
		reactionDao().store(reaction);
		reactionDao().link(reaction, asset);
		return reaction;
	}

	private Reaction reactOnTask(User user, Task task) {
		Reaction reaction = reactionDao().createReaction(user, "thumbsup");
		reactionDao().store(reaction);
		reactionDao().link(reaction, task);
		return reaction;
	}

	private Task createTask(User user) {
		Task task = taskDao().createTask(user, "job1");
		task.setUuid(TASK_UUID);
		taskDao().store(task);
		return task;
	}

	private Collection createCollection(String name, Project project, User user, Asset asset) {
		Collection collection = collectionDao().createCollection(user, name);
		collection.setUuid(COLLECTION_UUID);
		collectionDao().store(collection);
		collectionDao().link(collection, asset);
		return collection;
	}

	private Project createProject(User user) {
		Project project = projectDao().createProject(user, "test-project");
		project.setUuid(PROJECT_UUID);
		projectDao().store(project);
		return project;
	}

	private Cluster clusterEmbeddings(User user, Embedding... embeddings) {
		Cluster cluster = clusterDao().createCluster(user, "Cats", "PERSON");
		cluster.setUuid(CLUSTER_UUID);
		clusterDao().store(cluster);
		for (Embedding embedding : embeddings) {
			clusterDao().link(cluster, embedding);
		}
		return cluster;
	}

	private Embedding createEmbedding(UUID uuid, User user, Asset asset) {
		Embedding embedding = embeddingDao().createEmbedding(user, asset, VECTOR_DATA, EmbeddingType.DLIB_FACE_RESNET_v1, VECTOR_ID);
		embedding.setUuid(uuid);
		embeddingDao().store(embedding);
		return embedding;
	}

	private Tag tagAnnotation(User user, Annotation annotation, String tagName) {
		Tag tag = tagDao().createTag(user, tagName, "feedback");
		tag.setUuid(TAG_UUID);
		tagDao().store(tag);
		tagDao().tagAnnotation(tag, annotation);
		return tag;
	}

	private Annotation annotateAsset(Asset asset, User user) {
		Annotation annotation = annotationDao().createAnnotation(user, asset, "feedback here", AnnotationType.FEEDBACK);
		annotation.setUuid(ANNOTATION_UUID);
		annotationDao().store(annotation);
		return annotation;
	}

	private Tag tagAsset(User user, Asset asset, String name) {
		Tag tag = tagDao().createTag(user, name, "colors");
		tagDao().store(tag);
		tagDao().tagAsset(tag, asset);
		return tag;
	}

	private Asset createAsset(Library library, User user) {
		Asset asset = assetDao().createAsset(user, SHA512Sum.fromString(SHA256SUM), IMAGE_MIMETYPE, DUMMY_IMAGE_FILENAME, DUMMY_IMAGE_ORIGIN, 42L);
		asset.setUuid(ASSET_UUID);
		asset.setFilename("bigbuckbunny.mp4");
		assetDao().store(asset);
		return asset;
	}

	private Attachment createAttachment(UUID attachmentUuid, Embedding embedding, User user) {
		Attachment attachment = attachmentDao().createAttachment(user.getUuid(), SHA512SUM_3, DUMMY_IMAGE_FILENAME, 42L, IMAGE_MIMETYPE,
			AttachmentType.EMBEDDING_ATTACHMENT);
		attachment.setEmbeddingUuid(embedding.getUuid());
		attachment.setAssetUuid(embedding.getAssetUuid());
		attachment.setUuid(attachmentUuid);
		attachmentDao().store(attachment);
		return attachment;
	}

	private AssetLocation createAssetLocation(Library library, Asset asset, User user) {
		AssetLocation assetLocation = assetLocationDao().createAssetLocation("blume.mp4", asset.getUuid(), user.getUuid(), library.getUuid());
		assetLocation.setUuid(ASSET_LOCATION_UUID);
		assetLocationDao().store(assetLocation);
		return assetLocation;
	}

	private Library createLibrary(User user, String name) {
		Library library = libraryDao().createLibrary(user, name);
		library.setUuid(LIBRARY_UUID);
		libraryDao().store(library);
		return library;
	}

	private User setupACL() {

		// User
		User adminUser = userDao().createUser("admin");
		adminUser.setUuid(ADMIN_UUID);
		adminUser.setCreator(adminUser);
		adminUser.setEditor(adminUser);
		adminUser.setEdited(Instant.now());
		adminUser.setCreated(Instant.now());
		adminUser.setPasswordHash(authService.encodePassword("finger"));
		userDao().store(adminUser);

		// Group + Assign User to Group
		Group group = groupDao().create(adminUser, "test-group");
		group.setUuid(GROUP_UUID);
		groupDao().store(group);
		groupDao().addUserToGroup(group, adminUser);

		// Role + Assign Role to Group + Role Permission
		Role role = roleDao().createRole(adminUser.getUuid(), "test-role");
		role.setUuid(ROLE_UUID);
		roleDao().store(role);
		groupDao().addRoleToGroup(group, role);
		for (Permission perm : Permission.values()) {
			permissionDao().grantRolePermission(role.getUuid(), perm, "test");
		}

		// Second user
		User joeDoeUser = userDao().createUser("joedoe");
		joeDoeUser.setUuid(USER_UUID);
		joeDoeUser.setCreator(adminUser);
		joeDoeUser.setEditor(adminUser);
		joeDoeUser.setEdited(Instant.now());
		joeDoeUser.setCreated(Instant.now());
		joeDoeUser.setPasswordHash(authService.encodePassword("finger"));
		userDao().store(joeDoeUser);
		permissionDao().grantUserPermission(joeDoeUser.getUuid(), Permission.READ_USER, "test");

		// Create token + Permissions
		String tokenValue = StringUtils.randomHumanString(6);
		Token token = tokenDao().createToken(joeDoeUser, "test_token", tokenValue);
		token.setUuid(TOKEN_UUID);
		tokenDao().store(token);

		return joeDoeUser;
	}

}
