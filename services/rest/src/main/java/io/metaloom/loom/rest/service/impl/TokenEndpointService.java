package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_TOKEN;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_TOKEN;
import static io.metaloom.loom.db.model.perm.Permission.READ_TOKEN;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_TOKEN;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.token.Token;
import io.metaloom.loom.db.model.token.TokenDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class TokenEndpointService extends AbstractCRUDEndpointService<TokenDao, Token> {

	@Inject
	public TokenEndpointService(TokenDao tokenDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(tokenDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_TOKEN, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_TOKEN, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toTokenList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_TOKEN, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_TOKEN, () -> {
			String name = null;
			String collection = null;
			UUID userUuid = lrc.userUuid();
			return dao().createToken(userUuid, name, collection);
		}, modelBuilder::toResponseWithToken);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_TOKEN, () -> {
			Token token = dao().load(id);
			// TOOD update
			return dao().update(token);
		}, modelBuilder::toResponse);
	}

}
