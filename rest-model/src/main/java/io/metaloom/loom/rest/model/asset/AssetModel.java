
package io.metaloom.loom.rest.model.asset;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.asset.info.AudioInfo;
import io.metaloom.loom.rest.model.asset.info.ConsistencyInfo;
import io.metaloom.loom.rest.model.asset.info.DocumentInfo;
import io.metaloom.loom.rest.model.asset.info.FileInfo;
import io.metaloom.loom.rest.model.asset.info.GeoLocationInfo;
import io.metaloom.loom.rest.model.asset.info.HashInfo;
import io.metaloom.loom.rest.model.asset.info.ImageInfo;
import io.metaloom.loom.rest.model.asset.info.MediaInfo;
import io.metaloom.loom.rest.model.asset.info.VideoInfo;
import io.metaloom.utils.hash.SHA512Sum;

public interface AssetModel<T extends AssetModel<T>> extends MetaModel<T> {

	GeoLocationInfo getGeo();

	T setGeo(GeoLocationInfo geo);

	DocumentInfo getDocument();

	T setDocument(DocumentInfo document);

	VideoInfo getVideo();

	T setVideo(VideoInfo video);

	ImageInfo getImage();

	T setImage(ImageInfo image);

	AudioInfo getAudio();

	T setAudio(AudioInfo audio);

	HashInfo getHashes();

	T setHashes(HashInfo hashes);

	FileInfo getFile();

	T setFile(FileInfo file);

	MediaInfo getMedia();

	T setMedia(MediaInfo media);

	ConsistencyInfo getConsistency();

	T setConsistency(ConsistencyInfo consistency);

	@JsonIgnore
	default T setRequired(String filename, String mimeType, SHA512Sum hashsum, long size, String origin) {
		if (getFile() == null) {
			setFile(new FileInfo());
		}
		getFile().setFilename(filename).setSize(size).setMimeType(mimeType).setOrigin(origin);
		if (getHashes() == null) {
			setHashes(new HashInfo());
		}
		getHashes().setSha512(hashsum.toString());
		return self();
	}

	@JsonIgnore
	default T setVideoFingerprint(String fingerprint) {
		if (getVideo() == null) {
			setVideo(new VideoInfo());
		}
		getVideo().setFingerprint(fingerprint);
		return self();
	}
}
