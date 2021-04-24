package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ContentExamples.tagReferenceList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.metaloom.loom.rest.model.asset.AssetHash;
import io.metaloom.loom.rest.model.asset.AssetLocation;
import io.metaloom.loom.rest.model.asset.AssetS3Meta;
import io.metaloom.loom.rest.model.asset.AssetTimelineEntry;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.common.PagingInfo;
import io.metaloom.loom.rest.model.content.ContentReference;
import io.metaloom.loom.rest.model.content.field.asset.AssetContentField;
import io.metaloom.loom.rest.model.content.field.nested.NestedContentField;
import io.metaloom.loom.rest.model.content.field.text.TextContentField;
import io.metaloom.loom.rest.model.model.ModelReference;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.metaloom.loom.rest.model.user.UserReference;
import io.metaloom.loom.uuid.UUIDUtil;

public class AbstractExamples {

	public static final String DATE_OLD = "2018-10-12T14:15:06.024Z";

	public static final String DATE_NEW = "2018-11-20T20:12:01.084Z";

	public static UUID uuidA() {
		return UUIDUtil.fromString("f04e89d0-076d-4d90-b192-715a25a2cd59");
	}

	public static UUID uuidB() {
		return UUIDUtil.fromString("86abc160-4da2-4951-a91f-da0c33fbc634");
	}

	public static UUID uuidC() {
		return UUIDUtil.fromString("0f3332a6-e404-4777-88a9-1fa984a311bc");
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
		model.setCreator(userReferenceA());
		model.setCreated(DATE_OLD);
		model.setEditor(userReferenceA());
		model.setEdited(DATE_NEW);
	}

	public static ModelReference modelReference(String name) {
		ModelReference reference = new ModelReference();
		reference.setUuid(uuidB());
		reference.setName(name);
		return reference;
	}

	public static ContentReference parentContentReference() {
		ContentReference reference = new ContentReference();
		reference.setName("posts");
		reference.setUuid(uuidC());
		return reference;
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

	public static Map<String, String> meta() {
		return Collections.singletonMap("custom", "value");
	}

	public static AssetHash assetHashes() {
		AssetHash hashes = new AssetHash();
		hashes.setSha512(
			"0e3e75234abc68f4378a86b3f4b32a198ba301845b0cd6e50106e874345700cc6663a86c1ea125dc5e92be17c98f9a0f85ca9d5f595db2012f7cc3571945c123");
		hashes.setSha256("f2ca1bb6c7e907d06dafe4687e579fce76b37e4e93b7605022da52e6ccc26fd2");
		hashes.setMD5("d8e8fca2dc0f896fd7cb4cb0031ba249");
		return hashes;
	}

	public static AssetLocation assetLocation() {
		AssetLocation location = new AssetLocation();
		location.setLat(52.156);
		location.setLon(32.56);
		return location;
	}

	public static List<AssetTimelineEntry> assetTimeline() {
		List<AssetTimelineEntry> list = new ArrayList<>();

		AssetTimelineEntry first = new AssetTimelineEntry();
		first.setArea(0, 200);
		first.setDescription("The very nice intro");
		first.setThumbail("???");
		first.setTags(tagReferenceList());
		first.setMeta(meta());
		list.add(first);

		AssetTimelineEntry second = new AssetTimelineEntry();
		second.setArea(200, 900);
		second.setDescription("The main part of the movie");
		second.setThumbail("???");
		second.setTags(tagReferenceList());
		second.setMeta(meta());
		list.add(second);
		return list;
	}

	public static AssetContentField assetField() {
		AssetContentField asset = new AssetContentField()
			.setName("asset")
			.setDuration(20000)
			.setDominantColor("#FFFF00")
			.setSize(2005225)
			.setWidth(4000)
			.setHeight(2250)
			.setHashes(assetHashes())
			.setLocalPath("/opt/movies/bigbuckbunny-4k.mp4")
			.setS3(new AssetS3Meta().setBucket("big_bucket").setKey("themovie"))
			.setMeta(meta())
			.setMimeType("video/mp4")
			.setLocation(assetLocation())
			.setTags(tagReferenceList())
			.setTimeline(assetTimeline())
			.setFilename("bigbuckbunny-4k.mp4");
		return asset;
	}

	public static TextContentField textField(String name, String value) {
		TextContentField field = new TextContentField();
		field.setName(name);
		field.setValue(value);
		return field;
	}

	public static AssetContentField assetField(String name, String filename) {
		AssetContentField asset = new AssetContentField();
		asset.setName(name);
		asset.setFilename(filename);
		return asset;
	}

	public static NestedContentField contentField() {
		NestedContentField innerField = new NestedContentField();
		innerField.setName("inner-content");
		innerField.setFields(Arrays.asList(textField("text", "Inner value")));

		NestedContentField field = new NestedContentField();
		field.setName("content");
		field.setFields(Arrays.asList(textField("text", "ValueA"), innerField));
		return field;
	}
}
