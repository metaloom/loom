package io.metaloom.loom.rest.model.annotation;

import java.util.UUID;

import io.metaloom.loom.rest.model.asset.social.SocialInfo;

public class Comment {

	private UUID uuid;
	private String title;
	private String text;

	private SocialInfo social;

	public UUID getUuid() {
		return uuid;
	}

	public Comment setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Comment setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getText() {
		return text;
	}

	public Comment setText(String text) {
		this.text = text;
		return this;
	}

	public SocialInfo getSocial() {
		return social;
	}

	public Comment setSocial(SocialInfo social) {
		this.social = social;
		return this;
	}

}
