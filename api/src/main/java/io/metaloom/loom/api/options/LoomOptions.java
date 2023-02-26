package io.metaloom.loom.api.options;

public class LoomOptions implements Option {

	private DatabaseOptions database = new DatabaseOptions();

	public DatabaseOptions getDatabase() {
		return database;
	}

	public LoomOptions setDatabase(DatabaseOptions database) {
		this.database = database;
		return this;
	}

}
