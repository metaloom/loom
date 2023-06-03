package io.metaloom.loom.core.endpoint.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.api.annotation.AnnotationType;
import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.api.reaction.ReactionType;
import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.rest.model.annotation.AnnotationCreateRequest;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.annotation.AreaInfo;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.location.AssetLocationCreateRequest;
import io.metaloom.loom.rest.model.asset.location.AssetLocationFilesystemInfo;
import io.metaloom.loom.rest.model.asset.location.AssetLocationResponse;
import io.metaloom.loom.rest.model.asset.location.FileKey;
import io.metaloom.loom.rest.model.attachment.AttachmentResponse;
import io.metaloom.loom.rest.model.collection.CollectionCreateRequest;
import io.metaloom.loom.rest.model.collection.CollectionResponse;
import io.metaloom.loom.rest.model.comment.CommentCreateRequest;
import io.metaloom.loom.rest.model.comment.CommentResponse;
import io.metaloom.loom.rest.model.embedding.EmbeddingCreateRequest;
import io.metaloom.loom.rest.model.embedding.EmbeddingResponse;
import io.metaloom.loom.rest.model.library.LibraryCreateRequest;
import io.metaloom.loom.rest.model.library.LibraryResponse;
import io.metaloom.loom.rest.model.reaction.ReactionCreateRequest;
import io.metaloom.loom.rest.model.reaction.ReactionResponse;
import io.metaloom.loom.rest.model.tag.TagCreateRequest;
import io.metaloom.loom.rest.model.tag.TagResponse;
import io.metaloom.loom.rest.model.task.TaskCreateRequest;
import io.metaloom.loom.rest.model.task.TaskPriority;
import io.metaloom.loom.rest.model.task.TaskResponse;
import io.metaloom.loom.test.TestEnvHelper;
import io.metaloom.loom.test.Testdata;
import io.vertx.core.json.JsonObject;

public class CombinedEndpointTest extends AbstractEndpointTest {

	@Test
	public void testBasics() throws HttpErrorException, FileNotFoundException, IOException {
		Testdata env = TestEnvHelper.prepareTestdata("combined");
		try (LoomHttpClient client = loom.httpClient()) {
			loginAdmin(client);

			// Create library for assets being created
			LibraryCreateRequest libraryRequest = new LibraryCreateRequest();
			libraryRequest.setName(LIBRARY_NAME_2);
			LibraryResponse library = client.createLibrary(libraryRequest).sync();

			// Create an asset
			AssetCreateRequest assetRequest = new AssetCreateRequest();
			assetRequest.setRequired(DUMMY_IMAGE_FILENAME, IMAGE_MIMETYPE, ASSET_SHA512SUM, 42L, DUMMY_IMAGE_ORIGIN);
			assetRequest.addVideoFingerprint(VIDEO_FINGERPRINT);
			AssetResponse asset = client.createAsset(assetRequest).sync();

			for (long i = 0; i < 10; i++) {
				EmbeddingCreateRequest embeddingRequest = new EmbeddingCreateRequest();
				embeddingRequest.setType(EmbeddingType.DLIB_FACE_RESNET_v1);
				embeddingRequest.setArea(AreaInfo.create(20, 40, 200, 200));
				embeddingRequest.setVector(VECTOR_DATA);
				embeddingRequest.setAssetUuid(asset.getUuid());
				embeddingRequest.setSource("embedding_" + i);
				embeddingRequest.setMeta(new JsonObject().put("test", "1234"));
				EmbeddingResponse embedding = client.createEmbedding(embeddingRequest).sync();
				Path videoPath = env.sampleVideo2Path();
				try (InputStream stream = Files.newInputStream(videoPath)) {
					AttachmentResponse uploadResponse = client.uploadAttachment(DUMMY_VIDEO_FILENAME, VIDEO_MIMETYPE, stream).sync();
				}
			}

			// Create a location for the asset
			AssetLocationCreateRequest locationRequest = new AssetLocationCreateRequest();
			locationRequest.setLibraryUuid(library.getUuid());
			locationRequest.setAssetUuid(asset.getUuid());
			locationRequest.setFilesystem(
				new AssetLocationFilesystemInfo().setLastSeen(Instant.now()).setPath(DUMMY_IMAGE_ORIGIN).setFilekey(new FileKey(42L, 42L, 42L, 42L)));
			AssetLocationResponse location = client.createLocation(locationRequest).sync();

			// Collection are used to group assets together (e.g. for a set of remixes)
			CollectionCreateRequest collectionRequest = new CollectionCreateRequest();
			collectionRequest.setName(COLLECTION_NAME_2);
			CollectionResponse collection = client.createCollection(collectionRequest).sync();

			// Add annotation + task
			AnnotationCreateRequest annotationRequest = new AnnotationCreateRequest();
			annotationRequest.setArea(2L, 42L);
			annotationRequest.setDescription("This area needs to be reworked");
			annotationRequest.setTitle("Feedback on intro");
			annotationRequest.setType(AnnotationType.FEEDBACK);
			annotationRequest.setAssetUuid(asset.getUuid());
			AnnotationResponse annotation = client.createAnnotation(annotationRequest).sync();

			TaskCreateRequest taskRequest = new TaskCreateRequest();
			taskRequest.setTitle("Update Intro");
			taskRequest.setPriority(TaskPriority.CRITICAL);
			TaskResponse task = client.createTask(taskRequest).sync();

			// Tag
			TagCreateRequest tagRequest = new TagCreateRequest();
			tagRequest.setName("black");
			tagRequest.setCollection("colors");
			TagResponse tag = client.createTag(tagRequest).sync();

			// Comment
			CommentCreateRequest commentRequest = new CommentCreateRequest();
			commentRequest.setTitle("Feedback");
			commentRequest.setText("ABCDEFG");
			CommentResponse comment = client.createComment(commentRequest).sync();

			// Reactions
			ReactionCreateRequest reactionRequest = new ReactionCreateRequest();
			reactionRequest.setRating(42);
			reactionRequest.setType(ReactionType.PLUS_ONE);
			ReactionResponse reaction1 = client.createAssetReaction(asset.getUuid(), reactionRequest).sync();
			ReactionResponse reaction2 = client.createCommentReaction(comment.getUuid(), reactionRequest).sync();
			ReactionResponse reaction3 = client.createTaskReaction(task.getUuid(), reactionRequest).sync();
		}

	}

}
