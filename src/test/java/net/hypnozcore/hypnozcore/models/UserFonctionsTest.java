package net.hypnozcore.hypnozcore.models;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class UserFonctionsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserFonctions#UserFonctions()}
     *   <li>{@link UserFonctions#markNotNew()}
     *   <li>{@link UserFonctions#isNew()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserFonctions actualUserFonctions = new UserFonctions();
        actualUserFonctions.markNotNew();
        assertFalse(actualUserFonctions.isNew());
    }
}

