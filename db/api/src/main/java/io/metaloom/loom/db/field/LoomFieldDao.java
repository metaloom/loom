package io.metaloom.loom.db.field;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface LoomFieldDao extends LoomDao {

	LoomField createField();

	Completable deleteField(LoomField content);

	Completable updateField(LoomField content);

	Maybe<? extends LoomField> loadField(UUID uuid);


}
