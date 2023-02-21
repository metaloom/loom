package io.metaloom.worker.action;

import java.io.File;
import java.nio.file.Path;

public interface ProcessableMedia extends SHA256File {

	boolean isVideo();

	boolean isImage();

	boolean isAudio();

	File file();

	Path path();

	String absolutePath();

	boolean exists();

	String readAttrStr(String attrKey);

	Long readAttrLong(String attrKey);

	ProcessableMedia writeAttr(String attrKey, String value);

	ProcessableMedia writeAttr(String attrKey, Long value);

	String getHash512();

}
