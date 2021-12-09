/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.metaloom.loom.db.jooq.tables.TagContent;
import io.metaloom.loom.db.jooq.tables.interfaces.ITagContent;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagContentRecord extends UpdatableRecordImpl<TagContentRecord> implements VertxPojo, Record2<UUID, UUID>, ITagContent {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag_content.tag_uuid</code>.
     */
    @Override
    public TagContentRecord setTagUuid(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_content.tag_uuid</code>.
     */
    @Override
    public UUID getTagUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag_content.content_uuid</code>.
     */
    @Override
    public TagContentRecord setContentUuid(UUID value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_content.content_uuid</code>.
     */
    @Override
    public UUID getContentUuid() {
        return (UUID) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<UUID, UUID> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return TagContent.TAG_CONTENT.TAG_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return TagContent.TAG_CONTENT.CONTENT_UUID;
    }

    @Override
    public UUID component1() {
        return getTagUuid();
    }

    @Override
    public UUID component2() {
        return getContentUuid();
    }

    @Override
    public UUID value1() {
        return getTagUuid();
    }

    @Override
    public UUID value2() {
        return getContentUuid();
    }

    @Override
    public TagContentRecord value1(UUID value) {
        setTagUuid(value);
        return this;
    }

    @Override
    public TagContentRecord value2(UUID value) {
        setContentUuid(value);
        return this;
    }

    @Override
    public TagContentRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITagContent from) {
        setTagUuid(from.getTagUuid());
        setContentUuid(from.getContentUuid());
    }

    @Override
    public <E extends ITagContent> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagContentRecord
     */
    public TagContentRecord() {
        super(TagContent.TAG_CONTENT);
    }

    /**
     * Create a detached, initialised TagContentRecord
     */
    public TagContentRecord(UUID tagUuid, UUID contentUuid) {
        super(TagContent.TAG_CONTENT);

        setTagUuid(tagUuid);
        setContentUuid(contentUuid);
    }

        public TagContentRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
