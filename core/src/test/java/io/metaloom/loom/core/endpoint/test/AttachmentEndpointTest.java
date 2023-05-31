package io.metaloom.loom.core.endpoint.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.rest.model.attachment.AttachmentListResponse;
import io.metaloom.loom.rest.model.attachment.AttachmentResponse;
import io.metaloom.loom.rest.model.attachment.AttachmentUpdateRequest;
import io.metaloom.loom.test.TestEnvHelper;
import io.metaloom.loom.test.Testdata;

public class AttachmentEndpointTest extends AbstractCRUDEndpointTest {

	private static Testdata env;

	@BeforeAll
	public static void setupEnv() throws IOException {
		env = TestEnvHelper.prepareTestdata("attachment-test");
	}

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		AttachmentResponse response = client.loadAttachment(ATTACHMENT_UUID).sync();
	}

	@Override
	protected void testCreate(LoomHttpClient client) throws Exception {
		Path path = env.sampleVideo2Path();
		try (InputStream stream = Files.newInputStream(path)) {
			AttachmentResponse response = client.uploadAttachment(DUMMY_VIDEO_FILENAME, VIDEO_MIMETYPE, stream).sync();
		}
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteAttachment(ATTACHMENT_UUID).sync();
	}

	@Override
	protected void testUpdate(LoomHttpClient client) throws HttpErrorException {
		AttachmentUpdateRequest request = new AttachmentUpdateRequest();
		request.setFilename("new_filename.jpg");
		AttachmentResponse response = client.updateAttachment(ATTACHMENT_UUID, request).sync();
		assertEquals("new_filename.jpg", response.getFilename(), "The filename should have been updated.");
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws Exception {
		for (int i = 0; i < 10; i++) {
			Path path = env.sampleVideo2Path();
			try (InputStream stream = Files.newInputStream(path)) {
				AttachmentResponse response = client.uploadAttachment(DUMMY_VIDEO_FILENAME, VIDEO_MIMETYPE, stream).sync();
			}
		}
		AttachmentListResponse list = client.listAttachments().sync();
		System.out.println(Json.parse(list));

	}

}
