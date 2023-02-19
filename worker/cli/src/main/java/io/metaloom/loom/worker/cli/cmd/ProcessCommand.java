package io.metaloom.loom.worker.cli.cmd;

import static io.metaloom.loom.worker.cli.ExitCode.ERROR;
import static io.metaloom.loom.worker.cli.ExitCode.OK;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.worker.processor.FilesystemProcessor;
import io.metaloom.loom.worker.processor.impl.FilesystemProcessorImpl;
import picocli.CommandLine.Command;

@Command(name = "process", aliases = { "p" }, description = "Process command")
public class ProcessCommand extends AbstractLoomWorkerCommand {

	public static final Logger log = LoggerFactory.getLogger(ProcessCommand.class);

	@Command(name = "analyze", description = "Analyze the files")
	public int analyze(String path) {
		try {
			FilesystemProcessor processor = new FilesystemProcessorImpl();
			processor.analyze(path);
			return OK.code();
		} catch (Exception e) {
			log.error("Restoring collections failed.", e);
			return ERROR.code();
		}
	}

}
