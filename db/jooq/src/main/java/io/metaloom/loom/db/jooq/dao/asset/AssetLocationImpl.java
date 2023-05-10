package io.metaloom.loom.db.jooq.dao.asset;

import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.asset.AssetLocation;

public class AssetLocationImpl extends AbstractEditableElement<AssetLocation> implements AssetLocation {

	private String path;

	private UUID binaryUuid;

	private String mimeType;

	private Long filekeyInode;

	private long filekeyStDev;

	private Long filekeyEdate;

	private Long filekeyEdateNano;

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public AssetLocation setPath(String path) {
		this.path = path;
		return this;
	}

	@Override
	public UUID getBinaryUuid() {
		return binaryUuid;
	}

	@Override
	public AssetLocation setBinaryUuid(UUID binaryUuid) {
		this.binaryUuid = binaryUuid;
		return this;
	}

	@Override
	public String getMimeType() {
		return mimeType;
	}

	@Override
	public AssetLocation setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	@Override
	public Long getFilekeyInode() {
		return filekeyInode;
	}

	@Override
	public AssetLocation setFilekeyInode(Long inode) {
		this.filekeyInode = inode;
		return this;
	}

	@Override
	public Long getFilekeyStDev() {
		return filekeyStDev;
	}

	@Override
	public AssetLocation setFilekeyStDev(Long stDev) {
		this.filekeyStDev = stDev;
		return this;
	}

	@Override
	public Long getFilekeyEdate() {
		return filekeyEdate;
	}

	@Override
	public AssetLocation setFilekeyEdate(Long edate) {
		this.filekeyEdate = edate;
		return this;
	}

	@Override
	public Long getFilekeyEdateNano() {
		return filekeyEdateNano;
	}

	@Override
	public AssetLocation setFilekeyEdateNano(Long edate) {
		this.filekeyEdateNano = edate;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Asset [%s] - %s", getUuid(), getPath());
	}

}
