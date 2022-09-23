package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.mapper.GroupesMapper;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GroupesServicesTest {
    @MockBean
    private GroupesMapper groupesMapper;

    @MockBean
    private GroupesRepository groupesRepository;

    @Autowired
    private GroupesServices groupesServices;

    /**
     * Method under test: {@link GroupesServices#save(GroupesDto)}
     */
    @Test
    void testSave() {
        GroupesDto groupesDto = mock(GroupesDto.class);
        when(groupesDto.getCode()).thenReturn("Code");
        assertThrows(ResponseException.class, () -> groupesServices.save(groupesDto));
        verify(groupesDto).getCode();
    }

    /**
     * Method under test: {@link GroupesServices#save(GroupesDto)}
     */
    @Test
    void testSave2() {
        GroupesDto groupesDto = mock(GroupesDto.class);
        when(groupesDto.getCode()).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        assertThrows(ResponseException.class, () -> groupesServices.save(groupesDto));
        verify(groupesDto).getCode();
    }

    /**
     * Method under test: {@link GroupesServices#update(GroupesDto, Long)}
     */
    @Test
    void testUpdate() {
        GroupesDto groupesDto = mock(GroupesDto.class);
        when(groupesDto.getCode()).thenReturn("Code");
        assertThrows(ResponseException.class, () -> groupesServices.update(groupesDto, 123L));
        verify(groupesDto).getCode();
    }

    /**
     * Method under test: {@link GroupesServices#update(GroupesDto, Long)}
     */
    @Test
    void testUpdate2() {
        GroupesDto groupesDto = mock(GroupesDto.class);
        when(groupesDto.getCode()).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        assertThrows(ResponseException.class, () -> groupesServices.update(groupesDto, 123L));
        verify(groupesDto).getCode();
    }

    /**
     * Method under test: {@link GroupesServices#list(Long)}
     */
    @Test
    void testList() {
        ResponseEntity<List<GroupesDto>> actualListResult = groupesServices.list(1L);
        assertTrue(actualListResult.hasBody());
        assertEquals(HttpStatus.ACCEPTED, actualListResult.getStatusCode());
        assertTrue(actualListResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link GroupesServices#list(Long)}
     */
    @Test
    void testList2() {
        ResponseEntity<List<GroupesDto>> actualListResult = groupesServices.list(-1264874952L);
        assertTrue(actualListResult.hasBody());
        assertEquals(HttpStatus.ACCEPTED, actualListResult.getStatusCode());
        assertTrue(actualListResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link GroupesServices#findById(Long)}
     */
    @Test
    void testFindById() {
        assertThrows(ResponseException.class, () -> groupesServices.findById(123L));
        assertThrows(ResponseException.class, () -> groupesServices.findById(1L));
    }

    /**
     * Method under test: {@link GroupesServices#findOne(Long)}
     */
    @Test
    void testFindOne() {
        assertThrows(ResponseException.class, () -> groupesServices.findOne(123L));
    }
}

