package io.metaloom.loom.container.server;

import io.metaloom.loom.core.dagger.DaggerLoomComponent;
import io.metaloom.loom.core.dagger.LoomComponent;

public class ServerRunner {

	public static void main(String[] args) {
		LoomComponent loomComponent = DaggerLoomComponent.builder().build();
	}

}
