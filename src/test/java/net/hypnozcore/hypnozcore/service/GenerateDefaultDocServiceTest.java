package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void should_be_create_new_repertory() throws ResponseException {
               assertEquals("/opt/hypnozcore/", generateDefaultDocService.create());
    }

}

