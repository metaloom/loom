package io.metaloom.loom.db.mem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.Element;
import io.metaloom.loom.db.page.Page;

public abstract class AbstractMemDao<T extends Element<T>, PT> implements CRUDDao<T, PT> {

	protected Map<PT, T> storage = new HashMap<>();

	@Override
	public T load(PT id) {
		return storage.get(id);
	}

	@Override
	public void delete(PT id) {
		storage.remove(id);
	}

	@Override
	public void store(T element) {
		PT id = primaryId(element);
		storage.put(id, element);
	}

	@Override
	public T update(T element) {
		PT id = primaryId(element);
		storage.put(id, element);
		return element;
	}

	@Override
	public void clear() {
		storage.clear();
	}

	@Override
	public long count() {
		return storage.size();
	}

	@Override
	public Stream<T> findAll() {
		return storage.values().stream();
	}

	@Override
	public Page<T> loadPage(PT from, int pageSize) {
		List<T> list = new ArrayList<>();
		int n = 0;
		boolean start = from == null;
		for (T element : storage.values()) {
			n++;
			if (n >= pageSize) {
				break;
			}
			if (start) {
				list.add(element);
			} else {
				if (from.equals(element.getUuid())) {
					start = true;
					list.add(element);
				}
			}
		}
		return new Page<>(pageSize, list);
	}

}
