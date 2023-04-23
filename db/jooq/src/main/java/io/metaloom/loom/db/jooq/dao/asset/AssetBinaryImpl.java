package io.metaloom.loom.db.jooq.dao.asset;

import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqAssetBinarie;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.asset.AssetBinary;

public class AssetBinaryImpl extends AbstractWrappedElement<JooqAssetBinarie> implements AssetBinary {

	public AssetBinaryImpl(JooqAssetBinarie delegate) {
		super(delegate);
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public AssetBinary setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public String getSHA512() {
		return delegate().getSha512sum();
	}

	@Override
	public AssetBinary setSHA512(String hashsum) {
		delegate().setSha512sum(hashsum);
		return this;
	}

	@Override
	public String getSHA256() {
		return delegate().getSha256sum();
	}

	@Override
	public AssetBinary setSHA256(String hashsum) {
		delegate().setSha256sum(hashsum);
		return this;
	}

	@Override
	public String getMD5() {
		return delegate().getMd5sum();
	}

	@Override
	public AssetBinary setMD5(String hashsum) {
		delegate().setMd5sum(hashsum);
		return this;
	}

	@Override
	public String getChunkHash() {
		return delegate().getChunkhash();
	}

	@Override
	public AssetBinary setChunkHash(String chunkHash) {
		delegate().setChunkhash(chunkHash);
		return this;
	}

	@Override
	public long getZeroChunkCount() {
		return delegate().getZeroChunkCount();
	}

	@Override
	public AssetBinary setZeroChunkCount(long zeroChunkCount) {
		delegate().setZeroChunkCount(zeroChunkCount);
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return delegate().getMediaWidth();
	}

	@Override
	public AssetBinary setMediaWidth(Integer width) {
		delegate().setMediaWidth(width);
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return delegate().getMediaHeight();
	}

	@Override
	public AssetBinary setMediaHeight(Integer height) {
		delegate().setMediaHeight(height);
		return this;
	}

	@Override
	public String getFingerprint() {
		return delegate().getFingerprint();
	}

	@Override
	public AssetBinary setFingerprint(String fingerprint) {
		delegate().setFingerprint(fingerprint);
		return this;
	}

	@Override
	public long getSize() {
		return delegate().getSize();
	}

	@Override
	public AssetBinary setSize(long size) {
		delegate().setSize(size);
		return this;
	}
}
