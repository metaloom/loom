package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.binary.Binary;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.asset.HashInfo;
import io.metaloom.loom.rest.model.binary.AudioInfo;
import io.metaloom.loom.rest.model.binary.BinaryListResponse;
import io.metaloom.loom.rest.model.binary.BinaryResponse;
import io.metaloom.loom.rest.model.binary.DocumentInfo;
import io.metaloom.loom.rest.model.binary.ImageInfo;
import io.metaloom.loom.rest.model.binary.VideoInfo;

public interface BinaryModelBuilder extends ModelBuilder, UserModelBuilder {

	default BinaryResponse toResponse(Binary binary) {
		BinaryResponse response = new BinaryResponse();
		response.setUuid(binary.getUuid());

		response.setHashes(binaryHasheInfo(binary));
		response.setSize(binary.getSize());

		response.setImage(binaryImageInfo(binary));
		response.setVideo(binaryVideoInfo(binary));
		response.setAudio(binaryAudioInfo(binary));
		response.setDocument(binaryDocumentInfo(binary));

		response.setOrigin(binary.getInitialOrigin());
		response.setMeta(binary.getMeta());

		setStatus(binary, response);
		return response;
	}

	default HashInfo binaryHasheInfo(Binary binary) {
		HashInfo hashes = new HashInfo();
		hashes.setSha512(binary.getSHA512());
		hashes.setSha256(binary.getSHA256());
		hashes.setMD5(binary.getMD5());
		return hashes;
	}

	default DocumentInfo binaryDocumentInfo(Binary binary) {
		DocumentInfo info = new DocumentInfo();
		info.setWordCount(binary.getDocumentWordCount());
		return info;
	}

	default AudioInfo binaryAudioInfo(Binary binary) {
		AudioInfo info = new AudioInfo();
		info.setBpm(binary.getAudioBPM());
		info.setChannels(binary.getAudioChannels());
		info.setDuration(binary.getMediaDuration());
		info.setEncoding(binary.getAudioEncoding());
		info.setFingerprint(binary.getAudioFingerprint());
		info.setSamplingRate(binary.getAudioSamplingRate());
		return info;
	}

	default VideoInfo binaryVideoInfo(Binary binary) {
		VideoInfo info = new VideoInfo();
		info.setDuration(binary.getMediaDuration());
		// TODO use dedicated /binary/:uuid/embeddings endpoint for this
		//info.setEmbeddings();
		info.setEncoding(binary.getVideoEncoding());
		info.setFingerprint(binary.getVideoFingerprint());
		info.setHeight(binary.getMediaHeight());
		info.setWidth(binary.getMediaWidth());
		return info;
	}

	default ImageInfo binaryImageInfo(Binary binary) {
		ImageInfo info = new ImageInfo();
		info.setDominantColor(binary.getDominantColor());
		info.setHeight(binary.getMediaHeight());
		info.setWidth(binary.getMediaWidth());
		return info;
	}

	default BinaryListResponse toBinaryList(Page<Binary> page) {
		return setPage(new BinaryListResponse(), page, binary -> {
			return toResponse(binary);
		});
	}
}
