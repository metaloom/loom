package io.metaloom.loom.rest.model.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.AssetGeoLocation;
import io.metaloom.loom.rest.model.asset.AssetHash;
import io.metaloom.loom.rest.model.asset.social.ReactionType;
import io.metaloom.loom.rest.model.asset.social.SocialInfo;
import io.metaloom.loom.rest.model.asset.workflow.Area;
import io.metaloom.loom.rest.model.asset.workflow.Comment;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.common.PagingInfo;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.metaloom.loom.rest.model.task.TaskResponse;
import io.metaloom.loom.rest.model.user.UserReference;
import io.metaloom.utils.UUIDUtils;
import io.vertx.core.json.JsonObject;

public class AbstractExamples {

	public static final Date DATE_OLD = Date.from(Instant.parse("2018-10-12T14:15:06.024Z"));

	public static final Date DATE_NEW = Date.from(Instant.parse("2018-11-20T20:12:01.084Z"));

	public static UUID uuidA() {
		return UUIDUtils.fromString("f04e89d0-076d-4d90-b192-715a25a2cd59");
	}

	public static UUID uuidB() {
		return UUIDUtils.fromString("86abc160-4da2-4951-a91f-da0c33fbc634");
	}

	public static UUID uuidC() {
		return UUIDUtils.fromString("0f3332a6-e404-4777-88a9-1fa984a311bc");
	}

	public static UserReference userReferenceA() {
		UserReference reference = new UserReference();
		reference.setUuid(uuidA());
		reference.setName("joedoe");
		return reference;
	}

	public static PagingInfo pagingInfo() {
		PagingInfo info = new PagingInfo();
		info.setCurrentPage(0);
		info.setPageCount(14);
		info.setTotalCount(28);
		info.setPerPage(2L);
		return info;
	}

	public static void setCreatorEditor(AbstractCreatorEditorRestResponse model) {
		model.getStatus().setCreator(userReferenceA());
		model.getStatus().setCreated(DATE_OLD);
		model.getStatus().setEditor(userReferenceA());
		model.getStatus().setEdited(DATE_NEW);
	}

	public static TagReference tagReferenceA() {
		TagReference model = new TagReference();
		model.setUuid(uuidA());
		model.setName("red");
		return model;
	}

	public static TagReference tagReferenceB() {
		TagReference model = new TagReference();
		model.setUuid(uuidB());
		model.setName("blue");
		return model;
	}

	public static JsonObject meta() {
		JsonObject meta = new JsonObject();
		meta.put("abc", "cdef");
		return meta;
	}

	public static Map<String, String> meta2() {
		return Collections.singletonMap("custom2", "value2");
	}

	public static AssetHash assetHashes() {
		AssetHash hashes = new AssetHash();
		hashes.setSha512(
			"0e3e75234abc68f4378a86b3f4b32a198ba301845b0cd6e50106e874345700cc6663a86c1ea125dc5e92be17c98f9a0f85ca9d5f595db2012f7cc3571945c123");
		hashes.setSha256("f2ca1bb6c7e907d06dafe4687e579fce76b37e4e93b7605022da52e6ccc26fd2");
		hashes.setMD5("d8e8fca2dc0f896fd7cb4cb0031ba249");
		return hashes;
	}

	public static AssetGeoLocation assetGeoLocation() {
		AssetGeoLocation location = new AssetGeoLocation();
		location.setLat(52.156);
		location.setLon(32.56);
		return location;
	}

	private static TaskResponse task() {
		TaskResponse task = new TaskResponse();
		task.setUuid(uuidC());
		task.setTitle("Fix text offset here");
		task.setDescription("The text is not aligned with the title");
		task.getComments().add(comment());
		return task;
	}

	private static SocialInfo social() {
		SocialInfo social = new SocialInfo();
		social.getRating().setDownVotes(0).setUpVotes(42).setStars(10);
		social.getReactions().put(ReactionType.SATISFIED, 10L);
		return social;
	}

	private static Comment comment() {
		Comment comment = new Comment();
		comment.setUuid(uuidB());
		comment.setTitle("Great work!");
		comment.setSocial(social());
		comment.setText("What a great choice of colors!");
		return comment;
	}

	public static List<AnnotationResponse> assetAnnotations() {
		List<AnnotationResponse> list = new ArrayList<>();

		AnnotationResponse first = new AnnotationResponse();
		first.setTitle("Intro Feedback");
		first.setArea(new Area().setFrom(0).setTo(10));
		first.setDescription("The very nice intro");
		first.setThumbnail("???");
		first.setMeta(meta());
		first.getTasks().add(task());
		first.getComments().add(comment());
		list.add(first);

		// Annotation second = new Annotation();
		// second.setTitle("Main Feedback");
		// second.setArea(new Area().setFrom(11).setTo(200));
		// second.setDescription("The main part of the movie");
		// second.setThumbnail("???");
		// second.setTags(tagReferenceList());
		// second.getTasks().add(task());
		// second.getComments().add(comment());
		// second.setMeta(meta());
		// list.add(second);
		return list;
	}

}
