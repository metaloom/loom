package io.metaloom.loom.db.hib.dao;

import org.hibernate.reactive.mutiny.Mutiny.SessionFactory;

import io.reactivex.rxjava3.core.Completable;

public abstract class AbstractDao {

	protected SessionFactory emf;

	public AbstractDao(SessionFactory emf) {
		this.emf = emf;
	}

	protected Completable invokeClear(String typeName) {
		return null;
	}
}
