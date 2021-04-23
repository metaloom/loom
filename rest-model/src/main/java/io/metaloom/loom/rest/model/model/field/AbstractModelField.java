package io.metaloom.loom.rest.model.model.field;

public abstract class AbstractModelField implements ModelField {

	private String name;

	private String type;

	private String listType;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ModelField setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public ModelField setType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public String getListType() {
		return listType;
	}

	@Override
	public ModelField setListType(String listType) {
		this.listType = listType;
		return this;
	}

}
