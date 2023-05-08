package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.tag.TagListResponse;
import io.metaloom.loom.rest.model.tag.TagResponse;

public interface TagModelBuilder extends ModelBuilder, UserModelBuilder {

	default TagResponse toResponse(Tag tag, User creator, User editor) {
		TagResponse response = new TagResponse();
		response.setName(tag.getName());
		response.setCollection(tag.getCollection());
		setStatus(tag, creator, editor, response);
		return response;
	}

	default TagListResponse toTagList(Page<Tag> page) {
		TagListResponse response = new TagListResponse();
		for (Tag tag : page) {
			response.add(toResponse(tag, null, null));
		}
		return response;
	}

}
