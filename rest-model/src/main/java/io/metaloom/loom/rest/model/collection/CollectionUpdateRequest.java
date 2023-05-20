package io.metaloom.loom.rest.model.collection;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class CollectionUpdateRequest extends AbstractMetaModel<CollectionUpdateRequest> implements RestRequestModel {

	@Override
	public CollectionUpdateRequest self() {
		return this;
	}

}
