package net.hypnozcore.hypnozcore.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

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

