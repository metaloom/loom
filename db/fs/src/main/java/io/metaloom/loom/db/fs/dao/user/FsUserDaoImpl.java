package io.metaloom.loom.db.fs.dao.user;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsUserDaoImpl extends AbstractFSDao implements LoomUserDao {

	@Inject
	public FsUserDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.USER;
	}

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		return load(uuid, FsUserImpl.class);
	}

	@Override
	public Completable deleteUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		return delete(user.getUuid());
	}

	@Override
	public Single<? extends LoomUser> createUser(String username, Consumer<LoomUser> modifier) {
		return Single.defer(() -> {
			LoomUser user = new FsUserImpl();
			user.setUuid(UUIDUtil.randomUUID());
			user.setUsername(username);
			if (modifier != null) {
				modifier.accept(user);
			}
			return Single.just(user);
		});
	}

	@Override
	public Completable updateUser(LoomUser user) {
		return store(user).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			FileUtils.deleteDirectory(getTypeDir(getType()));
		});
	}

	@Override
	public Observable<LoomUser> findAll() {
		return null;
	}

}
