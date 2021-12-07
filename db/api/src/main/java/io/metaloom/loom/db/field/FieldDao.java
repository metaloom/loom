package io.metaloom.loom.db.field;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface FieldDao extends LoomDao {

	Single<? extends Field> createField();

	Completable deleteField(Field content);

	Completable updateField(Field content);

	Maybe<? extends Field> loadField(UUID uuid);

}
