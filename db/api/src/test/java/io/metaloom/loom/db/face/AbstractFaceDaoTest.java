package io.metaloom.loom.db.face;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.metaloom.loom.db.model.face.FaceOrigin;
import io.metaloom.loom.db.model.face.LoomFace;
import io.metaloom.loom.db.model.face.LoomFaceDao;

public abstract class AbstractFaceDaoTest {

	abstract public LoomFaceDao getDao();

	@After
	@Before
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
