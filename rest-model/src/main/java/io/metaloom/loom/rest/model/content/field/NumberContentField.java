package io.metaloom.loom.rest.model.content.field;

public class NumberContentField extends AbstractContentField {

	@Override
	public NumberContentField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public String getType() {
		return "number";
	}
}
