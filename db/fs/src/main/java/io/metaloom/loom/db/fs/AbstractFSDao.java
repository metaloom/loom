package io.metaloom.loom.db.fs;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.DaoCollection;
import io.reactivex.Completable;

public abstract class AbstractFSDao {

	private DaoCollection daos;

	public AbstractFSDao(DaoCollection daos) {
		this.daos = daos;
	}

	abstract protected FSType getType();
	
	public DaoCollection daos() {
		return daos;
	}
	
	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
		});
	}
}
