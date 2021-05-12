package io.metaloom.loom.container.server;

import io.metaloom.loom.core.dagger.DaggerLoomCoreComponent;
import io.metaloom.loom.core.dagger.LoomCoreComponent;

public class ServerRunner {

	public static void main(String[] args) {
		LoomCoreComponent loomComponent = DaggerLoomCoreComponent.builder().build();
	}

}
