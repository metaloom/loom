/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.metaloom.loom.db.jooq.tables.interfaces.IModel;

import java.time.LocalDateTime;
import java.util.UUID;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Model implements VertxPojo, IModel {

    private static final long serialVersionUID = 1L;

    private UUID          uuid;
    private String        name;
    private UUID          latestVersionUuid;
    private LocalDateTime created;
    private UUID          creatorUuid;
    private LocalDateTime edited;
    private UUID          editorUuid;

    public Model() {}

    public Model(IModel value) {
        this.uuid = value.getUuid();
        this.name = value.getName();
        this.latestVersionUuid = value.getLatestVersionUuid();
        this.created = value.getCreated();
        this.creatorUuid = value.getCreatorUuid();
        this.edited = value.getEdited();
        this.editorUuid = value.getEditorUuid();
    }

    public Model(
        UUID          uuid,
        String        name,
        UUID          latestVersionUuid,
        LocalDateTime created,
        UUID          creatorUuid,
        LocalDateTime edited,
        UUID          editorUuid
    ) {
        this.uuid = uuid;
        this.name = name;
        this.latestVersionUuid = latestVersionUuid;
        this.created = created;
        this.creatorUuid = creatorUuid;
        this.edited = edited;
        this.editorUuid = editorUuid;
    }

        public Model(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>public.model.uuid</code>.
     */
    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>public.model.uuid</code>.
     */
    @Override
    public Model setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * Getter for <code>public.model.name</code>. Human readable name of the content model
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.model.name</code>. Human readable name of the content model
     */
    @Override
    public Model setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.model.latest_version_uuid</code>.
     */
    @Override
    public UUID getLatestVersionUuid() {
        return this.latestVersionUuid;
    }

    /**
     * Setter for <code>public.model.latest_version_uuid</code>.
     */
    @Override
    public Model setLatestVersionUuid(UUID latestVersionUuid) {
        this.latestVersionUuid = latestVersionUuid;
        return this;
    }

    /**
     * Getter for <code>public.model.created</code>.
     */
    @Override
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Setter for <code>public.model.created</code>.
     */
    @Override
    public Model setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    /**
     * Getter for <code>public.model.creator_uuid</code>.
     */
    @Override
    public UUID getCreatorUuid() {
        return this.creatorUuid;
    }

    /**
     * Setter for <code>public.model.creator_uuid</code>.
     */
    @Override
    public Model setCreatorUuid(UUID creatorUuid) {
        this.creatorUuid = creatorUuid;
        return this;
    }

    /**
     * Getter for <code>public.model.edited</code>.
     */
    @Override
    public LocalDateTime getEdited() {
        return this.edited;
    }

    /**
     * Setter for <code>public.model.edited</code>.
     */
    @Override
    public Model setEdited(LocalDateTime edited) {
        this.edited = edited;
        return this;
    }

    /**
     * Getter for <code>public.model.editor_uuid</code>.
     */
    @Override
    public UUID getEditorUuid() {
        return this.editorUuid;
    }

    /**
     * Setter for <code>public.model.editor_uuid</code>.
     */
    @Override
    public Model setEditorUuid(UUID editorUuid) {
        this.editorUuid = editorUuid;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Model (");

        sb.append(uuid);
        sb.append(", ").append(name);
        sb.append(", ").append(latestVersionUuid);
        sb.append(", ").append(created);
        sb.append(", ").append(creatorUuid);
        sb.append(", ").append(edited);
        sb.append(", ").append(editorUuid);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IModel from) {
        setUuid(from.getUuid());
        setName(from.getName());
        setLatestVersionUuid(from.getLatestVersionUuid());
        setCreated(from.getCreated());
        setCreatorUuid(from.getCreatorUuid());
        setEdited(from.getEdited());
        setEditorUuid(from.getEditorUuid());
    }

    @Override
    public <E extends IModel> E into(E into) {
        into.from(this);
        return into;
    }
}
