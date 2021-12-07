package io.metaloom.loom.db.model.content.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.metaloom.loom.db.field.Field;
import io.metaloom.loom.db.model.AbstractCUDElement;

@Entity
@Table(name= "fields")
public class FieldImpl extends AbstractCUDElement implements Field {
	
}
