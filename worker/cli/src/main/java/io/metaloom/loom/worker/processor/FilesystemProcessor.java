package io.metaloom.loom.worker.processor;

import java.io.IOException;
import java.nio.file.Path;

import io.metaloom.worker.action.FilesystemAction;

public interface FilesystemProcessor {

	void analyze(Path path) throws IOException;

	void registerAction(FilesystemAction action);

}
