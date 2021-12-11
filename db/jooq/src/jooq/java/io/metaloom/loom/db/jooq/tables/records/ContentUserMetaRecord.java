/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.ContentUserMeta;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ContentUserMetaRecord extends UpdatableRecordImpl<ContentUserMetaRecord> implements Record4<UUID, UUID, Integer, JSONB> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.content_user_meta.content_uuid</code>.
     */
    public void setContentUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.content_user_meta.content_uuid</code>.
     */
    public UUID getContentUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.content_user_meta.user_uuid</code>.
     */
    public void setUserUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.content_user_meta.user_uuid</code>.
     */
    public UUID getUserUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.content_user_meta.rating</code>. Rating of the
     * content by the user
     */
    public void setRating(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.content_user_meta.rating</code>. Rating of the
     * content by the user
     */
    public Integer getRating() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.content_user_meta.meta</code>. Custom meta
     * properties
     */
    public void setMeta(JSONB value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.content_user_meta.meta</code>. Custom meta
     * properties
     */
    public JSONB getMeta() {
        return (JSONB) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, UUID, Integer, JSONB> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<UUID, UUID, Integer, JSONB> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return ContentUserMeta.CONTENT_USER_META.CONTENT_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return ContentUserMeta.CONTENT_USER_META.USER_UUID;
    }

    @Override
    public Field<Integer> field3() {
        return ContentUserMeta.CONTENT_USER_META.RATING;
    }

    @Override
    public Field<JSONB> field4() {
        return ContentUserMeta.CONTENT_USER_META.META;
    }

    @Override
    public UUID component1() {
        return getContentUuid();
    }

    @Override
    public UUID component2() {
        return getUserUuid();
    }

    @Override
    public Integer component3() {
        return getRating();
    }

    @Override
    public JSONB component4() {
        return getMeta();
    }

    @Override
    public UUID value1() {
        return getContentUuid();
    }

    @Override
    public UUID value2() {
        return getUserUuid();
    }

    @Override
    public Integer value3() {
        return getRating();
    }

    @Override
    public JSONB value4() {
        return getMeta();
    }

    @Override
    public ContentUserMetaRecord value1(UUID value) {
        setContentUuid(value);
        return this;
    }

    @Override
    public ContentUserMetaRecord value2(UUID value) {
        setUserUuid(value);
        return this;
    }

    @Override
    public ContentUserMetaRecord value3(Integer value) {
        setRating(value);
        return this;
    }

    @Override
    public ContentUserMetaRecord value4(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public ContentUserMetaRecord values(UUID value1, UUID value2, Integer value3, JSONB value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ContentUserMetaRecord
     */
    public ContentUserMetaRecord() {
        super(ContentUserMeta.CONTENT_USER_META);
    }

    /**
     * Create a detached, initialised ContentUserMetaRecord
     */
    public ContentUserMetaRecord(UUID contentUuid, UUID userUuid, Integer rating, JSONB meta) {
        super(ContentUserMeta.CONTENT_USER_META);

        setContentUuid(contentUuid);
        setUserUuid(userUuid);
        setRating(rating);
        setMeta(meta);
    }

    /**
     * Create a detached, initialised ContentUserMetaRecord
     */
    public ContentUserMetaRecord(io.metaloom.loom.db.jooq.tables.pojos.ContentUserMeta value) {
        super(ContentUserMeta.CONTENT_USER_META);

        if (value != null) {
            setContentUuid(value.getContentUuid());
            setUserUuid(value.getUserUuid());
            setRating(value.getRating());
            setMeta(value.getMeta());
        }
    }
}
