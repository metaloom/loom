package io.metaloom.loom.test.assertj;

import static io.metaloom.worker.action.api.ProcessableMediaMeta.ZERO_CHUNK_COUNT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.AbstractAssert;

import io.metaloom.worker.action.api.ProcessableMedia;
import io.metaloom.worker.action.api.ProcessableMediaMeta;

public class ProcessableMediaAssert extends AbstractAssert<ProcessableMediaAssert, ProcessableMedia> {

	protected ProcessableMediaAssert(ProcessableMedia actual) {
		super(actual, ProcessableMediaAssert.class);
	}

	public ProcessableMediaAssert hasXAttr(String key) {
		String fullKey = ProcessableMediaMeta.fullKey(key);
		assertTrue("The attr " + fullKey + " was not found in the media file.", actual.listXAttr().contains(fullKey));
		return this;
	}

	public ProcessableMediaAssert hasXAttr(ProcessableMediaMeta... metas) {
		for (ProcessableMediaMeta meta : metas) {
			assertTrue("The key is not enabled for persistance via xattr. It should thus not be present and must not be checked", meta.isPersisted());
			String fullKey = meta.key();
			assertTrue("The attr " + fullKey + " was not found in the media file.", actual.listXAttr().contains(fullKey));
		}
		return this;
	}

	public ProcessableMediaAssert printXAttrKeys() {
		actual.listXAttr().forEach(System.out::println);
		return this;
	}

	public ProcessableMediaAssert hasXAttr(int count) {
		assertEquals("The count of xattr did not match the expected count.", count, actual.listXAttr().size());
		return this;
	}

	public ProcessableMediaAssert hasXAttr(ProcessableMediaMeta meta, String value) {
		String actualValue = actual.get(meta);
		assertNotNull("Did not find attribute value for " + meta, actualValue);
		assertEquals("The value for " + meta + " did not match up.", value, actualValue);
		return this;
	}

	public ProcessableMediaAssert hasXAttr(ProcessableMediaMeta meta, long value) {
		Long actualValue = actual.get(meta);
		assertNotNull("Did not find attribute value for " + meta, actualValue);
		assertEquals("The value for " + meta + " did not match up.", value, actualValue.longValue());
		return this;
	}

	public ProcessableMediaAssert isConsistent() {
		hasXAttr(ZERO_CHUNK_COUNT, 0L);
		return this;
	}

}
