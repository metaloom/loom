package io.metaloom.loom.db.model.attachment;

import java.util.UUID;

import io.metaloom.loom.api.attachment.AttachmentType;
import io.metaloom.loom.db.CRUDDao;

public interface AttachmentDao extends CRUDDao<Attachment> {

	Attachment createAttachment(UUID userUuid, String sha512sum, String filename, long size, String mimeType, AttachmentType type);

}
