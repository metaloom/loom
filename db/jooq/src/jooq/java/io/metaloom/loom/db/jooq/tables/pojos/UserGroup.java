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
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID userUuid;
    private UUID groupUuid;

    public UserGroup() {}

    public UserGroup(UserGroup value) {
        this.userUuid = value.userUuid;
        this.groupUuid = value.groupUuid;
    }

    public UserGroup(
        UUID userUuid,
        UUID groupUuid
    ) {
        this.userUuid = userUuid;
        this.groupUuid = groupUuid;
    }

    /**
     * Getter for <code>public.user_group.user_uuid</code>.
     */
    public UUID getUserUuid() {
        return this.userUuid;
    }

    /**
     * Setter for <code>public.user_group.user_uuid</code>.
     */
    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * Getter for <code>public.user_group.group_uuid</code>.
     */
    public UUID getGroupUuid() {
        return this.groupUuid;
    }

    /**
     * Setter for <code>public.user_group.group_uuid</code>.
     */
    public void setGroupUuid(UUID groupUuid) {
        this.groupUuid = groupUuid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserGroup other = (UserGroup) obj;
        if (this.userUuid == null) {
            if (other.userUuid != null)
                return false;
        }
        else if (!this.userUuid.equals(other.userUuid))
            return false;
        if (this.groupUuid == null) {
            if (other.groupUuid != null)
                return false;
        }
        else if (!this.groupUuid.equals(other.groupUuid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.userUuid == null) ? 0 : this.userUuid.hashCode());
        result = prime * result + ((this.groupUuid == null) ? 0 : this.groupUuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserGroup (");

        sb.append(userUuid);
        sb.append(", ").append(groupUuid);

        sb.append(")");
        return sb.toString();
    }
}
