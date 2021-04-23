package io.metaloom.loom.rest.model.asset;

public enum AssetStatus {

	/**
	 * The asset has been queued for processing.
	 */
	QUEUED,

	/**
	 * The asset is being processed.
	 */
	PROCESSING,

	/**
	 * The asset has been processed without error.
	 */
	PROCESSED,

	/**
	 * Processing of the asset has failed.
	 */
	FAILED;
}
