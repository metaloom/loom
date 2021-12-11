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
public class UsersGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID userUuid;
    private UUID groupUuid;

    public UsersGroup() {}

    public UsersGroup(UsersGroup value) {
        this.userUuid = value.userUuid;
        this.groupUuid = value.groupUuid;
    }

    public UsersGroup(
        UUID userUuid,
        UUID groupUuid
    ) {
        this.userUuid = userUuid;
        this.groupUuid = groupUuid;
    }

    /**
     * Getter for <code>public.users_group.user_uuid</code>.
     */
    public UUID getUserUuid() {
        return this.userUuid;
    }

    /**
     * Setter for <code>public.users_group.user_uuid</code>.
     */
    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * Getter for <code>public.users_group.group_uuid</code>.
     */
    public UUID getGroupUuid() {
        return this.groupUuid;
    }

    /**
     * Setter for <code>public.users_group.group_uuid</code>.
     */
    public void setGroupUuid(UUID groupUuid) {
        this.groupUuid = groupUuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UsersGroup (");

        sb.append(userUuid);
        sb.append(", ").append(groupUuid);

        sb.append(")");
        return sb.toString();
    }
}
