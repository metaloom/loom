package io.metaloom.loom.db.mem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.Element;
import io.metaloom.loom.db.page.Page;

public abstract class AbstractMemDao<T extends Element<T>> implements CRUDDao<T> {

	protected Map<UUID, T> storage = new HashMap<>();

	@Override
	public T load(UUID uuid) {
		return storage.get(uuid);
	}

	@Override
	public void delete(UUID uuid) {
		storage.remove(uuid);
	}

	@Override
	public void store(T element) {
		storage.put(element.getUuid(), element);
	}

	@Override
	public T update(T element) {
		storage.put(element.getUuid(), element);
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
	public Page<T> loadPage(UUID fromUuid, int pageSize) {
		List<T> list = new ArrayList<>();
		int n = 0;
		boolean start = fromUuid == null;
		for (T element : storage.values()) {
			n++;
			if (n >= pageSize) {
				break;
			}
			if (start) {
				list.add(element);
			} else {
				if (fromUuid.equals(element.getUuid())) {
					start = true;
					list.add(element);
				}
			}
		}
		return new Page<>(list);
	}

}
