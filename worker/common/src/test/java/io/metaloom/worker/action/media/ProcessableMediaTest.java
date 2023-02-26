package io.metaloom.worker.action.media;

import static io.metaloom.worker.action.ProcessableMediaMeta.FACES;
import static io.metaloom.worker.action.ProcessableMediaMeta.SHA_512;
import static io.metaloom.worker.action.ProcessableMediaMeta.ZERO_CHUNK_COUNT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.metaloom.worker.action.ProcessableMedia;

public class ProcessableMediaTest extends AbstractWorkerTest {

	@Test
	public void testGetSet() throws IOException {
		ProcessableMedia media = createTestMediaFile();
		assertNull(media.get(SHA_512));
		media.put(SHA_512, "abcd");
		assertEquals("abcd", media.get(SHA_512));
		assertEquals(1, media.listXAttr().size());
	}

	@Test
	public void testGetSetUpdateString() throws IOException {
		ProcessableMedia media = createTestMediaFile();
		assertNull(media.get(SHA_512));
		media.put(SHA_512, "abcd");
		assertEquals("abcd", media.get(SHA_512));
		media.put(SHA_512, "dcba");
		assertEquals("dcba", media.get(SHA_512));
		assertEquals(1, media.listXAttr().size());
	}

	@Test
	public void testBasics() throws IOException {
		ProcessableMedia media = createTestMediaFile();
		assertTrue(media.exists());
	}

	@Test
	public void testGetSetUpdateLong() throws IOException {
		ProcessableMedia media = createTestMediaFile();
		assertNull(media.get(ZERO_CHUNK_COUNT));
		media.put(ZERO_CHUNK_COUNT, 42L);
		Long value1 = media.get(ZERO_CHUNK_COUNT);
		assertEquals(42L, value1.longValue());
		media.put(ZERO_CHUNK_COUNT, 43L);
		Long value2 = media.get(ZERO_CHUNK_COUNT);
		assertEquals(43L, value2.longValue());
		assertEquals(1, media.listXAttr().size());
	}

	@Test
	public void testGetSetUpdateList() throws IOException {
		ProcessableMedia media = createTestMediaFile();
		assertNull(media.get(FACES));
		List<String> list = new ArrayList<>();
		list.add("test1");

		media.put(FACES, list);
		List<String> value1 = media.get(FACES);
		assertEquals("test1", value1.get(0));

		List<String> list2 = new ArrayList<>();
		list2.add("test2");
		media.put(FACES, list2);
		List<String> value2 = media.get(FACES);
		assertEquals("test2", value2.get(0));
		assertEquals(0, media.listXAttr().size());
	}

}
