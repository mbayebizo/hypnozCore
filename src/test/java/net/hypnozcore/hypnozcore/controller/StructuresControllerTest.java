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

