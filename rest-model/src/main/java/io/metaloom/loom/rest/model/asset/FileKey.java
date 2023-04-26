package io.metaloom.loom.rest.model.asset;

public class FileKey {

	private long inode;
	private long stDev;

	public long getInode() {
		return inode;
	}

	public FileKey setInode(long inode) {
		this.inode = inode;
		return this;
	}

	public long getStDev() {
		return stDev;
	}

	public FileKey setStDev(long stDev) {
		this.stDev = stDev;
		return this;
	}

}
