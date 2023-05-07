package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.common.CreatorEditorStatus;
import io.metaloom.loom.rest.model.user.UserReference;
import io.metaloom.loom.rest.model.user.UserResponse;

public interface UserBuilder extends Builder {

	default UserResponse toResponse(User user) {
		UserResponse response = new UserResponse();
		response.setUsername(user.getUsername());
		response.setUuid(user.getUuid());
		return response;
	}

	default UserReference toReference(User user) {
		UserReference ref = new UserReference();
		ref.setUuid(user.getUuid());
		ref.setName(user.getUsername());
		return ref;
	}

	default void setStatus(CUDElement<?> element, User creator, User editor, AbstractCreatorEditorRestResponse response) {
		CreatorEditorStatus status = response.getStatus();
		status.setCreated(element.getCreated());
		status.setEdited(element.getEdited());
		status.setCreator(toReference(creator));
		status.setEditor(toReference(editor));
	}

}
