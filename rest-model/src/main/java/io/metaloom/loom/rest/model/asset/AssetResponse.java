package io.metaloom.loom.rest.model.asset;

import java.util.List;
import java.util.Map;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class AssetResponse extends AbstractCreatorEditorRestResponse {

	private AssetStatus status;

	private AssetKind kind;

	private AssetHash hashes;

	private String fileName;

	private long size;

	private String mimeType;

	private String dominantColor;

	private Map<String, String> meta;

	private AssetLocation location;

	private long duration;

	private List<AssetTimelineEntry> timeline;

	public AssetResponse() {
	}

	public AssetStatus getStatus() {
		return status;
	}

	public AssetResponse setStatus(AssetStatus status) {
		this.status = status;
		return this;
	}

	public AssetKind getKind() {
		return kind;
	}

	public AssetResponse setKind(AssetKind kind) {
		this.kind = kind;
		return this;
	}

	public AssetHash getHashes() {
		return hashes;
	}

	public AssetResponse setHashes(AssetHash hashes) {
		this.hashes = hashes;
		return this;
	}

}
