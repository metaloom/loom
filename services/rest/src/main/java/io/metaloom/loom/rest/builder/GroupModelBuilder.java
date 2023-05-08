package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.group.GroupListResponse;
import io.metaloom.loom.rest.model.group.GroupResponse;

public interface GroupModelBuilder extends ModelBuilder, UserModelBuilder {

	default GroupResponse toResponse(Group group, User creator, User editor) {
		GroupResponse response = new GroupResponse();
		response.setName(group.getName());
		response.setMeta(group.getMeta());
		setStatus(group, creator, editor, response);
		return response;
	}

	default GroupListResponse toGroupList(Page<Group> page) {
		GroupListResponse response = new GroupListResponse();
		for(Group group : page) {
			response.add(toResponse(group, null, null));
		}
		return response;
	}
	
}
