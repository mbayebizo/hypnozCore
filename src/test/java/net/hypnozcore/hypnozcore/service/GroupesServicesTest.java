package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.mapper.GroupesMapper;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ValidatorFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

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
    @DisplayName("throws EmptyStackException when popped")
    void shouldBeCodeIsNull() {
        GroupesDto groupesDto = GroupesDto.builder().build();
        Assert.assertThrows(ResponseException.class, () -> groupesServicesUnderTest.save(groupesDto).getBody());
    }
 @Test
    void shouldBeSizeCodeIncorrect() {
        GroupesDto groupesDto = GroupesDto.builder()
                .code("t")
                .build();
     Assert.assertThrows(ResponseException.class, () -> groupesServicesUnderTest.save(groupesDto).getBody());
    }

    @Test
    void shouldBeCreateGroupeCorrect() {
        GroupesDto groupesDto = GroupesDto.builder()
                .code("Cpt")
                .libelle("Comptabilité")
                .build();

        GroupesDto excepted = groupesServicesUnderTest.save(groupesDto).getBody();

        assertThat(excepted).isNotNull();
        assertThat(excepted.getCode()).isEqualTo(groupesDto.getCode());


    }


}