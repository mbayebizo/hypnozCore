package net.hypnozcore.hypnozcore.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {
	/**
	 * Method under test: {@link FileUtils#getMIMEType(String)}
	 */
	@Test
	void testGetMIMEType() {
		assertEquals("content/unknown", FileUtils.getMIMEType("Path Destination"));
	}
}

