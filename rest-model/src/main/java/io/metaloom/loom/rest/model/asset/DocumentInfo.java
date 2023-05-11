package io.metaloom.loom.rest.model.asset;

import io.metaloom.loom.rest.model.RestModel;

public class DocumentInfo implements RestModel {

	private long wordCount;

	public long getWordCount() {
		return wordCount;
	}

	public DocumentInfo setWordCount(long documentWordCount) {
		this.wordCount = documentWordCount;
		return this;
	}

}
