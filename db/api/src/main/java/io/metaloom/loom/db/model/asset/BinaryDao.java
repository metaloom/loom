package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;

public interface BinaryDao extends CRUDDao<Binary> {

	Binary createBinary(String sha512sum, long size);

	Binary loadBySHA512Sum(String sha512sum);

	Binary loadByUuid(UUID uuid);

}
