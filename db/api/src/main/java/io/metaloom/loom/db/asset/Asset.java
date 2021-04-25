package io.metaloom.loom.db.asset;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Taggable;

public interface Asset extends CUDElement, Taggable {

	String getFilename();

	Asset setFilename(String filename);
}
