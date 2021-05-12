package io.metaloom.loom.db.fs;

import static io.metaloom.LoomHttpStatusCodes.INTERNAL_SERVER_ERROR;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.error.LoomRestException;
import io.metaloom.loom.json.JsonUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

public abstract class AbstractFSDao {

	public static final File BASE = new File("storage");

	private final LoomDaoCollection daos;

	private final Vertx rxVertx;

	public AbstractFSDao(LoomDaoCollection daos, Vertx rxVertx) {
		this.daos = daos;
		this.rxVertx = rxVertx;
	}

	abstract protected FSType getType();

	public LoomDaoCollection daos() {
		return daos;
	}

	protected <T> Maybe<? extends T> load(UUID uuid, Class<? extends T> clazz) {
		return load(getType(), uuid, clazz);
	}

	protected Completable delete(UUID uuid) {
		return delete(getType(), uuid);
	}

	protected <T> Single<? extends T> store(LoomElement element) {
//		return store(getType(), element.getUuid(), element);
//		return load(getType(), element.getUuid(), element.getClass()).toSingle();
		return null;
	}

	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			FileUtils.deleteDirectory(getTypeDir(getType()));
		});
	}

	public File getTypeDir(FSType type) {
		return new File(BASE, type.name());
	}

	private <T> Maybe<? extends T> load(FSType type, UUID uuid, Class<T> clazz) {
		File fsFile = new File(getTypeDir(type), uuid.toString() + ".json");
		if (fsFile.exists()) {
			try {
				String json = FileUtils.readFileToString(fsFile, Charset.defaultCharset());
				T pojo = JsonUtil.toModel(json, clazz);
				return Maybe.just(pojo);
			} catch (IOException e) {
				// TODO i18n
				String message = "Could not read model from file {" + fsFile.getAbsolutePath() + "}";
				throw new LoomRestException(INTERNAL_SERVER_ERROR, message, e);
			}
		} else {
			return Maybe.empty();
		}
	}

	private Completable delete(FSType type, UUID uuid) {
		File fsFile = new File(getTypeDir(type), uuid.toString() + ".json");
		if (fsFile.exists()) {
			if (!fsFile.delete()) {
				// TODO i18n
				String message = "Unable to delete file {" + fsFile.getAbsolutePath() + "}";
				throw new LoomRestException(INTERNAL_SERVER_ERROR, message);
			}
		}
		return Completable.complete();

	}

	private Completable store(FSType type, UUID uuid, LoomElement element) {
		File fsFile = new File(getTypeDir(type), uuid.toString() + ".json");
		String json = JsonUtil.toJson(element);
		try {
			FileUtils.write(fsFile, json, Charset.defaultCharset());
		} catch (IOException e) {
			// TODO i18n
			String message = "Failed to write to file {" + fsFile.getAbsolutePath() + "}";
			throw new LoomRestException(INTERNAL_SERVER_ERROR, message);
		}
		return Completable.complete();
	}

	protected Completable clearTypeDir() {
		String path = getTypeDir(getType()).getAbsolutePath();
		return rxVertx.fileSystem().rxDeleteRecursive(path, true);
	}
}
