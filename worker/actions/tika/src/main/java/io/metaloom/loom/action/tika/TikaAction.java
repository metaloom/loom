package io.metaloom.loom.action.tika;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.worker.action.api.ActionResult;
import io.metaloom.worker.action.api.ProcessableMedia;
import io.metaloom.worker.action.common.AbstractFilesystemAction;
import io.metaloom.worker.action.settings.ProcessorSettings;

public class TikaAction extends AbstractFilesystemAction<TikaActionSettings> {

	public TikaAction(LoomGRPCClient client, ProcessorSettings processorSettings, TikaActionSettings settings) {
		super(client, processorSettings, settings);
	}

	private static final String NAME = "tika";

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
