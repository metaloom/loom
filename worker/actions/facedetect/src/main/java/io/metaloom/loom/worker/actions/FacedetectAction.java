package io.metaloom.loom.worker.actions;

import static io.metaloom.worker.action.ActionResult.CONTINUE_NEXT;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.video.facedetect.Face;
import io.metaloom.video.facedetect.dlib.impl.DLibFacedetector;
import io.metaloom.worker.action.AbstractFilesystemAction;
import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.settings.ProcessorSettings;

public class FacedetectAction extends AbstractFilesystemAction<FacedetectActionSettings> {

	public static final Logger log = LoggerFactory.getLogger(FacedetectAction.class);

	private static final String NAME = "facedetect";
	protected final DLibFacedetector detector;

	public FacedetectAction(LoomGRPCClient client, ProcessorSettings processorSettings, FacedetectActionSettings settings) throws FileNotFoundException {
		super(client, processorSettings, settings);
		this.detector = DLibFacedetector.create();
		this.detector.setMinFaceHeightFactor(0.05f);
	}

	@Override
	public String name() {
		return NAME;
	}

	@Override
	public ActionResult process(ProcessableMedia media) {
		long start = System.currentTimeMillis();
		try {
			if (media.isVideo()) {
				return processVideo(media);
			} else if (media.isImage()) {
				return processImage(media);
			} else {
				return skipped(media, start, "is unprocessable media type");
			}
		} catch (Exception e) {
			log.error("Failed to process media", e);
			return ActionResult.failed(CONTINUE_NEXT, start);
		}
	}

	private ActionResult processImage(ProcessableMedia media) throws IOException {
		// 1. Read image
		BufferedImage image = ImageIO.read(media.file());
		List<? extends Face> result = detector.detect(image);
		// TODO handle faces / get embeddings
		return null;
	}

	private ActionResult processVideo(ProcessableMedia media) {
		return null;
	}

}
