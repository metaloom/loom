package io.metaloom.worker.action.fp;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.video4j.fingerprint.v2.MultiSectorVideoFingerprinter;
import io.metaloom.video4j.fingerprint.v2.impl.MultiSectorVideoFingerprinterImpl;
import io.metaloom.worker.action.AbstractFilesystemAction;
import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.WorkerActionSettings;

public class FingerprintAction extends AbstractFilesystemAction {

	public FingerprintAction(LoomGRPCClient client, WorkerActionSettings settings) {
		super(client, settings);
	}

	public static final String NAME = "fingerprint";

	private MultiSectorVideoFingerprinter hasher = new MultiSectorVideoFingerprinterImpl();

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
