package io.metaloom.loom.db.field;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface FieldsDao extends LoomDao {

	Field createField();

	void deleteField(Field content);

	void updateField(Field content);

	Maybe<? extends Field> loadField(UUID uuid);

	void storeField(Field content);

}
