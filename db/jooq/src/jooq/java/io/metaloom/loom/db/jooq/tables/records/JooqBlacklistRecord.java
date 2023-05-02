/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqBlacklist;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Stores information on blocked binaries.
 * A binary can be blocked due to copyright claim issues or because the virus
 * scanner marked it.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqBlacklistRecord extends UpdatableRecordImpl<JooqBlacklistRecord> implements Record9<UUID, UUID, String, UUID, LocalDateTime, UUID, String, Integer, JSONB> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.blacklist.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.blacklist.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.blacklist.binary_uuid</code>. Blacklisted binary
     */
    public void setBinaryUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.blacklist.binary_uuid</code>. Blacklisted binary
     */
    public UUID getBinaryUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.blacklist.created</code>. Creation timestamp
     */
    public void setCreated(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.blacklist.created</code>. Creation timestamp
     */
    public String getCreated() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.blacklist.creator_uuid</code>. Creator of the
     * blacklist entry
     */
    public void setCreatorUuid(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.blacklist.creator_uuid</code>. Creator of the
     * blacklist entry
     */
    public UUID getCreatorUuid() {
        return (UUID) get(3);
    }

    /**
     * Setter for <code>public.blacklist.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.blacklist.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.blacklist.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.blacklist.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.blacklist.type</code>. Type of the blacklist
     * entry (e.g. copyright claim)
     */
    public void setType(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.blacklist.type</code>. Type of the blacklist
     * entry (e.g. copyright claim)
     */
    public String getType() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.blacklist.review_count</code>. Amount of times
     * this blacklist entry has been reviewed.
     */
    public void setReviewCount(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.blacklist.review_count</code>. Amount of times
     * this blacklist entry has been reviewed.
     */
    public Integer getReviewCount() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.blacklist.meta</code>. Custom meta properties of
     * the block entry. May contain additional information on the reason.
     */
    public void setMeta(JSONB value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.blacklist.meta</code>. Custom meta properties of
     * the block entry. May contain additional information on the reason.
     */
    public JSONB getMeta() {
        return (JSONB) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<UUID, UUID, String, UUID, LocalDateTime, UUID, String, Integer, JSONB> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<UUID, UUID, String, UUID, LocalDateTime, UUID, String, Integer, JSONB> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqBlacklist.BLACKLIST.UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqBlacklist.BLACKLIST.BINARY_UUID;
    }

    @Override
    public Field<String> field3() {
        return JooqBlacklist.BLACKLIST.CREATED;
    }

    @Override
    public Field<UUID> field4() {
        return JooqBlacklist.BLACKLIST.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return JooqBlacklist.BLACKLIST.EDITED;
    }

    @Override
    public Field<UUID> field6() {
        return JooqBlacklist.BLACKLIST.EDITOR_UUID;
    }

    @Override
    public Field<String> field7() {
        return JooqBlacklist.BLACKLIST.TYPE;
    }

    @Override
    public Field<Integer> field8() {
        return JooqBlacklist.BLACKLIST.REVIEW_COUNT;
    }

    @Override
    public Field<JSONB> field9() {
        return JooqBlacklist.BLACKLIST.META;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public UUID component2() {
        return getBinaryUuid();
    }

    @Override
    public String component3() {
        return getCreated();
    }

    @Override
    public UUID component4() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime component5() {
        return getEdited();
    }

    @Override
    public UUID component6() {
        return getEditorUuid();
    }

    @Override
    public String component7() {
        return getType();
    }

    @Override
    public Integer component8() {
        return getReviewCount();
    }

    @Override
    public JSONB component9() {
        return getMeta();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public UUID value2() {
        return getBinaryUuid();
    }

    @Override
    public String value3() {
        return getCreated();
    }

    @Override
    public UUID value4() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime value5() {
        return getEdited();
    }

    @Override
    public UUID value6() {
        return getEditorUuid();
    }

    @Override
    public String value7() {
        return getType();
    }

    @Override
    public Integer value8() {
        return getReviewCount();
    }

    @Override
    public JSONB value9() {
        return getMeta();
    }

    @Override
    public JooqBlacklistRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value2(UUID value) {
        setBinaryUuid(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value3(String value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value4(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value5(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value6(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value7(String value) {
        setType(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value8(Integer value) {
        setReviewCount(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord value9(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqBlacklistRecord values(UUID value1, UUID value2, String value3, UUID value4, LocalDateTime value5, UUID value6, String value7, Integer value8, JSONB value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqBlacklistRecord
     */
    public JooqBlacklistRecord() {
        super(JooqBlacklist.BLACKLIST);
    }

    /**
     * Create a detached, initialised JooqBlacklistRecord
     */
    public JooqBlacklistRecord(UUID uuid, UUID binaryUuid, String created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid, String type, Integer reviewCount, JSONB meta) {
        super(JooqBlacklist.BLACKLIST);

        setUuid(uuid);
        setBinaryUuid(binaryUuid);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
        setType(type);
        setReviewCount(reviewCount);
        setMeta(meta);
    }
}
