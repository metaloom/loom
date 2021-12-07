package io.metaloom.loom.db.hib.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.reactive.provider.ReactivePersistenceProvider;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import io.metaloom.loom.db.group.impl.GroupImpl;
import io.metaloom.loom.db.model.namespace.impl.NamespaceImpl;
import io.metaloom.loom.db.model.role.impl.RoleImpl;
import io.metaloom.loom.db.model.user.impl.LoomUserImpl;

public final class HibernateUtil {

	private HibernateUtil() {

	}

	public static SessionFactory sessionFactory(String url, String user, String pass, boolean logEnabled, int poolSize) {
		Configuration configuration = new Configuration();
		Properties settings = new Properties();

		// DB
		settings.put(Environment.URL, url);
		settings.put(Environment.USER, user);
		settings.put(Environment.PASS, pass);
		settings.put(Environment.POOL_SIZE, poolSize);

		// Logging
		if (logEnabled) {
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.FORMAT_SQL, "true");
		}
		settings.put(Environment.HIGHLIGHT_SQL, "false");

		// Control
		// settings.put(Environment.DRIVER, PgDriver.class.getName());
		// settings.put(Environment.DIALECT, "");
		settings.put(Environment.JPA_PERSISTENCE_PROVIDER, ReactivePersistenceProvider.class.getName());
		// settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		settings.put(Environment.HBM2DDL_AUTO, "validate");
		//settings.put(Environment.HBM2DDL_DATABASE_ACTION, "drop-and-create");
		//settings.put(Environment.HBM2DDL_DATABASE_ACTION, "validate");

		// Model
		configuration.setProperties(settings);
		configuration.addAnnotatedClass(LoomUserImpl.class);
		configuration.addAnnotatedClass(GroupImpl.class);
		configuration.addAnnotatedClass(RoleImpl.class);
		configuration.addAnnotatedClass(NamespaceImpl.class);

		ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
