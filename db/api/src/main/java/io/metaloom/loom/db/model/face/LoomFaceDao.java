package io.metaloom.loom.db.model.face;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface LoomFaceDao extends LoomDao {

	LoomFace createFace(String source, float[] embeddings, FaceOrigin origin);

	void deleteFace(UUID uuid);

}
