package io.metaloom.loom.db.model;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.db.user.User;

public class FsModelImpl extends AbstractFSCUDElement implements Model {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Model setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Stream<Tag> getTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTag(Tag tag) {
		// TODO Auto-generated method stub

	}

}
