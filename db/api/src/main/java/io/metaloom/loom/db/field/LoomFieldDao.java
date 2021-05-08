package io.metaloom.loom.db.field;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface LoomFieldDao extends LoomDao {

	LoomField createField();

	void deleteField(LoomField content);

	void updateField(LoomField content);

	Maybe<? extends LoomField> loadField(UUID uuid);

	void storeField(LoomField content);

}
