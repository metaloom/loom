/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.JSONB;


/**
 * Store information on remixes of binaries.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqBinaryRemix implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID binaryAUuid;
    private UUID binaryBUuid;
    private JSONB meta;
    private LocalDateTime created;
    private UUID creatorUuid;

    public JooqBinaryRemix() {}

    public JooqBinaryRemix(JooqBinaryRemix value) {
        this.binaryAUuid = value.binaryAUuid;
        this.binaryBUuid = value.binaryBUuid;
        this.meta = value.meta;
        this.created = value.created;
        this.creatorUuid = value.creatorUuid;
    }

    public JooqBinaryRemix(
        UUID binaryAUuid,
        UUID binaryBUuid,
        JSONB meta,
        LocalDateTime created,
        UUID creatorUuid
    ) {
        this.binaryAUuid = binaryAUuid;
        this.binaryBUuid = binaryBUuid;
        this.meta = meta;
        this.created = created;
        this.creatorUuid = creatorUuid;
    }

    /**
     * Getter for <code>public.binary_remix.binary_a_uuid</code>.
     */
    public UUID getBinaryAUuid() {
        return this.binaryAUuid;
    }

    /**
     * Setter for <code>public.binary_remix.binary_a_uuid</code>.
     */
    public void setBinaryAUuid(UUID binaryAUuid) {
        this.binaryAUuid = binaryAUuid;
    }

    /**
     * Getter for <code>public.binary_remix.binary_b_uuid</code>.
     */
    public UUID getBinaryBUuid() {
        return this.binaryBUuid;
    }

    /**
     * Setter for <code>public.binary_remix.binary_b_uuid</code>.
     */
    public void setBinaryBUuid(UUID binaryBUuid) {
        this.binaryBUuid = binaryBUuid;
    }

    /**
     * Getter for <code>public.binary_remix.meta</code>. Custom meta properties
     * to the element
     */
    public JSONB getMeta() {
        return this.meta;
    }

    /**
     * Setter for <code>public.binary_remix.meta</code>. Custom meta properties
     * to the element
     */
    public void setMeta(JSONB meta) {
        this.meta = meta;
    }

    /**
     * Getter for <code>public.binary_remix.created</code>.
     */
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Setter for <code>public.binary_remix.created</code>.
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * Getter for <code>public.binary_remix.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return this.creatorUuid;
    }

    /**
     * Setter for <code>public.binary_remix.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID creatorUuid) {
        this.creatorUuid = creatorUuid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JooqBinaryRemix other = (JooqBinaryRemix) obj;
        if (this.binaryAUuid == null) {
            if (other.binaryAUuid != null)
                return false;
        }
        else if (!this.binaryAUuid.equals(other.binaryAUuid))
            return false;
        if (this.binaryBUuid == null) {
            if (other.binaryBUuid != null)
                return false;
        }
        else if (!this.binaryBUuid.equals(other.binaryBUuid))
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
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.binaryAUuid == null) ? 0 : this.binaryAUuid.hashCode());
        result = prime * result + ((this.binaryBUuid == null) ? 0 : this.binaryBUuid.hashCode());
        result = prime * result + ((this.meta == null) ? 0 : this.meta.hashCode());
        result = prime * result + ((this.created == null) ? 0 : this.created.hashCode());
        result = prime * result + ((this.creatorUuid == null) ? 0 : this.creatorUuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqBinaryRemix (");

        sb.append(binaryAUuid);
        sb.append(", ").append(binaryBUuid);
        sb.append(", ").append(meta);
        sb.append(", ").append(created);
        sb.append(", ").append(creatorUuid);

        sb.append(")");
        return sb.toString();
    }
}
