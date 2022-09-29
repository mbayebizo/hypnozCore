package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GenerateMenuGroupeServiceTest {
    @Autowired
    private GenerateMenuGroupeService generateMenuGroupeService;

    /**
     * Method under test: {@link GenerateMenuGroupeService#deleteFonctionByGroupe(Long, Long)}
     */
    @Test
    void testDeleteFonctionByGroupe() {
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteFonctionByGroupe(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteFonctionByGroupe(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#deleteGroupeApplication(long, long)}
     */
    @Test
    void testDeleteGroupeApplication() {
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeApplication(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeApplication(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#deleteGroupeModule(Long, Long)}
     */
    @Test
    void testDeleteGroupeModule() {
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeModule(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeModule(2L, 1L));
    }
}

