package io.metaloom.loom.db.model.face;

import java.util.UUID;

import io.metaloom.loom.db.Dao;

public interface FaceDao extends Dao {

	Face createFace(String source, float[] embeddings, FaceOrigin origin);

	void deleteFace(UUID uuid);

}
