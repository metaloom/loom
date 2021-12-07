package io.metaloom.loom.db.hib.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.reactive.provider.ReactivePersistenceProvider;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import io.metaloom.loom.db.model.asset.impl.AssetBinaryImpl;
import io.metaloom.loom.db.model.asset.impl.AssetImpl;
import io.metaloom.loom.db.model.content.impl.ContentImpl;
import io.metaloom.loom.db.model.content.impl.FieldImpl;
import io.metaloom.loom.db.model.extension.impl.ExtensionImpl;
import io.metaloom.loom.db.model.group.impl.GroupImpl;
import io.metaloom.loom.db.model.model.impl.ModelImpl;
import io.metaloom.loom.db.model.namespace.impl.NamespaceImpl;
import io.metaloom.loom.db.model.role.impl.RoleImpl;
import io.metaloom.loom.db.model.tag.impl.TagImpl;
import io.metaloom.loom.db.model.user.impl.LoomUserImpl;
import io.metaloom.loom.db.model.webhook.impl.WebhookImpl;

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
		// settings.put(Environment.HBM2DDL_AUTO, "drop-and-create");
		// settings.put(Environment.HBM2DDL_DATABASE_ACTION, "drop-and-create");
		// settings.put(Environment.HBM2DDL_DATABASE_ACTION, "validate");

		// Model
		configuration.setProperties(settings);
		configuration.addAnnotatedClass(LoomUserImpl.class);
		configuration.addAnnotatedClass(GroupImpl.class);
		configuration.addAnnotatedClass(RoleImpl.class);

		configuration.addAnnotatedClass(TagImpl.class);
		configuration.addAnnotatedClass(AssetImpl.class);
		configuration.addAnnotatedClass(AssetBinaryImpl.class);
		configuration.addAnnotatedClass(ModelImpl.class);
		configuration.addAnnotatedClass(ExtensionImpl.class);
		configuration.addAnnotatedClass(WebhookImpl.class);

		configuration.addAnnotatedClass(ContentImpl.class);
		configuration.addAnnotatedClass(FieldImpl.class);
		configuration.addAnnotatedClass(NamespaceImpl.class);

		ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
