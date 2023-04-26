package io.metaloom.loom.rest.model.asset.social;

public class SocialInfo {

	private Rating rating;

	private Reactions reactions;

	public Rating getRating() {
		return rating;
	}

	public SocialInfo setRating(Rating rating) {
		this.rating = rating;
		return this;
	}

	public Reactions getReactions() {
		return reactions;
	}

	public SocialInfo setReactions(Reactions reactions) {
		this.reactions = reactions;
		return this;
	}
}
