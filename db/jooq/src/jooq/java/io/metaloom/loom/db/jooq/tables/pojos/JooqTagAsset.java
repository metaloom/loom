/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.pojos;


import java.io.Serializable;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqTagAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID tagUuid;
    private UUID assetUuid;

    public JooqTagAsset() {}

    public JooqTagAsset(JooqTagAsset value) {
        this.tagUuid = value.tagUuid;
        this.assetUuid = value.assetUuid;
    }

    public JooqTagAsset(
        UUID tagUuid,
        UUID assetUuid
    ) {
        this.tagUuid = tagUuid;
        this.assetUuid = assetUuid;
    }

    /**
     * Getter for <code>public.tag_asset.tag_uuid</code>.
     */
    public UUID getTagUuid() {
        return this.tagUuid;
    }

    /**
     * Setter for <code>public.tag_asset.tag_uuid</code>.
     */
    public void setTagUuid(UUID tagUuid) {
        this.tagUuid = tagUuid;
    }

    /**
     * Getter for <code>public.tag_asset.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return this.assetUuid;
    }

    /**
     * Setter for <code>public.tag_asset.asset_uuid</code>.
     */
    public void setAssetUuid(UUID assetUuid) {
        this.assetUuid = assetUuid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JooqTagAsset other = (JooqTagAsset) obj;
        if (this.tagUuid == null) {
            if (other.tagUuid != null)
                return false;
        }
        else if (!this.tagUuid.equals(other.tagUuid))
            return false;
        if (this.assetUuid == null) {
            if (other.assetUuid != null)
                return false;
        }
        else if (!this.assetUuid.equals(other.assetUuid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.tagUuid == null) ? 0 : this.tagUuid.hashCode());
        result = prime * result + ((this.assetUuid == null) ? 0 : this.assetUuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqTagAsset (");

        sb.append(tagUuid);
        sb.append(", ").append(assetUuid);

        sb.append(")");
        return sb.toString();
    }
}