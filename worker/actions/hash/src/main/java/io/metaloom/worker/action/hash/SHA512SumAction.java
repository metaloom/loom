package io.metaloom.worker.action.hash;

import static io.metaloom.worker.action.ActionResult.CONTINUE_NEXT;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.worker.action.AbstractFilesystemAction;
import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.settings.ProcessorSettings;

public class SHA512SumAction extends AbstractFilesystemAction<HashActionSettings> {

	public SHA512SumAction(LoomGRPCClient client, ProcessorSettings processorSettings, HashActionSettings settings) {
		super(client, processorSettings, settings);
	}

	private static final String NAME = "sha512-hash";

	@Override
	public String name() {
		return NAME;
	}

	@Override
	public ActionResult process(ProcessableMedia media) {
		long start = System.currentTimeMillis();
		media.getHash512();
		print(media, "DONE", "", start);
		return ActionResult.processed(CONTINUE_NEXT, start);
	}

}
