package io.metaloom.loom.rest.model.content.field;

public class JsonContentField extends AbstractContentField {

	@Override
	public JsonContentField setName(String name) {
		super.setName(name);
		return this;
	}
	
	@Override
	public String getType() {
		return "json";
	}
}
