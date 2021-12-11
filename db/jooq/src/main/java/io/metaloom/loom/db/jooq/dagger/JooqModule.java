package io.metaloom.loom.db.jooq.dagger;

import java.beans.PropertyVetoException;

import javax.inject.Singleton;
import javax.sql.DataSource;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.options.DatabaseOptions;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

@Module
public class JooqModule {

	@Provides
	@Singleton
	public DataSource dataSource(DatabaseOptions options) {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass(org.postgresql.Driver.class.getName());
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpds.setJdbcUrl(options.getJdbcUrl());
		cpds.setUser(options.getUsername());
		cpds.setPassword(options.getPassword());
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		return cpds;
	}

	@Provides
	@Singleton
	public DSLContext context(DataSource ds) {
		return DSL.using(ds, SQLDialect.POSTGRES);
	}

	@Provides
	@Singleton
	public Configuration configuration(DSLContext context) {
		return context.configuration();
	}

	@Provides
	@Singleton
	public ConnectionFactory r2dbcConnectionFactory(DatabaseOptions options) {
		ConnectionFactory connectionFactory = ConnectionFactories.get(
			ConnectionFactoryOptions
				.parse("r2dbc:postgresql://" + options.getHost() + ":" + options.getPort() + "/" + options.getDatabaseName())
				.mutate()
				.option(ConnectionFactoryOptions.USER, options.getUsername())
				.option(ConnectionFactoryOptions.PASSWORD, options.getPassword())
				.build());
		return connectionFactory;
	}
}
