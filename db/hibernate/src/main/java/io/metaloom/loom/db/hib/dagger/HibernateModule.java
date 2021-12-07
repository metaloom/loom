package io.metaloom.loom.db.hib.dagger;

import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.hib.util.HibernateUtil;
import io.metaloom.loom.options.DatabaseOptions;
import io.vertx.rxjava3.core.Vertx;

@Module
public class HibernateModule {

	@Provides
	@Singleton
	public Mutiny.SessionFactory sessionFactory(Vertx rxVertx, DatabaseOptions options) {
		boolean logging = true;
//		System.setProperty(PropertyKey.PRINT_BANNER.getKey(), "false");

		int poolSize = options.getPoolSize();
		String jdbcUrl = options.getJdbcUrl();
		String user = options.getUsername();
		String pass = options.getPassword();
		Mutiny.SessionFactory emf = HibernateUtil.sessionFactory(jdbcUrl, user, pass, logging, poolSize)
			.unwrap(Mutiny.SessionFactory.class);

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Closing factory");
			if (emf != null && emf.isOpen()) {
				emf.close();
			}
		}));

		return emf;
	}
}
