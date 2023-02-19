package io.metaloom.worker.action.fp;

import io.metaloom.video4j.fingerprint.v2.MultiSectorVideoFingerprinter;
import io.metaloom.video4j.fingerprint.v2.impl.MultiSectorVideoFingerprinterImpl;
import io.metaloom.worker.action.AbstractFilesystemAction;

public class FingerprintAction extends AbstractFilesystemAction {

	public static final String NAME = "fingerprint";

	private MultiSectorVideoFingerprinter hasher = new MultiSectorVideoFingerprinterImpl();

	@Override
	public String name() {
		return NAME;
	}

}
