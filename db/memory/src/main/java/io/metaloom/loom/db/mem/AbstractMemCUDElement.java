package io.metaloom.loom.db.mem;

import java.time.OffsetDateTime;
import java.util.UUID;

import io.metaloom.loom.db.CUDElement;

public abstract class AbstractMemCUDElement<SELF extends CUDElement<SELF>> extends AbstractMemLoomElement<SELF> implements CUDElement<SELF> {

	private OffsetDateTime cdate;
	private OffsetDateTime edate;
	private UUID editorUuid;
	private UUID creatorUuid;

	@Override
	public UUID getEditorUuid() {
		return editorUuid;
	}

	@Override
	public SELF setEditorUuid(UUID editorUuid) {
		this.editorUuid = editorUuid;
		return self();
	}

	@Override
	public OffsetDateTime getEdited() {
		return edate;
	}

	@Override
	public SELF setEdited(OffsetDateTime edate) {
		this.edate = edate;
		return self();
	}

	@Override
	public UUID getCreatorUuid() {
		return creatorUuid;
	}

	@Override
	public SELF setCreatorUuid(UUID creatorUuid) {
		this.creatorUuid = creatorUuid;
		return self();
	}

	@Override
	public OffsetDateTime getCreated() {
		return cdate;
	}

	@Override
	public SELF setCreated(OffsetDateTime cdate) {
		this.cdate = cdate;
		return self();
	}

}
