package io.metaloom.loom.server.grpc.auth;

import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;

public class AuthenticationConstants {

	public static final Key<String> AUTH_HEADER_KEY = Key.of("auth", Metadata.ASCII_STRING_MARSHALLER);
	public static final Context.Key<String> CONTEXT_PRINCIPLE_KEY = Context.key("user");

}
