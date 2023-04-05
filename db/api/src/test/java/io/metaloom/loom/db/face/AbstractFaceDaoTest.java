package io.metaloom.loom.db.face;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.face.FaceOrigin;
import io.metaloom.loom.db.model.face.LoomFace;
import io.metaloom.loom.db.model.face.LoomFaceDao;

public abstract class AbstractFaceDaoTest {

	abstract public LoomFaceDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}
	
	@Test
	public void testCreate() {
		LoomFaceDao dao = getDao();

		float[] embedding = new float[] {0,0,0};
		FaceOrigin origin = null;
		LoomFace face = dao.createFace("source", embedding, origin );
		assertNotNull(face.getUuid());
		assertEquals(42L, face.getFaceNr().longValue());
	}
}
