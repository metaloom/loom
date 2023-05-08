package io.metaloom.loom.rest.model.group;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface GroupExamples extends ExampleValues {

	default GroupResponse groupResponse() {
		GroupResponse model = new GroupResponse();
		model.setUuid(uuidC());
		model.setName("Guests");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

	default GroupReference groupReference() {
		GroupReference model = new GroupReference();
		model.setUuid(uuidA());
		model.setName("Guests");
		return model;
	}

	default GroupUpdateRequest groupUpdateRequest() {
		GroupUpdateRequest model = new GroupUpdateRequest();
		model.setName("NewGuests");
		model.setMeta(meta());
		return model;
	}

	default GroupCreateRequest groupCreateRequest() {
		GroupCreateRequest model = new GroupCreateRequest();
		model.setName("Guests");
		model.setMeta(meta());
		return model;
	}

	default GroupListResponse groupListResponse() {
		GroupListResponse model = new GroupListResponse();
		model.setMetainfo(pagingInfo());
		model.add(groupResponse());
		model.add(groupResponse());
		return model;
	}
}
