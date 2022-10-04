package net.hypnozcore.hypnozcore.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OsUtilsTest {
    /**
     * Method under test: {@link OsUtils#getOsType()}
     */
    @Test
    void testGetOsType() {
        assertEquals(1, OsUtils.getOsType());
    }

    /**
     * Method under test: {@link OsUtils#getOsPath(String)}
     */
    @Test
    void testGetOsPath() {
        assertEquals("foo/", OsUtils.getOsPath("foo"));
    }

    /**
     * Method under test: {@link OsUtils#getOsHomeDir()}
     */
    @Test
    void testGetOsHomeDir() {
        assertEquals("/opt/hypnozcore/", OsUtils.getOsHomeDir());
    }

    /**
     * Method under test: {@link OsUtils#getTempDir()}
     */
    @Test
    void testGetTempDir() {
        assertEquals("/opt/hypnozcore//temps", OsUtils.getTempDir());
    }
}

