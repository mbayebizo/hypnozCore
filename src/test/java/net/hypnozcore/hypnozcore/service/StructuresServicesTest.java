package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import net.hypnozcore.hypnozcore.dto.StructuresDto;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StructuresServices.class})
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
		assertThrows(ResponseException.class, () -> structuresServices.save(new StructuresDto()));
		assertThrows(ResponseException.class, () -> structuresServices.save(null));
	}

	/**
	 * Method under test: {@link StructuresServices#save(StructuresDto)}
	 */
	@Test
	void testSave2() {
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
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());
		when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures1);
		StructuresDto structuresDto = new StructuresDto(123L, "Raison Social", "Sigle",
				"The characteristics of someone or something", "Zone Fiscale", "Zone Fiscale2", LocalDate.ofEpochDay(1L),
				TypeEntreprise.SA, "Bilan Socail", "Form Juridique", "Adresse", "Ville", "Departement", "Pays", "4105551212",
				"jane.doe@example.org", "Siteweb", "Logo", "Activite Commerciale", "Responsable", "Qualite Responsable",
				"Capital");

		assertSame(structuresDto, structuresServices.save(structuresDto));
		verify(structuresRepository).saveAndFlush((Structures) any());
		verify(structuresMapper).toDto((Structures) any());
		verify(structuresMapper).toEntity((StructuresDto) any());
	}

	/**
	 * Method under test: {@link StructuresServices#save(StructuresDto)}
	 */
	@Test
	void testSave3() {
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
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
		when(structuresMapper.toDto((Structures) any())).thenThrow(new ResponseException("An error occurred"));
		when(structuresMapper.toEntity((StructuresDto) any())).thenThrow(new ResponseException("An error occurred"));
		assertThrows(ResponseException.class,
				() -> structuresServices
						.save(new StructuresDto(123L, "Raison Social", "Sigle", "The characteristics of someone or something",
								"Zone Fiscale", "Zone Fiscale2", LocalDate.ofEpochDay(1L), TypeEntreprise.SA, "Bilan Socail",
								"Form Juridique", "Adresse", "Ville", "Departement", "Pays", "4105551212", "jane.doe@example.org",
								"Siteweb", "Logo", "Activite Commerciale", "Responsable", "Qualite Responsable", "Capital")));
		verify(structuresMapper).toEntity((StructuresDto) any());
	}

	/**
	 * Method under test: {@link StructuresServices#deleteById(Long)}
	 */
	@Test
	void testDeleteById() {
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
		Optional<Structures> ofResult = Optional.of(structures);
		doNothing().when(structuresRepository).deleteById((Long) any());
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		structuresServices.deleteById(123L);
		verify(structuresRepository).findById((Long) any());
		verify(structuresRepository).deleteById((Long) any());
	}

	/**
	 * Method under test: {@link StructuresServices#deleteById(Long)}
	 */
	@Test
	void testDeleteById2() {
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
		Optional<Structures> ofResult = Optional.of(structures);
		doThrow(new ResponseException("An error occurred")).when(structuresRepository).deleteById((Long) any());
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		assertThrows(ResponseException.class, () -> structuresServices.deleteById(123L));
		verify(structuresRepository).findById((Long) any());
		verify(structuresRepository).deleteById((Long) any());
	}

	/**
	 * Method under test: {@link StructuresServices#deleteById(Long)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testDeleteById3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "java.util.Optional.isEmpty()" because the return value of "net.hypnozcore.hypnozcore.repository.StructuresRepository.findById(Object)" is null
		//       at net.hypnozcore.hypnozcore.service.StructuresServices.deleteById(StructuresServices.java:60)
		//   In order to prevent deleteById(Long)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   deleteById(Long).
		//   See https://diff.blue/R013 to resolve this issue.

		doNothing().when(structuresRepository).deleteById((Long) any());
		when(structuresRepository.findById((Long) any())).thenReturn(null);
		structuresServices.deleteById(123L);
	}

	/**
	 * Method under test: {@link StructuresServices#deleteById(Long)}
	 */
	@Test
	void testDeleteById4() {
		doNothing().when(structuresRepository).deleteById((Long) any());
		when(structuresRepository.findById((Long) any())).thenReturn(Optional.empty());
		assertThrows(ResponseException.class, () -> structuresServices.deleteById(123L));
		verify(structuresRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link StructuresServices#deleteById(Long)}
	 */
	@Test
	void testDeleteById5() {
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
		Optional<Structures> ofResult = Optional.of(structures);
		doNothing().when(structuresRepository).deleteById((Long) any());
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		assertThrows(ResponseException.class, () -> structuresServices.deleteById(null));
	}

	/**
	 * Method under test: {@link StructuresServices#findById(Long)}
	 */
	@Test
	void testFindById() {
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
		Optional<Structures> ofResult = Optional.of(structures);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		StructuresDto structuresDto = new StructuresDto();
		when(structuresMapper.toDto((Structures) any())).thenReturn(structuresDto);
		assertSame(structuresDto, structuresServices.findById(123L));
		verify(structuresRepository).findById((Long) any());
		verify(structuresMapper).toDto((Structures) any());
	}

	/**
	 * Method under test: {@link StructuresServices#findById(Long)}
	 */
	@Test
	void testFindById2() {
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
		Optional<Structures> ofResult = Optional.of(structures);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		when(structuresMapper.toDto((Structures) any())).thenThrow(new ResponseException("An error occurred"));
		assertThrows(ResponseException.class, () -> structuresServices.findById(123L));
		verify(structuresRepository).findById((Long) any());
		verify(structuresMapper).toDto((Structures) any());
	}

	/**
	 * Method under test: {@link StructuresServices#findById(Long)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testFindById3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "java.util.Optional.isPresent()" because "structuresOptional" is null
		//       at net.hypnozcore.hypnozcore.service.StructuresServices.findById(StructuresServices.java:70)
		//   In order to prevent findById(Long)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   findById(Long).
		//   See https://diff.blue/R013 to resolve this issue.

		when(structuresRepository.findById((Long) any())).thenReturn(null);
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());
		structuresServices.findById(123L);
	}

	/**
	 * Method under test: {@link StructuresServices#findById(Long)}
	 */
	@Test
	void testFindById4() {
		when(structuresRepository.findById((Long) any())).thenReturn(Optional.empty());
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());
		assertThrows(ResponseException.class, () -> structuresServices.findById(123L));
		verify(structuresRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link StructuresServices#findById(Long)}
	 */
	@Test
	void testFindById5() {
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
		Optional<Structures> ofResult = Optional.of(structures);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());
		assertThrows(ResponseException.class, () -> structuresServices.findById(null));
	}

	/**
	 * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
	 */
	@Test
	void testUpdate() {
		assertThrows(ResponseException.class, () -> structuresServices.update(new StructuresDto(), 123L));
		assertThrows(ResponseException.class, () -> structuresServices.update(null, 123L));
	}

	/**
	 * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
	 */
	@Test
	void testUpdate2() {
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
		Optional<Structures> ofResult = Optional.of(structures);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures1);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);

		Structures structures2 = new Structures();
		structures2.setActiviteCommerciale("Activite Commerciale");
		structures2.setAdresse("Adresse");
		structures2.setBilanSocail("Bilan Socail");
		structures2.setCapital("Capital");
		structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures2.setDepartement("Departement");
		structures2.setDescription("The characteristics of someone or something");
		structures2.setEmail("jane.doe@example.org");
		structures2.setFlagEtat(Etats.INACTIVE);
		structures2.setFormJuridique("Form Juridique");
		structures2.setId(123L);
		structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
		StructuresDto structuresDto = new StructuresDto();
		when(structuresMapper.toDto((Structures) any())).thenReturn(structuresDto);
		when(structuresMapper.toEntity((StructuresDto) any())).thenReturn(structures2);
		assertSame(structuresDto,
				structuresServices
						.update(
								new StructuresDto(123L, "Raison Social", "Sigle", "The characteristics of someone or something",
										"Zone Fiscale", "Zone Fiscale2", LocalDate.ofEpochDay(1L), TypeEntreprise.SA, "Bilan Socail",
										"Form Juridique", "Adresse", "Ville", "Departement", "Pays", "4105551212", "jane.doe@example.org",
										"Siteweb", "Logo", "Activite Commerciale", "Responsable", "Qualite Responsable", "Capital"),
								123L));
		verify(structuresRepository).saveAndFlush((Structures) any());
		verify(structuresRepository).findById((Long) any());
		verify(structuresMapper).toDto((Structures) any());
		verify(structuresMapper).toEntity((StructuresDto) any());
	}

	/**
	 * Method under test: {@link StructuresServices#update(StructuresDto, Long)}
	 */
	@Test
	void testUpdate3() {
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
		Optional<Structures> ofResult = Optional.of(structures);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures1);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		when(structuresMapper.toDto((Structures) any())).thenThrow(new ResponseException("An error occurred"));
		when(structuresMapper.toEntity((StructuresDto) any())).thenThrow(new ResponseException("An error occurred"));
		assertThrows(ResponseException.class,
				() -> structuresServices
						.update(
								new StructuresDto(123L, "Raison Social", "Sigle", "The characteristics of someone or something",
										"Zone Fiscale", "Zone Fiscale2", LocalDate.ofEpochDay(1L), TypeEntreprise.SA, "Bilan Socail",
										"Form Juridique", "Adresse", "Ville", "Departement", "Pays", "4105551212", "jane.doe@example.org",
										"Siteweb", "Logo", "Activite Commerciale", "Responsable", "Qualite Responsable", "Capital"),
								123L));
		verify(structuresRepository).findById((Long) any());
		verify(structuresMapper).toEntity((StructuresDto) any());
	}

	/**
	 * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testInitConfigStructure() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "String.isEmpty()" because the return value of "net.hypnozcore.hypnozcore.dto.StructuresDto.getSigle()" is null
		//       at net.hypnozcore.hypnozcore.service.StructuresServices.initConfigStructure(StructuresServices.java:99)
		//   In order to prevent initConfigStructure(StructuresDto)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   initConfigStructure(StructuresDto).
		//   See https://diff.blue/R013 to resolve this issue.

		structuresServices.initConfigStructure(new StructuresDto());
	}

	/**
	 * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testInitConfigStructure2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "String.isEmpty()" because the return value of "net.hypnozcore.hypnozcore.dto.StructuresDto.getRaisonSocial()" is null
		//       at net.hypnozcore.hypnozcore.service.StructuresServices.initConfigStructure(StructuresServices.java:100)
		//   In order to prevent initConfigStructure(StructuresDto)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   initConfigStructure(StructuresDto).
		//   See https://diff.blue/R013 to resolve this issue.

		StructuresDto structuresDto = new StructuresDto();
		structuresDto.setSigle("Sigle");
		structuresServices.initConfigStructure(structuresDto);
	}

	/**
	 * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testInitConfigStructure3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "String.isEmpty()" because the return value of "net.hypnozcore.hypnozcore.dto.StructuresDto.getRaisonSocial()" is null
		//       at net.hypnozcore.hypnozcore.service.StructuresServices.initConfigStructure(StructuresServices.java:100)
		//   In order to prevent initConfigStructure(StructuresDto)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   initConfigStructure(StructuresDto).
		//   See https://diff.blue/R013 to resolve this issue.

		StructuresDto structuresDto = new StructuresDto();
		structuresDto.setSigle("");
		structuresServices.initConfigStructure(structuresDto);
	}

	/**
	 * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
	 */
	@Test
	void testInitConfigStructure4() throws ResponseException {
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

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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
		Optional<Structures> ofResult = Optional.of(structures1);
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
		when(structuresRepository.findByRaisonSocialAndSigle((String) any(), (String) any())).thenReturn(ofResult);
		StructuresDto structuresDto = new StructuresDto();
		when(structuresMapper.toDto((Structures) any())).thenReturn(structuresDto);
		when(generateMenuService.createDefaultApplication((List<Modules>) any())).thenReturn(new ArrayList<>());
		when(generateMenuService.createDefaultFonctions((List<Applications>) any())).thenReturn(new ArrayList<>());
		when(generateMenuService.createDefaultModule((Structures) any())).thenReturn(new ArrayList<>());
		when(generateDefaultDocService.create()).thenReturn("Create");

		StructuresDto structuresDto1 = new StructuresDto();
		structuresDto1.setRaisonSocial("Raison Social");
		structuresDto1.setSigle("");
		assertSame(structuresDto, structuresServices.initConfigStructure(structuresDto1));
		verify(structuresRepository, atLeast(1)).findByRaisonSocialAndSigle((String) any(), (String) any());
		verify(structuresMapper).toDto((Structures) any());
		verify(generateMenuService).createDefaultApplication((List<Modules>) any());
		verify(generateMenuService).createDefaultFonctions((List<Applications>) any());
		verify(generateMenuService).createDefaultModule((Structures) any());
		verify(generateDefaultDocService).create();
	}

	/**
	 * Method under test: {@link StructuresServices#initConfigStructure(StructuresDto)}
	 */
	@Test
	void testInitConfigStructure5() throws ResponseException {
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

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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
		Optional<Structures> ofResult = Optional.of(structures1);
		when(structuresRepository.saveAndFlush((Structures) any())).thenReturn(structures);
		when(structuresRepository.findByRaisonSocialAndSigle((String) any(), (String) any())).thenReturn(ofResult);
		when(structuresMapper.toDto((Structures) any())).thenReturn(new StructuresDto());
		when(generateMenuService.createDefaultApplication((List<Modules>) any())).thenReturn(new ArrayList<>());
		when(generateMenuService.createDefaultFonctions((List<Applications>) any())).thenReturn(new ArrayList<>());
		when(generateMenuService.createDefaultModule((Structures) any())).thenReturn(new ArrayList<>());
		when(generateDefaultDocService.create()).thenThrow(new ResponseException("An error occurred"));

		StructuresDto structuresDto = new StructuresDto();
		structuresDto.setRaisonSocial("Raison Social");
		structuresDto.setSigle("");
		assertThrows(ResponseException.class, () -> structuresServices.initConfigStructure(structuresDto));
		verify(structuresRepository, atLeast(1)).findByRaisonSocialAndSigle((String) any(), (String) any());
		verify(generateMenuService).createDefaultApplication((List<Modules>) any());
		verify(generateMenuService).createDefaultFonctions((List<Applications>) any());
		verify(generateMenuService).createDefaultModule((Structures) any());
		verify(generateDefaultDocService).create();
	}
}

