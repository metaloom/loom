package io.metaloom.loom.rest.builder;

import io.metaloom.loom.rest.model.message.GenericMessageResponse;

public interface LoomModelBuilder extends
	AssetModelBuilder,
	AnnotationModelBuilder,
	BinaryModelBuilder,
	CollectionModelBuilder,
	CommentModelBuilder,
	EmbeddingModelBuilder,
	UserModelBuilder,
	GroupModelBuilder,
	RoleModelBuilder,
	TagModelBuilder,
	TaskModelBuilder,
	TokenModelBuilder,
	LibraryModelBuilder,
	ProjectModelBuilder,
	ReactionModelBuilder,
	WebhookModelBuilder {

	default GenericMessageResponse elementNotFound() {
		return new GenericMessageResponse();
	}

}
