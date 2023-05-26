
package io.metaloom.loom.rest.model.asset;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.asset.info.AudioInfo;
import io.metaloom.loom.rest.model.asset.info.DocumentInfo;
import io.metaloom.loom.rest.model.asset.info.FileInfo;
import io.metaloom.loom.rest.model.asset.info.GeoLocationInfo;
import io.metaloom.loom.rest.model.asset.info.HashInfo;
import io.metaloom.loom.rest.model.asset.info.ImageInfo;
import io.metaloom.loom.rest.model.asset.info.VideoInfo;

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

}
