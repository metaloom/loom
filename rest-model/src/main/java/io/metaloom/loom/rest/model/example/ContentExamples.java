package io.metaloom.loom.rest.model.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.metaloom.loom.rest.model.content.ContentCreateRequest;
import io.metaloom.loom.rest.model.content.ContentField;
import io.metaloom.loom.rest.model.content.ContentListResponse;
import io.metaloom.loom.rest.model.content.ContentReference;
import io.metaloom.loom.rest.model.content.ContentResponse;
import io.metaloom.loom.rest.model.content.ContentUpdateRequest;
import io.metaloom.loom.rest.model.content.field.TextContentField;
import io.metaloom.loom.rest.model.tag.TagReference;

public class ContentExamples extends AbstractExamples {

	public static ContentResponse contentResponse() {
		ContentResponse model = new ContentResponse();
		model.setUuid(uuidC());
		model.setVersion("1.0");
		model.setParent(parentContentReference());
		model.setModel(modelReference("BlogPost"));
		model.setTags(tagReferenceList());
		model.setFields(contentFieldList());
		setCreatorEditor(model);
		return model;
	}

	public static List<ContentField> contentFieldList() {
		List<ContentField> fields = new ArrayList<>();
		fields.add(textField());
		return fields;
	}

	public static ContentField textField() {
		TextContentField field = new TextContentField();
		field.setName("text");
		field.setValue("Lorem ipsum dolor sit amet");
		return field;
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

}
