/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.pojos;


import io.metaloom.loom.db.jooq.enums.LoomPermissionFlag;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.JSONB;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private String name;
    private LoomPermissionFlag permissions;
    private JSONB meta;
    private LocalDateTime created;
    private UUID creatorUuid;
    private LocalDateTime edited;
    private UUID editorUuid;

    public Role() {}

    public Role(Role value) {
        this.uuid = value.uuid;
        this.name = value.name;
        this.permissions = value.permissions;
        this.meta = value.meta;
        this.created = value.created;
        this.creatorUuid = value.creatorUuid;
        this.edited = value.edited;
        this.editorUuid = value.editorUuid;
    }

    public Role(
        UUID uuid,
        String name,
        LoomPermissionFlag permissions,
        JSONB meta,
        LocalDateTime created,
        UUID creatorUuid,
        LocalDateTime edited,
        UUID editorUuid
    ) {
        this.uuid = uuid;
        this.name = name;
        this.permissions = permissions;
        this.meta = meta;
        this.created = created;
        this.creatorUuid = creatorUuid;
        this.edited = edited;
        this.editorUuid = editorUuid;
    }

    /**
     * Getter for <code>public.role.uuid</code>.
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>public.role.uuid</code>.
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for <code>public.role.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.role.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.role.permissions</code>.
     */
    public LoomPermissionFlag getPermissions() {
        return this.permissions;
    }

    /**
     * Setter for <code>public.role.permissions</code>.
     */
    public void setPermissions(LoomPermissionFlag permissions) {
        this.permissions = permissions;
    }

    /**
     * Getter for <code>public.role.meta</code>. Custom meta properties to the
     * element
     */
    public JSONB getMeta() {
        return this.meta;
    }

    /**
     * Setter for <code>public.role.meta</code>. Custom meta properties to the
     * element
     */
    public void setMeta(JSONB meta) {
        this.meta = meta;
    }

    /**
     * Getter for <code>public.role.created</code>.
     */
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Setter for <code>public.role.created</code>.
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * Getter for <code>public.role.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return this.creatorUuid;
    }

    /**
     * Setter for <code>public.role.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID creatorUuid) {
        this.creatorUuid = creatorUuid;
    }

    /**
     * Getter for <code>public.role.edited</code>.
     */
    public LocalDateTime getEdited() {
        return this.edited;
    }

    /**
     * Setter for <code>public.role.edited</code>.
     */
    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    /**
     * Getter for <code>public.role.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return this.editorUuid;
    }

    /**
     * Setter for <code>public.role.editor_uuid</code>.
     */
    public void setEditorUuid(UUID editorUuid) {
        this.editorUuid = editorUuid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Role other = (Role) obj;
        if (this.uuid == null) {
            if (other.uuid != null)
                return false;
        }
        else if (!this.uuid.equals(other.uuid))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.permissions == null) {
            if (other.permissions != null)
                return false;
        }
        else if (!this.permissions.equals(other.permissions))
            return false;
        if (this.meta == null) {
            if (other.meta != null)
                return false;
        }
        else if (!this.meta.equals(other.meta))
            return false;
        if (this.created == null) {
            if (other.created != null)
                return false;
        }
        else if (!this.created.equals(other.created))
            return false;
        if (this.creatorUuid == null) {
            if (other.creatorUuid != null)
                return false;
        }
        else if (!this.creatorUuid.equals(other.creatorUuid))
            return false;
        if (this.edited == null) {
            if (other.edited != null)
                return false;
        }
        else if (!this.edited.equals(other.edited))
            return false;
        if (this.editorUuid == null) {
            if (other.editorUuid != null)
                return false;
        }
        else if (!this.editorUuid.equals(other.editorUuid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.permissions == null) ? 0 : this.permissions.hashCode());
        result = prime * result + ((this.meta == null) ? 0 : this.meta.hashCode());
        result = prime * result + ((this.created == null) ? 0 : this.created.hashCode());
        result = prime * result + ((this.creatorUuid == null) ? 0 : this.creatorUuid.hashCode());
        result = prime * result + ((this.edited == null) ? 0 : this.edited.hashCode());
        result = prime * result + ((this.editorUuid == null) ? 0 : this.editorUuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Role (");

        sb.append(uuid);
        sb.append(", ").append(name);
        sb.append(", ").append(permissions);
        sb.append(", ").append(meta);
        sb.append(", ").append(created);
        sb.append(", ").append(creatorUuid);
        sb.append(", ").append(edited);
        sb.append(", ").append(editorUuid);

        sb.append(")");
        return sb.toString();
    }
}
