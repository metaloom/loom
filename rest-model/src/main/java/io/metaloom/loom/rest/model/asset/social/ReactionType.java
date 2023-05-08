package io.metaloom.loom.rest.model.asset.social;

public enum ReactionType {

	// TODO lookup better source or convert https://gist.github.com/rxaviers/7360908

	SATISFIED("🤣", ":satisfied:"),

	THUMBSDOWN("👎", ":thumbsdown:"),

	THUMBSUP("👍", ":thumbsup:");

	private String id;
	private String icon;

	ReactionType(String icon, String id) {
		this.icon = icon;
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public String getId() {
		return id;
	}

}
