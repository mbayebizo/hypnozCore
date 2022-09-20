package net.hypnozcore.hypnozcore.utils.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.junit.jupiter.api.Test;

class ResponseExceptionTest {
    /**
     * Method under test: {@link ResponseException#ResponseException(String)}
     */
    @Test
    void testConstructor() {
        ResponseException actualResponseException = new ResponseException("An error occurred");
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("An error occurred", actualResponseException.getMessage());
        assertEquals("An error occurred", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor2() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.LIST_EMPTY);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("Liste est vide", actualResponseException.getMessage());
        assertEquals("Liste est vide", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor3() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.ERROR_SIGLE);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("sigle.error.description", actualResponseException.getMessage());
        assertEquals("sigle.error.description", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor4() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.NOT_FOUND_STRUCTURE);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("Find Structure not found", actualResponseException.getMessage());
        assertEquals("Find Structure not found", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor5() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.ERROR_RAISON_SOCIAL);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("raison.social.error.description", actualResponseException.getMessage());
        assertEquals("raison.social.error.description", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor6() {
        ResponseException actualResponseException = new ResponseException(
                RequestErrorEnum.ERROR_INSERT_OR_UPDATE_IN_DATABASE);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("raison.social.error.description", actualResponseException.getMessage());
        assertEquals("raison.social.error.description", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor7() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.ID_STRUCTURE_EMPTY);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("ID Structure not Found\"", actualResponseException.getMessage());
        assertEquals("ID Structure not Found\"", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor8() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.CODE_GROUPE_EMPTY);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("Code Groupe is empty\"", actualResponseException.getMessage());
        assertEquals("Code Groupe is empty\"", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor9() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.SIZE_CODE_EMPTY);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("La taille du code est incorrect\"", actualResponseException.getMessage());
        assertEquals("La taille du code est incorrect\"", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum)}
     */
    @Test
    void testConstructor10() {
        ResponseException actualResponseException = new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
        assertNull(actualResponseException.getCause());
        assertEquals(0, actualResponseException.getSuppressed().length);
        assertEquals("Find GROUPE not found", actualResponseException.getMessage());
        assertEquals("Find GROUPE not found", actualResponseException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor11() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.LIST_EMPTY, throwable)).getCause(), throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor12() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.ERROR_SIGLE, throwable)).getCause(), throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor13() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.NOT_FOUND_STRUCTURE, throwable)).getCause(), throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor14() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.ERROR_RAISON_SOCIAL, throwable)).getCause(), throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor15() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.ERROR_INSERT_OR_UPDATE_IN_DATABASE, throwable)).getCause(),
                throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor16() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.ID_STRUCTURE_EMPTY, throwable)).getCause(), throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor17() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.CODE_GROUPE_EMPTY, throwable)).getCause(), throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor18() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.SIZE_CODE_EMPTY, throwable)).getCause(), throwable);
    }

    /**
     * Method under test: {@link ResponseException#ResponseException(RequestErrorEnum, Throwable)}
     */
    @Test
    void testConstructor19() {
        Throwable throwable = new Throwable();
        assertSame((new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE, throwable)).getCause(), throwable);
    }
}

