package io.metaloom.loom.db.jooq.dao.asset;

import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqAssetBinarie;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.asset.LoomAssetBinary;

public class LoomAssetBinaryImpl extends AbstractWrappedElement<JooqAssetBinarie> implements LoomAssetBinary  {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAssetBinary setSHA512(String hashsum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSHA256() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAssetBinary setSHA256(String hashsum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMD5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAssetBinary setMD5(String hashsum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMediaWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAssetBinary setMediaWidth(Integer width) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMediaHeight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAssetBinary setMediaHeight(Integer height) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFingerprint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAssetBinary setFingerprint(String fingerprint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LoomAssetBinary setSize(long size) {
		// TODO Auto-generated method stub
		return null;
	}
}
