package io.metaloom.loom.db.model.group.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.impl.LoomUserImpl;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name = "groups")
public class GroupImpl extends AbstractCUDElement implements Group {

	@Size(max = 128)
	private String name;

	@Column(columnDefinition = "jsonb")
	@Type(type = "io.metaloom.loom.db.hib.types.Json")
	private JsonObject meta;

	// @ManyToMany(fetch = FetchType.LAZY, targetEntity = LoomUserImpl.class)
	@ManyToMany(cascade = CascadeType.ALL, targetEntity = LoomUserImpl.class)
	@JoinTable(name = "groups_users", joinColumns = { @JoinColumn(referencedColumnName = "uuid") }, inverseJoinColumns = {
		@JoinColumn(referencedColumnName = "uuid") })
	private Set<LoomUser> users = new HashSet<>();

	public GroupImpl() {
	}

	public GroupImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Group setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Group setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	public Set<LoomUser> getUsers() {
		return users;
	}

	public Group addUser(LoomUser user) {
		users.add(user);
		return this;
	}

	public Group removeUser(LoomUser user) {
		users.remove(user);
		return this;
	}

	@Override
	public String toString() {
		return toJson().encodePrettily();
	}

	private JsonObject toJson() {
		JsonObject json = new JsonObject();
		json.put("uuid", getUuid());
		return json;
	}

}
