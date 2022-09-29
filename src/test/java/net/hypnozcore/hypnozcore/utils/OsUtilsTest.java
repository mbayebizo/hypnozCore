package net.hypnozcore.hypnozcore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
        assertEquals("/", OsUtils.getOsPath("\\"));
        assertEquals("//", OsUtils.getOsPath("\\\\"));
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

