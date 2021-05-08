package io.metaloom.loom.db.extension;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;

public interface LoomExtension extends CUDElement, LoomElement {

	String getURL();

	LoomExtension setURL(String url);
}
