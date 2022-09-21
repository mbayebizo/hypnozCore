package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.UsersMapper;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.models.UserGroupes;
import net.hypnozcore.hypnozcore.models.UserStructures;
import net.hypnozcore.hypnozcore.models.Users;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.repository.UserGroupesRepository;
import net.hypnozcore.hypnozcore.repository.UserStructuresRepository;
import net.hypnozcore.hypnozcore.repository.UsersRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class UsersServicesTest {
    @MockBean
    private GroupesRepository groupesRepository;

    @MockBean
    private StructuresRepository structuresRepository;

    @MockBean
    private UserGroupesRepository userGroupesRepository;

    @MockBean
    private UserStructuresRepository userStructuresRepository;

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
        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");
        when(usersRepository.saveAndFlush((Users) any())).thenReturn(users);

        Groupes groupes = new Groupes();
        groupes.setCode("Code");
        groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setFlagEtat(Etats.INACTIVE);
        groupes.setId(123L);
        groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setLibelle("Libelle");
        groupes.setStructuresId(123L);
        Optional<Groupes> ofResult = Optional.of(groupes);
        when(groupesRepository.findById((Long) any())).thenReturn(ofResult);

        Structures structures = new Structures();
        structures.setActiviteCommerciale("Activite Commerciale");
        structures.setAdresse("Adresse");
        structures.setBilanSocail("Bilan Socail");
        structures.setCapital("Capital");
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures.setDepartement("Departement");
        structures.setDescription("The characteristics of someone or something");
        structures.setEmail("jane.doe@example.org");
        structures.setFlagEtat(Etats.INACTIVE);
        structures.setFormJuridique("Form Juridique");
        structures.setId(123L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
        Optional<Structures> ofResult1 = Optional.of(structures);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult1);
        when(userGroupesRepository.saveAndFlush((UserGroupes) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));

        Users users1 = new Users();
        users1.setAdresse("Adresse");
        users1.setBp("Bp");
        users1.setCel("Cel");
        users1.setCivilite("Civilite");
        users1.setCodeSecret("Code Secret");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Langue");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Login");
        users1.setNom("Nom");
        users1.setPatronyme("Patronyme");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Prenom");
        users1.setPwd("Pwd");
        users1.setSignature("Signature");
        users1.setTelBureau("Tel Bureau");
        users1.setTelDomicile("Tel Domicile");
        users1.setVille("Ville");
        when(usersMapper.toEntity((UsersDto) any())).thenReturn(users1);
        when(userStructuresRepository.saveAndFlush((UserStructures) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getId()).thenReturn(123L);
        GroupesDto groupesDto = mock(GroupesDto.class);
        when(groupesDto.getId()).thenReturn(123L);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getNom()).thenReturn("Nom");
        when(usersDto.getPrenom()).thenReturn("Prenom");
        when(usersDto.getGroupes()).thenReturn(groupesDto);
        when(usersDto.getStructuresDto()).thenReturn(structuresDto);
        when(usersDto.getPwd()).thenReturn("UUUUUUUUUU");
        assertThrows(ResponseException.class, () -> usersServices.save(usersDto));
        verify(usersRepository).saveAndFlush((Users) any());
        verify(groupesRepository).findById((Long) any());
        verify(structuresRepository).findById((Long) any());
        verify(usersMapper).toEntity((UsersDto) any());
        verify(userStructuresRepository).saveAndFlush((UserStructures) any());
        verify(usersDto).getNom();
        verify(usersDto).getPrenom();
        verify(usersDto).getPwd();
        verify(usersDto).getGroupes();
        verify(usersDto).getStructuresDto();
        verify(groupesDto).getId();
        verify(structuresDto).getId();
    }

    /**
     * Method under test: {@link UsersServices#save(UsersDto)}
     */
    @Test
    void testSave3() {
        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");
        when(usersRepository.saveAndFlush((Users) any())).thenReturn(users);

        Groupes groupes = new Groupes();
        groupes.setCode("Code");
        groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setFlagEtat(Etats.INACTIVE);
        groupes.setId(123L);
        groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setLibelle("Libelle");
        groupes.setStructuresId(123L);
        Optional<Groupes> ofResult = Optional.of(groupes);
        when(groupesRepository.findById((Long) any())).thenReturn(ofResult);

        Structures structures = new Structures();
        structures.setActiviteCommerciale("Activite Commerciale");
        structures.setAdresse("Adresse");
        structures.setBilanSocail("Bilan Socail");
        structures.setCapital("Capital");
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures.setDepartement("Departement");
        structures.setDescription("The characteristics of someone or something");
        structures.setEmail("jane.doe@example.org");
        structures.setFlagEtat(Etats.INACTIVE);
        structures.setFormJuridique("Form Juridique");
        structures.setId(123L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
        Optional<Structures> ofResult1 = Optional.of(structures);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult1);
        when(userGroupesRepository.saveAndFlush((UserGroupes) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));

        Users users1 = new Users();
        users1.setAdresse("Adresse");
        users1.setBp("Bp");
        users1.setCel("Cel");
        users1.setCivilite("Civilite");
        users1.setCodeSecret("Code Secret");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Langue");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Login");
        users1.setNom("Nom");
        users1.setPatronyme("Patronyme");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Prenom");
        users1.setPwd("Pwd");
        users1.setSignature("Signature");
        users1.setTelBureau("Tel Bureau");
        users1.setTelDomicile("Tel Domicile");
        users1.setVille("Ville");
        when(usersMapper.toEntity((UsersDto) any())).thenReturn(users1);
        when(userStructuresRepository.saveAndFlush((UserStructures) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getId()).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getNom()).thenReturn("Nom");
        when(usersDto.getPrenom()).thenReturn("Prenom");
        when(usersDto.getGroupes()).thenReturn(mock(GroupesDto.class));
        when(usersDto.getStructuresDto()).thenReturn(structuresDto);
        when(usersDto.getPwd()).thenReturn("UUUUUUUUUU");
        assertThrows(ResponseException.class, () -> usersServices.save(usersDto));
        verify(usersMapper).toEntity((UsersDto) any());
        verify(usersDto).getPwd();
        verify(usersDto).getStructuresDto();
        verify(structuresDto).getId();
    }

    /**
     * Method under test: {@link UsersServices#save(UsersDto)}
     */
    @Test
    void testSave4() {
        Users users = mock(Users.class);
        doNothing().when(users).setCreatedBy((String) any());
        doNothing().when(users).setCreatedDate((Date) any());
        doNothing().when(users).setFlagEtat((Etats) any());
        doNothing().when(users).setId((Long) any());
        doNothing().when(users).setLastModifiedBy((String) any());
        doNothing().when(users).setLastModifiedDate((Date) any());
        doNothing().when(users).setAdresse((String) any());
        doNothing().when(users).setBp((String) any());
        doNothing().when(users).setCel((String) any());
        doNothing().when(users).setCivilite((String) any());
        doNothing().when(users).setCodeSecret((String) any());
        doNothing().when(users).setConnexion(anyInt());
        doNothing().when(users).setDateNaissance((LocalDate) any());
        doNothing().when(users).setFirstLog((LocalDate) any());
        doNothing().when(users).setLangue((String) any());
        doNothing().when(users).setLastLog((LocalDate) any());
        doNothing().when(users).setLogin((String) any());
        doNothing().when(users).setNom((String) any());
        doNothing().when(users).setPatronyme((String) any());
        doNothing().when(users).setPhoto((String) any());
        doNothing().when(users).setPrenom((String) any());
        doNothing().when(users).setPwd((String) any());
        doNothing().when(users).setSignature((String) any());
        doNothing().when(users).setTelBureau((String) any());
        doNothing().when(users).setTelDomicile((String) any());
        doNothing().when(users).setVille((String) any());
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");
        when(usersRepository.saveAndFlush((Users) any())).thenReturn(users);

        Groupes groupes = new Groupes();
        groupes.setCode("Code");
        groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setFlagEtat(Etats.INACTIVE);
        groupes.setId(123L);
        groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setLibelle("Libelle");
        groupes.setStructuresId(123L);
        Optional<Groupes> ofResult = Optional.of(groupes);
        when(groupesRepository.findById((Long) any())).thenReturn(ofResult);

        Structures structures = new Structures();
        structures.setActiviteCommerciale("Activite Commerciale");
        structures.setAdresse("Adresse");
        structures.setBilanSocail("Bilan Socail");
        structures.setCapital("Capital");
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures.setDepartement("Departement");
        structures.setDescription("The characteristics of someone or something");
        structures.setEmail("jane.doe@example.org");
        structures.setFlagEtat(Etats.INACTIVE);
        structures.setFormJuridique("Form Juridique");
        structures.setId(123L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
        Optional<Structures> ofResult1 = Optional.of(structures);
        when(structuresRepository.findById((Long) any())).thenReturn(ofResult1);
        when(userGroupesRepository.saveAndFlush((UserGroupes) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));

        Users users1 = new Users();
        users1.setAdresse("Adresse");
        users1.setBp("Bp");
        users1.setCel("Cel");
        users1.setCivilite("Civilite");
        users1.setCodeSecret("Code Secret");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Langue");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Login");
        users1.setNom("Nom");
        users1.setPatronyme("Patronyme");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Prenom");
        users1.setPwd("Pwd");
        users1.setSignature("Signature");
        users1.setTelBureau("Tel Bureau");
        users1.setTelDomicile("Tel Domicile");
        users1.setVille("Ville");
        when(usersMapper.toEntity((UsersDto) any())).thenReturn(users1);
        when(userStructuresRepository.saveAndFlush((UserStructures) any()))
                .thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        StructuresDto structuresDto = mock(StructuresDto.class);
        when(structuresDto.getId()).thenReturn(123L);
        GroupesDto groupesDto = mock(GroupesDto.class);
        when(groupesDto.getId()).thenThrow(new ResponseException(RequestErrorEnum.LIST_EMPTY));
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getNom()).thenReturn("Nom");
        when(usersDto.getPrenom()).thenReturn("Prenom");
        when(usersDto.getGroupes()).thenReturn(groupesDto);
        when(usersDto.getStructuresDto()).thenReturn(structuresDto);
        when(usersDto.getPwd()).thenReturn("UUUUUUUUUU");
        assertThrows(ResponseException.class, () -> usersServices.save(usersDto));
        verify(users).setCreatedBy((String) any());
        verify(users).setCreatedDate((Date) any());
        verify(users).setFlagEtat((Etats) any());
        verify(users).setId((Long) any());
        verify(users).setLastModifiedBy((String) any());
        verify(users).setLastModifiedDate((Date) any());
        verify(users).setAdresse((String) any());
        verify(users).setBp((String) any());
        verify(users).setCel((String) any());
        verify(users).setCivilite((String) any());
        verify(users).setCodeSecret((String) any());
        verify(users).setConnexion(anyInt());
        verify(users).setDateNaissance((LocalDate) any());
        verify(users).setFirstLog((LocalDate) any());
        verify(users).setLangue((String) any());
        verify(users).setLastLog((LocalDate) any());
        verify(users).setLogin((String) any());
        verify(users).setNom((String) any());
        verify(users).setPatronyme((String) any());
        verify(users).setPhoto((String) any());
        verify(users).setPrenom((String) any());
        verify(users).setPwd((String) any());
        verify(users).setSignature((String) any());
        verify(users).setTelBureau((String) any());
        verify(users).setTelDomicile((String) any());
        verify(users).setVille((String) any());
        verify(structuresRepository).findById((Long) any());
        verify(usersMapper).toEntity((UsersDto) any());
        verify(usersDto).getPwd();
        verify(usersDto).getGroupes();
        verify(usersDto).getStructuresDto();
        verify(groupesDto).getId();
        verify(structuresDto).getId();
    }

    /**
     * Method under test: {@link UsersServices#findUserActiveBygroupe(Long)}
     */
    @Test
    void testFindUserActiveBygroupe() {
        assertThrows(ResponseException.class, () -> usersServices.findUserActiveBygroupe(123L));
        assertThrows(ResponseException.class, () -> usersServices.findUserActiveBygroupe(1L));
    }

    /**
     * Method under test: {@link UsersServices#findUserBygroupe(Long)}
     */
    @Test
    void testFindUserBygroupe() {
        assertThrows(ResponseException.class, () -> usersServices.findUserBygroupe(123L));
        assertThrows(ResponseException.class, () -> usersServices.findUserBygroupe(1L));
    }
}

