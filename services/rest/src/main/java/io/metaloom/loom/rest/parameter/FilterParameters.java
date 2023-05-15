package io.metaloom.loom.rest.parameter;

import io.metaloom.filter.Filter;
import io.metaloom.loom.rest.LoomRoutingContext;

public class FilterParameters extends AbstractQueryParameters {

	public FilterParameters(LoomRoutingContext lrc) {
		super(lrc);
	}

	public static FilterParameters create(LoomRoutingContext lrc) {
		return new FilterParameters(lrc);
	}

	public Filter filter() {
		return mapParameter(QueryParameterKey.FILTER);
	}

}
