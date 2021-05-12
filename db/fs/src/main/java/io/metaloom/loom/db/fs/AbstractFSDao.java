package io.metaloom.loom.db.fs;

import static io.metaloom.loom.utils.ExceptionUtils.isNotFoundError;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.json.JsonUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.file.FileSystem;

public abstract class AbstractFSDao {

	public static final File BASE = new File("storage");

	private final LoomDaoCollection daos;

	private final FileSystem rxFilesystem;

	public AbstractFSDao(LoomDaoCollection daos, FileSystem rxFilesystem) {
		this.daos = daos;
		this.rxFilesystem = rxFilesystem;
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

	protected <T extends LoomElement> Single<? extends T> store(T element) {
		return store(getType(), element.getUuid(), element).andThen(Single.just(element));
		// return load(getType(), element.getUuid(), element.getClass()).toSingle();
	}

	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			FileUtils.deleteDirectory(getTypeDir(getType()));
		});
	}

	private <T> Maybe<? extends T> load(FSType type, UUID uuid, Class<T> clazz) {
		return rxFilesystem.rxReadFile(getElementPath(type, uuid))
			.toMaybe()
			.onErrorResumeNext(err -> isNotFoundError(err) ? Maybe.empty() : Maybe.error(err))
			.flatMap(buffer -> {
				String json = buffer.toString();
				T pojo = JsonUtil.toModel(json, clazz);
				return Maybe.just(pojo);
			});
		// // TODO i18n
		// String message = "Could not read model from file {" + fsFile.getAbsolutePath() + "}";
		// throw new LoomRestException(INTERNAL_SERVER_ERROR, message, e);
	}

	private Completable delete(FSType type, UUID uuid) {
		return rxFilesystem.rxDelete(getElementPath(type, uuid));
		// if (fsFile.exists()) {
		// if (!fsFile.delete()) {
		// // TODO i18n
		// String message = "Unable to delete file {" + fsFile.getAbsolutePath() + "}";
		// throw new LoomRestException(INTERNAL_SERVER_ERROR, message);
		// }
		// }
		// return Completable.complete();

	}

	private Completable store(FSType type, UUID uuid, LoomElement element) {
		String folderPath = getFolderPath(type, uuid);
		String elementPath = getElementPath(type, uuid);
		String json = JsonUtil.toJson(element);

		Completable writeFile = rxFilesystem.rxWriteFile(elementPath, Buffer.buffer(json));
		return rxFilesystem.rxExists(folderPath).flatMapCompletable(fsExists -> {
			return fsExists ? writeFile : rxFilesystem.rxMkdirs(folderPath).andThen(writeFile);
		});
		// try {
		// FileUtils.write(fsFile, json, Charset.defaultCharset());
		// } catch (IOException e) {
		// // TODO i18n
		// String message = "Failed to write to file {" + fsFile.getAbsolutePath() + "}";
		// throw new LoomRestException(INTERNAL_SERVER_ERROR, message);
		// }
		// return Completable.complete();
	}

	public String getElementPath(FSType type, UUID uuid) {
		return new File(getFolderPath(type, uuid), uuid.toString() + ".json").getAbsolutePath();
	}

	private String getFolderPath(FSType type, UUID uuid) {
		File base = new File(BASE, type.name());
		String prefix = uuid.toString().substring(0, 3);
		return new File(base, prefix).getAbsolutePath();
	}

	public File getTypeDir(FSType type) {
		return new File(BASE, type.name());
	}

	protected Completable clearTypeDir() {
		String path = getTypeDir(getType()).getAbsolutePath();
		return rxFilesystem.rxDeleteRecursive(path, true);
	}
}
