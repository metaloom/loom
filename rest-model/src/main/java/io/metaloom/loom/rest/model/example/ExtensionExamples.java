package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.extension.ExtensionCreateRequest;
import io.metaloom.loom.rest.model.extension.ExtensionKind;
import io.metaloom.loom.rest.model.extension.ExtensionListResponse;
import io.metaloom.loom.rest.model.extension.ExtensionResponse;
import io.metaloom.loom.rest.model.extension.ExtensionUpdateRequest;

public class ExtensionExamples extends AbstractExamples {

	public static ExtensionResponse extensionResponse() {
		ExtensionResponse model = new ExtensionResponse();
		model.setUuid(uuidC());
		model.setURL("http://localhost:8086/asset");
		model.setKind(ExtensionKind.ASSET_PROCESSOR);
		setCreatorEditor(model);
		return model;
	}

	public static ExtensionUpdateRequest extensionUpdateRequest() {
		ExtensionUpdateRequest model = new ExtensionUpdateRequest();
		model.setURL("http://localhost:8088/asset");
		model.setKind(ExtensionKind.ASSET_PROCESSOR);
		return model;
	}

	public static ExtensionCreateRequest extensionCreateRequest() {
		ExtensionCreateRequest model = new ExtensionCreateRequest();
		model.setURL("http://localhost:8088/asset");
		model.setKind(ExtensionKind.ASSET_PROCESSOR);
		return model;
	}

	public static ExtensionListResponse extensionListResponse() {
		ExtensionListResponse model = new ExtensionListResponse();
		model.setMetainfo(pagingInfo());
		model.add(extensionResponse());
		model.add(extensionResponse());
		return model;
	}
}
