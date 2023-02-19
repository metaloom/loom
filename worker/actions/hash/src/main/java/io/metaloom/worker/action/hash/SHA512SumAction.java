package io.metaloom.worker.action.hash;

import io.metaloom.worker.action.AbstractFilesystemAction;

public class SHA512SumAction extends AbstractFilesystemAction{

	private static final String NAME = "sha512-hash";

	@Override
	public String name() {
		return NAME;
	}

}
