/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.JSONB;


/**
 * Table which stores the actual fields content as JSON
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Field implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID          uuid;
    private UUID          contentUuid;
    private JSONB         fieldsJson;
    private UUID          languageUuid;
    private LocalDateTime edited;
    private UUID          editorUuid;
    private LocalDateTime created;
    private UUID          creatorUuid;
    private UUID          modelversionUuid;
    private Integer       version;

    public Field() {}

    public Field(Field value) {
        this.uuid = value.uuid;
        this.contentUuid = value.contentUuid;
        this.fieldsJson = value.fieldsJson;
        this.languageUuid = value.languageUuid;
        this.edited = value.edited;
        this.editorUuid = value.editorUuid;
        this.created = value.created;
        this.creatorUuid = value.creatorUuid;
        this.modelversionUuid = value.modelversionUuid;
        this.version = value.version;
    }

    public Field(
        UUID          uuid,
        UUID          contentUuid,
        JSONB         fieldsJson,
        UUID          languageUuid,
        LocalDateTime edited,
        UUID          editorUuid,
        LocalDateTime created,
        UUID          creatorUuid,
        UUID          modelversionUuid,
        Integer       version
    ) {
        this.uuid = uuid;
        this.contentUuid = contentUuid;
        this.fieldsJson = fieldsJson;
        this.languageUuid = languageUuid;
        this.edited = edited;
        this.editorUuid = editorUuid;
        this.created = created;
        this.creatorUuid = creatorUuid;
        this.modelversionUuid = modelversionUuid;
        this.version = version;
    }

    /**
     * Getter for <code>public.field.uuid</code>.
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>public.field.uuid</code>.
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for <code>public.field.content_uuid</code>. Reference to the
     * content that uses this fields record
     */
    public UUID getContentUuid() {
        return this.contentUuid;
    }

    /**
     * Setter for <code>public.field.content_uuid</code>. Reference to the
     * content that uses this fields record
     */
    public void setContentUuid(UUID contentUuid) {
        this.contentUuid = contentUuid;
    }

    /**
     * Getter for <code>public.field.fields_json</code>. JSON which contains the
     * actual fields content
     */
    public JSONB getFieldsJson() {
        return this.fieldsJson;
    }

    /**
     * Setter for <code>public.field.fields_json</code>. JSON which contains the
     * actual fields content
     */
    public void setFieldsJson(JSONB fieldsJson) {
        this.fieldsJson = fieldsJson;
    }

    /**
     * Getter for <code>public.field.language_uuid</code>.
     */
    public UUID getLanguageUuid() {
        return this.languageUuid;
    }

    /**
     * Setter for <code>public.field.language_uuid</code>.
     */
    public void setLanguageUuid(UUID languageUuid) {
        this.languageUuid = languageUuid;
    }

    /**
     * Getter for <code>public.field.edited</code>.
     */
    public LocalDateTime getEdited() {
        return this.edited;
    }

    /**
     * Setter for <code>public.field.edited</code>.
     */
    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    /**
     * Getter for <code>public.field.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return this.editorUuid;
    }

    /**
     * Setter for <code>public.field.editor_uuid</code>.
     */
    public void setEditorUuid(UUID editorUuid) {
        this.editorUuid = editorUuid;
    }

    /**
     * Getter for <code>public.field.created</code>.
     */
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Setter for <code>public.field.created</code>.
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * Getter for <code>public.field.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return this.creatorUuid;
    }

    /**
     * Setter for <code>public.field.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID creatorUuid) {
        this.creatorUuid = creatorUuid;
    }

    /**
     * Getter for <code>public.field.modelversion_uuid</code>.
     */
    public UUID getModelversionUuid() {
        return this.modelversionUuid;
    }

    /**
     * Setter for <code>public.field.modelversion_uuid</code>.
     */
    public void setModelversionUuid(UUID modelversionUuid) {
        this.modelversionUuid = modelversionUuid;
    }

    /**
     * Getter for <code>public.field.version</code>.
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Setter for <code>public.field.version</code>.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Field (");

        sb.append(uuid);
        sb.append(", ").append(contentUuid);
        sb.append(", ").append(fieldsJson);
        sb.append(", ").append(languageUuid);
        sb.append(", ").append(edited);
        sb.append(", ").append(editorUuid);
        sb.append(", ").append(created);
        sb.append(", ").append(creatorUuid);
        sb.append(", ").append(modelversionUuid);
        sb.append(", ").append(version);

        sb.append(")");
        return sb.toString();
    }
}
