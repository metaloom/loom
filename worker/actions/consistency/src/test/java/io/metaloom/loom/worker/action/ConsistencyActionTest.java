package io.metaloom.loom.worker.action;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.loom.test.TestEnvHelper;
import io.metaloom.loom.worker.actions.ConsistencyAction;
import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.media.AbstractWorkerTest;
import io.metaloom.worker.action.media.LoomClientMock;
import io.metaloom.worker.action.media.ProcessableMediaImpl;

public class ConsistencyActionTest extends AbstractWorkerTest {

	@Test
	public void testSkipAction() throws IOException {
		ConsistencyAction action = new ConsistencyAction(null, null, null);
		ProcessableMedia media = createTestMediaFile();
		ActionResult result = action.process(media);
		assertSkipped(result);
	}

	@Test
	public void testProcessVideo() throws IOException {
		LoomGRPCClient client = LoomClientMock.mockGrpcClient();
		ConsistencyAction action = new ConsistencyAction(client, null, null);
		File testFolder = TestEnvHelper.prepareTestdata("action-test");
		ProcessableMedia media = new ProcessableMediaImpl(new File(testFolder, "folderA/folderB/pexels-jack-sparrow-5977265.mp4").toPath());
		ActionResult result = action.process(media);
		assertProcessed(result);
	}

}
