package io.metaloom.loom.db.namespace;

import java.util.stream.Stream;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.tag.Tag;

public class FsNamespaceImpl extends AbstractFSCUDElement implements Namespace {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Namespace setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Stream<Tag> getTags() {
		return null;
	}

	@Override
	public void removeTag(Tag tag) {

	}

	@Override
	public void addTag(Tag tag) {

	}

}
