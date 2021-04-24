package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.group.GroupCreateRequest;
import io.metaloom.loom.rest.model.group.GroupListResponse;
import io.metaloom.loom.rest.model.group.GroupReference;
import io.metaloom.loom.rest.model.group.GroupResponse;
import io.metaloom.loom.rest.model.group.GroupUpdateRequest;

public class GroupExamples extends AbstractExamples {

	public static GroupResponse groupResponse() {
		GroupResponse model = new GroupResponse();
		model.setUuid(uuidC());
		model.setName("Guests");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

	public static GroupReference groupReference() {
		GroupReference model = new GroupReference();
		model.setUuid(uuidA());
		model.setName("Guests");
		return model;
	}

	public static GroupUpdateRequest groupUpdateRequest() {
		GroupUpdateRequest model = new GroupUpdateRequest();
		model.setName("NewGuests");
		model.setMeta(meta());
		return model;
	}

	public static GroupCreateRequest groupCreateRequest() {
		GroupCreateRequest model = new GroupCreateRequest();
		model.setName("Guests");
		model.setMeta(meta());
		return model;
	}

	public static GroupListResponse groupListResponse() {
		GroupListResponse model = new GroupListResponse();
		model.setMetainfo(pagingInfo());
		model.add(groupResponse());
		model.add(groupResponse());
		return model;
	}
}
