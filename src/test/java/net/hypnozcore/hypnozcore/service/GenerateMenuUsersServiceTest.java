package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.Menus;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.UserApplications;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GenerateMenuUsersServiceTest {
    @MockBean
    private UserApplicationsRepository userApplicationsRepository;

    @MockBean
    private UserFonctionsRepository userFonctionsRepository;

    @MockBean
    private UserModulesRepository userModulesRepository;

    @Autowired
    private GenerateMenuUsersService generateMenuUsersService;

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
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles6() {
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
        Modules modules2 = mock(Modules.class);
        when(modules2.getActive()).thenReturn("Y");
        doNothing().when(modules2).setCreatedBy((String) any());
        doNothing().when(modules2).setCreatedDate((Date) any());
        doNothing().when(modules2).setFlagEtat((Etats) any());
        doNothing().when(modules2).setId((Long) any());
        doNothing().when(modules2).setLastModifiedBy((String) any());
        doNothing().when(modules2).setLastModifiedDate((Date) any());
        doNothing().when(modules2).setActive((String) any());
        doNothing().when(modules2).setCode((String) any());
        doNothing().when(modules2).setIconClass((String) any());
        doNothing().when(modules2).setLibCode((String) any());
        doNothing().when(modules2).setLibDesc((String) any());
        doNothing().when(modules2).setOrdre(anyInt());
        doNothing().when(modules2).setStandart(anyInt());
        doNothing().when(modules2).setUrl((String) any());
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

        UserModules.UserModulesPK userModulesPK2 = new UserModules.UserModulesPK();
        userModulesPK2.setModulesId(123L);
        userModulesPK2.setUsersId(123L);
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getId()).thenReturn(userModulesPK2);
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
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles7() {
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
        Modules modules2 = mock(Modules.class);
        when(modules2.getActive()).thenReturn("Y");
        doNothing().when(modules2).setCreatedBy((String) any());
        doNothing().when(modules2).setCreatedDate((Date) any());
        doNothing().when(modules2).setFlagEtat((Etats) any());
        doNothing().when(modules2).setId((Long) any());
        doNothing().when(modules2).setLastModifiedBy((String) any());
        doNothing().when(modules2).setLastModifiedDate((Date) any());
        doNothing().when(modules2).setActive((String) any());
        doNothing().when(modules2).setCode((String) any());
        doNothing().when(modules2).setIconClass((String) any());
        doNothing().when(modules2).setLibCode((String) any());
        doNothing().when(modules2).setLibDesc((String) any());
        doNothing().when(modules2).setOrdre(anyInt());
        doNothing().when(modules2).setStandart(anyInt());
        doNothing().when(modules2).setUrl((String) any());
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

        UserModules.UserModulesPK userModulesPK2 = new UserModules.UserModulesPK();
        userModulesPK2.setModulesId(null);
        userModulesPK2.setUsersId(123L);
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getId()).thenReturn(userModulesPK2);
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
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles8() {
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
        Modules modules2 = mock(Modules.class);
        when(modules2.getActive()).thenReturn("Y");
        doNothing().when(modules2).setCreatedBy((String) any());
        doNothing().when(modules2).setCreatedDate((Date) any());
        doNothing().when(modules2).setFlagEtat((Etats) any());
        doNothing().when(modules2).setId((Long) any());
        doNothing().when(modules2).setLastModifiedBy((String) any());
        doNothing().when(modules2).setLastModifiedDate((Date) any());
        doNothing().when(modules2).setActive((String) any());
        doNothing().when(modules2).setCode((String) any());
        doNothing().when(modules2).setIconClass((String) any());
        doNothing().when(modules2).setLibCode((String) any());
        doNothing().when(modules2).setLibDesc((String) any());
        doNothing().when(modules2).setOrdre(anyInt());
        doNothing().when(modules2).setStandart(anyInt());
        doNothing().when(modules2).setUrl((String) any());
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

        UserModules.UserModulesPK userModulesPK2 = new UserModules.UserModulesPK();
        userModulesPK2.setModulesId(123L);
        userModulesPK2.setUsersId(null);
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getId()).thenReturn(userModulesPK2);
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
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());

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
        assertThrows(ResponseException.class, () -> generateMenuUsersService.deleteUserApplication(2L, 123L));
    }

    /**
     * Method under test: {@link GenerateMenuUsersService#deleteUserModules(Long, Long)}
     */
    @Test
    void testDeleteUserModules() {
        assertThrows(ResponseException.class, () -> generateMenuUsersService.deleteUserModules(123L, 123L));
    }
}

