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
public class RoleGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID groupUuid;
    private UUID roleUuid;

    public RoleGroup() {}

    public RoleGroup(RoleGroup value) {
        this.groupUuid = value.groupUuid;
        this.roleUuid = value.roleUuid;
    }

    public RoleGroup(
        UUID groupUuid,
        UUID roleUuid
    ) {
        this.groupUuid = groupUuid;
        this.roleUuid = roleUuid;
    }

    /**
     * Getter for <code>public.role_group.group_uuid</code>.
     */
    public UUID getGroupUuid() {
        return this.groupUuid;
    }

    /**
     * Setter for <code>public.role_group.group_uuid</code>.
     */
    public void setGroupUuid(UUID groupUuid) {
        this.groupUuid = groupUuid;
    }

    /**
     * Getter for <code>public.role_group.role_uuid</code>.
     */
    public UUID getRoleUuid() {
        return this.roleUuid;
    }

    /**
     * Setter for <code>public.role_group.role_uuid</code>.
     */
    public void setRoleUuid(UUID roleUuid) {
        this.roleUuid = roleUuid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RoleGroup other = (RoleGroup) obj;
        if (this.groupUuid == null) {
            if (other.groupUuid != null)
                return false;
        }
        else if (!this.groupUuid.equals(other.groupUuid))
            return false;
        if (this.roleUuid == null) {
            if (other.roleUuid != null)
                return false;
        }
        else if (!this.roleUuid.equals(other.roleUuid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.groupUuid == null) ? 0 : this.groupUuid.hashCode());
        result = prime * result + ((this.roleUuid == null) ? 0 : this.roleUuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RoleGroup (");

        sb.append(groupUuid);
        sb.append(", ").append(roleUuid);

        sb.append(")");
        return sb.toString();
    }
}
