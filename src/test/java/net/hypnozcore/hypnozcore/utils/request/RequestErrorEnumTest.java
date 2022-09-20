package net.hypnozcore.hypnozcore.utils.request;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RequestErrorEnumTest {
    /**
     * Method under test: {@link RequestErrorEnum#loadEnumByErrorCode(String)}
     */
    @Test
    void testLoadEnumByErrorCode() {
        assertNull(RequestErrorEnum.loadEnumByErrorCode("Code"));
    }
}

