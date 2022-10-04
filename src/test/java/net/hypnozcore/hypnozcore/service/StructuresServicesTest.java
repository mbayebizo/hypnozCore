package net.hypnozcore.hypnozcore.service;


import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class StructuresServicesTest {
	@MockBean
	private GenerateDefaultDocService generateDefaultDocService;

	@MockBean
	private GenerateMenuService generateMenuService;

	@MockBean
	private StructuresMapper structuresMapper;

	@MockBean
	private StructuresRepository structuresRepository;

	@Autowired
	private StructuresServices structuresServices;

	/**
	 * Method under test: {@link StructuresServices#save(StructuresDto)}
	 */
	@Test
	void testSave() {
		Structures structures = getStructures();
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);

		Structures structures1 = getStructures();
		when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
		when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures1);
		StructuresDto structuresDto = mock(StructuresDto.class);
		when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
		when(structuresDto.getSigle()).thenReturn("Sigle");
		StructuresDto actualSaveResult = structuresServices.save(structuresDto);
		Assertions.assertEquals(structuresDto.getSigle(), actualSaveResult.getSigle());
		verify(structuresRepository).saveAndFlush((Structures) any());
		verify(structuresMapper, atLeast(1)).toDto((Structures) any());
		verify(structuresMapper).toEntity((StructuresDto) any());
		verify(structuresDto, atLeast(1)).getRaisonSocial();
		verify(structuresDto, atLeast(1)).getSigle();
	}

	@Test
	void should_be_test_save_when_sigle_is_null() {
		Structures structures= new Structures();
		structures.setSigle("");
		when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
		when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures);
		StructuresDto structuresDto = mock(StructuresDto.class);
		when(structuresDto.getRaisonSocial()).thenReturn("Raison Social");
		when(structuresDto.getSigle()).thenReturn("");
		assertThrows(ResponseException.class, () -> structuresServices.save(structuresDto));
	}

	@Test
	void should_be_test_save_when_raison_social_is_null() {
		Structures structures= new Structures();
		structures.setRaisonSocial("");
		when(structuresMapper.toDto((Structures) any())).thenReturn(mock(StructuresDto.class));
		when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures);
		StructuresDto structuresDto = mock(StructuresDto.class);
		when(structuresDto.getRaisonSocial()).thenReturn("");
		when(structuresDto.getSigle()).thenReturn("Sigle");
		assertThrows(ResponseException.class, () -> structuresServices.save(structuresDto));
	}

	@Test
	void should_be_test_save_when_structures_is_null(){
		StructuresDto structuresDto = null;
		assertThrows(ResponseException.class, () -> structuresServices.save(structuresDto));
	}

	@Test
	void should_be_test_findby_id_when_entity_no_exist() {
		assertThrows(ResponseException.class, () -> structuresServices.findById(123L));
	}
	@Test
	void should_be_test_findby_id_when_id_null() {
		assertThrows(ResponseException.class, () -> structuresServices.findById(null));
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
}

