package io.metaloom.loom.rest.model.example;

import io.netty.handler.codec.http.HttpResponseStatus;

public interface Example {

	Object body();

	String description();

	HttpResponseStatus code();

}
