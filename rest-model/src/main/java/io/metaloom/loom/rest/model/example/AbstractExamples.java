package io.metaloom.loom.rest.model.example;

import java.util.UUID;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.common.PagingInfo;
import io.metaloom.loom.rest.model.content.ContentReference;
import io.metaloom.loom.rest.model.model.ModelReference;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.metaloom.loom.rest.model.user.UserReference;
import io.metaloom.loom.uuid.UUIDUtil;

public class AbstractExamples {

	public static final String DATE_OLD = "2018-10-12T14:15:06.024Z";

	public static final String DATE_NEW = "2018-11-20T20:12:01.084Z";

	public static UUID uuidA() {
		return UUIDUtil.fromString("f04e89d0-076d-4d90-b192-715a25a2cd59");
	}

	public static UUID uuidB() {
		return UUIDUtil.fromString("86abc160-4da2-4951-a91f-da0c33fbc634");
	}

	public static UUID uuidC() {
		return UUIDUtil.fromString("0f3332a6-e404-4777-88a9-1fa984a311bc");
	}

	public static UserReference userReferenceA() {
		UserReference reference = new UserReference();
		reference.setUuid(uuidA());
		reference.setName("joedoe");
		return reference;
	}

	public static PagingInfo pagingInfo() {
		PagingInfo info = new PagingInfo();
		info.setCurrentPage(0);
		info.setPageCount(14);
		info.setTotalCount(28);
		info.setPerPage(2L);
		return info;
	}

	public static void setCreatorEditor(AbstractCreatorEditorRestResponse model) {
		model.setCreator(userReferenceA());
		model.setCreated(DATE_OLD);
		model.setEditor(userReferenceA());
		model.setEdited(DATE_NEW);
	}

	public static ModelReference modelReference(String name) {
		ModelReference reference = new ModelReference();
		reference.setUuid(uuidB());
		reference.setName(name);
		return reference;
	}

	public static ContentReference parentContentReference() {
		ContentReference reference = new ContentReference();
		reference.setName("posts");
		reference.setUuid(uuidC());
		return reference;
	}

	public static TagReference tagReferenceA() {
		TagReference model = new TagReference();
		model.setUuid(uuidA());
		model.setName("red");
		return model;
	}

	public static TagReference tagReferenceB() {
		TagReference model = new TagReference();
		model.setUuid(uuidB());
		model.setName("blue");
		return model;
	}

}
