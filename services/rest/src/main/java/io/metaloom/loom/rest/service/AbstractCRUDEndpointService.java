package io.metaloom.loom.rest.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.Element;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;

public abstract class AbstractCRUDEndpointService<D extends CRUDDao<E>, E extends Element<E>> extends AbstractEndpointService {

	private static final Logger log = LoggerFactory.getLogger(AbstractCRUDEndpointService.class);

	private D crudDao;

	public AbstractCRUDEndpointService(D crudDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.crudDao = crudDao;
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

}
