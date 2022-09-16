package net.hypnozcore.hypnozcore;

import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.service.GenerateDefaultDocService;
import net.hypnozcore.hypnozcore.service.GenerateMenuService;
import net.hypnozcore.hypnozcore.service.StructuresServices;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StructuresServiceTest {
    @Mock
    private StructuresRepository mockRepository;
    @Mock
    private StructuresMapper mockStructuresMapper;

    private StructuresServices structuresServiceUnderTest;
    @Mock
    private GenerateMenuService generateMenuService;
    @Mock
    private GenerateDefaultDocService generateDefaultDocService;

    @BeforeEach
    void setUp() {
        structuresServiceUnderTest = new StructuresServices(mockRepository, mockStructuresMapper, generateMenuService, generateDefaultDocService);
    }

   @Test
    void testSave() {
        // Setup
        final StructuresDto structuresDto = StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)

                .build();
        final StructuresDto expectedResult = StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)
                .build();
        when(mockStructuresMapper.toEntity(StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)
                .build())).thenReturn(Structures.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)
                .build());
        lenient().when(mockRepository.save(Structures.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)
                .build())).thenReturn(Structures.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)
                .build());
        when(mockStructuresMapper.toDto(Structures.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)
                .build())).thenReturn(StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .adresse("test deress")
                .bilanSocail("500000")
                .dateFiscale(LocalDate.now())
                .typeEntreprise(TypeEntreprise.SA)
                .build());

        // Run the test
        final StructuresDto result = structuresServiceUnderTest.save(structuresDto).getBody();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testExceptionRaisonSocialSave() {
        // Setup
        ResponseException exception = assertThrows(ResponseException.class, () -> {
            final StructuresDto structuresDto = StructuresDto.builder()
                    .sigle("teqsdqsdq")
                    .raisonSocial("r")
                    .build();
            final StructuresDto expectedResult = StructuresDto.builder()
                    .sigle("teqsdqsdq")
                    .raisonSocial("r")
                    .build();
            lenient().when(mockStructuresMapper.toEntity(StructuresDto.builder()
                    .sigle("teqsdqsdq")
                    .raisonSocial("r")
                    .build())).thenReturn(Structures.builder().build());
            lenient().when(mockRepository.save(Structures.builder()
                    .sigle("teqsdqsdq")
                    .raisonSocial("r")
                    .build())).thenReturn(Structures.builder()
                    .sigle("teqsdqsdq")
                    .raisonSocial("r")
                    .build());
            lenient().when(mockStructuresMapper.toDto(Structures.builder()
                    .sigle("teqsdqsdq")
                    .raisonSocial("r")
                    .build())).thenReturn(StructuresDto.builder()
                    .sigle("teqsdqsdq")
                    .raisonSocial("r")
                    .build());

            // Run the test
            final StructuresDto result = structuresServiceUnderTest.save(structuresDto).getBody();
        });


        // Verify the results
        assertEquals("raison.social.error.description", exception.getMessage());
    }

    @Test
    void testExceptionSigleSave() {
        // Setup
        ResponseException exception = assertThrows(ResponseException.class, () -> {
            final StructuresDto structuresDto = StructuresDto.builder()
                    .sigle("t")
                    .raisonSocial("rxcxcwxcwxcwxc")
                    .build();
            final StructuresDto expectedResult = StructuresDto.builder()
                    .sigle("t")
                    .raisonSocial("rxcxcwxcwxcwxc")
                    .build();
            lenient().when(mockStructuresMapper.toEntity(StructuresDto.builder()
                    .sigle("t")
                    .raisonSocial("rxcxcwxcwxcwxc")
                    .build())).thenReturn(Structures.builder().build());
            lenient().when(mockRepository.save(Structures.builder()
                    .sigle("t")
                    .raisonSocial("rxcxcwxcwxcwxc")
                    .build())).thenReturn(Structures.builder()
                    .sigle("t")
                    .raisonSocial("rxcxcwxcwxcwxc")
                    .build());
            lenient().when(mockStructuresMapper.toDto(Structures.builder()
                    .sigle("t")
                    .raisonSocial("rxcxcwxcwxcwxc")
                    .build())).thenReturn(StructuresDto.builder()
                    .sigle("t")
                    .raisonSocial("rxcxcwxcwxcwxc")
                    .build());

            // Run the test
            final StructuresDto result = structuresServiceUnderTest.save(structuresDto).getBody();
        });


        // Verify the results
        assertEquals("sigle.error.description", exception.getMessage());
    }


    @Test
    void testDeleteById() {
        // Setup
        // Run the test
        structuresServiceUnderTest.deleteById(1L);

        // Verify the results
        verify(mockRepository).deleteById(1L);
    }

  @Test
    void testFindById() {
        // Setup
        final StructuresDto expectedResult = StructuresDto.builder()
                .raisonSocial("raison social")
                .build();

        // Configure StructuresRepository.findById(...).
        final Optional<Structures> structures = Optional.of(Structures.builder().build());
        when(mockRepository.findById(1L)).thenReturn(structures);

        when(mockStructuresMapper.toDto(Structures.builder().build())).thenReturn(StructuresDto.builder().build());

        // Run the test
        final StructuresDto result = structuresServiceUnderTest.findById(1L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testFindById_StructuresRepositoryReturnsAbsent() {
        // Setup
        when(mockRepository.findById(1L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> structuresServiceUnderTest.findById(1L)).isInstanceOf(ResourceNotFoundException.class);
    }


/*
    @Test
    void testUpdate() {
        // Setup
        final StructuresDto structuresDto = StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .build();
        final StructuresDto expectedResult = StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .build();

        // Configure StructuresRepository.findById(...).
        final Optional<Structures> structures = Optional.of(Structures.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .build());
        when(mockRepository.findById(1L)).thenReturn(structures);

        when(mockStructuresMapper.toDto(Structures.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .build())).thenReturn(StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .build());
        when(mockStructuresMapper.toEntity(StructuresDto.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .build())).thenReturn(Structures.builder().build());
        lenient().when(mockRepository.save(Structures.builder().build())).thenReturn(Structures.builder()
                .sigle("teste")
                .raisonSocial("raison social")
                .build());

        // Run the test
        final StructuresDto result = structuresServiceUnderTest.update(structuresDto, 1L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
*/

    @Test
    void testUpdate_StructuresRepositoryFindByIdReturnsAbsent() {
        // Setup
        final StructuresDto structuresDto = StructuresDto.builder().build();
        when(mockRepository.findById(1L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> structuresServiceUnderTest.update(structuresDto, 1L))
                .isInstanceOf(ResourceNotFoundException.class);
    }

   /* @Test
    void testInitModules() {
        StructuresDto structureInitPojo = StructuresDto.builder()
                .sigle("HYPNOZ")
                .raisonSocial("Hypnoz Test ")
                .build();
        structuresServiceUnderTest.initConfigStructure(structureInitPojo);
    }*/
}
