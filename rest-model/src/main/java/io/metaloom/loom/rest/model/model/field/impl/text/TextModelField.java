package io.metaloom.loom.rest.model.model.field.impl.text;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class TextModelField extends AbstractModelField {

	private TextMarkup markup;

	@Override
	public TextModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public TextModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public TextModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public TextModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.TEXT;
	}

	public TextMarkup getMarkup() {
		return markup;
	}

	public TextModelField setMarkup(TextMarkup markup) {
		this.markup = markup;
		return this;
	}

}
