package io.metaloom.loom.rest.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.mockito.Mockito;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;
import io.metaloom.loom.rest.builder.impl.LoomModelBuilderImpl;
import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.test.TestValues;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public abstract class AbstractModelBuilderTest implements TestValues {

	private LoomModelBuilder builder = new LoomModelBuilderImpl();

	public LoomModelBuilder builder() {
		return builder;
	}

	public void assertWithModel(RestModel model, String modelName) throws IOException {
		String json = Json.parse(model);
		assertWithModel(json, modelName);
	}

	public void assertWithModel(String json, String modelName) throws IOException {
		try (InputStream ins = getClass().getResourceAsStream("/model/" + modelName)) {
			if (ins == null) {
				System.out.println(json);
			}
			assertNotNull(ins, "Model file " + modelName + " not found in test resources");
			String model = IOUtils.toString(ins, Charset.defaultCharset());
			assertEquals(model, json, "The json did not match with the stored model.");
		}
	}

	public void mockCreatorEditor(CUDElement<?> element) {
		Mockito.when(element.getCreated()).thenReturn(DATE_OLD);
		Mockito.when(element.getEdited()).thenReturn(DATE_OLD);
		Mockito.when(element.getCreatorUuid()).thenReturn(USER_UUID);
		Mockito.when(element.getEditorUuid()).thenReturn(USER_UUID);
	}

	public void mockMeta(MetaElement<?> element) {
		JsonObject json = new JsonObject().put("abc", "efg");
		json.put("nested", new JsonObject().put("key", 42));
		json.put("array", new JsonArray().add(42).add(24));
		Mockito.when(element.getMeta()).thenReturn(json);
	}

}
