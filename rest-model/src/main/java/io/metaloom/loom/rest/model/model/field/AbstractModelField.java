package io.metaloom.loom.rest.model.model.field;

public abstract class AbstractModelField implements ModelField {

	private String name;

	private Boolean required;

	private Boolean i18n;

	private Boolean indexing;

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
	public Boolean getRequired() {
		return required;
	}

	@Override
	public ModelField  setRequired(Boolean required) {
		this.required = required;
		return this;
	}

	@Override
	public Boolean getI18N() {
		return this.i18n;
	}

	@Override
	public ModelField setI18N(Boolean i18n) {
		this.i18n = i18n;
		return this;
	}

	@Override
	public Boolean getIndexing() {
		return this.indexing;
	}

	@Override
	public ModelField setIndexing(Boolean indexing) {
		this.indexing = indexing;
		return this;
	}

}
