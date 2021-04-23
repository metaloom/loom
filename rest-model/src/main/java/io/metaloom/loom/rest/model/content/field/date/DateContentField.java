package io.metaloom.loom.rest.model.content.field.date;

import io.metaloom.loom.rest.model.content.field.AbstractContentField;

public class DateContentField extends AbstractContentField {

	@Override
	public DateContentField setName(String name) {
		super.setName(name);
		return this;
	}
	
	@Override
	public String getType() {
		return "date";
	}
}
