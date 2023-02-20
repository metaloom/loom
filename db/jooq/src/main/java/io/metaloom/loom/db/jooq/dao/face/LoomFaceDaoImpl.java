package io.metaloom.loom.db.jooq.dao.face;

import java.util.UUID;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.FaceDao;
import io.metaloom.loom.db.jooq.tables.pojos.Face;
import io.metaloom.loom.db.model.face.FaceOrigin;
import io.metaloom.loom.db.model.face.LoomFace;
import io.metaloom.loom.db.model.face.LoomFaceDao;

public class LoomFaceDaoImpl extends AbstractDao implements LoomFaceDao {

	private final FaceDao dao;

	public LoomFaceDaoImpl(FaceDao dao, DSLContext ctx) {
		super(ctx);
		this.dao = dao;
	}

	@Override
	public void clear() {
		context().truncate(io.metaloom.loom.db.jooq.tables.Face.FACE).cascade().execute();
	}

	@Override
	public LoomFace createFace(String source, float[] embeddings, FaceOrigin origin) {
		Face face = new Face();
		face.setFaceNr(origin.faceNr());
		dao.insert(face);
		return new LoomFaceImpl(face);
	}

	@Override
	public void deleteFace(UUID uuid) {
		dao.deleteById(uuid);
	}

}
