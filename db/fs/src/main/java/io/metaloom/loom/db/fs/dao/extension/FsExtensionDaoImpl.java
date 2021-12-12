package io.metaloom.loom.db.fs.dao.extension;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.extension.Extension;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsExtensionDaoImpl extends AbstractFSDao implements ExtensionDao {

	@Inject
	public FsExtensionDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.EXTENSION;
	}

	@Override
	public Maybe<? extends Extension> loadExtension(UUID uuid) {
		return load(uuid, FsExtensionImpl.class);
	}

	@Override
	public Completable deleteExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		return delete(extension.getUuid());
	}

	@Override
	public Single<? extends Extension> createExtension(String url, Consumer<Extension> modifier) {
		return Single.defer(() -> {
			Extension extension = new FsExtensionImpl();
			extension.setUuid(UUIDUtil.randomUUID());
			if (modifier != null) {
				modifier.accept(extension);
			}
			return store(extension);
		});
	}

	@Override
	public Completable updateExtension(Extension extension) {
		return store(extension).ignoreElement();
	}

}
