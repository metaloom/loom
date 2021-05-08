package io.metaloom.loom.db.asset;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Taggable;

public interface LoomAsset extends CUDElement, Taggable {

	String getFilename();

	LoomAsset setFilename(String filename);
}
