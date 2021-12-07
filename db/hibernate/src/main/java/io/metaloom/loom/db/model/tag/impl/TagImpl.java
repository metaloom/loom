package io.metaloom.loom.db.model.tag.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.tag.Tag;

@Entity
@Table(name = "tags")
public class TagImpl extends AbstractCUDElement implements Tag {

	@Size(max = 128)
	private String name;

	@Size(max = 128)
	@Column(name = "collection")
	private String collectionName;

	public TagImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Tag setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getCollection() {
		return collectionName;
	}

	@Override
	public Tag setCollection(String collectionName) {
		this.collectionName = collectionName;
		return this;
	}

}
