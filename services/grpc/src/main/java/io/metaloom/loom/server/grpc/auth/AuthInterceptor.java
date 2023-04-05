package io.metaloom.loom.server.grpc.auth;

import javax.inject.Inject;

import com.google.common.base.Strings;

import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.metaloom.loom.api.auth.AuthenticationService;

public class AuthInterceptor implements ServerInterceptor {

	private AuthenticationService authService;

	@Inject
	public AuthInterceptor(AuthenticationService authService) {
		this.authService = authService;
	}

	@Override
	public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata metadata, ServerCallHandler<ReqT, RespT> next) {
		try {
			String token = metadata.get(AuthenticationConstants.AUTH_HEADER_KEY);
			if (!Strings.isNullOrEmpty(token)) {
				Context context = Context.current();
				authService.verify(token);
				context = context.withValue(AuthenticationConstants.CONTEXT_PRINCIPLE_KEY, token);
				return Contexts.interceptCall(context, call, metadata, next);
			} else {
				call.close(Status.UNAUTHENTICATED.withDescription("Auth Token Required"), metadata);
			}
			return next.startCall(call, metadata);
		} finally {
			call.close(Status.UNAUTHENTICATED.withDescription("Auth Token Required"), metadata);
		}
	}

}
