package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ContentFieldExamples.assetField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.assetListField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.dateField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.dateListField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.jsonField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.jsonListField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.nestedField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.nestedListField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.numberField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.numberListField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.referenceField;
import static io.metaloom.loom.rest.model.example.ContentFieldExamples.referenceListField;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.metaloom.loom.json.JsonUtil;
import io.metaloom.loom.rest.model.content.ContentField;
import io.metaloom.loom.rest.model.content.field.asset.AssetContentField;
import io.metaloom.loom.rest.model.content.field.asset.AssetListContentField;
import io.metaloom.loom.rest.model.content.field.bool.BooleanContentField;
import io.metaloom.loom.rest.model.content.field.date.DateContentField;
import io.metaloom.loom.rest.model.content.field.date.DateListContentField;
import io.metaloom.loom.rest.model.content.field.json.JsonContentField;
import io.metaloom.loom.rest.model.content.field.json.JsonListContentField;
import io.metaloom.loom.rest.model.content.field.nested.NestedContentField;
import io.metaloom.loom.rest.model.content.field.nested.NestedListContentField;
import io.metaloom.loom.rest.model.content.field.number.NumberContentField;
import io.metaloom.loom.rest.model.content.field.number.NumberListContentField;
import io.metaloom.loom.rest.model.content.field.reference.ReferenceContentField;
import io.metaloom.loom.rest.model.content.field.reference.ReferenceListContentField;
import io.metaloom.loom.rest.model.content.field.text.TextContentField;

public class ContentFieldModelTest {

	@Test
	public void testAssetField() {
		AssetContentField field = assetField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testAssetListField() {
		AssetListContentField field = assetListField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testNestedField() {
		NestedContentField field = nestedField();
		System.out.println(JsonUtil.toJson(field));
	}
	
	@Test
	public void testNestedListField() {
		NestedListContentField field = nestedListField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testContentFields() {
		TextContentField text = new TextContentField().setName("text").setValue("Lorem ipsum dolor sit amet");
		AssetContentField asset = new AssetContentField().setName("asset").setFilename("flower.jpg");
		DateContentField date = new DateContentField().setName("date");
		NumberContentField number = new NumberContentField().setName("number");
		JsonContentField json = new JsonContentField().setName("json");
		BooleanContentField bool = new BooleanContentField().setName("boolean").setValue(true);

		// ContentContentField
		// ReferenceContentField

		List<ContentField> model = Arrays.asList(text, asset, date, number, json, bool);
		System.out.println(JsonUtil.toJson(model));
	}

	@Test
	public void testJsonField() {
		JsonContentField field = jsonField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testJsonListField() {
		JsonListContentField field = jsonListField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testDateField() {
		DateContentField field = dateField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testDateListField() {
		DateListContentField field = dateListField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testNumberField() {
		NumberContentField field = numberField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testNumberListField() {
		NumberListContentField field = numberListField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testReferenceField() {
		ReferenceContentField field = referenceField();
		System.out.println(JsonUtil.toJson(field));
	}

	@Test
	public void testReferenceListField() {
		ReferenceListContentField field = referenceListField();
		System.out.println(JsonUtil.toJson(field));
	}

}
