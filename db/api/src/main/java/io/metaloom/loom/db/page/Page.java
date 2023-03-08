package io.metaloom.loom.db.page;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import io.metaloom.loom.db.LoomElement;

public class Page<T extends LoomElement> implements Iterable<T> {

	private List<T> list;

	public Page(List<T> list) {
		this.list = list;
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	public long size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public UUID lastUUID() {
		if (isEmpty()) {
			return null;
		} else {
			return last().getUuid();
		}
	}

	public T last() {
		if (isEmpty()) {
			return null;
		} else {
			return list.get(list.size() - 1);
		}
	}

	public T first() {
		if (isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
