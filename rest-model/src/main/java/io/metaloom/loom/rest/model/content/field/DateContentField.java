package io.metaloom.loom.rest.model.content.field;

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
