package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
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

import net.hypnozcore.hypnozcore.dto.Menus;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.dto.UsersDto;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.UserApplications;
import net.hypnozcore.hypnozcore.models.UserFonctions;
import net.hypnozcore.hypnozcore.models.UserModules;
import net.hypnozcore.hypnozcore.models.Users;
import net.hypnozcore.hypnozcore.repository.UserApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.UserFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.UserModulesRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GenerateMenuUsersServiceTest {
    @Autowired
    private GenerateMenuUsersService generateMenuUsersService;

    @MockBean
    private UserApplicationsRepository userApplicationsRepository;

    @MockBean
    private UserFonctionsRepository userFonctionsRepository;

    @MockBean
    private UserModulesRepository userModulesRepository;

    /**
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles() {
        ArrayList<UserModules> userModulesList = new ArrayList<>();
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuUsersService.getRoles(usersDto, modulesDto);
        assertEquals(userModulesList, actualRoles.getBody());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles2() {
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenThrow(new ResponseException("An error occurred"));
        assertThrows(ResponseException.class, () -> generateMenuUsersService.getRoles(usersDto, modulesDto));
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles3() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuUsersService.getRoles(usersDto, modulesDto);
        assertTrue(actualRoles.hasBody());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles4() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");

        UserModules userModules1 = new UserModules();
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        ArrayList<UserApplications> userApplicationsList = new ArrayList<>();
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(userApplicationsList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuUsersService.getRoles(usersDto, modulesDto);
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(userApplicationsRepository).findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles5() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");

        Modules modules2 = new Modules();
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getModules()).thenReturn(modules2);
        doNothing().when(userModules1).setId((UserModules.UserModulesPK) any());
        doNothing().when(userModules1).setModules((Modules) any());
        doNothing().when(userModules1).setNew(anyBoolean());
        doNothing().when(userModules1).setUsers((Users) any());
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        ArrayList<UserApplications> userApplicationsList = new ArrayList<>();
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(userApplicationsList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuUsersService.getRoles(usersDto, modulesDto);
        assertEquals(userApplicationsList, actualRoles.getBody());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(userModules1).getModules();
        verify(userModules1).setId((UserModules.UserModulesPK) any());
        verify(userModules1).setModules((Modules) any());
        verify(userModules1).setNew(anyBoolean());
        verify(userModules1).setUsers((Users) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getMenuByUser(UserModules)}
     */
    @Test
    void testGetMenuByUser() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);
        assertTrue(generateMenuUsersService.getMenuByUser(userModules).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getMenuByUser(UserModules)}
     */
    @Test
    void testGetMenuByUser2() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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
        UserModules.UserModulesPK id = new UserModules.UserModulesPK();
        Modules modules1 = new Modules();

        UserModules userModules = new UserModules(id, modules1, new Users(), true);
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);
        assertTrue(generateMenuUsersService.getMenuByUser(userModules).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#deleteUserFonction(Long, Long)}
     */
    @Test
    void testDeleteUserFonction() {
        assertThrows(ResponseException.class, () -> generateMenuUsersService.deleteUserFonction(123L, 123L));
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#deleteUserApplication(Long, Long)}
     */
    @Test
    void testDeleteUserApplication() {
        assertThrows(ResponseException.class, () -> generateMenuUsersService.deleteUserApplication(123L, 123L));
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#deleteUserModules(Long, Long)}
     */
    @Test
    void testDeleteUserModules() {
        assertThrows(ResponseException.class, () -> generateMenuUsersService.deleteUserModules(123L, 123L));
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#addUserModules(Users, Modules)}
     */
    @Test
    void testAddUserModules() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Active");
        modules1.setCode("Code");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Icon Class");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Lib Code");
        modules1.setLibDesc("Lib Desc");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

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
        users1.setEtat(true);
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

        UserModules userModules1 = new UserModules();
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);
        Optional<UserModules> ofResult = Optional.of(userModules1);
        doNothing().when(userModulesRepository).deleteByModulesAndUsers((Modules) any(), (Users) any());
        when(userModulesRepository.saveAndFlush((UserModules) any())).thenReturn(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersId((Long) any(), (Long) any())).thenReturn(ofResult);

        Users users2 = new Users();
        users2.setAdresse("Adresse");
        users2.setBp("Bp");
        users2.setCel("Cel");
        users2.setCivilite("Civilite");
        users2.setCodeSecret("Code Secret");
        users2.setConnexion(1);
        users2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        users2.setDateNaissance(LocalDate.ofEpochDay(1L));
        users2.setEtat(true);
        users2.setFirstLog(LocalDate.ofEpochDay(1L));
        users2.setFlagEtat(Etats.INACTIVE);
        users2.setId(123L);
        users2.setLangue("Langue");
        users2.setLastLog(LocalDate.ofEpochDay(1L));
        users2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        users2.setLogin("Login");
        users2.setNom("Nom");
        users2.setPatronyme("Patronyme");
        users2.setPhoto("alice.liddell@example.org");
        users2.setPrenom("Prenom");
        users2.setPwd("Pwd");
        users2.setSignature("Signature");
        users2.setTelBureau("Tel Bureau");
        users2.setTelDomicile("Tel Domicile");
        users2.setVille("Ville");

        Modules modules2 = new Modules();
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");
        ResponseEntity<UserModules> actualAddUserModulesResult = generateMenuUsersService.addUserModules(users2, modules2);
        assertTrue(actualAddUserModulesResult.hasBody());
        assertTrue(actualAddUserModulesResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CREATED, actualAddUserModulesResult.getStatusCode());
        UserModules body = actualAddUserModulesResult.getBody();
        assertFalse(body.isNew());
        assertSame(modules2, body.getModules());
        assertEquals(users, body.getUsers());
        verify(userModulesRepository).saveAndFlush((UserModules) any());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersId((Long) any(), (Long) any());
        verify(userModulesRepository).deleteByModulesAndUsers((Modules) any(), (Users) any());
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#addUserModules(Users, Modules)}
     */
    @Test
    void testAddUserModules2() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Active");
        modules1.setCode("Code");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Icon Class");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Lib Code");
        modules1.setLibDesc("Lib Desc");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

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
        users1.setEtat(true);
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

        UserModules userModules1 = new UserModules();
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);
        Optional<UserModules> ofResult = Optional.of(userModules1);
        doThrow(new ResponseException("An error occurred")).when(userModulesRepository)
                .deleteByModulesAndUsers((Modules) any(), (Users) any());
        when(userModulesRepository.saveAndFlush((UserModules) any())).thenReturn(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersId((Long) any(), (Long) any())).thenReturn(ofResult);

        Users users2 = new Users();
        users2.setAdresse("Adresse");
        users2.setBp("Bp");
        users2.setCel("Cel");
        users2.setCivilite("Civilite");
        users2.setCodeSecret("Code Secret");
        users2.setConnexion(1);
        users2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        users2.setDateNaissance(LocalDate.ofEpochDay(1L));
        users2.setEtat(true);
        users2.setFirstLog(LocalDate.ofEpochDay(1L));
        users2.setFlagEtat(Etats.INACTIVE);
        users2.setId(123L);
        users2.setLangue("Langue");
        users2.setLastLog(LocalDate.ofEpochDay(1L));
        users2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        users2.setLogin("Login");
        users2.setNom("Nom");
        users2.setPatronyme("Patronyme");
        users2.setPhoto("alice.liddell@example.org");
        users2.setPrenom("Prenom");
        users2.setPwd("Pwd");
        users2.setSignature("Signature");
        users2.setTelBureau("Tel Bureau");
        users2.setTelDomicile("Tel Domicile");
        users2.setVille("Ville");

        Modules modules2 = new Modules();
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");
        assertThrows(ResponseException.class, () -> generateMenuUsersService.addUserModules(users2, modules2));
        verify(userModulesRepository).findByIdModulesIdAndIdUsersId((Long) any(), (Long) any());
        verify(userModulesRepository).deleteByModulesAndUsers((Modules) any(), (Users) any());
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#addUserFonction(Users, Fonctions)}
     */
    @Test
    void testAddUserFonction() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.orm.jpa.JpaSystemException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.UserFonctions.users]; nested exception is org.hibernate.id.IdentifierGenerationException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.UserFonctions.users]
        //       at org.springframework.orm.jpa.vendor.HibernateJpaDialect.convertHibernateAccessException(HibernateJpaDialect.java:331)
        //       at org.springframework.orm.jpa.vendor.HibernateJpaDialect.translateExceptionIfPossible(HibernateJpaDialect.java:233)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.translateExceptionIfPossible(AbstractEntityManagerFactoryBean.java:551)
        //       at org.springframework.dao.support.ChainedPersistenceExceptionTranslator.translateExceptionIfPossible(ChainedPersistenceExceptionTranslator.java:61)
        //       at org.springframework.dao.support.DataAccessUtils.translateIfNecessary(DataAccessUtils.java:242)
        //       at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:152)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:174)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215)
        //       at jdk.proxy4.$Proxy198.saveAndFlush(null)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuUsersService.addUserFonction(GenerateMenuUsersService.java:151)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuUsersService$$FastClassBySpringCGLIB$$bc1abbab.invoke(<generated>)
        //       at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
        //       at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:793)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        //       at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:763)
        //       at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123)
        //       at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:388)
        //       at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:763)
        //       at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:708)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuUsersService$$EnhancerBySpringCGLIB$$fb5bcd0f.addUserFonction(<generated>)
        //   In order to prevent addUserFonction(Users, Fonctions)
        //   from throwing JpaSystemException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addUserFonction(Users, Fonctions).
        //   See https://diff.blue/R013 to resolve this issue.

        UserFonctionsRepository userFonctionsRepository = mock(UserFonctionsRepository.class);
        when(userFonctionsRepository.saveAndFlush((UserFonctions) any()))
                .thenThrow(new ResponseException("An error occurred"));
        when(userFonctionsRepository.findByIdFonctionsIdAndIdUsersId((Long) any(), (Long) any()))
                .thenThrow(new ResponseException("An error occurred"));
        GenerateMenuUsersService generateMenuUsersService = new GenerateMenuUsersService(mock(UserModulesRepository.class),
                mock(UserApplicationsRepository.class), userFonctionsRepository);

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
        users.setEtat(true);
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

        Fonctions fonctions = new Fonctions();
        fonctions.setActions("Actions");
        fonctions.setActive("Active");
        fonctions.setApplication("Application");
        fonctions.setApplicationsId(123L);
        fonctions.setCode("Code");
        fonctions.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions.setFlagEtat(Etats.INACTIVE);
        fonctions.setIconClass("Icon Class");
        fonctions.setId(123L);
        fonctions.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions.setLibCode("Lib Code");
        fonctions.setLibDesc("Lib Desc");
        fonctions.setModule("Module");
        fonctions.setOrdre(1);
        fonctions.setType("Type");
        fonctions.setUrl("https://example.org/example");
        fonctions.setUsed(true);
        assertThrows(ResponseException.class, () -> generateMenuUsersService.addUserFonction(users, fonctions));
        verify(userFonctionsRepository).findByIdFonctionsIdAndIdUsersId((Long) any(), (Long) any());
    }


}

