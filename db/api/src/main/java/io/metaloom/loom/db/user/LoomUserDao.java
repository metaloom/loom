package io.metaloom.loom.db.user;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoomUserDao extends LoomDao {

	Single<? extends LoomUser> createUser(String username);

	Maybe<? extends LoomUser> loadUser(UUID uuid);

	Completable updateUser(LoomUser user);

	Completable deleteUser(LoomUser user);

}
