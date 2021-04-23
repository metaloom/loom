package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ModelExamples.modelCreateRequest;
import static io.metaloom.loom.rest.model.example.ModelExamples.modelListResponse;
import static io.metaloom.loom.rest.model.example.ModelExamples.modelReference;
import static io.metaloom.loom.rest.model.example.ModelExamples.modelResponse;
import static io.metaloom.loom.rest.model.example.ModelExamples.modelUpdateRequest;
import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;
import static io.metaloom.loom.rest.model.model.field.impl.text.TextMarkup.PLAIN;

import java.util.Arrays;

import org.junit.Test;

import io.metaloom.loom.json.JsonUtil;
import io.metaloom.loom.rest.model.model.field.impl.text.TextModelField;

public class ModelModelTest implements ModelTestcases {

	@Test
	@Override
	public void testResponse() {
		assertModel(modelResponse(), "ModelResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(modelCreateRequest(), "ModelCreateRequest");

	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(modelUpdateRequest(), "ModelUpdateRequest");
	}

	@Test
	@Override
	public void testReference() {
		assertModel(modelReference(), "ModelReference");
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(modelListResponse(), "ModelListResponse");
	}

	@Test
	public void testModelFields() {
		TextModelField text = new TextModelField()
			.setName("text")
			.setRequired(false)
			.setIndexing(true)
			.setMarkup(PLAIN)
			.setI18N(true);
		String json = JsonUtil.toJson(Arrays.asList(text));
		System.out.println(json);
	}

}
