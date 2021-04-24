package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.model.field.impl.text.TextMarkup.PLAIN;

import java.util.Arrays;

import org.junit.Test;

import io.metaloom.loom.json.JsonUtil;
import io.metaloom.loom.rest.model.model.field.impl.text.TextModelField;

public class ModelFieldModelTest extends AbstractExamples {

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
