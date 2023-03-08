package io.metaloom.loom.api.options;

public class ServerOptions implements Option {

	public static final int DEFAULT_GRPC_PORT = 8091;

	public static final String DEFAULT_BIND_ADDRESS = "0.0.0.0";

	private int grpcPort = DEFAULT_GRPC_PORT;

	private String bindAddress = DEFAULT_BIND_ADDRESS;

	public int getGrpcPort() {
		return grpcPort;
	}

	public ServerOptions setGrpcPort(int grpcPort) {
		this.grpcPort = grpcPort;
		return this;
	}

	public String getBindAddress() {
		return bindAddress;
	}

	public ServerOptions setBindAddress(String bindAddress) {
		this.bindAddress = bindAddress;
		return this;
	}

}
