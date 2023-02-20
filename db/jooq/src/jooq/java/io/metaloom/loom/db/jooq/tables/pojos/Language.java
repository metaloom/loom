/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.pojos;


import java.io.Serializable;
import java.util.UUID;

import org.jooq.JSONB;


/**
 * Table which stores the languages for loom
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private String nativeName;
    private String tag;
    private JSONB meta;

    public Language() {}

    public Language(Language value) {
        this.uuid = value.uuid;
        this.nativeName = value.nativeName;
        this.tag = value.tag;
        this.meta = value.meta;
    }

    public Language(
        UUID uuid,
        String nativeName,
        String tag,
        JSONB meta
    ) {
        this.uuid = uuid;
        this.nativeName = nativeName;
        this.tag = tag;
        this.meta = meta;
    }

    /**
     * Getter for <code>public.language.uuid</code>.
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>public.language.uuid</code>.
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for <code>public.language.native_name</code>.
     */
    public String getNativeName() {
        return this.nativeName;
    }

    /**
     * Setter for <code>public.language.native_name</code>.
     */
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    /**
     * Getter for <code>public.language.tag</code>.
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * Setter for <code>public.language.tag</code>.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Getter for <code>public.language.meta</code>. Custom meta properties to
     * the element
     */
    public JSONB getMeta() {
        return this.meta;
    }

    /**
     * Setter for <code>public.language.meta</code>. Custom meta properties to
     * the element
     */
    public void setMeta(JSONB meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Language other = (Language) obj;
        if (this.uuid == null) {
            if (other.uuid != null)
                return false;
        }
        else if (!this.uuid.equals(other.uuid))
            return false;
        if (this.nativeName == null) {
            if (other.nativeName != null)
                return false;
        }
        else if (!this.nativeName.equals(other.nativeName))
            return false;
        if (this.tag == null) {
            if (other.tag != null)
                return false;
        }
        else if (!this.tag.equals(other.tag))
            return false;
        if (this.meta == null) {
            if (other.meta != null)
                return false;
        }
        else if (!this.meta.equals(other.meta))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
        result = prime * result + ((this.nativeName == null) ? 0 : this.nativeName.hashCode());
        result = prime * result + ((this.tag == null) ? 0 : this.tag.hashCode());
        result = prime * result + ((this.meta == null) ? 0 : this.meta.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Language (");

        sb.append(uuid);
        sb.append(", ").append(nativeName);
        sb.append(", ").append(tag);
        sb.append(", ").append(meta);

        sb.append(")");
        return sb.toString();
    }
}
