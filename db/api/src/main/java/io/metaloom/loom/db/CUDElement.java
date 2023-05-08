package io.metaloom.loom.db;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.model.user.User;

public interface CUDElement<SELF extends CUDElement<SELF>> extends Element<SELF>, MetaElement<SELF> {

	UUID getEditorUuid();

	default SELF setEditor(User editor) {
		Objects.requireNonNull(editor, "The editor is null");
		return setEditor(editor);
	}

	SELF setEditorUuid(UUID editorUuid);

	UUID getCreatorUuid();

	default SELF setCreator(User creator) {
		Objects.requireNonNull(creator, "The creator is null");
		return setCreator(creator);
	}

	SELF setCreatorUuid(UUID uuid);

	OffsetDateTime getEdited();

	SELF setEdited(OffsetDateTime edate);

	OffsetDateTime getCreated();

	SELF setCreated(OffsetDateTime cdate);
}
