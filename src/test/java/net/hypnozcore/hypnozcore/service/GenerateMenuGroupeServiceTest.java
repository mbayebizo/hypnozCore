package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.GroupesApplications;
import net.hypnozcore.hypnozcore.models.GroupesFonctions;
import net.hypnozcore.hypnozcore.models.GroupesModules;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.GroupesApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesModulesRepository;
import net.hypnozcore.hypnozcore.repository.UserApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.UserFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.UserModulesRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GenerateMenuGroupeService.class})
@ExtendWith(SpringExtension.class)
class GenerateMenuGroupeServiceTest {
	@Autowired
	private GenerateMenuGroupeService generateMenuGroupeService;

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

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteFonctionByGroupe(Long, Long)}
	 */
	@Test
	void testDeleteFonctionByGroupe() {
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

		Structures structures = new Structures();
		structures.setActiviteCommerciale("Activite Commerciale");
		structures.setAdresse("Adresse");
		structures.setBilanSocail("Bilan Socail");
		structures.setCapital("Capital");
		structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures.setDepartement("Departement");
		structures.setDescription("The characteristics of someone or something");
		structures.setEmail("jane.doe@example.org");
		structures.setFlagEtat(Etats.INACTIVE);
		structures.setFormJuridique("Form Juridique");
		structures.setId(123L);
		structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);

		GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK = new GroupesFonctions.GroupesFonctionsPK();
		groupesFonctionsPK.setFonctionsId(123L);
		groupesFonctionsPK.setGroupesId(123L);

		GroupesFonctions groupesFonctions = new GroupesFonctions();
		groupesFonctions.setFonctions(fonctions);
		groupesFonctions.setGroupes(groupes);
		groupesFonctions.setId(groupesFonctionsPK);
		groupesFonctions.setNew(true);
		Optional<GroupesFonctions> ofResult = Optional.of(groupesFonctions);
		doNothing().when(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
		when(groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any())).thenReturn(ofResult);
		when(userFonctionsRepository.findByIdFonctionsId((Long) any())).thenReturn(new ArrayList<>());
		generateMenuGroupeService.deleteFonctionByGroupe(1L, 1L);
		verify(groupesFonctionsRepository).findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any());
		verify(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
		verify(userFonctionsRepository).findByIdFonctionsId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteFonctionByGroupe(Long, Long)}
	 */
	@Test
	void testDeleteFonctionByGroupe2() {
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

		Structures structures = new Structures();
		structures.setActiviteCommerciale("Activite Commerciale");
		structures.setAdresse("Adresse");
		structures.setBilanSocail("Bilan Socail");
		structures.setCapital("Capital");
		structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures.setDepartement("Departement");
		structures.setDescription("The characteristics of someone or something");
		structures.setEmail("jane.doe@example.org");
		structures.setFlagEtat(Etats.INACTIVE);
		structures.setFormJuridique("Form Juridique");
		structures.setId(123L);
		structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);

		GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK = new GroupesFonctions.GroupesFonctionsPK();
		groupesFonctionsPK.setFonctionsId(123L);
		groupesFonctionsPK.setGroupesId(123L);

		GroupesFonctions groupesFonctions = new GroupesFonctions();
		groupesFonctions.setFonctions(fonctions);
		groupesFonctions.setGroupes(groupes);
		groupesFonctions.setId(groupesFonctionsPK);
		groupesFonctions.setNew(true);
		Optional<GroupesFonctions> ofResult = Optional.of(groupesFonctions);
		doNothing().when(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
		when(groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any()))
				.thenReturn(ofResult);
		when(userFonctionsRepository.findByIdFonctionsId((Long) any()))
				.thenThrow(new ResponseException("An error occurred"));
		Assertions.assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteFonctionByGroupe(1L, 1L));
		verify(userFonctionsRepository).findByIdFonctionsId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteFonctionByGroupe(Long, Long)}
	 */
	@Test
	void testDeleteFonctionByGroupe3() {
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

		Structures structures = new Structures();
		structures.setActiviteCommerciale("Activite Commerciale");
		structures.setAdresse("Adresse");
		structures.setBilanSocail("Bilan Socail");
		structures.setCapital("Capital");
		structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures.setDepartement("Departement");
		structures.setDescription("The characteristics of someone or something");
		structures.setEmail("jane.doe@example.org");
		structures.setFlagEtat(Etats.INACTIVE);
		structures.setFormJuridique("Form Juridique");
		structures.setId(123L);
		structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);

		GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK = new GroupesFonctions.GroupesFonctionsPK();
		groupesFonctionsPK.setFonctionsId(123L);
		groupesFonctionsPK.setGroupesId(123L);

		Fonctions fonctions1 = new Fonctions();
		fonctions1.setActions("Actions");
		fonctions1.setActive("Active");
		fonctions1.setApplication("Application");
		fonctions1.setApplicationsId(123L);
		fonctions1.setCode("Code");
		fonctions1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions1.setFlagEtat(Etats.INACTIVE);
		fonctions1.setIconClass("Icon Class");
		fonctions1.setId(123L);
		fonctions1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions1.setLibCode("Lib Code");
		fonctions1.setLibDesc("Lib Desc");
		fonctions1.setModule("Module");
		fonctions1.setOrdre(1);
		fonctions1.setType("Type");
		fonctions1.setUrl("https://example.org/example");
		fonctions1.setUsed(true);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);
		GroupesFonctions groupesFonctions = mock(GroupesFonctions.class);
		when(groupesFonctions.getFonctions()).thenReturn(fonctions1);
		when(groupesFonctions.getGroupes()).thenReturn(groupes1);
		doNothing().when(groupesFonctions).setFonctions((Fonctions) any());
		doNothing().when(groupesFonctions).setGroupes((Groupes) any());
		doNothing().when(groupesFonctions).setId((GroupesFonctions.GroupesFonctionsPK) any());
		doNothing().when(groupesFonctions).setNew(anyBoolean());
		groupesFonctions.setFonctions(fonctions);
		groupesFonctions.setGroupes(groupes);
		groupesFonctions.setId(groupesFonctionsPK);
		groupesFonctions.setNew(true);
		Optional<GroupesFonctions> ofResult = Optional.of(groupesFonctions);
		doNothing().when(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
		when(groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any()))
				.thenReturn(ofResult);
		when(userFonctionsRepository.findByIdFonctionsId((Long) any())).thenReturn(new ArrayList<>());
		generateMenuGroupeService.deleteFonctionByGroupe(1L, 1L);
		verify(groupesFonctionsRepository).findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any());
		verify(groupesFonctionsRepository).deleteByFonctionsAndGroupes((Fonctions) any(), (Groupes) any());
		verify(groupesFonctions).getFonctions();
		verify(groupesFonctions).getGroupes();
		verify(groupesFonctions).setFonctions((Fonctions) any());
		verify(groupesFonctions).setGroupes((Groupes) any());
		verify(groupesFonctions).setId((GroupesFonctions.GroupesFonctionsPK) any());
		verify(groupesFonctions).setNew(anyBoolean());
		verify(userFonctionsRepository).findByIdFonctionsId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteGroupeApplication(long, long)}
	 */
	@Test
	void testDeleteGroupeApplication() {
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

		Applications applications = new Applications();
		applications.setActive("Active");
		applications.setCode("Code");
		applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setFlagEtat(Etats.INACTIVE);
		applications.setIconClass("Icon Class");
		applications.setId(123L);
		applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setLibCode("Lib Code");
		applications.setLibDesc("Lib Desc");
		applications.setModule("Module");
		applications.setModules(modules);
		applications.setOrdre(1);
		applications.setUrl("https://example.org/example");

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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);

		GroupesApplications.GroupesApplicationsPK groupesApplicationsPK = new GroupesApplications.GroupesApplicationsPK();
		groupesApplicationsPK.setApplicationsId(123L);
		groupesApplicationsPK.setGroupesId(123L);

		GroupesApplications groupesApplications = new GroupesApplications();
		groupesApplications.setApplications(applications);
		groupesApplications.setGroupes(groupes);
		groupesApplications.setId(groupesApplicationsPK);
		groupesApplications.setNew(true);
		Optional<GroupesApplications> ofResult = Optional.of(groupesApplications);
		doNothing().when(groupesApplicationsRepository)
				.deleteByApplicationsAndGroupes((Applications) any(), (Groupes) any());
		when(groupesApplicationsRepository.findByIdApplicationsIdAndIdGroupesId((Long) any(), (Long) any()))
				.thenReturn(ofResult);
		when(userApplicationsRepository.findByIdApplicationsId((Long) any())).thenReturn(new ArrayList<>());
		generateMenuGroupeService.deleteGroupeApplication(1L, 1L);
		verify(groupesApplicationsRepository).findByIdApplicationsIdAndIdGroupesId((Long) any(), (Long) any());
		verify(groupesApplicationsRepository).deleteByApplicationsAndGroupes((Applications) any(), (Groupes) any());
		verify(userApplicationsRepository).findByIdApplicationsId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteGroupeApplication(long, long)}
	 */
	@Test
	void testDeleteGroupeApplication2() {
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

		Applications applications = new Applications();
		applications.setActive("Active");
		applications.setCode("Code");
		applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setFlagEtat(Etats.INACTIVE);
		applications.setIconClass("Icon Class");
		applications.setId(123L);
		applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setLibCode("Lib Code");
		applications.setLibDesc("Lib Desc");
		applications.setModule("Module");
		applications.setModules(modules);
		applications.setOrdre(1);
		applications.setUrl("https://example.org/example");

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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);

		GroupesApplications.GroupesApplicationsPK groupesApplicationsPK = new GroupesApplications.GroupesApplicationsPK();
		groupesApplicationsPK.setApplicationsId(123L);
		groupesApplicationsPK.setGroupesId(123L);

		GroupesApplications groupesApplications = new GroupesApplications();
		groupesApplications.setApplications(applications);
		groupesApplications.setGroupes(groupes);
		groupesApplications.setId(groupesApplicationsPK);
		groupesApplications.setNew(true);
		Optional<GroupesApplications> ofResult = Optional.of(groupesApplications);
		doNothing().when(groupesApplicationsRepository)
				.deleteByApplicationsAndGroupes((Applications) any(), (Groupes) any());
		when(groupesApplicationsRepository.findByIdApplicationsIdAndIdGroupesId((Long) any(), (Long) any()))
				.thenReturn(ofResult);
		when(userApplicationsRepository.findByIdApplicationsId((Long) any()))
				.thenThrow(new ResponseException("An error occurred"));
		Assertions.assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeApplication(1L, 1L));
		verify(userApplicationsRepository).findByIdApplicationsId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteGroupeApplication(long, long)}
	 */
	@Test
	void testDeleteGroupeApplication3() {
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

		Applications applications = new Applications();
		applications.setActive("Active");
		applications.setCode("Code");
		applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setFlagEtat(Etats.INACTIVE);
		applications.setIconClass("Icon Class");
		applications.setId(123L);
		applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setLibCode("Lib Code");
		applications.setLibDesc("Lib Desc");
		applications.setModule("Module");
		applications.setModules(modules);
		applications.setOrdre(1);
		applications.setUrl("https://example.org/example");

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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);

		GroupesApplications.GroupesApplicationsPK groupesApplicationsPK = new GroupesApplications.GroupesApplicationsPK();
		groupesApplicationsPK.setApplicationsId(123L);
		groupesApplicationsPK.setGroupesId(123L);

		Modules modules1 = new Modules();
		modules1.setActive("Active");
		modules1.setCode("Code");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("Icon Class");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setLibCode("Lib Code");
		modules1.setLibDesc("Lib Desc");
		modules1.setOrdre(1);
		modules1.setStandart(1);
		modules1.setUrl("https://example.org/example");

		Applications applications1 = new Applications();
		applications1.setActive("Active");
		applications1.setCode("Code");
		applications1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setFlagEtat(Etats.INACTIVE);
		applications1.setIconClass("Icon Class");
		applications1.setId(123L);
		applications1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setLibCode("Lib Code");
		applications1.setLibDesc("Lib Desc");
		applications1.setModule("Module");
		applications1.setModules(modules1);
		applications1.setOrdre(1);
		applications1.setUrl("https://example.org/example");

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult12 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult12.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult13 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult13.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult14 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult14.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult15 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult15.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);
		GroupesApplications groupesApplications = mock(GroupesApplications.class);
		when(groupesApplications.getApplications()).thenReturn(applications1);
		when(groupesApplications.getGroupes()).thenReturn(groupes1);
		doNothing().when(groupesApplications).setApplications((Applications) any());
		doNothing().when(groupesApplications).setGroupes((Groupes) any());
		doNothing().when(groupesApplications).setId((GroupesApplications.GroupesApplicationsPK) any());
		doNothing().when(groupesApplications).setNew(anyBoolean());
		groupesApplications.setApplications(applications);
		groupesApplications.setGroupes(groupes);
		groupesApplications.setId(groupesApplicationsPK);
		groupesApplications.setNew(true);
		Optional<GroupesApplications> ofResult = Optional.of(groupesApplications);
		doNothing().when(groupesApplicationsRepository)
				.deleteByApplicationsAndGroupes((Applications) any(), (Groupes) any());
		when(groupesApplicationsRepository.findByIdApplicationsIdAndIdGroupesId((Long) any(), (Long) any()))
				.thenReturn(ofResult);
		when(userApplicationsRepository.findByIdApplicationsId((Long) any())).thenReturn(new ArrayList<>());
		generateMenuGroupeService.deleteGroupeApplication(1L, 1L);
		verify(groupesApplicationsRepository).findByIdApplicationsIdAndIdGroupesId((Long) any(), (Long) any());
		verify(groupesApplicationsRepository).deleteByApplicationsAndGroupes((Applications) any(), (Groupes) any());
		verify(groupesApplications).getApplications();
		verify(groupesApplications).getGroupes();
		verify(groupesApplications).setApplications((Applications) any());
		verify(groupesApplications).setGroupes((Groupes) any());
		verify(groupesApplications).setId((GroupesApplications.GroupesApplicationsPK) any());
		verify(groupesApplications).setNew(anyBoolean());
		verify(userApplicationsRepository).findByIdApplicationsId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteGroupeModule(Long, Long)}
	 */
	@Test
	void testDeleteGroupeModule() {
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
		groupes.setStructures(structures);

		GroupesModules.GroupesModulesPK groupesModulesPK = new GroupesModules.GroupesModulesPK();
		groupesModulesPK.setGroupesId(123L);
		groupesModulesPK.setModulesId(123L);

		Modules modules = new Modules();
		modules.setActive("Active");
		modules.setCode("Code");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("Icon Class");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
		Optional<GroupesModules> ofResult = Optional.of(groupesModules);
		doNothing().when(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
		when(groupesModulesRepository.findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any())).thenReturn(ofResult);
		when(userModulesRepository.findByIdModulesId((Long) any())).thenReturn(new ArrayList<>());
		generateMenuGroupeService.deleteGroupeModule(1L, 1L);
		verify(groupesModulesRepository).findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any());
		verify(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
		verify(userModulesRepository).findByIdModulesId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteGroupeModule(Long, Long)}
	 */
	@Test
	void testDeleteGroupeModule2() {
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
		groupes.setStructures(structures);

		GroupesModules.GroupesModulesPK groupesModulesPK = new GroupesModules.GroupesModulesPK();
		groupesModulesPK.setGroupesId(123L);
		groupesModulesPK.setModulesId(123L);

		Modules modules = new Modules();
		modules.setActive("Active");
		modules.setCode("Code");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("Icon Class");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
		Optional<GroupesModules> ofResult = Optional.of(groupesModules);
		doNothing().when(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
		when(groupesModulesRepository.findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any())).thenReturn(ofResult);
		when(userModulesRepository.findByIdModulesId((Long) any())).thenThrow(new ResponseException("An error occurred"));
		Assertions.assertThrows(ResponseException.class, () -> generateMenuGroupeService.deleteGroupeModule(1L, 1L));
		verify(userModulesRepository).findByIdModulesId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#deleteGroupeModule(Long, Long)}
	 */
	@Test
	void testDeleteGroupeModule3() {
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
		groupes.setStructures(structures);

		GroupesModules.GroupesModulesPK groupesModulesPK = new GroupesModules.GroupesModulesPK();
		groupesModulesPK.setGroupesId(123L);
		groupesModulesPK.setModulesId(123L);

		Modules modules = new Modules();
		modules.setActive("Active");
		modules.setCode("Code");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("Icon Class");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("Lib Code");
		modules.setLibDesc("Lib Desc");
		modules.setOrdre(1);
		modules.setStandart(1);
		modules.setUrl("https://example.org/example");

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);

		Modules modules1 = new Modules();
		modules1.setActive("Active");
		modules1.setCode("Code");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("Icon Class");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setLibCode("Lib Code");
		modules1.setLibDesc("Lib Desc");
		modules1.setOrdre(1);
		modules1.setStandart(1);
		modules1.setUrl("https://example.org/example");
		GroupesModules groupesModules = mock(GroupesModules.class);
		when(groupesModules.getGroupes()).thenReturn(groupes1);
		when(groupesModules.getModules()).thenReturn(modules1);
		doNothing().when(groupesModules).setGroupes((Groupes) any());
		doNothing().when(groupesModules).setId((GroupesModules.GroupesModulesPK) any());
		doNothing().when(groupesModules).setModules((Modules) any());
		doNothing().when(groupesModules).setNew(anyBoolean());
		groupesModules.setGroupes(groupes);
		groupesModules.setId(groupesModulesPK);
		groupesModules.setModules(modules);
		groupesModules.setNew(true);
		Optional<GroupesModules> ofResult = Optional.of(groupesModules);
		doNothing().when(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
		when(groupesModulesRepository.findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any())).thenReturn(ofResult);
		when(userModulesRepository.findByIdModulesId((Long) any())).thenReturn(new ArrayList<>());
		generateMenuGroupeService.deleteGroupeModule(1L, 1L);
		verify(groupesModulesRepository).findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any());
		verify(groupesModulesRepository).deleteByModulesAndGroupes((Modules) any(), (Groupes) any());
		verify(groupesModules).getGroupes();
		verify(groupesModules).getModules();
		verify(groupesModules).setGroupes((Groupes) any());
		verify(groupesModules).setId((GroupesModules.GroupesModulesPK) any());
		verify(groupesModules).setModules((Modules) any());
		verify(groupesModules).setNew(anyBoolean());
		verify(userModulesRepository).findByIdModulesId((Long) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#addGroupesModules(Groupes, Modules)}
	 */
	@Test
	@Disabled
	void testAddGroupesModules() {
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
		groupes.setStructures(structures);

		Modules modules = new Modules();
		modules.setActive("Active");
		modules.setCode("Code");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("Icon Class");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("Lib Code");
		modules.setLibDesc("Lib Desc");
		modules.setOrdre(1);
		modules.setStandart(1);
		modules.setUrl("https://example.org/example");
		assertTrue(generateMenuGroupeService.addGroupesModules(groupes, modules).isNew());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#addGroupesModules(Groupes, Modules)}
	 */
	@Test
	@Disabled
	void testAddGroupesModules2() {
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
		Groupes groupes = mock(Groupes.class);
		when(groupes.getId()).thenReturn(123L);
		doNothing().when(groupes).setCreatedBy((String) any());
		doNothing().when(groupes).setCreatedDate((Date) any());
		doNothing().when(groupes).setFlagEtat((Etats) any());
		doNothing().when(groupes).setId((Long) any());
		doNothing().when(groupes).setLastModifiedBy((String) any());
		doNothing().when(groupes).setLastModifiedDate((Date) any());
		doNothing().when(groupes).setCode((String) any());
		doNothing().when(groupes).setLibelle((String) any());
		doNothing().when(groupes).setStructures((Structures) any());
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
		groupes.setStructures(structures);

		Modules modules = new Modules();
		modules.setActive("Active");
		modules.setCode("Code");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("Icon Class");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("Lib Code");
		modules.setLibDesc("Lib Desc");
		modules.setOrdre(1);
		modules.setStandart(1);
		modules.setUrl("https://example.org/example");
		assertTrue(generateMenuGroupeService.addGroupesModules(groupes, modules).isNew());
		verify(groupes).getId();
		verify(groupes).setCreatedBy((String) any());
		verify(groupes).setCreatedDate((Date) any());
		verify(groupes).setFlagEtat((Etats) any());
		verify(groupes).setId((Long) any());
		verify(groupes).setLastModifiedBy((String) any());
		verify(groupes).setLastModifiedDate((Date) any());
		verify(groupes).setCode((String) any());
		verify(groupes).setLibelle((String) any());
		verify(groupes).setStructures((Structures) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#addGroupesModules(Groupes, Modules)}
	 */
	@Test
	void testAddGroupesModules3() {
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
		Groupes groupes = mock(Groupes.class);
		when(groupes.getId()).thenReturn(null);
		doNothing().when(groupes).setCreatedBy((String) any());
		doNothing().when(groupes).setCreatedDate((Date) any());
		doNothing().when(groupes).setFlagEtat((Etats) any());
		doNothing().when(groupes).setId((Long) any());
		doNothing().when(groupes).setLastModifiedBy((String) any());
		doNothing().when(groupes).setLastModifiedDate((Date) any());
		doNothing().when(groupes).setCode((String) any());
		doNothing().when(groupes).setLibelle((String) any());
		doNothing().when(groupes).setStructures((Structures) any());
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
		groupes.setStructures(structures);

		Modules modules = new Modules();
		modules.setActive("Active");
		modules.setCode("Code");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("Icon Class");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("Lib Code");
		modules.setLibDesc("Lib Desc");
		modules.setOrdre(1);
		modules.setStandart(1);
		modules.setUrl("https://example.org/example");
		assertThrows(ResponseException.class, () -> generateMenuGroupeService.addGroupesModules(groupes, modules));
		verify(groupes).getId();
		verify(groupes).setCreatedBy((String) any());
		verify(groupes).setCreatedDate((Date) any());
		verify(groupes).setFlagEtat((Etats) any());
		verify(groupes).setId((Long) any());
		verify(groupes).setLastModifiedBy((String) any());
		verify(groupes).setLastModifiedDate((Date) any());
		verify(groupes).setCode((String) any());
		verify(groupes).setLibelle((String) any());
		verify(groupes).setStructures((Structures) any());
	}

	/**
	 * Method under test: {@link GenerateMenuGroupeService#addGroupesModules(Groupes, Modules)}
	 */
	@Test
	void testAddGroupesModules4() {
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
		groupes.setStructures(structures);

		GroupesModules.GroupesModulesPK groupesModulesPK = new GroupesModules.GroupesModulesPK();
		groupesModulesPK.setGroupesId(123L);
		groupesModulesPK.setModulesId(123L);

		Modules modules = new Modules();
		modules.setActive("Active");
		modules.setCode("Code");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("Icon Class");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);

		GroupesModules.GroupesModulesPK groupesModulesPK1 = new GroupesModules.GroupesModulesPK();
		groupesModulesPK1.setGroupesId(123L);
		groupesModulesPK1.setModulesId(123L);

		Modules modules1 = new Modules();
		modules1.setActive("Active");
		modules1.setCode("Code");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("Icon Class");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
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
		when(groupesModulesRepository.saveAndFlush((GroupesModules) any())).thenReturn(groupesModules);
		when(groupesModulesRepository.findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any())).thenReturn(ofResult);

		Structures structures2 = new Structures();
		structures2.setActiviteCommerciale("Activite Commerciale");
		structures2.setAdresse("Adresse");
		structures2.setBilanSocail("Bilan Socail");
		structures2.setCapital("Capital");
		structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult12 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setCreatedDate(Date.from(atStartOfDayResult12.atZone(ZoneId.of("UTC")).toInstant()));
		structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures2.setDepartement("Departement");
		structures2.setDescription("The characteristics of someone or something");
		structures2.setEmail("jane.doe@example.org");
		structures2.setFlagEtat(Etats.INACTIVE);
		structures2.setFormJuridique("Form Juridique");
		structures2.setId(123L);
		structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult13 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setLastModifiedDate(Date.from(atStartOfDayResult13.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes2 = new Groupes();
		groupes2.setCode("Code");
		groupes2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult14 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes2.setCreatedDate(Date.from(atStartOfDayResult14.atZone(ZoneId.of("UTC")).toInstant()));
		groupes2.setFlagEtat(Etats.INACTIVE);
		groupes2.setId(123L);
		groupes2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult15 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes2.setLastModifiedDate(Date.from(atStartOfDayResult15.atZone(ZoneId.of("UTC")).toInstant()));
		groupes2.setLibelle("Libelle");
		groupes2.setStructures(structures2);

		Modules modules2 = new Modules();
		modules2.setActive("Active");
		modules2.setCode("Code");
		modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult16 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules2.setCreatedDate(Date.from(atStartOfDayResult16.atZone(ZoneId.of("UTC")).toInstant()));
		modules2.setFlagEtat(Etats.INACTIVE);
		modules2.setIconClass("Icon Class");
		modules2.setId(123L);
		modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult17 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules2.setLastModifiedDate(Date.from(atStartOfDayResult17.atZone(ZoneId.of("UTC")).toInstant()));
		modules2.setLibCode("Lib Code");
		modules2.setLibDesc("Lib Desc");
		modules2.setOrdre(1);
		modules2.setStandart(1);
		modules2.setUrl("https://example.org/example");
		assertSame(groupesModules1, generateMenuGroupeService.addGroupesModules(groupes2, modules2));
		verify(groupesModulesRepository).findByIdModulesIdAndIdGroupesId((Long) any(), (Long) any());
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

		Structures structures = new Structures();
		structures.setActiviteCommerciale("Activite Commerciale");
		structures.setAdresse("Adresse");
		structures.setBilanSocail("Bilan Socail");
		structures.setCapital("Capital");
		structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures.setDepartement("Departement");
		structures.setDescription("The characteristics of someone or something");
		structures.setEmail("jane.doe@example.org");
		structures.setFlagEtat(Etats.INACTIVE);
		structures.setFormJuridique("Form Juridique");
		structures.setId(123L);
		structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);

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
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions1.setFlagEtat(Etats.INACTIVE);
		fonctions1.setIconClass("Icon Class");
		fonctions1.setId(123L);
		fonctions1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions1.setLibCode("Lib Code");
		fonctions1.setLibDesc("Lib Desc");
		fonctions1.setModule("Module");
		fonctions1.setOrdre(1);
		fonctions1.setType("Type");
		fonctions1.setUrl("https://example.org/example");
		fonctions1.setUsed(true);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);

		GroupesFonctions.GroupesFonctionsPK groupesFonctionsPK1 = new GroupesFonctions.GroupesFonctionsPK();
		groupesFonctionsPK1.setFonctionsId(123L);
		groupesFonctionsPK1.setGroupesId(123L);

		GroupesFonctions groupesFonctions1 = new GroupesFonctions();
		groupesFonctions1.setFonctions(fonctions1);
		groupesFonctions1.setGroupes(groupes1);
		groupesFonctions1.setId(groupesFonctionsPK1);
		groupesFonctions1.setNew(true);
		Optional<GroupesFonctions> ofResult = Optional.of(groupesFonctions1);
		when(groupesFonctionsRepository.saveAndFlush((GroupesFonctions) any())).thenReturn(groupesFonctions);
		when(groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any()))
				.thenReturn(ofResult);

		Structures structures2 = new Structures();
		structures2.setActiviteCommerciale("Activite Commerciale");
		structures2.setAdresse("Adresse");
		structures2.setBilanSocail("Bilan Socail");
		structures2.setCapital("Capital");
		structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult12 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setCreatedDate(Date.from(atStartOfDayResult12.atZone(ZoneId.of("UTC")).toInstant()));
		structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures2.setDepartement("Departement");
		structures2.setDescription("The characteristics of someone or something");
		structures2.setEmail("jane.doe@example.org");
		structures2.setFlagEtat(Etats.INACTIVE);
		structures2.setFormJuridique("Form Juridique");
		structures2.setId(123L);
		structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult13 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setLastModifiedDate(Date.from(atStartOfDayResult13.atZone(ZoneId.of("UTC")).toInstant()));
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

		Groupes groupes2 = new Groupes();
		groupes2.setCode("Code");
		groupes2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult14 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes2.setCreatedDate(Date.from(atStartOfDayResult14.atZone(ZoneId.of("UTC")).toInstant()));
		groupes2.setFlagEtat(Etats.INACTIVE);
		groupes2.setId(123L);
		groupes2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult15 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes2.setLastModifiedDate(Date.from(atStartOfDayResult15.atZone(ZoneId.of("UTC")).toInstant()));
		groupes2.setLibelle("Libelle");
		groupes2.setStructures(structures2);

		Fonctions fonctions2 = new Fonctions();
		fonctions2.setActions("Actions");
		fonctions2.setActive("Active");
		fonctions2.setApplication("Application");
		fonctions2.setApplicationsId(123L);
		fonctions2.setCode("Code");
		fonctions2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult16 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions2.setCreatedDate(Date.from(atStartOfDayResult16.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions2.setFlagEtat(Etats.INACTIVE);
		fonctions2.setIconClass("Icon Class");
		fonctions2.setId(123L);
		fonctions2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult17 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions2.setLastModifiedDate(Date.from(atStartOfDayResult17.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions2.setLibCode("Lib Code");
		fonctions2.setLibDesc("Lib Desc");
		fonctions2.setModule("Module");
		fonctions2.setOrdre(1);
		fonctions2.setType("Type");
		fonctions2.setUrl("https://example.org/example");
		fonctions2.setUsed(true);
		assertSame(groupesFonctions1, generateMenuGroupeService.addGroupesFonctions(groupes2, fonctions2));
		verify(groupesFonctionsRepository).findByIdGroupesIdAndIdFonctionsId((Long) any(), (Long) any());
	}


}

