package io.metaloom.loom.db.jooq.dao.asset;

import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqAssetBinarie;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.asset.LoomAssetBinary;

public class LoomAssetBinaryImpl extends AbstractWrappedElement<JooqAssetBinarie> implements LoomAssetBinary {

	public LoomAssetBinaryImpl(JooqAssetBinarie delegate) {
		super(delegate);
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public LoomAssetBinary setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public String getSHA512() {
		return delegate().getSha512sum();
	}

	@Override
	public LoomAssetBinary setSHA512(String hashsum) {
		delegate().setSha512sum(hashsum);
		return this;
	}

	@Override
	public String getSHA256() {
		return delegate().getSha256sum();
	}

	@Override
	public LoomAssetBinary setSHA256(String hashsum) {
		delegate().setSha256sum(hashsum);
		return this;
	}

	@Override
	public String getMD5() {
		return delegate().getMd5sum();
	}

	@Override
	public LoomAssetBinary setMD5(String hashsum) {
		delegate().setMd5sum(hashsum);
		return this;
	}

	@Override
	public String getChunkHash() {
		return delegate().getChunkhash();
	}

	@Override
	public LoomAssetBinary setChunkHash(String chunkHash) {
		delegate().setChunkhash(chunkHash);
		return this;
	}

	@Override
	public long getZeroChunkCount() {
		return delegate().getZeroChunkCount();
	}

	@Override
	public LoomAssetBinary setZeroChunkCount(long zeroChunkCount) {
		delegate().setZeroChunkCount(zeroChunkCount);
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return delegate().getMediaWidth();
	}

	@Override
	public LoomAssetBinary setMediaWidth(Integer width) {
		delegate().setMediaWidth(width);
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return delegate().getMediaHeight();
	}

	@Override
	public LoomAssetBinary setMediaHeight(Integer height) {
		delegate().setMediaHeight(height);
		return this;
	}

	@Override
	public String getFingerprint() {
		return delegate().getFingerprint();
	}

	@Override
	public LoomAssetBinary setFingerprint(String fingerprint) {
		delegate().setFingerprint(fingerprint);
		return this;
	}

	@Override
	public long getSize() {
		return delegate().getSize();
	}

	@Override
	public LoomAssetBinary setSize(long size) {
		delegate().setSize(size);
		return this;
	}
}
