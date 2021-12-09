/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.metaloom.loom.db.jooq.tables.TagUserMeta;
import io.metaloom.loom.db.jooq.tables.interfaces.ITagUserMeta;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagUserMetaRecord extends TableRecordImpl<TagUserMetaRecord> implements VertxPojo, Record4<UUID, UUID, Integer, String>, ITagUserMeta {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag_user_meta.tag_uuid</code>.
     */
    @Override
    public TagUserMetaRecord setTagUuid(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_user_meta.tag_uuid</code>.
     */
    @Override
    public UUID getTagUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag_user_meta.user_uuid</code>.
     */
    @Override
    public TagUserMetaRecord setUserUuid(UUID value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_user_meta.user_uuid</code>.
     */
    @Override
    public UUID getUserUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.tag_user_meta.rating</code>. Rating of the tag by the user
     */
    @Override
    public TagUserMetaRecord setRating(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_user_meta.rating</code>. Rating of the tag by the user
     */
    @Override
    public Integer getRating() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.tag_user_meta.meta</code>. Custom meta properties
     */
    @Override
    public TagUserMetaRecord setMeta(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_user_meta.meta</code>. Custom meta properties
     */
    @Override
    public String getMeta() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, UUID, Integer, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<UUID, UUID, Integer, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return TagUserMeta.TAG_USER_META.TAG_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return TagUserMeta.TAG_USER_META.USER_UUID;
    }

    @Override
    public Field<Integer> field3() {
        return TagUserMeta.TAG_USER_META.RATING;
    }

    @Override
    public Field<String> field4() {
        return TagUserMeta.TAG_USER_META.META;
    }

    @Override
    public UUID component1() {
        return getTagUuid();
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
    public String component4() {
        return getMeta();
    }

    @Override
    public UUID value1() {
        return getTagUuid();
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
    public String value4() {
        return getMeta();
    }

    @Override
    public TagUserMetaRecord value1(UUID value) {
        setTagUuid(value);
        return this;
    }

    @Override
    public TagUserMetaRecord value2(UUID value) {
        setUserUuid(value);
        return this;
    }

    @Override
    public TagUserMetaRecord value3(Integer value) {
        setRating(value);
        return this;
    }

    @Override
    public TagUserMetaRecord value4(String value) {
        setMeta(value);
        return this;
    }

    @Override
    public TagUserMetaRecord values(UUID value1, UUID value2, Integer value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITagUserMeta from) {
        setTagUuid(from.getTagUuid());
        setUserUuid(from.getUserUuid());
        setRating(from.getRating());
        setMeta(from.getMeta());
    }

    @Override
    public <E extends ITagUserMeta> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagUserMetaRecord
     */
    public TagUserMetaRecord() {
        super(TagUserMeta.TAG_USER_META);
    }

    /**
     * Create a detached, initialised TagUserMetaRecord
     */
    public TagUserMetaRecord(UUID tagUuid, UUID userUuid, Integer rating, String meta) {
        super(TagUserMeta.TAG_USER_META);

        setTagUuid(tagUuid);
        setUserUuid(userUuid);
        setRating(rating);
        setMeta(meta);
    }

        public TagUserMetaRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
