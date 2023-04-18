package io.metaloom.loom.rest.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.metaloom.loom.rest.model.RestModel;

/**
 * Helper which manages JSON handling.
 */
public final class Json {

	private static final String PARSE_ERROR = "Error while parsing model to JSON.";

	public static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper()
			.setSerializationInclusion(Include.NON_NULL);

		SimpleModule module = new SimpleModule();
		mapper.registerModule(module);
	}

	private Json() {
	}

	public static JsonNode toJson(String content) throws JsonProcessingException {
		JsonNode json = mapper.readTree(content);
		if (json == null) {
			return null;
		}
		return json;
	}

	public static String parse(RestModel model) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(model);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(PARSE_ERROR, e);
		}
	}

	public static String parseCompact(RestModel model) {
		try {
			return mapper.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(PARSE_ERROR, e);
		}
	}

	public static <T extends RestModel> T parse(String json, Class<T> modelClass) {
		try {
			return mapper.readValue(json, modelClass);
		} catch (JacksonException e) {
			throw new RuntimeException(PARSE_ERROR, e);
		}
	}

}
