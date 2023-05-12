package io.metaloom.loom.rest.json;

import java.io.InputStream;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.metaloom.loom.rest.json.deserializer.JsonArrayDeserializer;
import io.metaloom.loom.rest.json.deserializer.JsonObjectDeserializer;
import io.metaloom.loom.rest.json.serializer.JsonArraySerializer;
import io.metaloom.loom.rest.json.serializer.JsonObjectSerializer;
import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.rest.model.RestResponseModel;
import io.netty.buffer.ByteBufInputStream;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

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
		module.addSerializer(JsonObject.class, new JsonObjectSerializer());
		module.addSerializer(JsonArray.class, new JsonArraySerializer());
		module.addDeserializer(JsonObject.class, new JsonObjectDeserializer());
		module.addDeserializer(JsonArray.class, new JsonArrayDeserializer());
		mapper.registerModule(new JavaTimeModule());
		mapper.setTimeZone(TimeZone.getTimeZone("UTC"));
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

	public static <T extends RestModel> T parse(Buffer buffer, Class<T> modelClass) {
		try (InputStream ins = new ByteBufInputStream(buffer.getByteBuf())) {
			return mapper.readValue(ins, modelClass);
		} catch (Exception e) {
			throw new RuntimeException(PARSE_ERROR, e);
		}
	}

	public static Buffer encodeCompactToBuffer(RestResponseModel model) {
		try {
			return Buffer.buffer(mapper.writeValueAsBytes(model));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(PARSE_ERROR, e);
		}
	}

	public static Buffer encodeToBuffer(RestResponseModel model) {
		try {
			return Buffer.buffer(mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(model));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(PARSE_ERROR, e);
		}
	}

}
