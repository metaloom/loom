package io.metaloom.loom.rest.model.attachment;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class AttachmentResponse extends AbstractCreatorEditorRestResponse<AttachmentResponse>
	implements AttachmentModel<AttachmentResponse> {

	private String sha512sum;

	private String filename;

	private String mimeType;

	private long size;

	public String getSha512sum() {
		return sha512sum;
	}

	public AttachmentResponse setSha512sum(String sha512sum) {
		this.sha512sum = sha512sum;
		return this;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	@Override
	public AttachmentResponse setFilename(String filename) {
		this.filename = filename;
		return this;
	}

	@Override
	public String getMimeType() {
		return mimeType;
	}

	@Override
	public AttachmentResponse setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	public long getSize() {
		return size;
	}

	public AttachmentResponse setSize(long size) {
		this.size = size;
		return this;
	}

	@Override
	public AttachmentResponse self() {
		return this;
	}
}
