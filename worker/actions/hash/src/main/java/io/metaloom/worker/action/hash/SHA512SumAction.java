package io.metaloom.worker.action.hash;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.worker.action.AbstractFilesystemAction;
import static io.metaloom.worker.action.ActionResult.CONTINUE_NEXT;
import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.WorkerActionSettings;

public class SHA512SumAction extends AbstractFilesystemAction {

	public SHA512SumAction(LoomGRPCClient client, WorkerActionSettings settings) {
		super(client, settings);
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
