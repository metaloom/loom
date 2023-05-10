package io.metaloom.loom.rest.model.asset;

public class FileKey {

	private long inode;
	private long stDev;
	private long edate;
	private long edateNano;

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

	public long getEdate() {
		return edate;
	}

	public FileKey setEDate(Long edate) {
		this.edate = edate;
		return this;
	}

	public long getEdateNano() {
		return edateNano;
	}

	public FileKey setEDateNano(Long edateNano) {
		this.edateNano = edateNano;
		return this;
	}

}
