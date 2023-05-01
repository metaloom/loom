package io.metaloom.loom.db.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.library.LibraryDao;

public abstract class AbstractLibraryDaoTest {

	abstract public LibraryDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LibraryDao dao = getDao();

		// Create library
		Library library = dao.createLibrary("Dummy");
		assertNotNull(library.getUuid());
		assertEquals("Dummy", library.getName());
	}

	@Test
	public void testDelete() {
		LibraryDao dao = getDao();

		// Create library
		Library library = dao.createLibrary("Dummy");
		assertNotNull(library);

		// Now assert deletion
		dao.deleteLibrary(library);
		assertNull(dao.loadLibrary(library.getUuid()), "The library should be deleted.");
	}

	@Test
	public void testUpdate() {
		LibraryDao dao = getDao();

		// Create and store
		Library library = dao.createLibrary("Dummy");

		// Now update
		library.setName("Dummy2");
		dao.updateLibrary(library);

		// Load and assert update was persisted
		Library updatedLibrary = dao.loadLibrary(library.getUuid());
		assertEquals("Dummy2", updatedLibrary.getName());

	}

	@Test
	public void testLoad() {
		LibraryDao dao = getDao();

		// Create and store library
		Library library = dao.createLibrary("Dummy");

		// Now load again
		assertNotNull(dao.loadLibrary(library.getUuid()));
	}
}
