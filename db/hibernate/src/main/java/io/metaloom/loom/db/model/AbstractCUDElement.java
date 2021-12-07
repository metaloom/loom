package io.metaloom.loom.db.model;

import static javax.persistence.FetchType.LAZY;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.impl.LoomUserImpl;

@MappedSuperclass
public abstract class AbstractCUDElement extends AbstractLoomElement implements CUDElement {

	@NotNull
	@ManyToOne(fetch = LAZY, targetEntity = LoomUserImpl.class)
	private LoomUser editor;

	@NotNull
	@ManyToOne(fetch = LAZY, targetEntity = LoomUserImpl.class)
	private LoomUser creator;

	@Past
	@NotNull
	@Column(name = "edited")
	@Basic(fetch = LAZY)
	private LocalDateTime edate;

	@Past
	@NotNull
	@Column(name = "created")
	@Basic(fetch = LAZY)
	private LocalDateTime cdate;

	@Override
	public LoomElement setEditor(LoomUser editor) {
		this.editor = editor;
		return this;
	}

	@Override
	public LoomElement setCreator(LoomUser creator) {
		this.creator = creator;
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return edate;
	}

	@Override
	public LoomElement setEdited(LocalDateTime edate) {
		this.edate = edate;
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return cdate;
	}

	@Override
	public LoomElement setCreated(LocalDateTime cdate) {
		this.cdate = cdate;
		return this;
	}

}
