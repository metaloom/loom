package io.metaloom.loom.db.fs;

import static io.metaloom.LoomHttpStatusCodes.INTERNAL_SERVER_ERROR;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.user.User;
import io.metaloom.loom.error.LoomRestException;
import io.metaloom.loom.json.JsonUtil;

public class FilesystemIoHelper {

	public static final File BASE = new File("storage");

	public static File getTypeDir(FSType type) {
		return new File(BASE, type.name());
	}

	public static <T> T load(FSType type, UUID uuid, Class<T> clazz) {
		File fsFile = new File(getTypeDir(type), uuid.toString() + ".json");
		if (fsFile.exists()) {
			try {
				String json = FileUtils.readFileToString(fsFile, Charset.defaultCharset());
				return JsonUtil.toModel(json, clazz);
			} catch (IOException e) {
				// TODO i18n
				String message = "Could not read model from file {" + fsFile.getAbsolutePath() + "}";
				throw new LoomRestException(INTERNAL_SERVER_ERROR, message, e);
			}
		} else {
			return null;
		}
	}

	public static void delete(FSType type, UUID uuid) {
		File fsFile = new File(getTypeDir(type), uuid.toString() + ".json");
		if (fsFile.exists()) {
			if (!fsFile.delete()) {
				// TODO i18n
				String message = "Unable to delete file {" + fsFile.getAbsolutePath() + "}";
				throw new LoomRestException(INTERNAL_SERVER_ERROR, message);
			}
		}

	}

	public static void store(FSType type, UUID uuid, LoomElement element) {
		File fsFile = new File(getTypeDir(type), uuid.toString() + ".json");
		String json = JsonUtil.toJson(element);
		try {
			FileUtils.write(fsFile, json, Charset.defaultCharset());
		} catch (IOException e) {
			// TODO i18n
			String message = "Failed to write to file {" + fsFile.getAbsolutePath() + "}";
			throw new LoomRestException(INTERNAL_SERVER_ERROR, message);
		}

	}

}
