package io.metaloom.loom.json;

import static io.metaloom.LoomHttpStatusCodes.INTERNAL_SERVER_ERROR;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.metaloom.loom.error.LoomRestException;

/**
 * Central JSON utility that is used to handle serialization and deserialization
 * of JSON models.
 */
public final class JsonUtil {

	protected static ObjectMapper defaultMapper;

	static {
		initDefaultMapper();
	}

	/**
	 * Initialize the default mapper.
	 */
	private static void initDefaultMapper() {
		defaultMapper = new ObjectMapper();
	}

	/**
	 * Transform the given object into a JSON string.
	 * 
	 * @param obj
	 * @return
	 * @throws GenericRestException
	 */
	public static <T> String toJson(T obj) throws LoomRestException {
//		if (obj instanceof JSONObject) {
//			return ((JSONObject) obj).toString();
//		}
		try {
			return defaultMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (IOException e) {
			// TODO i18n
			String message = "Could not generate json from object";
			throw new LoomRestException(INTERNAL_SERVER_ERROR, message, e);
		}
	}

	/**
	 * Return the JSON object mapper.
	 * 
	 * @return
	 */
	public static ObjectMapper getMapper() {
		return defaultMapper;
	}
}
