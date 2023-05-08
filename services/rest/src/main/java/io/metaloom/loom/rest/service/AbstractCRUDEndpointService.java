package io.metaloom.loom.rest.service;

import java.util.UUID;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.Element;
import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.perm.Permission;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.RestResponseModel;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;

public abstract class AbstractCRUDEndpointService<D extends CRUDDao<E>, E extends Element<E>> extends AbstractEndpointService {

	private static final Logger log = LoggerFactory.getLogger(AbstractCRUDEndpointService.class);

	private final D crudDao;

	private final DaoCollection daos;

	public AbstractCRUDEndpointService(D crudDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.crudDao = crudDao;
		this.daos = daos;
	}

	public D dao() {
		return crudDao;
	}

	public void delete(LoomRoutingContext lrc) {
		String uuidStr = lrc.pathParam("uuid");
		UUID uuid = UUID.fromString(uuidStr);
		E element = dao().load(uuid);
		if (element == null) {
			lrc.send(new GenericMessageResponse(), 404);
			return;
		} else {
			dao().delete(element);
			lrc.send();
		}
	}

	public void list(LoomRoutingContext lrc, Permission permission, Function<D, Page<E>> loader, Function<Page<E>, RestResponseModel<?>> builder) {
		lrc.requirePerm(permission).onSuccess(l -> {
			Page<E> page = loader.apply(dao());
			RestResponseModel<?> response = builder.apply(page);
			lrc.send(response);
		}).onFailure(e -> {
			// TODO this should be 500 error
			log.error("Failed to check perms", e);
			lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
		});
	}

	public void load(LoomRoutingContext lrc, Permission permission, Function<D, E> loader, Function<E, RestResponseModel<?>> builder) {
		lrc.requirePerm(permission).onSuccess(l -> {
			E element = loader.apply(dao());
			if (element == null) {
				lrc.send(modelBuilder.elementNotFound(), 404);
				return;
			}
			RestResponseModel<?> response = builder.apply(element);
			lrc.send(response);
		}).onFailure(e -> {
			// TODO this should be 500 error
			log.error("Failed to check perms", e);
			lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
		});
	}

	public void create(LoomRoutingContext lrc, Permission permission, Function<DaoCollection, E> creator,
		Function<E, RestResponseModel<?>> builder) {
		lrc.requirePerm(permission).onSuccess(l -> {
			E element = creator.apply(daos);
			dao().store(element);
			RestResponseModel<?> response = builder.apply(element);
			lrc.send(response, 201);
		}).onFailure(e -> {
			// TODO this should be 500 error
			log.error("Failed to check perms", e);
			lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
		});

	}

}
