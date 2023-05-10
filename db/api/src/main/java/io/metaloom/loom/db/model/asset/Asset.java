package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;
import io.metaloom.loom.db.Taggable;

public interface Asset extends CUDElement<Asset>, Taggable, MetaElement<Asset> {

	/**
	 * Return the filesystem path of the asset.
	 * 
	 * @return
	 */
	String getPath();

	/**
	 * Set the filesystem path of the asset.
	 * 
	 * @param filename
	 * @return Fluent API
	 */
	Asset setPath(String filename);

	UUID getBinaryUuid();

	Asset setBinaryUuid(UUID binaryUuid);

	String getMimeType();

	Asset setMimeType(String mimeType);

	Long getFilekeyInode();

	Asset setFilekeyInode(Long inode);

	Long getFilekeyStDev();

	Asset setFilekeyStDev(Long stDev);

	Long getFilekeyEdate();

	Asset setFilekeyEdate(Long edate);

	Long getFilekeyEdateNano();

	Asset setFilekeyEdateNano(Long edate);

}
