package io.metaloom.loom.rest.model.embedding;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.rest.model.annotation.AreaInfo;

public interface EmbeddingModel<T extends EmbeddingModel<T>> extends MetaModel<T>, RestModel {

	AreaInfo getArea();

	T setArea(AreaInfo area);

}
