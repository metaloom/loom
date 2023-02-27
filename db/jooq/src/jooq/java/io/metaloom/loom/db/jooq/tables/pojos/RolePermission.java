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
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID roleUuid;
    private UUID elementUuid;
    private Boolean createPerm;
    private Boolean readPerm;
    private Boolean deletePerm;
    private Boolean updatePerm;
    private Boolean readPublishPerm;
    private Boolean publishPerm;

    public RolePermission() {}

    public RolePermission(RolePermission value) {
        this.roleUuid = value.roleUuid;
        this.elementUuid = value.elementUuid;
        this.createPerm = value.createPerm;
        this.readPerm = value.readPerm;
        this.deletePerm = value.deletePerm;
        this.updatePerm = value.updatePerm;
        this.readPublishPerm = value.readPublishPerm;
        this.publishPerm = value.publishPerm;
    }

    public RolePermission(
        UUID roleUuid,
        UUID elementUuid,
        Boolean createPerm,
        Boolean readPerm,
        Boolean deletePerm,
        Boolean updatePerm,
        Boolean readPublishPerm,
        Boolean publishPerm
    ) {
        this.roleUuid = roleUuid;
        this.elementUuid = elementUuid;
        this.createPerm = createPerm;
        this.readPerm = readPerm;
        this.deletePerm = deletePerm;
        this.updatePerm = updatePerm;
        this.readPublishPerm = readPublishPerm;
        this.publishPerm = publishPerm;
    }

    /**
     * Getter for <code>public.role_permission.role_uuid</code>.
     */
    public UUID getRoleUuid() {
        return this.roleUuid;
    }

    /**
     * Setter for <code>public.role_permission.role_uuid</code>.
     */
    public void setRoleUuid(UUID roleUuid) {
        this.roleUuid = roleUuid;
    }

    /**
     * Getter for <code>public.role_permission.element_uuid</code>.
     */
    public UUID getElementUuid() {
        return this.elementUuid;
    }

    /**
     * Setter for <code>public.role_permission.element_uuid</code>.
     */
    public void setElementUuid(UUID elementUuid) {
        this.elementUuid = elementUuid;
    }

    /**
     * Getter for <code>public.role_permission.create_perm</code>.
     */
    public Boolean getCreatePerm() {
        return this.createPerm;
    }

    /**
     * Setter for <code>public.role_permission.create_perm</code>.
     */
    public void setCreatePerm(Boolean createPerm) {
        this.createPerm = createPerm;
    }

    /**
     * Getter for <code>public.role_permission.read_perm</code>.
     */
    public Boolean getReadPerm() {
        return this.readPerm;
    }

    /**
     * Setter for <code>public.role_permission.read_perm</code>.
     */
    public void setReadPerm(Boolean readPerm) {
        this.readPerm = readPerm;
    }

    /**
     * Getter for <code>public.role_permission.delete_perm</code>.
     */
    public Boolean getDeletePerm() {
        return this.deletePerm;
    }

    /**
     * Setter for <code>public.role_permission.delete_perm</code>.
     */
    public void setDeletePerm(Boolean deletePerm) {
        this.deletePerm = deletePerm;
    }

    /**
     * Getter for <code>public.role_permission.update_perm</code>.
     */
    public Boolean getUpdatePerm() {
        return this.updatePerm;
    }

    /**
     * Setter for <code>public.role_permission.update_perm</code>.
     */
    public void setUpdatePerm(Boolean updatePerm) {
        this.updatePerm = updatePerm;
    }

    /**
     * Getter for <code>public.role_permission.read_publish_perm</code>.
     */
    public Boolean getReadPublishPerm() {
        return this.readPublishPerm;
    }

    /**
     * Setter for <code>public.role_permission.read_publish_perm</code>.
     */
    public void setReadPublishPerm(Boolean readPublishPerm) {
        this.readPublishPerm = readPublishPerm;
    }

    /**
     * Getter for <code>public.role_permission.publish_perm</code>.
     */
    public Boolean getPublishPerm() {
        return this.publishPerm;
    }

    /**
     * Setter for <code>public.role_permission.publish_perm</code>.
     */
    public void setPublishPerm(Boolean publishPerm) {
        this.publishPerm = publishPerm;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RolePermission other = (RolePermission) obj;
        if (this.roleUuid == null) {
            if (other.roleUuid != null)
                return false;
        }
        else if (!this.roleUuid.equals(other.roleUuid))
            return false;
        if (this.elementUuid == null) {
            if (other.elementUuid != null)
                return false;
        }
        else if (!this.elementUuid.equals(other.elementUuid))
            return false;
        if (this.createPerm == null) {
            if (other.createPerm != null)
                return false;
        }
        else if (!this.createPerm.equals(other.createPerm))
            return false;
        if (this.readPerm == null) {
            if (other.readPerm != null)
                return false;
        }
        else if (!this.readPerm.equals(other.readPerm))
            return false;
        if (this.deletePerm == null) {
            if (other.deletePerm != null)
                return false;
        }
        else if (!this.deletePerm.equals(other.deletePerm))
            return false;
        if (this.updatePerm == null) {
            if (other.updatePerm != null)
                return false;
        }
        else if (!this.updatePerm.equals(other.updatePerm))
            return false;
        if (this.readPublishPerm == null) {
            if (other.readPublishPerm != null)
                return false;
        }
        else if (!this.readPublishPerm.equals(other.readPublishPerm))
            return false;
        if (this.publishPerm == null) {
            if (other.publishPerm != null)
                return false;
        }
        else if (!this.publishPerm.equals(other.publishPerm))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.roleUuid == null) ? 0 : this.roleUuid.hashCode());
        result = prime * result + ((this.elementUuid == null) ? 0 : this.elementUuid.hashCode());
        result = prime * result + ((this.createPerm == null) ? 0 : this.createPerm.hashCode());
        result = prime * result + ((this.readPerm == null) ? 0 : this.readPerm.hashCode());
        result = prime * result + ((this.deletePerm == null) ? 0 : this.deletePerm.hashCode());
        result = prime * result + ((this.updatePerm == null) ? 0 : this.updatePerm.hashCode());
        result = prime * result + ((this.readPublishPerm == null) ? 0 : this.readPublishPerm.hashCode());
        result = prime * result + ((this.publishPerm == null) ? 0 : this.publishPerm.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RolePermission (");

        sb.append(roleUuid);
        sb.append(", ").append(elementUuid);
        sb.append(", ").append(createPerm);
        sb.append(", ").append(readPerm);
        sb.append(", ").append(deletePerm);
        sb.append(", ").append(updatePerm);
        sb.append(", ").append(readPublishPerm);
        sb.append(", ").append(publishPerm);

        sb.append(")");
        return sb.toString();
    }
}