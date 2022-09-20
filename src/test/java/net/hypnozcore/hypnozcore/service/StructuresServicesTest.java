package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StructuresServices.class})
@ActiveProfiles({"dev"})
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
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);

        Structures structures1 = new Structures();
        structures1.setActiviteCommerciale("Activite Commerciale");
        structures1.setAdresse("Adresse");
        structures1.setBilanSocail("Bilan Socail");
        structures1.setCapital("Capital");
        structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures1.setDepartement("Departement");
        structures1.setDescription("The characteristics of someone or something");
        structures1.setEmail("jane.doe@example.org");
        structures1.setFlagEtat(Etats.INACTIVE);
        structures1.setFormJuridique("Form Juridique");
        structures1.setId(123L);
        structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setLogo("Logo");
        structures1.setPays("Pays");
        structures1.setQualiteResponsable("Qualite Responsable");
        structures1.setRaisonSocial("Raison Social");
        structures1.setResponsable("Responsable");
        structures1.setSigle("Sigle");
        structures1.setSiteweb("Siteweb");
        structures1.setTelephone("4105551212");
        structures1.setTypeEntreprise(TypeEntreprise.SA);
        structures1.setVille("Ville");
        structures1.setZoneFiscale("Zone Fiscale");
        structures1.setZoneFiscale2("Zone Fiscale2");
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
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
        when(structuresMapper.toDto((Structures) any())).thenThrow(new ResourceNotFoundException("An error occurred"));
        when(structuresMapper.toEntity((StructuresDto) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        assertThrows(ResourceNotFoundException.class, () -> structuresServices.save(structuresDto));
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
        Optional<Structures> ofResult = Optional.of(structures);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        structuresServices.findById(123L);
        verify(structuresRepository).findById((Long) any());
        verify(structuresMapper).toDto((Structures) any());
    }

    /**
     * Method under test: {@link StructuresServices#findById(long)}
     */
    @Test
    void testFindById2() {
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
        Optional<Structures> ofResult = Optional.of(structures);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
        when(structuresMapper.toDto((Structures) any())).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        assertThrows(ResponseException.class, () -> structuresServices.findById(123L));
        verify(structuresRepository).findById((Long) any());
        verify(structuresMapper).toDto((Structures) any());
    }

    /**
     * Method under test: {@link StructuresServices#findById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.data.rest.webmvc.ResourceNotFoundException: EntityRepresentationModel not found!
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at net.hypnozcore.hypnozcore.service.StructuresServices.findById(StructuresServices.java:63)
        //   In order to prevent findById(long)
        //   from throwing ResourceNotFoundException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findById(long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(structuresRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        structuresServices.findById(123L);
    }

    /**
     * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
     */
    @Test
    void testUpdate() {
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
        Optional<Structures> ofResult = Optional.of(structures);

        Structures structures1 = new Structures();
        structures1.setActiviteCommerciale("Activite Commerciale");
        structures1.setAdresse("Adresse");
        structures1.setBilanSocail("Bilan Socail");
        structures1.setCapital("Capital");
        structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures1.setDepartement("Departement");
        structures1.setDescription("The characteristics of someone or something");
        structures1.setEmail("jane.doe@example.org");
        structures1.setFlagEtat(Etats.INACTIVE);
        structures1.setFormJuridique("Form Juridique");
        structures1.setId(123L);
        structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setLogo("Logo");
        structures1.setPays("Pays");
        structures1.setQualiteResponsable("Qualite Responsable");
        structures1.setRaisonSocial("Raison Social");
        structures1.setResponsable("Responsable");
        structures1.setSigle("Sigle");
        structures1.setSiteweb("Siteweb");
        structures1.setTelephone("4105551212");
        structures1.setTypeEntreprise(TypeEntreprise.SA);
        structures1.setVille("Ville");
        structures1.setZoneFiscale("Zone Fiscale");
        structures1.setZoneFiscale2("Zone Fiscale2");
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures1);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getId()).thenReturn(123L);
        when(structuresDto.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
        when(structuresDto.getLastModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
        when(structuresDto.getActiviteCommerciale()).thenReturn("Activite Commerciale");
        when(structuresDto.getAdresse()).thenReturn("Adresse");
        when(structuresDto.getBilanSocail()).thenReturn("Bilan Socail");
        when(structuresDto.getCapital()).thenReturn("Capital");
        when(structuresDto.getDepartement()).thenReturn("Departement");
        when(structuresDto.getDescription()).thenReturn("The characteristics of someone or something");
        when(structuresDto.getEmail()).thenReturn("jane.doe@example.org");
        when(structuresDto.getFormJuridique()).thenReturn("Form Juridique");
        when(structuresDto.getLogo()).thenReturn("Logo");
        when(structuresDto.getPays()).thenReturn("Pays");
        when(structuresDto.getQualiteResponsable()).thenReturn("Qualite Responsable");
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getResponsable()).thenReturn("Responsable");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        when(structuresDto.getSiteweb()).thenReturn("Siteweb");
        when(structuresDto.getTelephone()).thenReturn("4105551212");
        when(structuresDto.getVille()).thenReturn("Ville");
        when(structuresDto.getZoneFiscale()).thenReturn("Zone Fiscale");
        when(structuresDto.getZoneFiscale2()).thenReturn("Zone Fiscale2");
        when(structuresDto.getDateFiscale()).thenReturn(LocalDate.ofEpochDay(1L));
        when(structuresDto.getTypeEntreprise()).thenReturn(TypeEntreprise.SA);

        Structures structures2 = new Structures();
        structures2.setActiviteCommerciale("Activite Commerciale");
        structures2.setAdresse("Adresse");
        structures2.setBilanSocail("Bilan Socail");
        structures2.setCapital("Capital");
        structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures2.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures2.setDepartement("Departement");
        structures2.setDescription("The characteristics of someone or something");
        structures2.setEmail("jane.doe@example.org");
        structures2.setFlagEtat(Etats.INACTIVE);
        structures2.setFormJuridique("Form Juridique");
        structures2.setId(123L);
        structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures2.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        structures2.setLogo("Logo");
        structures2.setPays("Pays");
        structures2.setQualiteResponsable("Qualite Responsable");
        structures2.setRaisonSocial("Raison Social");
        structures2.setResponsable("Responsable");
        structures2.setSigle("Sigle");
        structures2.setSiteweb("Siteweb");
        structures2.setTelephone("4105551212");
        structures2.setTypeEntreprise(TypeEntreprise.SA);
        structures2.setVille("Ville");
        structures2.setZoneFiscale("Zone Fiscale");
        structures2.setZoneFiscale2("Zone Fiscale2");
        when(structuresMapper.toDto((Structures) any())).thenReturn(structuresDto);
        when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures2);
        structuresServices.update(mock(StructuresDto.class), 123L);
        verify(structuresRepository).saveAndFlush((Structures) any());
        verify(structuresRepository).findById((Long) any());
        verify(structuresMapper, atLeast(1)).toDto((Structures) any());
        verify(structuresMapper, atLeast(1)).toEntity((StructuresDto) any());
        verify(structuresDto).getId();
        verify(structuresDto).getCreatedBy();
        verify(structuresDto).getLastModifiedBy();
        verify(structuresDto).getActiviteCommerciale();
        verify(structuresDto).getAdresse();
        verify(structuresDto).getBilanSocail();
        verify(structuresDto).getCapital();
        verify(structuresDto).getDepartement();
        verify(structuresDto).getDescription();
        verify(structuresDto).getEmail();
        verify(structuresDto).getFormJuridique();
        verify(structuresDto).getLogo();
        verify(structuresDto).getPays();
        verify(structuresDto).getQualiteResponsable();
        verify(structuresDto, atLeast(1)).getRaisonSocial();
        verify(structuresDto).getResponsable();
        verify(structuresDto, atLeast(1)).getSigle();
        verify(structuresDto).getSiteweb();
        verify(structuresDto).getTelephone();
        verify(structuresDto).getVille();
        verify(structuresDto).getZoneFiscale();
        verify(structuresDto).getZoneFiscale2();
        verify(structuresDto).getDateFiscale();
        verify(structuresDto).getTypeEntreprise();
    }

    /**
     * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
     */
    @Test
    void testUpdate2() {
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
        Optional<Structures> ofResult = Optional.of(structures);
        when(structuresRepository.saveAndFlush((Structures) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getId()).thenReturn(123L);
        when(structuresDto.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
        when(structuresDto.getLastModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
        when(structuresDto.getActiviteCommerciale()).thenReturn("Activite Commerciale");
        when(structuresDto.getAdresse()).thenReturn("Adresse");
        when(structuresDto.getBilanSocail()).thenReturn("Bilan Socail");
        when(structuresDto.getCapital()).thenReturn("Capital");
        when(structuresDto.getDepartement()).thenReturn("Departement");
        when(structuresDto.getDescription()).thenReturn("The characteristics of someone or something");
        when(structuresDto.getEmail()).thenReturn("jane.doe@example.org");
        when(structuresDto.getFormJuridique()).thenReturn("Form Juridique");
        when(structuresDto.getLogo()).thenReturn("Logo");
        when(structuresDto.getPays()).thenReturn("Pays");
        when(structuresDto.getQualiteResponsable()).thenReturn("Qualite Responsable");
        when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
        when(structuresDto.getResponsable()).thenReturn("Responsable");
        when(structuresDto.getSigle()).thenReturn("Sigle");
        when(structuresDto.getSiteweb()).thenReturn("Siteweb");
        when(structuresDto.getTelephone()).thenReturn("4105551212");
        when(structuresDto.getVille()).thenReturn("Ville");
        when(structuresDto.getZoneFiscale()).thenReturn("Zone Fiscale");
        when(structuresDto.getZoneFiscale2()).thenReturn("Zone Fiscale2");
        when(structuresDto.getDateFiscale()).thenReturn(LocalDate.ofEpochDay(1L));
        when(structuresDto.getTypeEntreprise()).thenReturn(TypeEntreprise.SA);

        Structures structures1 = new Structures();
        structures1.setActiviteCommerciale("Activite Commerciale");
        structures1.setAdresse("Adresse");
        structures1.setBilanSocail("Bilan Socail");
        structures1.setCapital("Capital");
        structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures1.setDepartement("Departement");
        structures1.setDescription("The characteristics of someone or something");
        structures1.setEmail("jane.doe@example.org");
        structures1.setFlagEtat(Etats.INACTIVE);
        structures1.setFormJuridique("Form Juridique");
        structures1.setId(123L);
        structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setLogo("Logo");
        structures1.setPays("Pays");
        structures1.setQualiteResponsable("Qualite Responsable");
        structures1.setRaisonSocial("Raison Social");
        structures1.setResponsable("Responsable");
        structures1.setSigle("Sigle");
        structures1.setSiteweb("Siteweb");
        structures1.setTelephone("4105551212");
        structures1.setTypeEntreprise(TypeEntreprise.SA);
        structures1.setVille("Ville");
        structures1.setZoneFiscale("Zone Fiscale");
        structures1.setZoneFiscale2("Zone Fiscale2");
        when(structuresMapper.toDto((Structures) any())).thenReturn(structuresDto);
        when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures1);
        assertThrows(ResponseException.class, () -> structuresServices.update(mock(StructuresDto.class), 123L));
        verify(structuresRepository).saveAndFlush((Structures) any());
        verify(structuresRepository).findById((Long) any());
        verify(structuresMapper, atLeast(1)).toDto((Structures) any());
        verify(structuresMapper, atLeast(1)).toEntity((StructuresDto) any());
        verify(structuresDto).getId();
        verify(structuresDto).getCreatedBy();
        verify(structuresDto).getLastModifiedBy();
        verify(structuresDto).getActiviteCommerciale();
        verify(structuresDto).getAdresse();
        verify(structuresDto).getBilanSocail();
        verify(structuresDto).getCapital();
        verify(structuresDto).getDepartement();
        verify(structuresDto).getDescription();
        verify(structuresDto).getEmail();
        verify(structuresDto).getFormJuridique();
        verify(structuresDto).getLogo();
        verify(structuresDto).getPays();
        verify(structuresDto).getQualiteResponsable();
        verify(structuresDto, atLeast(1)).getRaisonSocial();
        verify(structuresDto).getResponsable();
        verify(structuresDto, atLeast(1)).getSigle();
        verify(structuresDto).getSiteweb();
        verify(structuresDto).getTelephone();
        verify(structuresDto).getVille();
        verify(structuresDto).getZoneFiscale();
        verify(structuresDto).getZoneFiscale2();
        verify(structuresDto).getDateFiscale();
        verify(structuresDto).getTypeEntreprise();
    }

    /**
     * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.beans.FatalBeanException: Could not copy property 'activiteCommerciale' from source to target; nested exception is java.lang.reflect.InvocationTargetException
        //       at org.springframework.beans.BeanUtils.copyProperties(BeanUtils.java:825)
        //       at org.springframework.beans.BeanUtils.copyProperties(BeanUtils.java:719)
        //       at net.hypnozcore.hypnozcore.service.StructuresServices.update(StructuresServices.java:69)
        //   In order to prevent update(StructuresDto, Long)
        //   from throwing FatalBeanException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(StructuresDto, Long).
        //   See https://diff.blue/R013 to resolve this issue.

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
        Optional<Structures> ofResult = Optional.of(structures);
        Structures structures1 = mock(Structures.class);
        doNothing().when(structures1).setCreatedBy((String) any());
        doNothing().when(structures1).setCreatedDate((Date) any());
        doNothing().when(structures1).setFlagEtat((Etats) any());
        doNothing().when(structures1).setId((Long) any());
        doNothing().when(structures1).setLastModifiedBy((String) any());
        doNothing().when(structures1).setLastModifiedDate((Date) any());
        doNothing().when(structures1).setActiviteCommerciale((String) any());
        doNothing().when(structures1).setAdresse((String) any());
        doNothing().when(structures1).setBilanSocail((String) any());
        doNothing().when(structures1).setCapital((String) any());
        doNothing().when(structures1).setDateFiscale((LocalDate) any());
        doNothing().when(structures1).setDepartement((String) any());
        doNothing().when(structures1).setDescription((String) any());
        doNothing().when(structures1).setEmail((String) any());
        doNothing().when(structures1).setFormJuridique((String) any());
        doNothing().when(structures1).setLogo((String) any());
        doNothing().when(structures1).setPays((String) any());
        doNothing().when(structures1).setQualiteResponsable((String) any());
        doNothing().when(structures1).setRaisonSocial((String) any());
        doNothing().when(structures1).setResponsable((String) any());
        doNothing().when(structures1).setSigle((String) any());
        doNothing().when(structures1).setSiteweb((String) any());
        doNothing().when(structures1).setTelephone((String) any());
        doNothing().when(structures1).setTypeEntreprise((TypeEntreprise) any());
        doNothing().when(structures1).setVille((String) any());
        doNothing().when(structures1).setZoneFiscale((String) any());
        doNothing().when(structures1).setZoneFiscale2((String) any());
        structures1.setActiviteCommerciale("Activite Commerciale");
        structures1.setAdresse("Adresse");
        structures1.setBilanSocail("Bilan Socail");
        structures1.setCapital("Capital");
        structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures1.setDepartement("Departement");
        structures1.setDescription("The characteristics of someone or something");
        structures1.setEmail("jane.doe@example.org");
        structures1.setFlagEtat(Etats.INACTIVE);
        structures1.setFormJuridique("Form Juridique");
        structures1.setId(123L);
        structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setLogo("Logo");
        structures1.setPays("Pays");
        structures1.setQualiteResponsable("Qualite Responsable");
        structures1.setRaisonSocial("Raison Social");
        structures1.setResponsable("Responsable");
        structures1.setSigle("Sigle");
        structures1.setSiteweb("Siteweb");
        structures1.setTelephone("4105551212");
        structures1.setTypeEntreprise(TypeEntreprise.SA);
        structures1.setVille("Ville");
        structures1.setZoneFiscale("Zone Fiscale");
        structures1.setZoneFiscale2("Zone Fiscale2");
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures1);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult);

        Structures structures2 = new Structures();
        structures2.setActiviteCommerciale("Activite Commerciale");
        structures2.setAdresse("Adresse");
        structures2.setBilanSocail("Bilan Socail");
        structures2.setCapital("Capital");
        structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures2.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures2.setDepartement("Departement");
        structures2.setDescription("The characteristics of someone or something");
        structures2.setEmail("jane.doe@example.org");
        structures2.setFlagEtat(Etats.INACTIVE);
        structures2.setFormJuridique("Form Juridique");
        structures2.setId(123L);
        structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures2.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        structures2.setLogo("Logo");
        structures2.setPays("Pays");
        structures2.setQualiteResponsable("Qualite Responsable");
        structures2.setRaisonSocial("Raison Social");
        structures2.setResponsable("Responsable");
        structures2.setSigle("Sigle");
        structures2.setSiteweb("Siteweb");
        structures2.setTelephone("4105551212");
        structures2.setTypeEntreprise(TypeEntreprise.SA);
        structures2.setVille("Ville");
        structures2.setZoneFiscale("Zone Fiscale");
        structures2.setZoneFiscale2("Zone Fiscale2");
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures2);
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        structuresServices.update(mock(StructuresDto.class), 123L);
    }

    /**
     * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
     */
    @Test
    void testInitConfigStructure() throws ResponseException {
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

        Structures structures1 = new Structures();
        structures1.setActiviteCommerciale("Activite Commerciale");
        structures1.setAdresse("Adresse");
        structures1.setBilanSocail("Bilan Socail");
        structures1.setCapital("Capital");
        structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures1.setDepartement("Departement");
        structures1.setDescription("The characteristics of someone or something");
        structures1.setEmail("jane.doe@example.org");
        structures1.setFlagEtat(Etats.INACTIVE);
        structures1.setFormJuridique("Form Juridique");
        structures1.setId(123L);
        structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setLogo("Logo");
        structures1.setPays("Pays");
        structures1.setQualiteResponsable("Qualite Responsable");
        structures1.setRaisonSocial("Raison Social");
        structures1.setResponsable("Responsable");
        structures1.setSigle("Sigle");
        structures1.setSiteweb("Siteweb");
        structures1.setTelephone("4105551212");
        structures1.setTypeEntreprise(TypeEntreprise.SA);
        structures1.setVille("Ville");
        structures1.setZoneFiscale("Zone Fiscale");
        structures1.setZoneFiscale2("Zone Fiscale2");
        Optional<Structures> ofResult = Optional.of(structures1);
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
        when(structuresRepository.findByRaisonSocialAndSigle((String) any(), (String) any())).thenReturn(ofResult);
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        when(generateMenuService.createDefaultApplication((List<Modules>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultFonctions((List<Applications>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultModule((Structures) any())).thenReturn(new ArrayList<>());
        doNothing().when(generateDefaultDocService).create();
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

        Structures structures1 = new Structures();
        structures1.setActiviteCommerciale("Activite Commerciale");
        structures1.setAdresse("Adresse");
        structures1.setBilanSocail("Bilan Socail");
        structures1.setCapital("Capital");
        structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures1.setDepartement("Departement");
        structures1.setDescription("The characteristics of someone or something");
        structures1.setEmail("jane.doe@example.org");
        structures1.setFlagEtat(Etats.INACTIVE);
        structures1.setFormJuridique("Form Juridique");
        structures1.setId(123L);
        structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        structures1.setLogo("Logo");
        structures1.setPays("Pays");
        structures1.setQualiteResponsable("Qualite Responsable");
        structures1.setRaisonSocial("Raison Social");
        structures1.setResponsable("Responsable");
        structures1.setSigle("Sigle");
        structures1.setSiteweb("Siteweb");
        structures1.setTelephone("4105551212");
        structures1.setTypeEntreprise(TypeEntreprise.SA);
        structures1.setVille("Ville");
        structures1.setZoneFiscale("Zone Fiscale");
        structures1.setZoneFiscale2("Zone Fiscale2");
        Optional<Structures> ofResult = Optional.of(structures1);
        when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
        when(structuresRepository.findByRaisonSocialAndSigle((String) any(), (String) any())).thenReturn(ofResult);
        when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
        when(generateMenuService.createDefaultApplication((List<Modules>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultFonctions((List<Applications>) any())).thenReturn(new ArrayList<>());
        when(generateMenuService.createDefaultModule((Structures) any())).thenReturn(new ArrayList<>());
        doNothing().when(generateDefaultDocService).create();
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getRaisonSocial()).thenThrow(new ResourceNotFoundException("An error occurred"));
        when(structuresDto.getSigle()).thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> structuresServices.initConfigStructure(structuresDto));
        verify(structuresDto).getRaisonSocial();
    }
}

