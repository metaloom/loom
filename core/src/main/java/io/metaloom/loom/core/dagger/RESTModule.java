package io.metaloom.loom.core.dagger;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

@Module
public class RESTModule {

	@Provides
	@Singleton
	@Named("restRouter")
	public Router restRouter(Vertx vertx) {
		return Router.router(vertx);
	}
}
