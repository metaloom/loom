package io.metaloom.loom.db.model.library;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;
import io.metaloom.loom.db.Taggable;

public interface Library extends CUDElement<Library>, Taggable, MetaElement<Library> {

	String getName();

	Library setName(String name);

}
