package io.metaloom.loom.db.asset;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Observable;

public class FsAssetImpl extends AbstractFSCUDElement implements Asset {

	private String name;

	private List<Tag> tags = new ArrayList<>();

	public FsAssetImpl(DaoCollection daos) {
		super(daos);
	}

	@Override
	public String getFilename() {
		return name;
	}

	@Override
	public Asset setFilename(String name) {
		this.name = name;
		return this;
	}

	@Override
	@JsonIgnore
	public Observable<Tag> getTags() {
		return Observable.fromIterable(tags);
	}

	@Override
	public void addTag(Tag tag) {
		tags.add(tag);
	}

	@Override
	public void removeTag(Tag tag) {
		tags.remove(tag);
	}

}
