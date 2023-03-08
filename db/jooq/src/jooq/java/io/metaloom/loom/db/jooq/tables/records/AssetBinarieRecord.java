/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.AssetBinarie;
import io.metaloom.loom.db.jooq.tables.pojos.JooqAssetBinarie;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This table stores the immutable asset information
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetBinarieRecord extends UpdatableRecordImpl<AssetBinarieRecord> implements Record8<UUID, String, Long, String, String, Integer, Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.asset_binarie.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.asset_binarie.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.asset_binarie.sha512sum</code>.
     */
    public void setSha512sum(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.asset_binarie.sha512sum</code>.
     */
    public String getSha512sum() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.asset_binarie.size</code>.
     */
    public void setSize(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.asset_binarie.size</code>.
     */
    public Long getSize() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.asset_binarie.sha256sum</code>.
     */
    public void setSha256sum(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.asset_binarie.sha256sum</code>.
     */
    public String getSha256sum() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.asset_binarie.md5sum</code>.
     */
    public void setMd5sum(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.asset_binarie.md5sum</code>.
     */
    public String getMd5sum() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.asset_binarie.media_width</code>. Only set for
     * images
     */
    public void setMediaWidth(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.asset_binarie.media_width</code>. Only set for
     * images
     */
    public Integer getMediaWidth() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.asset_binarie.media_height</code>. Only set for
     * images
     */
    public void setMediaHeight(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.asset_binarie.media_height</code>. Only set for
     * images
     */
    public Integer getMediaHeight() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.asset_binarie.fingerprint</code>. Media
     * fingerprint information
     */
    public void setFingerprint(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.asset_binarie.fingerprint</code>. Media
     * fingerprint information
     */
    public String getFingerprint() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<UUID, String, Long, String, String, Integer, Integer, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<UUID, String, Long, String, String, Integer, Integer, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return AssetBinarie.ASSET_BINARIE.UUID;
    }

    @Override
    public Field<String> field2() {
        return AssetBinarie.ASSET_BINARIE.SHA512SUM;
    }

    @Override
    public Field<Long> field3() {
        return AssetBinarie.ASSET_BINARIE.SIZE;
    }

    @Override
    public Field<String> field4() {
        return AssetBinarie.ASSET_BINARIE.SHA256SUM;
    }

    @Override
    public Field<String> field5() {
        return AssetBinarie.ASSET_BINARIE.MD5SUM;
    }

    @Override
    public Field<Integer> field6() {
        return AssetBinarie.ASSET_BINARIE.MEDIA_WIDTH;
    }

    @Override
    public Field<Integer> field7() {
        return AssetBinarie.ASSET_BINARIE.MEDIA_HEIGHT;
    }

    @Override
    public Field<String> field8() {
        return AssetBinarie.ASSET_BINARIE.FINGERPRINT;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public String component2() {
        return getSha512sum();
    }

    @Override
    public Long component3() {
        return getSize();
    }

    @Override
    public String component4() {
        return getSha256sum();
    }

    @Override
    public String component5() {
        return getMd5sum();
    }

    @Override
    public Integer component6() {
        return getMediaWidth();
    }

    @Override
    public Integer component7() {
        return getMediaHeight();
    }

    @Override
    public String component8() {
        return getFingerprint();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public String value2() {
        return getSha512sum();
    }

    @Override
    public Long value3() {
        return getSize();
    }

    @Override
    public String value4() {
        return getSha256sum();
    }

    @Override
    public String value5() {
        return getMd5sum();
    }

    @Override
    public Integer value6() {
        return getMediaWidth();
    }

    @Override
    public Integer value7() {
        return getMediaHeight();
    }

    @Override
    public String value8() {
        return getFingerprint();
    }

    @Override
    public AssetBinarieRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public AssetBinarieRecord value2(String value) {
        setSha512sum(value);
        return this;
    }

    @Override
    public AssetBinarieRecord value3(Long value) {
        setSize(value);
        return this;
    }

    @Override
    public AssetBinarieRecord value4(String value) {
        setSha256sum(value);
        return this;
    }

    @Override
    public AssetBinarieRecord value5(String value) {
        setMd5sum(value);
        return this;
    }

    @Override
    public AssetBinarieRecord value6(Integer value) {
        setMediaWidth(value);
        return this;
    }

    @Override
    public AssetBinarieRecord value7(Integer value) {
        setMediaHeight(value);
        return this;
    }

    @Override
    public AssetBinarieRecord value8(String value) {
        setFingerprint(value);
        return this;
    }

    @Override
    public AssetBinarieRecord values(UUID value1, String value2, Long value3, String value4, String value5, Integer value6, Integer value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AssetBinarieRecord
     */
    public AssetBinarieRecord() {
        super(AssetBinarie.ASSET_BINARIE);
    }

    /**
     * Create a detached, initialised AssetBinarieRecord
     */
    public AssetBinarieRecord(UUID uuid, String sha512sum, Long size, String sha256sum, String md5sum, Integer mediaWidth, Integer mediaHeight, String fingerprint) {
        super(AssetBinarie.ASSET_BINARIE);

        setUuid(uuid);
        setSha512sum(sha512sum);
        setSize(size);
        setSha256sum(sha256sum);
        setMd5sum(md5sum);
        setMediaWidth(mediaWidth);
        setMediaHeight(mediaHeight);
        setFingerprint(fingerprint);
    }

    /**
     * Create a detached, initialised AssetBinarieRecord
     */
    public AssetBinarieRecord(JooqAssetBinarie value) {
        super(AssetBinarie.ASSET_BINARIE);

        if (value != null) {
            setUuid(value.getUuid());
            setSha512sum(value.getSha512sum());
            setSize(value.getSize());
            setSha256sum(value.getSha256sum());
            setMd5sum(value.getMd5sum());
            setMediaWidth(value.getMediaWidth());
            setMediaHeight(value.getMediaHeight());
            setFingerprint(value.getFingerprint());
        }
    }
}
