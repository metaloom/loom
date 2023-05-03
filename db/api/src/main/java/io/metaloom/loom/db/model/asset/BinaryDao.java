package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.user.User;

public interface BinaryDao extends CRUDDao<Binary> {

	default Binary createBinary(User user, String sha512sum, String mimeType, String initialOrigin, long size) {
		return createBinary(user.getUuid(), sha512sum, mimeType, initialOrigin, size);
	}

	Binary createBinary(UUID userUuid, String sha512sum, String mimeType, String initialOrigin, long size);

	Binary loadBySHA512Sum(String sha512sum);

	Binary loadByUuid(UUID uuid);

}
