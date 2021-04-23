package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ContentExamples.contentCreateRequest;
import static io.metaloom.loom.rest.model.example.ContentExamples.contentListResponse;
import static io.metaloom.loom.rest.model.example.ContentExamples.contentReference;
import static io.metaloom.loom.rest.model.example.ContentExamples.contentResponse;
import static io.metaloom.loom.rest.model.example.ContentExamples.contentUpdateRequest;
import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.metaloom.loom.json.JsonUtil;
import io.metaloom.loom.rest.model.content.ContentField;
import io.metaloom.loom.rest.model.content.field.AssetContentField;
import io.metaloom.loom.rest.model.content.field.BooleanContentField;
import io.metaloom.loom.rest.model.content.field.DateContentField;
import io.metaloom.loom.rest.model.content.field.JsonContentField;
import io.metaloom.loom.rest.model.content.field.NumberContentField;
import io.metaloom.loom.rest.model.content.field.TextContentField;

public class ContentModelTest implements ModelTestcases {

	@Test
	@Override
	public void testResponse() {
		assertModel(contentResponse(), "ContentResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(contentCreateRequest(), "ContentCreateRequest");
	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(contentUpdateRequest(), "ContentUpdateRequest");
	}

	@Test
	@Override
	public void testReference() {
		assertModel(contentReference(), "ContentReference");
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(contentListResponse(), "ContentListResponse");
	}

	@Test
	public void testContentFields() {
		TextContentField text = new TextContentField().setName("text").setValue("Lorem ipsum dolor sit amet");
		AssetContentField asset = new AssetContentField().setName("asset").setFilename("flower.jpg");
		DateContentField date = new DateContentField().setName("date");
		NumberContentField number = new NumberContentField().setName("number");
		JsonContentField json = new JsonContentField().setName("json");
		BooleanContentField bool = new BooleanContentField().setName("boolean").setValue(true);

		List<ContentField> model = Arrays.asList(text, asset, date, number, json, bool);
		System.out.println(JsonUtil.toJson(model));
	}
}
