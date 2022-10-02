package net.hypnozcore.hypnozcore.models;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class GroupesApplicationsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GroupesApplications#GroupesApplications()}
     *   <li>{@link GroupesApplications#markNotNew()}
     *   <li>{@link GroupesApplications#isNew()}
     * </ul>
     */
    @Test
    void testConstructor() {
        GroupesApplications actualGroupesApplications = new GroupesApplications();
        actualGroupesApplications.markNotNew();
        assertFalse(actualGroupesApplications.isNew());
    }
}

