package io.metaloom.loom.db.field;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface LoomFieldDao extends LoomDao {

	LoomField createField();

	void deleteField(LoomField content);

	void updateField(LoomField content);

	LoomField loadField(UUID uuid);

}
