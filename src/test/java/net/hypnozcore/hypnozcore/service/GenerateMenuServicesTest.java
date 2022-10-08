package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;

import net.hypnozcore.hypnozcore.repository.ApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.FonctionsRepository;
import net.hypnozcore.hypnozcore.repository.ModulesRepository;
import net.hypnozcore.hypnozcore.repository.ModulesStructureRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GenerateMenuServices.class})
@ExtendWith(SpringExtension.class)
class GenerateMenuServicesTest {
	@MockBean
	private ApplicationsRepository applicationsRepository;

	@MockBean
	private FonctionsRepository fonctionsRepository;

	@Autowired
	private GenerateMenuServices generateMenuServices;

	@MockBean
	private ModulesRepository modulesRepository;

	@MockBean
	private ModulesStructureRepository modulesStructureRepository;

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultModule(Structures)}
	 */
	@Test
	void testCreateDefaultModule() {
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

		Modules modules1 = new Modules();
		modules1.setActive("Active");
		modules1.setCode("Code");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("Icon Class");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setLibCode("Lib Code");
		modules1.setLibDesc("Lib Desc");
		modules1.setOrdre(1);
		modules1.setStandart(1);
		modules1.setUrl("https://example.org/example");
		Optional<Modules> ofResult = Optional.of(modules1);
		when(modulesRepository.saveAndFlush((Modules) any())).thenReturn(modules);
		when(modulesRepository.findByCode((String) any())).thenReturn(ofResult);

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
		assertEquals(8, generateMenuServices.createDefaultModule(structures).size());
		verify(modulesRepository, atLeast(1)).findByCode((String) any());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultApplication(List)}
	 */
	@Test
	void testCreateDefaultApplication() {
		assertTrue(generateMenuServices.createDefaultApplication(new ArrayList<>()).isEmpty());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultApplication(List)}
	 */
	@Test
	void testCreateDefaultApplication2() {
		Modules modules = new Modules();
		modules.setActive("config/Applications.json");
		modules.setCode("config/Applications.json");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("config/Applications.json");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("config/Applications.json");
		modules.setLibDesc("config/Applications.json");
		modules.setOrdre(3);
		modules.setStandart(3);
		modules.setUrl("https://example.org/example");

		ArrayList<Modules> modulesList = new ArrayList<>();
		modulesList.add(modules);
		assertTrue(generateMenuServices.createDefaultApplication(modulesList).isEmpty());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultApplication(List)}
	 */
	@Test
	void testCreateDefaultApplication3() {
		Modules modules = new Modules();
		modules.setActive("config/Applications.json");
		modules.setCode("config/Applications.json");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("config/Applications.json");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("config/Applications.json");
		modules.setLibDesc("config/Applications.json");
		modules.setOrdre(3);
		modules.setStandart(3);
		modules.setUrl("https://example.org/example");

		Modules modules1 = new Modules();
		modules1.setActive("config/Applications.json");
		modules1.setCode("config/Applications.json");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("config/Applications.json");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setLibCode("config/Applications.json");
		modules1.setLibDesc("config/Applications.json");
		modules1.setOrdre(1);
		modules1.setStandart(1);
		modules1.setUrl("https://example.org/example");

		ArrayList<Modules> modulesList = new ArrayList<>();
		modulesList.add(modules1);
		modulesList.add(modules);
		assertTrue(generateMenuServices.createDefaultApplication(modulesList).isEmpty());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultApplication(List)}
	 */
	@Test
	void testCreateDefaultApplication4() {
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
		Optional<Modules> ofResult = Optional.of(modules);
		when(modulesRepository.findByCode((String) any())).thenReturn(ofResult);

		Modules modules1 = new Modules();
		modules1.setActive("Active");
		modules1.setCode("Code");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("Icon Class");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setLibCode("Lib Code");
		modules1.setLibDesc("Lib Desc");
		modules1.setOrdre(1);
		modules1.setStandart(1);
		modules1.setUrl("https://example.org/example");

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
		applications.setModules(modules1);
		applications.setOrdre(1);
		applications.setUrl("https://example.org/example");

		Modules modules2 = new Modules();
		modules2.setActive("Active");
		modules2.setCode("Code");
		modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules2.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		modules2.setFlagEtat(Etats.INACTIVE);
		modules2.setIconClass("Icon Class");
		modules2.setId(123L);
		modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules2.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		modules2.setLibCode("Lib Code");
		modules2.setLibDesc("Lib Desc");
		modules2.setOrdre(1);
		modules2.setStandart(1);
		modules2.setUrl("https://example.org/example");

		Applications applications1 = new Applications();
		applications1.setActive("Active");
		applications1.setCode("Code");
		applications1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setFlagEtat(Etats.INACTIVE);
		applications1.setIconClass("Icon Class");
		applications1.setId(123L);
		applications1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setLibCode("Lib Code");
		applications1.setLibDesc("Lib Desc");
		applications1.setModule("Module");
		applications1.setModules(modules2);
		applications1.setOrdre(1);
		applications1.setUrl("https://example.org/example");
		Optional<Applications> ofResult1 = Optional.of(applications1);
		when(applicationsRepository.saveAndFlush((Applications) any())).thenReturn(applications);
		when(applicationsRepository.findByCodeAndModule((String) any(), (String) any())).thenReturn(ofResult1);

		Modules modules3 = new Modules();
		modules3.setActive("config/Applications.json");
		modules3.setCode("M0");
		modules3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules3.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		modules3.setFlagEtat(Etats.INACTIVE);
		modules3.setIconClass("config/Applications.json");
		modules3.setId(123L);
		modules3.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules3.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		modules3.setLibCode("config/Applications.json");
		modules3.setLibDesc("config/Applications.json");
		modules3.setOrdre(3);
		modules3.setStandart(3);
		modules3.setUrl("https://example.org/example");

		ArrayList<Modules> modulesList = new ArrayList<>();
		modulesList.add(modules3);
		assertEquals(3, generateMenuServices.createDefaultApplication(modulesList).size());
		verify(modulesRepository, atLeast(1)).findByCode((String) any());
		verify(applicationsRepository, atLeast(1)).findByCodeAndModule((String) any(), (String) any());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultApplication(List)}
	 */
	@Test
	void testCreateDefaultApplication5() {
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
		Optional<Modules> ofResult = Optional.of(modules);
		when(modulesRepository.findByCode((String) any())).thenReturn(ofResult);
		when(applicationsRepository.saveAndFlush((Applications) any()))
				.thenThrow(new ResponseException("An error occurred"));
		when(applicationsRepository.findByCodeAndModule((String) any(), (String) any()))
				.thenThrow(new ResponseException("An error occurred"));

		Modules modules1 = new Modules();
		modules1.setActive("config/Applications.json");
		modules1.setCode("M0");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("config/Applications.json");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setLibCode("config/Applications.json");
		modules1.setLibDesc("config/Applications.json");
		modules1.setOrdre(3);
		modules1.setStandart(3);
		modules1.setUrl("https://example.org/example");

		ArrayList<Modules> modulesList = new ArrayList<>();
		modulesList.add(modules1);
		assertThrows(ResponseException.class, () -> generateMenuServices.createDefaultApplication(modulesList));
		verify(modulesRepository).findByCode((String) any());
		verify(applicationsRepository).findByCodeAndModule((String) any(), (String) any());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultFonctions(List)}
	 */
	@Test
	void testCreateDefaultFonctions() {
		assertTrue(generateMenuServices.createDefaultFonctions(new ArrayList<>()).isEmpty());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultFonctions(List)}
	 */
	@Test
	void testCreateDefaultFonctions2() {
		Modules modules = new Modules();
		modules.setActive("config/fonctions.json");
		modules.setCode("config/fonctions.json");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("config/fonctions.json");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("config/fonctions.json");
		modules.setLibDesc("config/fonctions.json");
		modules.setOrdre(1);
		modules.setStandart(1);
		modules.setUrl("https://example.org/example");

		Applications applications = new Applications();
		applications.setActive("config/fonctions.json");
		applications.setCode("config/fonctions.json");
		applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setFlagEtat(Etats.INACTIVE);
		applications.setIconClass("config/fonctions.json");
		applications.setId(123L);
		applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setLibCode("config/fonctions.json");
		applications.setLibDesc("config/fonctions.json");
		applications.setModule("config/fonctions.json");
		applications.setModules(modules);
		applications.setOrdre(1);
		applications.setUrl("https://example.org/example");

		ArrayList<Applications> applicationsList = new ArrayList<>();
		applicationsList.add(applications);
		assertTrue(generateMenuServices.createDefaultFonctions(applicationsList).isEmpty());
	}

	/**
	 * Method under test: {@link GenerateMenuServices#createDefaultFonctions(List)}
	 */
	@Test
	void testCreateDefaultFonctions3() {
		Modules modules = new Modules();
		modules.setActive("config/fonctions.json");
		modules.setCode("config/fonctions.json");
		modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setFlagEtat(Etats.INACTIVE);
		modules.setIconClass("config/fonctions.json");
		modules.setId(123L);
		modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		modules.setLibCode("config/fonctions.json");
		modules.setLibDesc("config/fonctions.json");
		modules.setOrdre(1);
		modules.setStandart(1);
		modules.setUrl("https://example.org/example");

		Applications applications = new Applications();
		applications.setActive("config/fonctions.json");
		applications.setCode("config/fonctions.json");
		applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setFlagEtat(Etats.INACTIVE);
		applications.setIconClass("config/fonctions.json");
		applications.setId(123L);
		applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setLibCode("config/fonctions.json");
		applications.setLibDesc("config/fonctions.json");
		applications.setModule("config/fonctions.json");
		applications.setModules(modules);
		applications.setOrdre(1);
		applications.setUrl("https://example.org/example");

		Modules modules1 = new Modules();
		modules1.setActive("config/fonctions.json");
		modules1.setCode("config/fonctions.json");
		modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setFlagEtat(Etats.INACTIVE);
		modules1.setIconClass("config/fonctions.json");
		modules1.setId(123L);
		modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		modules1.setLibCode("config/fonctions.json");
		modules1.setLibDesc("config/fonctions.json");
		modules1.setOrdre(1);
		modules1.setStandart(1);
		modules1.setUrl("https://example.org/example");

		Applications applications1 = new Applications();
		applications1.setActive("config/fonctions.json");
		applications1.setCode("config/fonctions.json");
		applications1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setFlagEtat(Etats.INACTIVE);
		applications1.setIconClass("config/fonctions.json");
		applications1.setId(123L);
		applications1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setLibCode("config/fonctions.json");
		applications1.setLibDesc("config/fonctions.json");
		applications1.setModule("config/fonctions.json");
		applications1.setModules(modules1);
		applications1.setOrdre(1);
		applications1.setUrl("https://example.org/example");

		ArrayList<Applications> applicationsList = new ArrayList<>();
		applicationsList.add(applications1);
		applicationsList.add(applications);
		assertTrue(generateMenuServices.createDefaultFonctions(applicationsList).isEmpty());
	}
}

