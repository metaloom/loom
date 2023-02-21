package io.metaloom.loom.action.thumbnail;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.worker.action.AbstractFilesystemAction;
import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.WorkerActionSettings;

public class ThumbnailAction extends AbstractFilesystemAction {

	public ThumbnailAction(LoomGRPCClient client, WorkerActionSettings settings) {
		super(client, settings);
	}

	private static final String NAME = "thumbnail";

	@Override
	public String name() {
		return NAME;
	}

	@Override
	public ActionResult process(ProcessableMedia media) {
		// TODO Auto-generated method stub
		return null;
	}

}
