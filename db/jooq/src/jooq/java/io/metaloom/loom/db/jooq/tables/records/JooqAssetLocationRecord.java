/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqAssetLocation;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Assets keep track of media that has been found by the scanner. Multiple
 * asset_locations may share the same asset thus the properties will be
 * decoupled from asset.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqAssetLocationRecord extends UpdatableRecordImpl<JooqAssetLocationRecord> implements Record16<UUID, UUID, String, Integer, Integer, Integer, Integer, String, String, String, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.asset_location.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.asset_location.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.asset_location.asset_uuid</code>. Reference to
     * the media asset for the asset_location.
     */
    public void setAssetUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.asset_location.asset_uuid</code>. Reference to
     * the media asset for the asset_location.
     */
    public UUID getAssetUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.asset_location.path</code>. Currently known path
     * to the asset_location in the filesystem
     */
    public void setPath(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.asset_location.path</code>. Currently known path
     * to the asset_location in the filesystem
     */
    public String getPath() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.asset_location.filekey_inode</code>.
     */
    public void setFilekeyInode(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.asset_location.filekey_inode</code>.
     */
    public Integer getFilekeyInode() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.asset_location.filekey_stdev</code>.
     */
    public void setFilekeyStdev(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.asset_location.filekey_stdev</code>.
     */
    public Integer getFilekeyStdev() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.asset_location.filekey_edate_nano</code>.
     */
    public void setFilekeyEdateNano(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.asset_location.filekey_edate_nano</code>.
     */
    public Integer getFilekeyEdateNano() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.asset_location.filekey_edate</code>.
     */
    public void setFilekeyEdate(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.asset_location.filekey_edate</code>.
     */
    public Integer getFilekeyEdate() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.asset_location.meta</code>. Custom meta
     * properties to the asset_location
     */
    public void setMeta(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.asset_location.meta</code>. Custom meta
     * properties to the asset_location
     */
    public String getMeta() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.asset_location.mime_type</code>.
     */
    public void setMimeType(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.asset_location.mime_type</code>.
     */
    public String getMimeType() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.asset_location.license</code>.
     */
    public void setLicense(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.asset_location.license</code>.
     */
    public String getLicense() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.asset_location.state</code>.
     */
    public void setState(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.asset_location.state</code>.
     */
    public String getState() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.asset_location.locked_by_uuid</code>.
     */
    public void setLockedByUuid(UUID value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.asset_location.locked_by_uuid</code>.
     */
    public UUID getLockedByUuid() {
        return (UUID) get(11);
    }

    /**
     * Setter for <code>public.asset_location.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.asset_location.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(12);
    }

    /**
     * Setter for <code>public.asset_location.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.asset_location.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(13);
    }

    /**
     * Setter for <code>public.asset_location.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.asset_location.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(14);
    }

    /**
     * Setter for <code>public.asset_location.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.asset_location.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row16<UUID, UUID, String, Integer, Integer, Integer, Integer, String, String, String, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    public Row16<UUID, UUID, String, Integer, Integer, Integer, Integer, String, String, String, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqAssetLocation.ASSET_LOCATION.UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqAssetLocation.ASSET_LOCATION.ASSET_UUID;
    }

    @Override
    public Field<String> field3() {
        return JooqAssetLocation.ASSET_LOCATION.PATH;
    }

    @Override
    public Field<Integer> field4() {
        return JooqAssetLocation.ASSET_LOCATION.FILEKEY_INODE;
    }

    @Override
    public Field<Integer> field5() {
        return JooqAssetLocation.ASSET_LOCATION.FILEKEY_STDEV;
    }

    @Override
    public Field<Integer> field6() {
        return JooqAssetLocation.ASSET_LOCATION.FILEKEY_EDATE_NANO;
    }

    @Override
    public Field<Integer> field7() {
        return JooqAssetLocation.ASSET_LOCATION.FILEKEY_EDATE;
    }

    @Override
    public Field<String> field8() {
        return JooqAssetLocation.ASSET_LOCATION.META;
    }

    @Override
    public Field<String> field9() {
        return JooqAssetLocation.ASSET_LOCATION.MIME_TYPE;
    }

    @Override
    public Field<String> field10() {
        return JooqAssetLocation.ASSET_LOCATION.LICENSE;
    }

    @Override
    public Field<String> field11() {
        return JooqAssetLocation.ASSET_LOCATION.STATE;
    }

    @Override
    public Field<UUID> field12() {
        return JooqAssetLocation.ASSET_LOCATION.LOCKED_BY_UUID;
    }

    @Override
    public Field<LocalDateTime> field13() {
        return JooqAssetLocation.ASSET_LOCATION.CREATED;
    }

    @Override
    public Field<UUID> field14() {
        return JooqAssetLocation.ASSET_LOCATION.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field15() {
        return JooqAssetLocation.ASSET_LOCATION.EDITED;
    }

    @Override
    public Field<UUID> field16() {
        return JooqAssetLocation.ASSET_LOCATION.EDITOR_UUID;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public UUID component2() {
        return getAssetUuid();
    }

    @Override
    public String component3() {
        return getPath();
    }

    @Override
    public Integer component4() {
        return getFilekeyInode();
    }

    @Override
    public Integer component5() {
        return getFilekeyStdev();
    }

    @Override
    public Integer component6() {
        return getFilekeyEdateNano();
    }

    @Override
    public Integer component7() {
        return getFilekeyEdate();
    }

    @Override
    public String component8() {
        return getMeta();
    }

    @Override
    public String component9() {
        return getMimeType();
    }

    @Override
    public String component10() {
        return getLicense();
    }

    @Override
    public String component11() {
        return getState();
    }

    @Override
    public UUID component12() {
        return getLockedByUuid();
    }

    @Override
    public LocalDateTime component13() {
        return getCreated();
    }

    @Override
    public UUID component14() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime component15() {
        return getEdited();
    }

    @Override
    public UUID component16() {
        return getEditorUuid();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public UUID value2() {
        return getAssetUuid();
    }

    @Override
    public String value3() {
        return getPath();
    }

    @Override
    public Integer value4() {
        return getFilekeyInode();
    }

    @Override
    public Integer value5() {
        return getFilekeyStdev();
    }

    @Override
    public Integer value6() {
        return getFilekeyEdateNano();
    }

    @Override
    public Integer value7() {
        return getFilekeyEdate();
    }

    @Override
    public String value8() {
        return getMeta();
    }

    @Override
    public String value9() {
        return getMimeType();
    }

    @Override
    public String value10() {
        return getLicense();
    }

    @Override
    public String value11() {
        return getState();
    }

    @Override
    public UUID value12() {
        return getLockedByUuid();
    }

    @Override
    public LocalDateTime value13() {
        return getCreated();
    }

    @Override
    public UUID value14() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime value15() {
        return getEdited();
    }

    @Override
    public UUID value16() {
        return getEditorUuid();
    }

    @Override
    public JooqAssetLocationRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value2(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value3(String value) {
        setPath(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value4(Integer value) {
        setFilekeyInode(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value5(Integer value) {
        setFilekeyStdev(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value6(Integer value) {
        setFilekeyEdateNano(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value7(Integer value) {
        setFilekeyEdate(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value8(String value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value9(String value) {
        setMimeType(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value10(String value) {
        setLicense(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value11(String value) {
        setState(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value12(UUID value) {
        setLockedByUuid(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value13(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value14(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value15(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord value16(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqAssetLocationRecord values(UUID value1, UUID value2, String value3, Integer value4, Integer value5, Integer value6, Integer value7, String value8, String value9, String value10, String value11, UUID value12, LocalDateTime value13, UUID value14, LocalDateTime value15, UUID value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqAssetLocationRecord
     */
    public JooqAssetLocationRecord() {
        super(JooqAssetLocation.ASSET_LOCATION);
    }

    /**
     * Create a detached, initialised JooqAssetLocationRecord
     */
    public JooqAssetLocationRecord(UUID uuid, UUID assetUuid, String path, Integer filekeyInode, Integer filekeyStdev, Integer filekeyEdateNano, Integer filekeyEdate, String meta, String mimeType, String license, String state, UUID lockedByUuid, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(JooqAssetLocation.ASSET_LOCATION);

        setUuid(uuid);
        setAssetUuid(assetUuid);
        setPath(path);
        setFilekeyInode(filekeyInode);
        setFilekeyStdev(filekeyStdev);
        setFilekeyEdateNano(filekeyEdateNano);
        setFilekeyEdate(filekeyEdate);
        setMeta(meta);
        setMimeType(mimeType);
        setLicense(license);
        setState(state);
        setLockedByUuid(lockedByUuid);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }
}