package io.metaloom.loom.db.fs;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.user.LoomUser;

public abstract class AbstractFSCUDElement extends AbstractFSLoomElement implements CUDElement {

	private UUID creatorUuid;
	private LocalDateTime cdate;

	private UUID editorUuid;
	private LocalDateTime edate;


//	@JsonIgnore
//	@Override
//	public User getEditor() {
//		return daos.getUserDao().loadUser(editorUuid).blockingGet();
//	}
//
	@Override
	public void setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "A valid user must be specified");
		this.editorUuid = editor.getUuid();
	}

	public UUID getEditorUuid() {
		return editorUuid;
	}

	public void setEditorUuid(UUID editorUuid) {
		this.editorUuid = editorUuid;
	}

	@Override
	public LocalDateTime getEdate() {
		return edate;
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		this.edate = edate;
	}

//	@JsonIgnore
//	@Override
//	public User getCreator() {
//		return daos.getUserDao().loadUser(creatorUuid).blockingGet();
//	}
//
	@Override
	public void setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "A valid user must be specified");
		this.creatorUuid = creator.getUuid();
	}

	public UUID getCreatorUuid() {
		return creatorUuid;
	}

	public void setCreatorUuid(UUID creatorUuid) {
		this.creatorUuid = creatorUuid;
	}

	@Override
	public LocalDateTime getCdate() {
		return cdate;
	}

	@Override
	public void setCdate(LocalDateTime cdate) {
		this.cdate = cdate;
	}

}
