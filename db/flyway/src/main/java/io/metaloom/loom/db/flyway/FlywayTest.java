package io.metaloom.loom.db.flyway;

import org.flywaydb.core.Flyway;

public class FlywayTest {

	public static void main(String[] args) {
		int port = 5432;
		String url = "jdbc:postgresql://127.0.0.1:" + port + "/loom";
		String user = "postgres";
		String password = "finger";
		Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
		flyway.migrate();

	}
}
