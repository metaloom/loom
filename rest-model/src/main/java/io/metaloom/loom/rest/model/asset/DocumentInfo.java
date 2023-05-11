package io.metaloom.loom.rest.model.asset;

import io.metaloom.loom.rest.model.RestModel;

public class DocumentInfo implements RestModel {

	private Long wordCount;

	public Long getWordCount() {
		return wordCount;
	}

	public DocumentInfo setWordCount(Long documentWordCount) {
		this.wordCount = documentWordCount;
		return this;
	}

}
