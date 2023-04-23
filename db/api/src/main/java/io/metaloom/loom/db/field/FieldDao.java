package io.metaloom.loom.db.field;

import java.util.UUID;

import io.metaloom.loom.db.Dao;

public interface FieldDao extends Dao {

	Field createField();

	void deleteField(Field content);

	void updateField(Field content);

	Field loadField(UUID uuid);

}
