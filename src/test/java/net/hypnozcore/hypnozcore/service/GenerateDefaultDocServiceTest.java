package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GenerateDefaultDocService.class})
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class GenerateDefaultDocServiceTest {
    @Autowired
    private GenerateDefaultDocService generateDefaultDocService;

    /**
     * Method under test: {@link GenerateDefaultDocService#create()}
     */
    @Test
    void testCreate() throws ResponseException {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        generateDefaultDocService.create();
    }
}

