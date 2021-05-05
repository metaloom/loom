package io.metaloom.loom.db.model;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Observable;

public class FsModelImpl extends AbstractFSCUDElement implements Model {

	private String name;

	public FsModelImpl(DaoCollection daos) {
		super(daos);
	}

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
	public Observable<Tag> getTags() {
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
