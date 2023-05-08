package io.metaloom.loom.rest.model.example;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.test.TestValues;

public class DateTest implements TestValues {

	@Test
	public void testDate() {
		DatePojo pojo = new DatePojo();
		pojo.setEdited(DATE_NEW);
		String json = Json.parse(pojo);
		System.out.println(json);
	}
}
