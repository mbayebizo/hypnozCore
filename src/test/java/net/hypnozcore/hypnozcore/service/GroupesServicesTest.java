package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.mapper.GroupesMapper;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GroupesServicesTest {

    @Mock
    private GroupesRepository mockRepository;
    @Mock
    private GroupesMapper mockGroupeMapper;


    private GroupesServices groupesServicesUnderTest;


    @BeforeEach
    void setUp() {
        groupesServicesUnderTest = new GroupesServices(mockRepository,mockGroupeMapper);
    }

    @Test
    void saveGroupeTest() {
        GroupesDto groupesDto = GroupesDto.builder().build();
        groupesServicesUnderTest.save(groupesDto);
    }
}