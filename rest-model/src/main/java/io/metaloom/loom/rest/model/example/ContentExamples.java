package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ContentExamples.tagReferenceList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.metaloom.loom.rest.model.asset.AssetHash;
import io.metaloom.loom.rest.model.asset.AssetS3Meta;
import io.metaloom.loom.rest.model.content.ContentCreateRequest;
import io.metaloom.loom.rest.model.content.ContentField;
import io.metaloom.loom.rest.model.content.ContentListResponse;
import io.metaloom.loom.rest.model.content.ContentReference;
import io.metaloom.loom.rest.model.content.ContentResponse;
import io.metaloom.loom.rest.model.content.ContentUpdateRequest;
import io.metaloom.loom.rest.model.content.field.asset.AssetContentField;
import io.metaloom.loom.rest.model.content.field.text.TextContentField;
import io.metaloom.loom.rest.model.tag.TagReference;

public class ContentExamples extends AbstractExamples {

	public static ContentResponse contentResponse() {
		ContentResponse model = new ContentResponse();
		model.setUuid(uuidC());
		model.setVersion("1.0");
		model.setParent(parentContentReference());
		model.setModel(modelReference("BlogPost"));
		model.setTags(tagReferenceList());
		Map<String, List<ContentField>> fieldsMap = new HashMap<>();
		fieldsMap.put("default", contentDefaultFieldList());
		fieldsMap.put("en", contentEnglishFieldList());
		fieldsMap.put("de", contentGermanFieldList());

		model.setFields(fieldsMap);
		setCreatorEditor(model);
		return model;
	}

	public static List<ContentField> contentEnglishFieldList() {
		List<ContentField> fields = new ArrayList<>();
		fields.add(textField("text", "The quick brown fox jumps over the lazy dog"));
		return fields;
	}

	public static List<ContentField> contentGermanFieldList() {
		List<ContentField> fields = new ArrayList<>();
		fields.add(textField("text", "Der schnelle braune Fuchs springt über den faulen Hund"));
		return fields;
	}

	public static List<ContentField> contentDefaultFieldList() {
		List<ContentField> fields = new ArrayList<>();
		fields.add(assetField("image", "dog.jpg"));
		return fields;
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

	public static List<TagReference> tagReferenceList() {
		return Arrays.asList(tagReferenceA(), tagReferenceB());
	}

	public static ContentCreateRequest contentCreateRequest() {
		ContentCreateRequest model = new ContentCreateRequest();
		model.setModel(modelReference("BlogPost"));
		model.setTags(tagReferenceList());
		return model;
	}

	public static ContentUpdateRequest contentUpdateRequest() {
		ContentUpdateRequest model = new ContentUpdateRequest();
		model.setTags(tagReferenceList());
		return model;
	}

	public static ContentListResponse contentListResponse() {
		ContentListResponse model = new ContentListResponse();
		model.setMetainfo(pagingInfo());
		model.add(contentResponse());
		model.add(contentResponse());
		return model;
	}

	public static ContentReference contentReference() {
		ContentReference model = new ContentReference();
		model.setUuid(uuidA());
		model.setName("MyPost");
		return model;
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

}
