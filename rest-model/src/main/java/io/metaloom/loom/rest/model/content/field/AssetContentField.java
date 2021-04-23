package io.metaloom.loom.rest.model.content.field;

public class AssetContentField extends AbstractContentField {

	private String filename;

	@Override
	public AssetContentField setName(String name) {
		super.setName(name);
		return this;
	}

	public String getFilename() {
		return filename;
	}

	public AssetContentField setFilename(String filename) {
		this.filename = filename;
		return this;
	}

	@Override
	public String getType() {
		return "asset";
	}
}
