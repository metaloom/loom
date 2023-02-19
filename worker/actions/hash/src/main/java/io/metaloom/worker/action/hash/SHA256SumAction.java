package io.metaloom.worker.action.hash;

import io.metaloom.worker.action.AbstractFilesystemAction;

public class SHA256SumAction extends AbstractFilesystemAction {

	private static final String NAME = "sha256-hash";

	@Override
	public String name() {
		return NAME;
	}

}
