package net.hypnozcore.hypnozcore.controller;

import net.hypnozcore.hypnozcore.builder.CustomUtils;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.service.StructuresServices;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class StructuresControllerTest {
	private static final String ENDPOINT_URL = "/structures";
	@InjectMocks
	private StructuresController structuresController;
	@Mock
	private StructuresServices structuresServices;
	private MockMvc mockMvc;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(structuresController)
				.build();
	}


	/**
	 * Method under test: {@link StructuresController#save(StructuresDto)}
	 */

	@Test
	 void should_be_save_structure_complet() throws Exception {
		Mockito.when(structuresServices.save(ArgumentMatchers.any(StructuresDto.class))).thenReturn(getStructuresDto());
		mockMvc.perform(
				MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(getStructuresDto())))
                .andExpect(status().isCreated());

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

