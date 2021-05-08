package io.metaloom.loom.db.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.vertx.core.Vertx;

@Module
public class VertxModule {

	@Provides
	@Singleton
	public Vertx vertx() {
		return Vertx.vertx();
	}

	@Provides
	@Singleton
	public io.vertx.reactivex.core.Vertx rxVertx(Vertx vertx) {
		return new io.vertx.reactivex.core.Vertx(vertx);
	}

}
