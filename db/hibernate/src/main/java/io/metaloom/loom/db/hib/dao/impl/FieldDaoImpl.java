package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.field.Field;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class FieldDaoImpl extends AbstractDao implements FieldDao {

	@Inject
	public FieldDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Field> createField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteField(Field content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateField(Field content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Field> loadField(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
