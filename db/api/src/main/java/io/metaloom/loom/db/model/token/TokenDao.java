package io.metaloom.loom.db.model.token;

import io.metaloom.loom.db.CRUDDao;

public interface TokenDao extends CRUDDao<Token> {

	Token createToken(String name, String tokenValue);

}
