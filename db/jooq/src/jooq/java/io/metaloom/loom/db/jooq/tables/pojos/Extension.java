/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.pojos;


import io.metaloom.loom.db.jooq.enums.LoomExtensionType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.JSONB;


/**
 * Table which lists the registered extensions
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Extension implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private String url;
    private LoomExtensionType kind;
    private String status;
    private JSONB meta;
    private LocalDateTime created;
    private UUID creatorUuid;
    private LocalDateTime edited;
    private UUID editorUuid;

    public Extension() {}

    public Extension(Extension value) {
        this.uuid = value.uuid;
        this.url = value.url;
        this.kind = value.kind;
        this.status = value.status;
        this.meta = value.meta;
        this.created = value.created;
        this.creatorUuid = value.creatorUuid;
        this.edited = value.edited;
        this.editorUuid = value.editorUuid;
    }

    public Extension(
        UUID uuid,
        String url,
        LoomExtensionType kind,
        String status,
        JSONB meta,
        LocalDateTime created,
        UUID creatorUuid,
        LocalDateTime edited,
        UUID editorUuid
    ) {
        this.uuid = uuid;
        this.url = url;
        this.kind = kind;
        this.status = status;
        this.meta = meta;
        this.created = created;
        this.creatorUuid = creatorUuid;
        this.edited = edited;
        this.editorUuid = editorUuid;
    }

    /**
     * Getter for <code>public.extension.uuid</code>.
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>public.extension.uuid</code>.
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for <code>public.extension.url</code>.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Setter for <code>public.extension.url</code>.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter for <code>public.extension.kind</code>. Defines the type of the
     * extension service
     */
    public LoomExtensionType getKind() {
        return this.kind;
    }

    /**
     * Setter for <code>public.extension.kind</code>. Defines the type of the
     * extension service
     */
    public void setKind(LoomExtensionType kind) {
        this.kind = kind;
    }

    /**
     * Getter for <code>public.extension.status</code>.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.extension.status</code>.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for <code>public.extension.meta</code>. Custom meta properties to
     * the element
     */
    public JSONB getMeta() {
        return this.meta;
    }

    /**
     * Setter for <code>public.extension.meta</code>. Custom meta properties to
     * the element
     */
    public void setMeta(JSONB meta) {
        this.meta = meta;
    }

    /**
     * Getter for <code>public.extension.created</code>.
     */
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Setter for <code>public.extension.created</code>.
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * Getter for <code>public.extension.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return this.creatorUuid;
    }

    /**
     * Setter for <code>public.extension.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID creatorUuid) {
        this.creatorUuid = creatorUuid;
    }

    /**
     * Getter for <code>public.extension.edited</code>.
     */
    public LocalDateTime getEdited() {
        return this.edited;
    }

    /**
     * Setter for <code>public.extension.edited</code>.
     */
    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    /**
     * Getter for <code>public.extension.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return this.editorUuid;
    }

    /**
     * Setter for <code>public.extension.editor_uuid</code>.
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
        final Extension other = (Extension) obj;
        if (this.uuid == null) {
            if (other.uuid != null)
                return false;
        }
        else if (!this.uuid.equals(other.uuid))
            return false;
        if (this.url == null) {
            if (other.url != null)
                return false;
        }
        else if (!this.url.equals(other.url))
            return false;
        if (this.kind == null) {
            if (other.kind != null)
                return false;
        }
        else if (!this.kind.equals(other.kind))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
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
        result = prime * result + ((this.url == null) ? 0 : this.url.hashCode());
        result = prime * result + ((this.kind == null) ? 0 : this.kind.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.meta == null) ? 0 : this.meta.hashCode());
        result = prime * result + ((this.created == null) ? 0 : this.created.hashCode());
        result = prime * result + ((this.creatorUuid == null) ? 0 : this.creatorUuid.hashCode());
        result = prime * result + ((this.edited == null) ? 0 : this.edited.hashCode());
        result = prime * result + ((this.editorUuid == null) ? 0 : this.editorUuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Extension (");

        sb.append(uuid);
        sb.append(", ").append(url);
        sb.append(", ").append(kind);
        sb.append(", ").append(status);
        sb.append(", ").append(meta);
        sb.append(", ").append(created);
        sb.append(", ").append(creatorUuid);
        sb.append(", ").append(edited);
        sb.append(", ").append(editorUuid);

        sb.append(")");
        return sb.toString();
    }
}