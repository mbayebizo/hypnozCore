package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.mapper.UsersMapper;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.UsersRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UsersServices.class})
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class UsersServicesTest {
    @MockBean
    private GroupesRepository groupesRepository;

    @MockBean
    private UsersMapper usersMapper;

    @MockBean
    private UsersRepository usersRepository;

    @Autowired
    private UsersServices usersServices;

    /**
     * Method under test: {@link UsersServices#save(UsersDto)}
     */
    @Test
    void testSave() {
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getPwd()).thenReturn("Pwd");
        assertThrows(ResponseException.class, () -> usersServices.save(usersDto));
        verify(usersDto).getPwd();
    }

    /**
     * Method under test: {@link UsersServices#save(UsersDto)}
     */
    @Test
    void testSave2() {
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getPwd()).thenReturn("UUUUUUUUUU");
        ResponseEntity<UsersDto> actualSaveResult = usersServices.save(usersDto);
        assertNull(actualSaveResult.getBody());
        assertEquals(HttpStatus.OK, actualSaveResult.getStatusCode());
        assertTrue(actualSaveResult.getHeaders().isEmpty());
        verify(usersDto).getPwd();
    }

    /**
     * Method under test: {@link UsersServices#save(UsersDto)}
     */
    @Test
    void testSave3() {
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getPwd()).thenReturn(null);
        assertThrows(ResponseException.class, () -> usersServices.save(usersDto));
        verify(usersDto).getPwd();
    }
}

