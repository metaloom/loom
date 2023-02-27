package io.metaloom.loom.worker.action.facedetect;

import static io.metaloom.loom.test.assertj.LoomWorkerAssertions.assertThat;
import static io.metaloom.worker.action.api.ProcessableMediaMeta.FACES;
import static io.metaloom.worker.action.api.ProcessableMediaMeta.SHA_512;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.loom.test.TestEnvHelper;
import io.metaloom.loom.test.Testdata;
import io.metaloom.video.facedetect.Face;
import io.metaloom.worker.action.api.ActionResult;
import io.metaloom.worker.action.api.ProcessableMedia;
import io.metaloom.worker.action.common.settings.ProcessorSettings;
import io.metaloom.worker.action.media.AbstractWorkerTest;
import io.metaloom.worker.action.media.LoomClientMock;

public class FacedetectActionTest extends AbstractWorkerTest {

	@Test
	public void testAction() throws IOException {
		FacedetectAction action = mockAction();
		Testdata data = TestEnvHelper.prepareTestdata("action-test");
		ProcessableMedia media = sampleVideoMedia3(data);
		ActionResult result = action.process(media);
		assertThat(result).isProcessed();
		assertThat(media).hasXAttr(1).hasXAttr(SHA_512);
		List<Face> faces = media.get(FACES);
		System.out.println("Faces: " + faces.size());
	}

	public FacedetectAction mockAction() throws FileNotFoundException {
		LoomGRPCClient client = LoomClientMock.mockGrpcClient();
		return new FacedetectAction(client, new ProcessorSettings(),
			new FacedetectActionSettings().setMinFaceHeightFactor(0.05f).setVideoScaleSize(512));
	}
}
