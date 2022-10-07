package net.hypnozcore.hypnozcore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FileUtilsTest {
	/**
	 * Method under test: {@link FileUtils#getMIMEType(String)}
	 */
	@Test
	void testGetMIMEType() {
		assertEquals("content/unknown", FileUtils.getMIMEType("Path Destination"));
	}
}

