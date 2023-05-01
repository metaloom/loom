package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.Dao;

public interface BinaryDao extends Dao {

	Binary createBinary(String sha512sum, long size);

	void storeBinary(Binary binary);

	void updateBinary(Binary binary);

	void deleteBinary(Binary binary);

	long count();

	Binary loadBinaryBySHA512Sum(String sha512sum);

	Binary loadBinaryByUuid(UUID uuid);

}
