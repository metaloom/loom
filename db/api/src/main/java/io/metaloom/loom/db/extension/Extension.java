package io.metaloom.loom.db.extension;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;

public interface Extension extends CUDElement, LoomElement {

	String getURL();

	Extension setURL(String url);
}
