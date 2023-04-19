package io.metaloom.loom.rest.model.common;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestResponseModel;

/**
 * Abstract model for list REST responses.
 *
 * @param <T>
 */
public class ListResponse<T> implements RestResponseModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Array which contains the found elements.")
	private List<T> data;

	@JsonPropertyDescription("Paging information of the list result.")
	@JsonProperty(value = "_metainfo", required = true)
	private PagingInfo metainfo;

	public ListResponse() {
	}

	/**
	 * Return the meta info for the list.
	 * 
	 * @return Meta info
	 */
	public PagingInfo getMetainfo() {
		return metainfo;
	}

	/**
	 * Set the meta info for the list.
	 * 
	 * @param metainfo Meta info
	 */
	public void setMetainfo(PagingInfo metainfo) {
		this.metainfo = metainfo;
	}

	/**
	 * Return the list data.
	 * 
	 * @return List data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * Add the given element to the list.
	 * 
	 * @param e
	 */
	public void add(T e) {
		if (data == null) {
			data = new ArrayList<>();
		}
		data.add(e);
	}
}
