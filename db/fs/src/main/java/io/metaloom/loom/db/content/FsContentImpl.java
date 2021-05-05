package io.metaloom.loom.db.content;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Observable;

public class FsContentImpl extends AbstractFSCUDElement implements Content {

	public FsContentImpl(DaoCollection daos) {
		super(daos);
	}

	public FsContentImpl() {
		this(null);
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
