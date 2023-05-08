package io.metaloom.loom.rest.model.common;

public abstract class AbstractNamedReference extends AbstractResponse<AbstractNamedReference> {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
