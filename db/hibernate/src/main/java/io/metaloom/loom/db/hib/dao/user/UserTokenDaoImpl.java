package io.metaloom.loom.db.hib.dao.user;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.user.UserTokenDao;

@Singleton
public class UserTokenDaoImpl extends AbstractDao implements UserTokenDao {

	@Inject
	public UserTokenDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

}
