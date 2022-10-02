package net.hypnozcore.hypnozcore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.ApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.FonctionsRepository;
import net.hypnozcore.hypnozcore.repository.ModulesRepository;
import net.hypnozcore.hypnozcore.repository.ModulesStructureRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.service.GenerateDefaultDocService;
import net.hypnozcore.hypnozcore.service.GenerateMenuService;
import net.hypnozcore.hypnozcore.service.StructuresServices;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {StructuresController.class, StructuresServices.class, GenerateMenuService.class,
		GenerateDefaultDocService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class StructuresControllerTest {
	@MockBean
	private ApplicationsRepository applicationsRepository;

	@MockBean
	private FonctionsRepository fonctionsRepository;

	@MockBean
	private ModulesRepository modulesRepository;

	@MockBean
	private ModulesStructureRepository modulesStructureRepository;

	@Autowired
	private StructuresController structuresController;

	@MockBean
	private StructuresMapper structuresMapper;

	@MockBean
	private StructuresRepository structuresRepository;

	/**
	 * Method under test: {@link StructuresController#findById(Long)}
	 */
	@Test
	void testFindById() throws Exception {
		Structures structures = getStructures();
		Optional<Structures> ofResult = Optional.of(structures);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/structures/{id}", 123L);
		MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content()
						.string(
								"{\"id\":null,\"serialVersionUID\":5570157676629231277,\"raisonSocial\":null,\"sigle\":null,\"description\":null"
										+ ",\"zoneFiscale\":null,\"zoneFiscale2\":null,\"dateFiscale\":null,\"typeEntreprise\":null,\"bilanSocail\":null,"
										+ "\"formJuridique\":null,\"adresse\":null,\"ville\":null,\"departement\":null,\"pays\":null,\"telephone\":null,\"email"
										+ "\":null,\"siteweb\":null,\"logo\":null,\"activiteCommerciale\":null,\"responsable\":null,\"qualiteResponsable\""
										+ ":null,\"capital\":null}"));
	}

	/**
	 * Method under test: {@link StructuresController#delete(Long)}
	 */
	@Test
	void testDelete() throws Exception {
		Structures structures = getStructures();
		Optional<Structures> ofResult = Optional.of(structures);
		doNothing().when(structuresRepository).deleteById((Long) any());
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/structures/{id}", 123L);
		MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk());
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

	/**
	 * Method under test: {@link StructuresController#initSysteme(StructuresDto)}
	 */
	@Test
	void testInitSysteme() throws Exception {
		Structures structures = getStructures();

		Structures structures1 = getStructures();
		Optional<Structures> ofResult = Optional.of(structures1);
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
		when(structuresRepository.findByRaisonSocialAndSigle((String) any(), (String) any())).thenReturn(ofResult);
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());

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
		Optional<Modules> ofResult1 = Optional.of(modules1);
		when(modulesRepository.saveAndFlush((Modules) any())).thenReturn(modules);
		when(modulesRepository.findByCode((String) any())).thenReturn(ofResult1);

		Fonctions fonctions = new Fonctions();
		fonctions.setActions("Actions");
		fonctions.setActive("Active");
		fonctions.setApplication("Application");
		fonctions.setApplicationsId(123L);
		fonctions.setCode("Code");
		fonctions.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions.setFlagEtat(Etats.INACTIVE);
		fonctions.setIconClass("Icon Class");
		fonctions.setId(123L);
		fonctions.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		fonctions.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		fonctions.setLibCode("Lib Code");
		fonctions.setLibDesc("Lib Desc");
		fonctions.setModule("Module");
		fonctions.setOrdre(1);
		fonctions.setType("Type");
		fonctions.setUrl("https://example.org/example");
		fonctions.setUsed(true);
		when(fonctionsRepository.saveAndFlush((Fonctions) any())).thenReturn(fonctions);

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

		Applications applications = new Applications();
		applications.setActive("Active");
		applications.setCode("Code");
		applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult12 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setCreatedDate(Date.from(atStartOfDayResult12.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setFlagEtat(Etats.INACTIVE);
		applications.setIconClass("Icon Class");
		applications.setId(123L);
		applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult13 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications.setLastModifiedDate(Date.from(atStartOfDayResult13.atZone(ZoneId.of("UTC")).toInstant()));
		applications.setLibCode("Lib Code");
		applications.setLibDesc("Lib Desc");
		applications.setModule("Module");
		applications.setModules(modules2);
		applications.setOrdre(1);
		applications.setUrl("https://example.org/example");

		Modules modules3 = new Modules();
		modules3.setActive("Active");
		modules3.setCode("Code");
		modules3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult14 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules3.setCreatedDate(Date.from(atStartOfDayResult14.atZone(ZoneId.of("UTC")).toInstant()));
		modules3.setFlagEtat(Etats.INACTIVE);
		modules3.setIconClass("Icon Class");
		modules3.setId(123L);
		modules3.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult15 = LocalDate.of(1970, 1, 1).atStartOfDay();
		modules3.setLastModifiedDate(Date.from(atStartOfDayResult15.atZone(ZoneId.of("UTC")).toInstant()));
		modules3.setLibCode("Lib Code");
		modules3.setLibDesc("Lib Desc");
		modules3.setOrdre(1);
		modules3.setStandart(1);
		modules3.setUrl("https://example.org/example");

		Applications applications1 = new Applications();
		applications1.setActive("Active");
		applications1.setCode("Code");
		applications1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult16 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setCreatedDate(Date.from(atStartOfDayResult16.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setFlagEtat(Etats.INACTIVE);
		applications1.setIconClass("Icon Class");
		applications1.setId(123L);
		applications1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult17 = LocalDate.of(1970, 1, 1).atStartOfDay();
		applications1.setLastModifiedDate(Date.from(atStartOfDayResult17.atZone(ZoneId.of("UTC")).toInstant()));
		applications1.setLibCode("Lib Code");
		applications1.setLibDesc("Lib Desc");
		applications1.setModule("Module");
		applications1.setModules(modules3);
		applications1.setOrdre(1);
		applications1.setUrl("https://example.org/example");
		Optional<Applications> ofResult2 = Optional.of(applications1);
		when(applicationsRepository.saveAndFlush((Applications) any())).thenReturn(applications);
		when(applicationsRepository.findByCodeAndModule((String) any(), (String) any())).thenReturn(ofResult2);

		StructuresDto structuresDto = getStructuresDto();
		String content = (new ObjectMapper()).writeValueAsString(structuresDto);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/structures/initSysteme")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content);
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content()
						.string(
								"{\"id\":null,\"serialVersionUID\":5570157676629231277,\"raisonSocial\":null,\"sigle\":null,\"description\":null"
										+ ",\"zoneFiscale\":null,\"zoneFiscale2\":null,\"dateFiscale\":null,\"typeEntreprise\":null,\"bilanSocail\":null,"
										+ "\"formJuridique\":null,\"adresse\":null,\"ville\":null,\"departement\":null,\"pays\":null,\"telephone\":null,\"email"
										+ "\":null,\"siteweb\":null,\"logo\":null,\"activiteCommerciale\":null,\"responsable\":null,\"qualiteResponsable\""
										+ ":null,\"capital\":null}"));
	}

	/**
	 * Method under test: {@link StructuresController#save(StructuresDto)}
	 */
	@Test
	void testSave() throws Exception {
		StructuresDto structuresDto = getStructuresDto();
		String content = (new ObjectMapper()).writeValueAsString(structuresDto);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/structures")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content);
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
	}

	/**
	 * Method under test: {@link StructuresController#update(StructuresDto, Long)}
	 */
	@Test
	void testUpdate() throws Exception {
		Structures structures = getStructures();
		Optional<Structures> ofResult = Optional.of(structures);

		Structures structures1 = getStructures();
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures1);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);

		Structures structures2 = getStructures();
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());
		when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures2);

		StructuresDto structuresDto = getStructuresDto();
		String content = (new ObjectMapper()).writeValueAsString(structuresDto);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/structures/{id}", 123L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(content);
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content()
						.string(
								"{\"id\":null,\"serialVersionUID\":5570157676629231277,\"raisonSocial\":null,\"sigle\":null,\"description\":null"
										+ ",\"zoneFiscale\":null,\"zoneFiscale2\":null,\"dateFiscale\":null,\"typeEntreprise\":null,\"bilanSocail\":null,"
										+ "\"formJuridique\":null,\"adresse\":null,\"ville\":null,\"departement\":null,\"pays\":null,\"telephone\":null,\"email"
										+ "\":null,\"siteweb\":null,\"logo\":null,\"activiteCommerciale\":null,\"responsable\":null,\"qualiteResponsable\""
										+ ":null,\"capital\":null}"));
	}

	@NotNull
	private static StructuresDto getStructuresDto() {
		StructuresDto structuresDto = new StructuresDto();
		structuresDto.setActiviteCommerciale("Activite Commerciale");
		structuresDto.setAdresse("Adresse");
		structuresDto.setBilanSocail("Bilan Socail");
		structuresDto.setCapital("Capital");
		structuresDto.setDateFiscale(null);
		structuresDto.setDepartement("Departement");
		structuresDto.setDescription("The characteristics of someone or something");
		structuresDto.setEmail("jane.doe@example.org");
		structuresDto.setFormJuridique("Form Juridique");
		structuresDto.setId(123L);
		structuresDto.setLogo("Logo");
		structuresDto.setPays("Pays");
		structuresDto.setQualiteResponsable("Qualite Responsable");
		structuresDto.setRaisonSocial("Raison Social");
		structuresDto.setResponsable("Responsable");
		structuresDto.setSigle("Sigle");
		structuresDto.setSiteweb("Siteweb");
		structuresDto.setTelephone("4105551212");
		structuresDto.setTypeEntreprise(TypeEntreprise.SA);
		structuresDto.setVille("Ville");
		structuresDto.setZoneFiscale("Zone Fiscale");
		structuresDto.setZoneFiscale2("Zone Fiscale2");
		return structuresDto;
	}
}

