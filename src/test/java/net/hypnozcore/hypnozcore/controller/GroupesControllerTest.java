package net.hypnozcore.hypnozcore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.service.GroupesServices;
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

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {GroupesController.class})
@ExtendWith(SpringExtension.class)
class GroupesControllerTest {
	@Autowired
	private GroupesController groupesController;

	@MockBean
	private GroupesServices groupesServices;

	/**
	 * Method under test: {@link GroupesController#findById(Long)}
	 */
	@Test
	void testFindById() throws Exception {
		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		Optional<GroupesDto> ofResult = Optional.of(groupesDto);
		when(groupesServices.findById((Long) any())).thenReturn(ofResult);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/groupes/{id}", 123L);
		MockMvcBuilders.standaloneSetup(groupesController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content()
						.string(
								"{\"id\":123,\"code\":\"Code\",\"libelle\":\"Libelle\",\"structures\":{\"id\":null,\"raisonSocial\":null,\"sigle\":null"
										+ ",\"description\":null,\"zoneFiscale\":null,\"zoneFiscale2\":null,\"dateFiscale\":null,\"typeEntreprise\":null,"
										+ "\"bilanSocail\":null,\"formJuridique\":null,\"adresse\":null,\"ville\":null,\"departement\":null,\"pays\":null,"
										+ "\"telephone\":null,\"email\":null,\"siteweb\":null,\"logo\":null,\"activiteCommerciale\":null,\"responsable\":null"
										+ ",\"qualiteResponsable\":null,\"capital\":null}}"));
	}

	/**
	 * Method under test: {@link GroupesController#delete(Long)}
	 */
	@Test
	void testDelete() throws Exception {
		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		Optional<GroupesDto> ofResult = Optional.of(groupesDto);
		when(groupesServices.findById((Long) any())).thenReturn(ofResult);
		doNothing().when(groupesServices).deleteById((Long) any());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/groupes/{id}", 123L);
		MockMvcBuilders.standaloneSetup(groupesController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * Method under test: {@link GroupesController#update(GroupesDto, Long)}
	 */
	@Test
	void testUpdate() throws Exception {
		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		when(groupesServices.update((GroupesDto) any(), (Long) any())).thenReturn(groupesDto);

		GroupesDto groupesDto1 = new GroupesDto();
		groupesDto1.setCode("Code");
		groupesDto1.setId(123L);
		groupesDto1.setLibelle("Libelle");
		groupesDto1.setStructures(new StructuresDto());
		String content = (new ObjectMapper()).writeValueAsString(groupesDto1);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/groupes/{id}", 123L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(content);
		MockMvcBuilders.standaloneSetup(groupesController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * Method under test: {@link GroupesController#save(GroupesDto)}
	 */
	@Test
	void testSave() throws Exception {
		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		String content = (new ObjectMapper()).writeValueAsString(groupesDto);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/groupes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content);
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(groupesController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
	}
}

