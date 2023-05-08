package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.tag.TagListResponse;
import io.metaloom.loom.rest.model.tag.TagResponse;

public interface TagModelBuilder extends ModelBuilder, UserModelBuilder {

	default TagResponse toResponse(Tag tag) {
		TagResponse response = new TagResponse();
		response.setUuid(tag.getUuid());
		response.setName(tag.getName());
		response.setCollection(tag.getCollection());
		setStatus(tag, response);
		return response;
	}

	default TagListResponse toTagList(Page<Tag> page) {
		return setPage(new TagListResponse(), page, tag -> {
			return toResponse(tag);
		});
	}

}
