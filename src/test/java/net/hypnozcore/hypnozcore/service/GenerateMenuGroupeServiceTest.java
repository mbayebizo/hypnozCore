package net.hypnozcore.hypnozcore.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.GroupesApplications;
import net.hypnozcore.hypnozcore.models.GroupesFonctions;
import net.hypnozcore.hypnozcore.models.GroupesModules;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.repository.GroupesApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesModulesRepository;
import net.hypnozcore.hypnozcore.repository.UserApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.UserFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.UserModulesRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GenerateMenuGroupeServiceTest {
    @MockBean
    private GroupesApplicationsRepository groupesApplicationsRepository;

    @MockBean
    private GroupesFonctionsRepository groupesFonctionsRepository;

    @MockBean
    private GroupesModulesRepository groupesModulesRepository;

    @MockBean
    private UserApplicationsRepository userApplicationsRepository;

    @MockBean
    private UserFonctionsRepository userFonctionsRepository;

    @MockBean
    private UserModulesRepository userModulesRepository;

    @Autowired
    private GenerateMenuGroupeService generateMenuGroupeService;

    /**
     * Method under test: {@link GenerateMenuGroupeService#deleteFonctionByGroupe(Long, Long)}
     */
    @Test
    void testDeleteFonctionByGroupe() {
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteFonctionByGroupe(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteFonctionByGroupe(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#deleteGroupeApplication(long, long)}
     */
    @Test
    void testDeleteGroupeApplication() {
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeApplication(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeApplication(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#deleteGroupeModule(Long, Long)}
     */
    @Test
    void testDeleteGroupeModule() {
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeModule(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeModule(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#addGroupesModules(Groupes, Modules)}
     */
    @Test
    void testAddGroupesModules() {
        Groupes groupes = new Groupes();
        groupes.setCode("Code");
        groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setFlagEtat(Etats.INACTIVE);
        groupes.setId(123L);
        groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setLibelle("Libelle");
        groupes.setStructuresId(123L);

        GroupesModules.GroupesModulesPK groupesModulesPK = new GroupesModules.GroupesModulesPK();
        groupesModulesPK.setGroupesId(123L);
        groupesModulesPK.setModulesId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        GroupesModules groupesModules = new GroupesModules();
        groupesModules.setGroupes(groupes);
        groupesModules.setId(groupesModulesPK);
        groupesModules.setModules(modules);
        groupesModules.setNew(true);

        Groupes groupes1 = new Groupes();
        groupes1.setCode("Code");
        groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setFlagEtat(Etats.INACTIVE);
        groupes1.setId(123L);
        groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setLibelle("Libelle");
        groupes1.setStructuresId(123L);

        GroupesModules.GroupesModulesPK groupesModulesPK1 = new GroupesModules.GroupesModulesPK();
        groupesModulesPK1.setGroupesId(123L);
        groupesModulesPK1.setModulesId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Active");
        modules1.setCode("Code");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Icon Class");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Lib Code");
        modules1.setLibDesc("Lib Desc");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        GroupesModules groupesModules1 = new GroupesModules();
        groupesModules1.setGroupes(groupes1);
        groupesModules1.setId(groupesModulesPK1);
        groupesModules1.setModules(modules1);
        groupesModules1.setNew(true);
        Optional<GroupesModules> ofResult = Optional.of(groupesModules1);
        doNothing().when(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
        when(groupesModulesRepository.saveAndFlush((GroupesModules) any())).thenReturn(groupesModules);
        when(groupesModulesRepository.findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any())).thenReturn(ofResult);

        Groupes groupes2 = new Groupes();
        groupes2.setCode("Code");
        groupes2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setFlagEtat(Etats.INACTIVE);
        groupes2.setId(123L);
        groupes2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setLibelle("Libelle");
        groupes2.setStructuresId(123L);

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
        ResponseEntity<GroupesModules> actualAddGroupesModulesResult = generateMenuGroupeService
                .addGroupesModules(groupes2, modules2);
        assertTrue(actualAddGroupesModulesResult.hasBody());
        assertTrue(actualAddGroupesModulesResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.ACCEPTED, actualAddGroupesModulesResult.getStatusCode());
        GroupesModules body = actualAddGroupesModulesResult.getBody();
        assertFalse(body.isNew());
        assertEquals(groupes, body.getGroupes());
        assertSame(modules2, body.getModules());
        verify(groupesModulesRepository).saveAndFlush((GroupesModules) any());
        verify(groupesModulesRepository).findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any());
        verify(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#addGroupesModules(Groupes, Modules)}
     */
    @Test
    void testAddGroupesModules2() {
        Groupes groupes = new Groupes();
        groupes.setCode("Code");
        groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setFlagEtat(Etats.INACTIVE);
        groupes.setId(123L);
        groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setLibelle("Libelle");
        groupes.setStructuresId(123L);

        GroupesModules.GroupesModulesPK groupesModulesPK = new GroupesModules.GroupesModulesPK();
        groupesModulesPK.setGroupesId(123L);
        groupesModulesPK.setModulesId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        GroupesModules groupesModules = new GroupesModules();
        groupesModules.setGroupes(groupes);
        groupesModules.setId(groupesModulesPK);
        groupesModules.setModules(modules);
        groupesModules.setNew(true);

        Groupes groupes1 = new Groupes();
        groupes1.setCode("Code");
        groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setFlagEtat(Etats.INACTIVE);
        groupes1.setId(123L);
        groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setLibelle("Libelle");
        groupes1.setStructuresId(123L);

        GroupesModules.GroupesModulesPK groupesModulesPK1 = new GroupesModules.GroupesModulesPK();
        groupesModulesPK1.setGroupesId(123L);
        groupesModulesPK1.setModulesId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Active");
        modules1.setCode("Code");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Icon Class");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Lib Code");
        modules1.setLibDesc("Lib Desc");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        GroupesModules groupesModules1 = new GroupesModules();
        groupesModules1.setGroupes(groupes1);
        groupesModules1.setId(groupesModulesPK1);
        groupesModules1.setModules(modules1);
        groupesModules1.setNew(true);
        Optional<GroupesModules> ofResult = Optional.of(groupesModules1);
        doThrow(new ResponseException("An error occurred")).when(groupesModulesRepository)
                .deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
        when(groupesModulesRepository.saveAndFlush((GroupesModules) any())).thenReturn(groupesModules);
        when(groupesModulesRepository.findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any())).thenReturn(ofResult);

        Groupes groupes2 = new Groupes();
        groupes2.setCode("Code");
        groupes2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setFlagEtat(Etats.INACTIVE);
        groupes2.setId(123L);
        groupes2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setLibelle("Libelle");
        groupes2.setStructuresId(123L);

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
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.addGroupesModules(groupes2, modules2));
        verify(groupesModulesRepository).findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any());
        verify(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#addGroupesFonctions(Groupes, Fonctions)}
     */
    @Test
    void testAddGroupesFonctions() {
        Fonctions fonctions = new Fonctions();
        fonctions.setActions("Actions");
        fonctions.setActive("Active");
        fonctions.setApplication("Application");
        fonctions.setApplicationsId(123L);
        fonctions.setCode("Code");
        fonctions.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions.setFlagEtat(Etats.INACTIVE);
        fonctions.setIconClass("Icon Class");
        fonctions.setId(123L);
        fonctions.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions.setLibCode("Lib Code");
        fonctions.setLibDesc("Lib Desc");
        fonctions.setModule("Module");
        fonctions.setOrdre(1);
        fonctions.setType("Type");
        fonctions.setUrl("https://example.org/example");
        fonctions.setUsed(true);

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

        GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK = new GroupesFonctions.GroupesFonctionsPK();
        groupesFonctionsPK.setFonctionsId(123L);
        groupesFonctionsPK.setGroupesId(123L);

        GroupesFonctions groupesFonctions = new GroupesFonctions();
        groupesFonctions.setFonctions(fonctions);
        groupesFonctions.setGroupes(groupes);
        groupesFonctions.setId(groupesFonctionsPK);
        groupesFonctions.setNew(true);

        Fonctions fonctions1 = new Fonctions();
        fonctions1.setActions("Actions");
        fonctions1.setActive("Active");
        fonctions1.setApplication("Application");
        fonctions1.setApplicationsId(123L);
        fonctions1.setCode("Code");
        fonctions1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions1.setFlagEtat(Etats.INACTIVE);
        fonctions1.setIconClass("Icon Class");
        fonctions1.setId(123L);
        fonctions1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions1.setLibCode("Lib Code");
        fonctions1.setLibDesc("Lib Desc");
        fonctions1.setModule("Module");
        fonctions1.setOrdre(1);
        fonctions1.setType("Type");
        fonctions1.setUrl("https://example.org/example");
        fonctions1.setUsed(true);

        Groupes groupes1 = new Groupes();
        groupes1.setCode("Code");
        groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setFlagEtat(Etats.INACTIVE);
        groupes1.setId(123L);
        groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setLibelle("Libelle");
        groupes1.setStructuresId(123L);

        GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK1 = new GroupesFonctions.GroupesFonctionsPK();
        groupesFonctionsPK1.setFonctionsId(123L);
        groupesFonctionsPK1.setGroupesId(123L);

        GroupesFonctions groupesFonctions1 = new GroupesFonctions();
        groupesFonctions1.setFonctions(fonctions1);
        groupesFonctions1.setGroupes(groupes1);
        groupesFonctions1.setId(groupesFonctionsPK1);
        groupesFonctions1.setNew(true);
        Optional<GroupesFonctions> ofResult = Optional.of(groupesFonctions1);
        doNothing().when(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
        when(groupesFonctionsRepository.saveAndFlush((GroupesFonctions) any())).thenReturn(groupesFonctions);
        when(groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any()))
                .thenReturn(ofResult);

        Groupes groupes2 = new Groupes();
        groupes2.setCode("Code");
        groupes2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setFlagEtat(Etats.INACTIVE);
        groupes2.setId(123L);
        groupes2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setLibelle("Libelle");
        groupes2.setStructuresId(123L);

        Fonctions fonctions2 = new Fonctions();
        fonctions2.setActions("Actions");
        fonctions2.setActive("Active");
        fonctions2.setApplication("Application");
        fonctions2.setApplicationsId(123L);
        fonctions2.setCode("Code");
        fonctions2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions2.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions2.setFlagEtat(Etats.INACTIVE);
        fonctions2.setIconClass("Icon Class");
        fonctions2.setId(123L);
        fonctions2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions2.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions2.setLibCode("Lib Code");
        fonctions2.setLibDesc("Lib Desc");
        fonctions2.setModule("Module");
        fonctions2.setOrdre(1);
        fonctions2.setType("Type");
        fonctions2.setUrl("https://example.org/example");
        fonctions2.setUsed(true);
        ResponseEntity<GroupesFonctions> actualAddGroupesFonctionsResult = generateMenuGroupeService
                .addGroupesFonctions(groupes2, fonctions2);
        assertTrue(actualAddGroupesFonctionsResult.hasBody());
        assertTrue(actualAddGroupesFonctionsResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CREATED, actualAddGroupesFonctionsResult.getStatusCode());
        GroupesFonctions body = actualAddGroupesFonctionsResult.getBody();
        assertFalse(body.isNew());
        assertSame(fonctions2, body.getFonctions());
        assertEquals(groupes, body.getGroupes());
        verify(groupesFonctionsRepository).saveAndFlush((GroupesFonctions) any());
        verify(groupesFonctionsRepository).findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any());
        verify(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#addGroupesFonctions(Groupes, Fonctions)}
     */
    @Test
    void testAddGroupesFonctions2() {
        Fonctions fonctions = new Fonctions();
        fonctions.setActions("Actions");
        fonctions.setActive("Active");
        fonctions.setApplication("Application");
        fonctions.setApplicationsId(123L);
        fonctions.setCode("Code");
        fonctions.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions.setFlagEtat(Etats.INACTIVE);
        fonctions.setIconClass("Icon Class");
        fonctions.setId(123L);
        fonctions.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions.setLibCode("Lib Code");
        fonctions.setLibDesc("Lib Desc");
        fonctions.setModule("Module");
        fonctions.setOrdre(1);
        fonctions.setType("Type");
        fonctions.setUrl("https://example.org/example");
        fonctions.setUsed(true);

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

        GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK = new GroupesFonctions.GroupesFonctionsPK();
        groupesFonctionsPK.setFonctionsId(123L);
        groupesFonctionsPK.setGroupesId(123L);

        GroupesFonctions groupesFonctions = new GroupesFonctions();
        groupesFonctions.setFonctions(fonctions);
        groupesFonctions.setGroupes(groupes);
        groupesFonctions.setId(groupesFonctionsPK);
        groupesFonctions.setNew(true);

        Fonctions fonctions1 = new Fonctions();
        fonctions1.setActions("Actions");
        fonctions1.setActive("Active");
        fonctions1.setApplication("Application");
        fonctions1.setApplicationsId(123L);
        fonctions1.setCode("Code");
        fonctions1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions1.setFlagEtat(Etats.INACTIVE);
        fonctions1.setIconClass("Icon Class");
        fonctions1.setId(123L);
        fonctions1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions1.setLibCode("Lib Code");
        fonctions1.setLibDesc("Lib Desc");
        fonctions1.setModule("Module");
        fonctions1.setOrdre(1);
        fonctions1.setType("Type");
        fonctions1.setUrl("https://example.org/example");
        fonctions1.setUsed(true);

        Groupes groupes1 = new Groupes();
        groupes1.setCode("Code");
        groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setFlagEtat(Etats.INACTIVE);
        groupes1.setId(123L);
        groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        groupes1.setLibelle("Libelle");
        groupes1.setStructuresId(123L);

        GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK1 = new GroupesFonctions.GroupesFonctionsPK();
        groupesFonctionsPK1.setFonctionsId(123L);
        groupesFonctionsPK1.setGroupesId(123L);

        GroupesFonctions groupesFonctions1 = new GroupesFonctions();
        groupesFonctions1.setFonctions(fonctions1);
        groupesFonctions1.setGroupes(groupes1);
        groupesFonctions1.setId(groupesFonctionsPK1);
        groupesFonctions1.setNew(true);
        Optional<GroupesFonctions> ofResult = Optional.of(groupesFonctions1);
        doThrow(new ResponseException("An error occurred")).when(groupesFonctionsRepository)
                .deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
        when(groupesFonctionsRepository.saveAndFlush((GroupesFonctions) any())).thenReturn(groupesFonctions);
        when(groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any()))
                .thenReturn(ofResult);

        Groupes groupes2 = new Groupes();
        groupes2.setCode("Code");
        groupes2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setFlagEtat(Etats.INACTIVE);
        groupes2.setId(123L);
        groupes2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        groupes2.setLibelle("Libelle");
        groupes2.setStructuresId(123L);

        Fonctions fonctions2 = new Fonctions();
        fonctions2.setActions("Actions");
        fonctions2.setActive("Active");
        fonctions2.setApplication("Application");
        fonctions2.setApplicationsId(123L);
        fonctions2.setCode("Code");
        fonctions2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions2.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions2.setFlagEtat(Etats.INACTIVE);
        fonctions2.setIconClass("Icon Class");
        fonctions2.setId(123L);
        fonctions2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        fonctions2.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        fonctions2.setLibCode("Lib Code");
        fonctions2.setLibDesc("Lib Desc");
        fonctions2.setModule("Module");
        fonctions2.setOrdre(1);
        fonctions2.setType("Type");
        fonctions2.setUrl("https://example.org/example");
        fonctions2.setUsed(true);
        assertThrows(ResponseException.class, () -> generateMenuGroupeService.addGroupesFonctions(groupes2, fonctions2));
        verify(groupesFonctionsRepository).findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any());
        verify(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
    }

    /**
     * Method under test: {@link GenerateMenuGroupeService#addGroupesApplications(Groupes, Applications)}
     */
    @Test
    void testAddGroupesApplications() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.orm.jpa.JpaSystemException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.GroupesApplications.applications]; nested exception is org.hibernate.id.IdentifierGenerationException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.GroupesApplications.applications]
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
        //       at jdk.proxy4.$Proxy193.saveAndFlush(null)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuGroupeService.addGroupesApplications(GenerateMenuGroupeService.java:131)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuGroupeService$$FastClassBySpringCGLIB$$24a259b1.invoke(<generated>)
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
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuGroupeService$$EnhancerBySpringCGLIB$$8e89fca4.addGroupesApplications(<generated>)
        //   In order to prevent addGroupesApplications(Groupes, Applications)
        //   from throwing JpaSystemException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addGroupesApplications(Groupes, Applications).
        //   See https://diff.blue/R013 to resolve this issue.

        GroupesApplicationsRepository groupesApplicationsRepository = mock(GroupesApplicationsRepository.class);
        when(groupesApplicationsRepository.saveAndFlush((GroupesApplications) any()))
                .thenThrow(new ResponseException("An error occurred"));
        when(groupesApplicationsRepository.findByIdApplicationsIdAndIdGroupesId((Long) any(), (Long) any()))
                .thenThrow(new ResponseException("An error occurred"));
        GenerateMenuGroupeService generateMenuGroupeService = new GenerateMenuGroupeService(
                mock(GroupesFonctionsRepository.class), groupesApplicationsRepository, mock(GroupesModulesRepository.class),
                mock(UserModulesRepository.class), mock(UserApplicationsRepository.class),
                mock(UserFonctionsRepository.class));

        Groupes groupes = new Groupes();
        groupes.setCode("Code");
        groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setFlagEtat(Etats.INACTIVE);
        groupes.setId(123L);
        groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        groupes.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        groupes.setLibelle("Libelle");
        groupes.setStructuresId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Applications applications = new Applications();
        applications.setActive("Active");
        applications.setCode("Code");
        applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setFlagEtat(Etats.INACTIVE);
        applications.setIconClass("Icon Class");
        applications.setId(123L);
        applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setLibCode("Lib Code");
        applications.setLibDesc("Lib Desc");
        applications.setModule("Module");
        applications.setModules(modules);
        applications.setOrdre(1);
        applications.setUrl("https://example.org/example");
        assertThrows(ResponseException.class,
                () -> generateMenuGroupeService.addGroupesApplications(groupes, applications));
        verify(groupesApplicationsRepository).findByIdApplicationsIdAndIdGroupesId((Long) any(), (Long) any());
    }
}

