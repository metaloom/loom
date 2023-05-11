package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.annotation.AnnotationExamples;
import io.metaloom.loom.rest.model.asset.AssetExamples;
import io.metaloom.loom.rest.model.asset.location.LocationExamples;
import io.metaloom.loom.rest.model.cluster.ClusterExamples;
import io.metaloom.loom.rest.model.comment.CommentExamples;
import io.metaloom.loom.rest.model.group.GroupExamples;
import io.metaloom.loom.rest.model.library.LibraryExamples;
import io.metaloom.loom.rest.model.project.ProjectExamples;
import io.metaloom.loom.rest.model.reaction.ReactionExamples;
import io.metaloom.loom.rest.model.role.RoleExamples;
import io.metaloom.loom.rest.model.tag.TagExamples;
import io.metaloom.loom.rest.model.task.TaskExamples;
import io.metaloom.loom.rest.model.token.TokenExamples;
import io.metaloom.loom.rest.model.user.UserExamples;
import io.metaloom.loom.rest.model.webhook.WebhookExamples;

public interface Examples extends
	AnnotationExamples,
	AssetExamples,
	LocationExamples,
	ClusterExamples,
	CommentExamples,
	TaskExamples,
	TagExamples,
	TokenExamples,
	RoleExamples,
	UserExamples,
	ReactionExamples,
	GroupExamples,
	ProjectExamples,
	LibraryExamples,
	WebhookExamples {
}
