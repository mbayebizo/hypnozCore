package net.hypnozcore.hypnozcore.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.service.StructuresServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StructuresController.class})
@ExtendWith(SpringExtension.class)
class StructuresControllerTest {
	@Autowired
	private StructuresController structuresController;

	@MockBean
	private StructuresServices structuresServices;

	/**
	 * Method under test: {@link StructuresController#findById(Long)}
	 */
	@Test
	void testFindById() throws Exception {
		when(structuresServices.findById((Long) any())).thenReturn(new StructuresDto());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/structures/{id}", 123L);
		MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content()
						.string(
								"{\"id\":null,\"raisonSocial\":null,\"sigle\":null,\"description\":null,\"zoneFiscale\":null,\"zoneFiscale2\":null"
										+ ",\"dateFiscale\":null,\"typeEntreprise\":null,\"bilanSocail\":null,\"formJuridique\":null,\"adresse\":null,\"ville"
										+ "\":null,\"departement\":null,\"pays\":null,\"telephone\":null,\"email\":null,\"siteweb\":null,\"logo\":null,"
										+ "\"activiteCommerciale\":null,\"responsable\":null,\"qualiteResponsable\":null,\"capital\":null}"));
	}

	/**
	 * Method under test: {@link StructuresController#delete(Long)}
	 */
	@Test
	void testDelete() throws Exception {
		doNothing().when(structuresServices).deleteById((Long) any());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/structures/{id}", 123L);
		MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * Method under test: {@link StructuresController#delete(Long)}
	 */
	@Test
	void testDelete2() throws Exception {
		doNothing().when(structuresServices).deleteById((Long) any());
		MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/structures/{id}", 123L);
		deleteResult.characterEncoding("Encoding");
		MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(deleteResult)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * Method under test: {@link StructuresController#update(StructuresDto, Long)}
	 */
	@Test
	void testUpdate() throws Exception {
		when(structuresServices.update((StructuresDto) any(), (Long) any())).thenReturn(new StructuresDto());

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
								"{\"id\":null,\"raisonSocial\":null,\"sigle\":null,\"description\":null,\"zoneFiscale\":null,\"zoneFiscale2\":null"
										+ ",\"dateFiscale\":null,\"typeEntreprise\":null,\"bilanSocail\":null,\"formJuridique\":null,\"adresse\":null,\"ville"
										+ "\":null,\"departement\":null,\"pays\":null,\"telephone\":null,\"email\":null,\"siteweb\":null,\"logo\":null,"
										+ "\"activiteCommerciale\":null,\"responsable\":null,\"qualiteResponsable\":null,\"capital\":null}"));
	}

	/**
	 * Method under test: {@link StructuresController#initSysteme(StructuresDto)}
	 */
	@Test
	void testInitSysteme() throws Exception {
		when(structuresServices.initConfigStructure((StructuresDto) any())).thenReturn(new StructuresDto());

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
								"{\"id\":null,\"raisonSocial\":null,\"sigle\":null,\"description\":null,\"zoneFiscale\":null,\"zoneFiscale2\":null"
										+ ",\"dateFiscale\":null,\"typeEntreprise\":null,\"bilanSocail\":null,\"formJuridique\":null,\"adresse\":null,\"ville"
										+ "\":null,\"departement\":null,\"pays\":null,\"telephone\":null,\"email\":null,\"siteweb\":null,\"logo\":null,"
										+ "\"activiteCommerciale\":null,\"responsable\":null,\"qualiteResponsable\":null,\"capital\":null}"));
	}

	/**
	 * Method under test: {@link StructuresController#save(StructuresDto)}
	 */
	@Test
	void testSave() throws Exception {
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
		String content = (new ObjectMapper()).writeValueAsString(structuresDto);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/structures")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content);
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(structuresController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
	}
}

