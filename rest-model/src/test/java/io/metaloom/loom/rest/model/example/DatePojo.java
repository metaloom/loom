package io.metaloom.loom.rest.model.example;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class DatePojo implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("ISO8601 formatted editing date string.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private OffsetDateTime edited;

	public OffsetDateTime getEdited() {
		return edited;
	}

	public void setEdited(OffsetDateTime edited) {
		this.edited = edited;
	}
}
