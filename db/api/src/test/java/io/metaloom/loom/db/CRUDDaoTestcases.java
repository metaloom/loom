package io.metaloom.loom.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;

public interface CRUDDaoTestcases<DAO extends CRUDDao<T>, T extends Element<T>> extends FixtureElementProvider {

	DAO getDao();

	T createElement(User user, int i);

	@Test
	default void testCreate() {
		DAO dao = getDao();
		long before = dao.count();

		AtomicReference<UUID> ref = new AtomicReference<>();
		User creator = dummyUser();
		transaction(t -> {
			T element = createElement(creator, 0);
			assertNotNull(element);
			dao.store(element);
			ref.set(element.getUuid());
			assertNotNull(element.getUuid());
			getDao().store(element);
		});

		assertEquals(before + 1, dao.count());
		assertNotNull(dao.load(ref.get()));
	}

	@Test
	default void testDelete() {
		DAO dao = getDao();
		User user = dummyUser();

		// Create library
		T element = createElement(user, 0);
		assertNotNull(element);

		// Now assert deletion
		dao.delete(element);
		assertNull(dao.load(element.getUuid()), "The library should be deleted.");
	}

	@Test
	default void testUpdate() {
		DAO dao = getDao();
		User user = dummyUser();

		// Create and store
		T element = createElement(user, 0);
		dao.store(element);

		// Now update
		updateElement(element);
		dao.update(element);

		// Load and assert update was persisted
		T updatedElement = dao.load(element.getUuid());
		assertUpdate(updatedElement);

	}

	void assertUpdate(T updatedElement);

	void updateElement(T element);

	@Test
	default void testLoad() {
		DAO dao = getDao();
		User user = dummyUser();

		// Create and store element
		T element = createElement(user, 0);

		dao.store(element);

		// Now load again
		assertNotNull(dao.load(element.getUuid()));
	}

	@Test
	default void testLoadPage() {
		for (int i = 0; i < 1024; i++) {
			T element = createElement(dummyUser(), i);
			getDao().store(element);
		}
		assertEquals(1024, getDao().count());

		UUID uuid = null;
		long totalFound = 0;
		while (true) {
			Page<T> page = getDao().loadPage(uuid, 30);
			if (page.isEmpty()) {
				break;
			} else {
				uuid = page.lastUUID();
			}
			for (T element : page) {
				System.out.println(element);
				totalFound++;
			}
			System.out.println("--");
		}

		assertEquals(1024, totalFound);
	}

}