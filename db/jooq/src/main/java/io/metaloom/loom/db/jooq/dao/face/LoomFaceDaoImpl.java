package io.metaloom.loom.db.jooq.dao.face;

import java.util.UUID;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqFaceDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqFace;
import io.metaloom.loom.db.model.face.FaceOrigin;
import io.metaloom.loom.db.model.face.LoomFace;
import io.metaloom.loom.db.model.face.LoomFaceDao;

public class LoomFaceDaoImpl extends AbstractJooqDao<JooqFaceDao> implements LoomFaceDao {

	public LoomFaceDaoImpl(JooqFaceDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public LoomFace createFace(String source, float[] embeddings, FaceOrigin origin) {
		JooqFace face = new JooqFace();
		face.setFaceNr(origin.faceNr());
		return new LoomFaceImpl(face);
	}

	@Override
	public void deleteFace(UUID uuid) {
		dao().deleteById(uuid);
	}

}
