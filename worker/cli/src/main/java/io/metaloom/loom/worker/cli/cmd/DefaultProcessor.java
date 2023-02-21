package io.metaloom.loom.worker.cli.cmd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.metaloom.loom.action.thumbnail.ThumbnailAction;
import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.loom.worker.actions.ConsistencyAction;
import io.metaloom.loom.worker.processor.FilesystemProcessor;
import io.metaloom.loom.worker.processor.impl.FilesystemProcessorImpl;
import io.metaloom.worker.action.FilesystemAction;
import io.metaloom.worker.action.WorkerActionSettings;
import io.metaloom.worker.action.hash.ChunkHashAction;
import io.metaloom.worker.action.hash.SHA256SumAction;
import io.metaloom.worker.action.hash.SHA512SumAction;

public class DefaultProcessor {

	private final FilesystemProcessor processor;
	private final WorkerActionSettings settings;

	public DefaultProcessor(WorkerActionSettings settings) {
		this.settings = settings;
		this.processor = new FilesystemProcessorImpl();
	}

	public void process(Path folder) throws IOException {
		if (Files.exists(folder)) {
			throw new FileNotFoundException("Startfolder not found " + folder.toString());
		}

		String hostname = null;
		int port = 0;
		try (LoomGRPCClient client = LoomGRPCClient.builder().setHostname(hostname).setPort(port).build()) {
			registerAction(new ConsistencyAction(client, settings));
			registerAction(new ChunkHashAction(client, settings));
			registerAction(new SHA256SumAction(client, settings));
			registerAction(new SHA512SumAction(client, settings));
			registerAction(new ThumbnailAction(client, settings));
			processor.analyze(folder);
		}
	}

	private void registerAction(FilesystemAction action) {
		processor.registerAction(action);
	}

}
