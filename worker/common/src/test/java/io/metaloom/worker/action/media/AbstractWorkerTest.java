package io.metaloom.worker.action.media;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.ResultState;

public abstract class AbstractWorkerTest {

	public ProcessableMedia createTestMediaFile() throws IOException {
		File file = File.createTempFile("processable-media-test", "file");
		return new ProcessableMediaImpl(file.toPath());
	}

	public void assertProcessed(ActionResult result) {
		assertEquals("The action was not in stat processed.", ResultState.PROCESSED, result.getState());
	}
	
	public void assertSkipped(ActionResult result) {
		assertEquals("The action was not in stat skipped.", ResultState.SKIPPED, result.getState());
	}

}
