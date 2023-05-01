package io.metaloom.loom.db.jooq.dao.asset.bin;

import java.math.BigDecimal;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqBinary;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.asset.Binary;

public class BinaryImpl extends AbstractWrappedElement<JooqBinary> implements Binary {

	public BinaryImpl(JooqBinary delegate) {
		super(delegate);
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Binary setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public String getSHA512() {
		return delegate().getSha512sum();
	}

	@Override
	public Binary setSHA512(String hashsum) {
		delegate().setSha512sum(hashsum);
		return this;
	}

	@Override
	public String getSHA256() {
		return delegate().getSha256sum();
	}

	@Override
	public Binary setSHA256(String hashsum) {
		delegate().setSha256sum(hashsum);
		return this;
	}

	@Override
	public String getMD5() {
		return delegate().getMd5sum();
	}

	@Override
	public Binary setMD5(String hashsum) {
		delegate().setMd5sum(hashsum);
		return this;
	}

	@Override
	public String getChunkHash() {
		return delegate().getChunkHash();
	}

	@Override
	public Binary setChunkHash(String chunkHash) {
		delegate().setChunkHash(chunkHash);
		return this;
	}

	@Override
	public long getZeroChunkCount() {
		return delegate().getZeroChunkCount();
	}

	@Override
	public Binary setZeroChunkCount(long zeroChunkCount) {
		delegate().setZeroChunkCount(zeroChunkCount);
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return delegate().getMediaWidth();
	}

	@Override
	public Binary setMediaWidth(Integer width) {
		delegate().setMediaWidth(width);
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return delegate().getMediaHeight();
	}

	@Override
	public Binary setMediaHeight(Integer height) {
		delegate().setMediaHeight(height);
		return this;
	}

	@Override
	public String getVideoFingerprint() {
		return delegate().getVideoFingerprint();
	}

	@Override
	public Binary setVideoFingerprint(String fingerprint) {
		delegate().setVideoFingerprint(fingerprint);
		return this;
	}

	@Override
	public String getAudioFingerprint() {
		return delegate().getAudioFingerprint();
	}

	@Override
	public Binary setAudioFingerprint(String fingerprint) {
		delegate().setAudioFingerprint(fingerprint);
		return this;
	}

	@Override
	public long getSize() {
		return delegate().getSize();
	}

	@Override
	public Binary setSize(long size) {
		delegate().setSize(size);
		return this;
	}

	@Override
	public String getS3BucketName() {
		return delegate().getS3BucketName();
	}

	@Override
	public Binary setS3BucketName(String bucketName) {
		delegate().setS3BucketName(bucketName);
		return this;
	}

	@Override
	public String getS3ObjectPath() {
		return delegate().getS3ObjectPath();
	}

	@Override
	public Binary setS3ObjectPath(String path) {
		delegate().setS3ObjectPath(path);
		return this;
	}

	@Override
	public String getDominantColor() {
		return delegate().getImageDominantColor();
	}

	@Override
	public Binary setDominantColor(String color) {
		delegate().setImageDominantColor(color);
		return this;
	}

	@Override
	public BigDecimal getGeoLat() {
		return delegate().getGeoLat();
	}

	@Override
	public Binary setGeoLat(BigDecimal lat) {
		delegate().setGeoLat(lat);
		return this;
	}

	@Override
	public BigDecimal getGeoLon() {
		return delegate().getGeoLon();
	}

	@Override
	public Binary setGeoLon(BigDecimal lon) {
		delegate().setGeoLon(lon);
		return this;
	}
	//

	@Override
	public String getMimeType() {
		return delegate().getMimeType();
	}

	@Override
	public Binary setMimeType(String mimeType) {
		delegate().setMimeType(mimeType);
		return this;
	}
}
