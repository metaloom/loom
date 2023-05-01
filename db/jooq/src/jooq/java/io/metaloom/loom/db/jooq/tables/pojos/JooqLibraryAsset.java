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
public class JooqLibraryAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID libraryUuid;
    private UUID assetUuid;

    public JooqLibraryAsset() {}

    public JooqLibraryAsset(JooqLibraryAsset value) {
        this.libraryUuid = value.libraryUuid;
        this.assetUuid = value.assetUuid;
    }

    public JooqLibraryAsset(
        UUID libraryUuid,
        UUID assetUuid
    ) {
        this.libraryUuid = libraryUuid;
        this.assetUuid = assetUuid;
    }

    /**
     * Getter for <code>public.library_asset.library_uuid</code>.
     */
    public UUID getLibraryUuid() {
        return this.libraryUuid;
    }

    /**
     * Setter for <code>public.library_asset.library_uuid</code>.
     */
    public void setLibraryUuid(UUID libraryUuid) {
        this.libraryUuid = libraryUuid;
    }

    /**
     * Getter for <code>public.library_asset.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return this.assetUuid;
    }

    /**
     * Setter for <code>public.library_asset.asset_uuid</code>.
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
        final JooqLibraryAsset other = (JooqLibraryAsset) obj;
        if (this.libraryUuid == null) {
            if (other.libraryUuid != null)
                return false;
        }
        else if (!this.libraryUuid.equals(other.libraryUuid))
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
        result = prime * result + ((this.libraryUuid == null) ? 0 : this.libraryUuid.hashCode());
        result = prime * result + ((this.assetUuid == null) ? 0 : this.assetUuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqLibraryAsset (");

        sb.append(libraryUuid);
        sb.append(", ").append(assetUuid);

        sb.append(")");
        return sb.toString();
    }
}
