package io.metaloom.loom.rest.service;

import java.util.function.Function;
import java.util.function.Supplier;

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

/**
 * 
 * @param <D>
 *            DAO Type
 * @param <E>
 *            DTO / POJO Type
 * @param <PT>
 *            Type of the path id element
 */
public abstract class AbstractCRUDEndpointService<D extends CRUDDao<E, PT>, E extends Element<E>, PT> extends AbstractEndpointService {

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

	public DaoCollection daos() {
		return daos;
	}

	public abstract void delete(LoomRoutingContext lrc, PT id);

	protected void delete(LoomRoutingContext lrc, Permission permission, PT id) {
		lrc.requirePerm(permission).onSuccess(l -> {
			E element = dao().load(id);
			if (element == null) {
				lrc.send(new GenericMessageResponse(), 404);
				return;
			} else {
				dao().delete(element);
				lrc.send();
			}
		}).onFailure(e -> {
			// TODO this should be 500 error
			log.error("Failed to check perms", e);
			lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
		});
	}

	public abstract void list(LoomRoutingContext lrc);

	protected void list(LoomRoutingContext lrc, Permission permission, Supplier<Page<E>> loader, Function<Page<E>, RestResponseModel<?>> builder) {
		lrc.requirePerm(permission).onSuccess(l -> {
			Page<E> page = loader.get();
			RestResponseModel<?> response = builder.apply(page);
			lrc.send(response);
		}).onFailure(e -> {
			// TODO this should be 500 error
			log.error("Failed to check perms", e);
			lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
		});
	}

	public abstract void load(LoomRoutingContext lrc, PT id);

	protected void load(LoomRoutingContext lrc, Permission permission, Supplier<E> loader, Function<E, RestResponseModel<?>> builder) {
		lrc.requirePerm(permission).onSuccess(l -> {
			E element = loader.get();
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

	public abstract void create(LoomRoutingContext lrc);

	protected void create(LoomRoutingContext lrc, Permission permission, Supplier<E> creator,
		Function<E, RestResponseModel<?>> builder) {
		lrc.requirePerm(permission).onSuccess(l -> {
			E element = creator.get();
			dao().store(element);
			RestResponseModel<?> response = builder.apply(element);
			lrc.send(response, 201);
		}).onFailure(e -> {
			// TODO this should be 500 error
			log.error("Failed to check perms", e);
			lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
		});

	}

	public abstract void update(LoomRoutingContext lrc, PT id);

	protected void update(LoomRoutingContext lrc, Permission permission, Supplier<E> updator,
		Function<E, RestResponseModel<?>> builder) {
		lrc.requirePerm(permission).onSuccess(l -> {
			E element = updator.get();
			dao().update(element);
			RestResponseModel<?> response = builder.apply(element);
			lrc.send(response, 201);
		}).onFailure(e -> {
			// TODO this should be 500 error
			log.error("Failed to check perms", e);
			lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
		});

	}

}
