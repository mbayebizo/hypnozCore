package net.hypnozcore.hypnozcore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class FileUtilsTest {
    /**
     * Method under test: {@link FileUtils#copier(File, File)}
     */
    @Test
    void testCopier() {
        File source = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
        assertFalse(FileUtils.copier(source, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    }

    /**
     * Method under test: {@link FileUtils#existed(String)}
     */
    @Test
    void testExisted() {
        assertFalse(FileUtils.existed("Path Destination"));
    }

    /**
     * Method under test: {@link FileUtils#getFileExtension(File)}
     */
    @Test
    void testGetFileExtension() {
        assertEquals("txt",
                FileUtils.getFileExtension(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertEquals("", FileUtils.getFileExtension(Paths.get(System.getProperty("java.io.tmpdir"), "More").toFile()));
        assertEquals("", FileUtils.getFileExtension("Tmp Fichier"));
        assertEquals("FileUtils", FileUtils.getFileExtension("net.hypnozcore.hypnozcore.utils.FileUtils"));
    }

    /**
     * Method under test: {@link FileUtils#getTaille(File)}
     */
    @Test
    void testGetTaille() {
        assertEquals(0L, FileUtils.getTaille(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertEquals(0L,
                FileUtils.getTaille(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), "Conv"));
        assertEquals(0L,
                FileUtils.getTaille(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), (String) "KB"));
        assertEquals(0L,
                FileUtils.getTaille(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), (String) "MB"));
    }

    /**
     * Method under test: {@link FileUtils#getStringTaille(long)}
     */
    @Test
    void testGetStringTaille() {
        assertEquals("1 Bytes", FileUtils.getStringTaille(1L));
        assertEquals("1000.0 KB", FileUtils.getStringTaille(1000000L));
        assertEquals("", FileUtils.getStringTaille(Long.MAX_VALUE));
        assertEquals("1000.0 MB", FileUtils.getStringTaille(1000000000L));
        assertEquals("0 Bytes",
                FileUtils.getStringTaille(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertEquals("12.288 KB",
                FileUtils.getStringTaille(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile()));
    }

    /**
     * Method under test: {@link FileUtils#getFileName(String)}
     */
    @Test
    void testGetFileName() {
        assertEquals("", FileUtils.getFileName("Tmp Fichier"));
        assertEquals("net.hypnozcore.hypnozcore.utils",
                FileUtils.getFileName("net.hypnozcore.hypnozcore.utils.FileUtils"));
    }

    /**
     * Method under test: {@link FileUtils#getMIMEType(File)}
     */
    @Test
    void testGetMIMEType() {
        assertEquals("text/plain",
                FileUtils.getMIMEType(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertEquals("content/unknown", FileUtils.getMIMEType("Path Destination"));
    }

    /**
     * Method under test: {@link FileUtils#getFileNameFromDirectory(String)}
     */
    @Test
    void testGetFileNameFromDirectory() {
        assertTrue(FileUtils.getFileNameFromDirectory("Path").isEmpty());
    }

    /**
     * Method under test: {@link FileUtils#getFileNameFromDirectory(String)}
     */
    @Test
    void testGetFileNameFromDirectory2() {
        List<String> actualFileNameFromDirectory = FileUtils.getFileNameFromDirectory("");
        assertEquals(1073, actualFileNameFromDirectory.size());
        assertEquals("application.properties", actualFileNameFromDirectory.get(0));
        assertEquals("Applications.json", actualFileNameFromDirectory.get(1));
        assertEquals("modules.json", actualFileNameFromDirectory.get(2));
        assertEquals("fonctions.json", actualFileNameFromDirectory.get(3));
        assertEquals("TypeAction.java", actualFileNameFromDirectory.get(4));
        assertEquals("Etats.java", actualFileNameFromDirectory.get(5));
        assertEquals("master", actualFileNameFromDirectory.get(1067));
        assertEquals("crud_groupes", actualFileNameFromDirectory.get(1068));
        assertEquals(HypnozCoreCostance.DEFAULT_DOC_SERVEUR_MODELS, actualFileNameFromDirectory.get(1069));
        assertEquals("FETCH_HEAD", actualFileNameFromDirectory.get(1070));
        assertEquals(".gitignore", actualFileNameFromDirectory.get(1071));
        assertEquals("build.yml", actualFileNameFromDirectory.get(1072));
    }

    /**
     * Method under test: {@link FileUtils#deletefile(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeletefile() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file 'Path', permission 'delete').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        FileUtils.deletefile("Path");
    }
}

