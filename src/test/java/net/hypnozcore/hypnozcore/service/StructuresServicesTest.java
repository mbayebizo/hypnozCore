package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class StructuresServicesTest {
    @MockBean
    private GenerateDefaultDocService generateDefaultDocService;

    @MockBean
    private GenerateMenuService generateMenuService;

    @MockBean
    private StructuresMapper structuresMapper;

    @MockBean
    private StructuresRepository structuresRepository;

    @Autowired
    private StructuresServices structuresServices;

    /**
     * Method under test: {@link StructuresServices#save(StructuresDto)}
     */
    @Test
    void testSave() {
        Structures structures = getStructures();
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);

        Structures structures1 = getStructures();
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures1);
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        ResponseEntity<StructuresDto> actualSaveResult = structuresServices.save(structuresDto);
        assertTrue(actualSaveResult.hasBody());
        assertEquals(HttpStatus.OK, actualSaveResult.getStatusCode());
        assertTrue(actualSaveResult.getHeaders().isEmpty());
        verify(structuresRepository).saveAndFlush((Structures) any());
        verify(structuresMapper, atLeast(1)).toDto((Structures) any());
        verify(structuresMapper).toEntity((StructuresDto) any());
        verify(structuresDto, atLeast(1)).getRaisonSocial();
        verify(structuresDto, atLeast(1)).getSigle();
    }

  

    /**
     * Method under test: {@link StructuresServices#save(StructuresDto)}
     */
    @Test
    void testSave2() {
        Structures structures = getStructures();
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
        when(structuresMapper.toDto((Structures) any())).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        when(structuresMapper.toEntity((StructuresDto) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        assertThrows(ResponseException.class, () -> structuresServices.save(structuresDto));
        verify(structuresMapper).toEntity((StructuresDto) any());
        verify(structuresDto, atLeast(1)).getRaisonSocial();
        verify(structuresDto, atLeast(1)).getSigle();
    }

    /**
     * Method under test: {@link StructuresServices#deleteById(long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(structuresRepository).deleteById((Long) any());
        structuresServices.deleteById(123L);
        verify(structuresRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link StructuresServices#deleteById(long)}
     */
    @Test
    void testDeleteById2() {
        doThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY)).when(structuresRepository).deleteById((Long) any());
        assertThrows(ResponseException.class, () -> structuresServices.deleteById(123L));
        verify(structuresRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link StructuresServices#findById(long)}
     */
    @Test
    void testFindById() {
        assertThrows(ResponseException.class, () -> structuresServices.findById(123L));
    }

    /**
     * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
     */
    @Test
    void testUpdate() {
        Structures structures = getStructures();
        Optional<Structures> ofResult = Optional.of(structures);

        Structures structures1 = getStructures();
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures1);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult);

        Structures structures2 = getStructures();
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures2);
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        ResponseEntity<StructuresDto> actualUpdateResult = structuresServices.update(structuresDto, 123L);
        assertTrue(actualUpdateResult.hasBody());
        assertEquals(HttpStatus.CREATED, actualUpdateResult.getStatusCode());
        assertTrue(actualUpdateResult.getHeaders().isEmpty());
        verify(structuresRepository).saveAndFlush((Structures) any());
        verify(structuresRepository).findById((Long) any());
        verify(structuresMapper).toDto((Structures) any());
        verify(structuresMapper).toEntity((StructuresDto) any());
        verify(structuresDto, atLeast(1)).getRaisonSocial();
        verify(structuresDto, atLeast(1)).getSigle();
    }

    /**
     * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
     */
    @Test
    void testUpdate2() {
        Structures structures = getStructures();
        Optional<Structures> ofResult = Optional.of(structures);

        Structures structures1 = getStructures();
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures1);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
        when(structuresMapper.toDto((Structures) any())).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        when(structuresMapper.toEntity((StructuresDto) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        assertThrows(ResponseException.class, () -> structuresServices.update(structuresDto, 123L));
        verify(structuresRepository).findById((Long) any());
        verify(structuresMapper).toEntity((StructuresDto) any());
        verify(structuresDto, atLeast(1)).getRaisonSocial();
        verify(structuresDto, atLeast(1)).getSigle();
    }

    /**
     * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
     */
    @Test
    void testInitConfigStructure() throws ResponseException {
        Structures structures = getStructures();

        Structures structures1 = getStructures();
        Optional<Structures> ofResult = Optional.of(structures1);
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
        when(structuresRepository.findByRaisonSocialAndSigle((String) any(), (String) any())).thenReturn(ofResult);
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        when(generateMenuService.createDefaultApplication((List<Modules>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultFonctions((List<Applications>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultModule((Structures) any())).thenReturn(new ArrayList<>());
        when(generateDefaultDocService.create()).thenReturn("Create");
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        ResponseEntity<StructuresDto> actualInitConfigStructureResult = structuresServices
                .initConfigStructure(structuresDto);
        assertTrue(actualInitConfigStructureResult.hasBody());
        assertEquals(HttpStatus.OK, actualInitConfigStructureResult.getStatusCode());
        assertTrue(actualInitConfigStructureResult.getHeaders().isEmpty());
        verify(structuresRepository, atLeast(1)).findByRaisonSocialAndSigle((String) any(), (String) any());
        verify(structuresMapper).toDto((Structures) any());
        verify(generateMenuService).createDefaultApplication((List<Modules>) any());
        verify(generateMenuService).createDefaultFonctions((List<Applications>) any());
        verify(generateMenuService).createDefaultModule((Structures) any());
        verify(generateDefaultDocService).create();
        verify(structuresDto, atLeast(1)).getRaisonSocial();
        verify(structuresDto, atLeast(1)).getSigle();
    }

    /**
     * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
     */
    @Test
    void testInitConfigStructure2() throws ResponseException {
        Structures structures = getStructures();

        Structures structures1 = getStructures();
        Optional<Structures> ofResult = Optional.of(structures1);
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
        when(structuresRepository.findByRaisonSocialAndSigle((String) any(), (String) any())).thenReturn(ofResult);
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        when(generateMenuService.createDefaultApplication((List<Modules>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultFonctions((List<Applications>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultModule((Structures) any())).thenReturn(new ArrayList<>());
        when(generateDefaultDocService.create()).thenReturn("Create");
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        when(structuresDto.getSigle()).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        assertThrows(ResponseException.class, () -> structuresServices.initConfigStructure(structuresDto));
        verify(structuresDto).getRaisonSocial();
    }



    @NotNull
    private static Structures getStructures() {
        Structures structures = new Structures();
        structures.setActiviteCommerciale("Activite Commerciale");
        structures.setAdresse("Adresse");
        structures.setBilanSocail("Bilan Socail");
        structures.setCapital("Capital");
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures.setDepartement("Departement");
        structures.setDescription("The characteristics of someone or something");
        structures.setEmail("jane.doe@example.org");
        structures.setFlagEtat(Etats.INACTIVE);
        structures.setFormJuridique("Form Juridique");
        structures.setId(123L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setLogo("Logo");
        structures.setPays("Pays");
        structures.setQualiteResponsable("Qualite Responsable");
        structures.setRaisonSocial("Raison Social");
        structures.setResponsable("Responsable");
        structures.setSigle("Sigle");
        structures.setSiteweb("Siteweb");
        structures.setTelephone("4105551212");
        structures.setTypeEntreprise(TypeEntreprise.SA);
        structures.setVille("Ville");
        structures.setZoneFiscale("Zone Fiscale");
        structures.setZoneFiscale2("Zone Fiscale2");
        return structures;
    }
}

