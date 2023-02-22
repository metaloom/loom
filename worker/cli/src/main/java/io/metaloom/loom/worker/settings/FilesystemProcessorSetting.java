package io.metaloom.loom.worker.settings;

import io.metaloom.loom.action.thumbnail.ThumbnailActionSettings;
import io.metaloom.loom.worker.actions.ConsistencyActionSettings;
import io.metaloom.loom.worker.actions.FacedetectActionSettings;
import io.metaloom.worker.action.fp.FingerprintActionSettings;
import io.metaloom.worker.action.hash.HashActionSettings;
import io.metaloom.worker.action.settings.ProcessorSettings;

public class FilesystemProcessorSetting {

	private ProcessorSettings processorSettings;

	private ThumbnailActionSettings thumbnailSettings;

	private HashActionSettings hashSettings;

	private ConsistencyActionSettings consistencySettings;

	private FingerprintActionSettings fingerprintActionSettings;

	private FacedetectActionSettings facedetectActionSettings;

	public HashActionSettings getHashSettings() {
		return hashSettings;
	}

	public FilesystemProcessorSetting setHashSettings(HashActionSettings hashSettings) {
		this.hashSettings = hashSettings;
		return this;
	}

	public ConsistencyActionSettings getConsistencySettings() {
		return consistencySettings;
	}

	public FilesystemProcessorSetting setConsistencySettings(ConsistencyActionSettings consistencySettings) {
		this.consistencySettings = consistencySettings;
		return this;
	}

	public FacedetectActionSettings getFacedetectActionSettings() {
		return facedetectActionSettings;
	}

	public FilesystemProcessorSetting setFacedetectActionSettings(FacedetectActionSettings facedetectActionSettings) {
		this.facedetectActionSettings = facedetectActionSettings;
		return this;
	}

	public FingerprintActionSettings getFingerprintActionSettings() {
		return fingerprintActionSettings;
	}

	public FilesystemProcessorSetting setFingerprintActionSettings(FingerprintActionSettings fingerprintActionSettings) {
		this.fingerprintActionSettings = fingerprintActionSettings;
		return this;
	}

	public ThumbnailActionSettings getThumbnailSettings() {
		return thumbnailSettings;
	}

	public FilesystemProcessorSetting setThumbnailSettings(ThumbnailActionSettings thumbnailSettings) {
		this.thumbnailSettings = thumbnailSettings;
		return this;
	}

	public ProcessorSettings getProcessorSettings() {
		return processorSettings;
	}

	public FilesystemProcessorSetting setProcessorSettings(ProcessorSettings processorSettings) {
		this.processorSettings = processorSettings;
		return this;
	}
}
