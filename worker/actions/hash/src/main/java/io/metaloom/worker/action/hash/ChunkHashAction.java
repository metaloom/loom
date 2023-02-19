package io.metaloom.worker.action.hash;

import io.metaloom.worker.action.AbstractFilesystemAction;

public class ChunkHashAction extends AbstractFilesystemAction {

	private static final String NAME = "chunk-hash";

	@Override
	public String name() {
		return NAME;
	}

}
