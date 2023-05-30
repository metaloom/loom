package io.metaloom.loom.db.model.attachment;

import java.util.UUID;

import io.metaloom.loom.api.attachment.AttachmentType;
import io.metaloom.loom.db.CUDElement;

public interface Attachment extends CUDElement<Attachment> {

	String getFilename();

	Attachment setFilename(String filename);

	String getMimeType();

	Attachment setMimeType(String mimeType);

	long getSize();

	Attachment setSize(long size);

	String getSha512sum();

	Attachment setSha512sum(String sha512sum);

	UUID getEmbeddingUuid();

	Attachment setEmbeddingUuid(UUID uuid);

	UUID getAssetUuid();

	Attachment setAssetUuid(UUID assetUuid);

	AttachmentType getType();

	Attachment setType(AttachmentType type);

}
