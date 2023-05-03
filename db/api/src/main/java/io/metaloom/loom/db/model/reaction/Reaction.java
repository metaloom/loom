package io.metaloom.loom.db.model.reaction;

import io.metaloom.loom.db.CUDElement;

public interface Reaction extends CUDElement<Reaction> {

	String getType();

	Reaction setType(String type);

}
