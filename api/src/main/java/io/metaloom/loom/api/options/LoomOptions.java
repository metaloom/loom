package io.metaloom.loom.api.options;

public class LoomOptions implements Option {

	private DatabaseOptions database = new DatabaseOptions();
	
	private ServerOptions server = new ServerOptions();

	public DatabaseOptions getDatabase() {
		return database;
	}

	public LoomOptions setDatabase(DatabaseOptions database) {
		this.database = database;
		return this;
	}
	
	public ServerOptions getServer() {
		return server;
	}
	public LoomOptions setServer(ServerOptions server) {
		this.server = server;
		return this;
	}

	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
