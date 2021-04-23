package io.metaloom.loom.rest.model.content.field;

public class TextContentField extends AbstractContentField {

	private String value;

	public String getValue() {
		return value;
	}

	public TextContentField setValue(String text) {
		this.value = text;
		return this;
	}
	
	@Override
	public TextContentField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public String getType() {
		return "text";
	}
}
