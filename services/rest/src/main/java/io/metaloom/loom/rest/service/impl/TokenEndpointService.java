package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.token.TokenDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class TokenEndpointService extends AbstractEndpointService {

	private final TokenDao tokenDao;

	@Inject
	public TokenEndpointService(TokenDao tokenDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.tokenDao = tokenDao;
	}

}
