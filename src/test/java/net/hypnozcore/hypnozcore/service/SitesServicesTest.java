package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import net.hypnozcore.hypnozcore.dto.SitesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.SitesMapper;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Sites;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.SitesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SitesServices.class})
@ExtendWith(SpringExtension.class)
class SitesServicesTest {
	@MockBean
	private SitesMapper sitesMapper;

	@MockBean
	private SitesRepository sitesRepository;

	@Autowired
	private SitesServices sitesServices;

	@MockBean
	private StructuresRepository structuresRepository;
	@MockBean
	private StructuresMapper structuresMapper;

	/**
	 * Method under test: {@link SitesServices#getSites(SitesDto)}
	 */
	@Test
	void testGetSites() {
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

		Sites sites = new Sites();
		sites.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		sites.setFlagEtat(Etats.INACTIVE);
		sites.setId(123L);
		sites.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		sites.setSitCode("Sit Code");
		sites.setSitIdResponsable(1L);
		sites.setSitInactif(1);
		sites.setSitNomFr("Sit Nom Fr");
		sites.setSitNomResponsable("Sit Nom Responsable");
		sites.setStructures(structures);
		Optional<Sites> ofResult = Optional.of(sites);
		when(sitesRepository.findById((Long) any())).thenReturn(ofResult);

		SitesDto sitesDto = new SitesDto();
		sitesDto.setCode("Code");
		sitesDto.setId(123L);
		sitesDto.setInactif(1);
		sitesDto.setLibelle("Libelle");
		sitesDto.setSitIdClient(1L);
		sitesDto.setSitIdResponsable(1L);
		sitesDto.setSitNomResponsable("Sit Nom Responsable");
		sitesDto.setStructuresId(123L);
		when(sitesMapper.toDto((Sites) any())).thenReturn(sitesDto);

		SitesDto sitesDto1 = new SitesDto();
		sitesDto1.setCode("Code");
		sitesDto1.setId(123L);
		sitesDto1.setInactif(1);
		sitesDto1.setLibelle("Libelle");
		sitesDto1.setSitIdClient(1L);
		sitesDto1.setSitIdResponsable(1L);
		sitesDto1.setSitNomResponsable("Sit Nom Responsable");
		sitesDto1.setStructuresId(123L);
		assertSame(sitesDto, sitesServices.getSites(sitesDto1));
		verify(sitesRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
	}

	/**
	 * Method under test: {@link SitesServices#getSites(SitesDto)}
	 */
	@Test
	void testGetSites2() {
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

		Sites sites = new Sites();
		sites.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		sites.setFlagEtat(Etats.INACTIVE);
		sites.setId(123L);
		sites.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		sites.setSitCode("Sit Code");
		sites.setSitIdResponsable(1L);
		sites.setSitInactif(1);
		sites.setSitNomFr("Sit Nom Fr");
		sites.setSitNomResponsable("Sit Nom Responsable");
		sites.setStructures(structures);
		Optional<Sites> ofResult = Optional.of(sites);
		when(sitesRepository.findById((Long) any())).thenReturn(ofResult);
		when(sitesMapper.toDto((Sites) any())).thenThrow(new ResponseException("An error occurred"));

		SitesDto sitesDto = new SitesDto();
		sitesDto.setCode("Code");
		sitesDto.setId(123L);
		sitesDto.setInactif(1);
		sitesDto.setLibelle("Libelle");
		sitesDto.setSitIdClient(1L);
		sitesDto.setSitIdResponsable(1L);
		sitesDto.setSitNomResponsable("Sit Nom Responsable");
		sitesDto.setStructuresId(123L);
		assertThrows(ResponseException.class, () -> sitesServices.getSites(sitesDto));
		verify(sitesRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
	}

	/**
	 * Method under test: {@link SitesServices#getAllSites(StructuresDto)}
	 */
	@Test
	void testGetAllSites() {
		when(sitesRepository.findByStructuresId((Long) any())).thenReturn(new ArrayList<>());

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
		assertTrue(sitesServices.getAllSites(new StructuresDto()).isEmpty());
		verify(sitesRepository).findByStructuresId((Long) any());
		verify(structuresRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link SitesServices#getAllSites(StructuresDto)}
	 */
	@Test
	void testGetAllSites2() {
		when(sitesRepository.findByStructuresId((Long) any())).thenThrow(new ResponseException("An error occurred"));

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
		Assertions.assertThrows(ResponseException.class, () -> sitesServices.getAllSites(new StructuresDto()));
		verify(sitesRepository).findByStructuresId((Long) any());
		verify(structuresRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link SitesServices#getAllSites(StructuresDto)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetAllSites3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   net.hypnozcore.hypnozcore.utils.exceptions.ResponseException: An error occurred
		//       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
		//       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
		//       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
		//       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
		//       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
		//       at java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
		//       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
		//       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
		//       at java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
		//       at net.hypnozcore.hypnozcore.service.SitesServices.getAllSites(SitesServices.java:89)
		//   In order to prevent getAllSites(StructuresDto)
		//   from throwing ResponseException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   getAllSites(StructuresDto).
		//   See https://diff.blue/R013 to resolve this issue.

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

		Sites sites = new Sites();
		sites.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		sites.setFlagEtat(Etats.INACTIVE);
		sites.setId(123L);
		sites.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		sites.setSitCode("Sit Code");
		sites.setSitIdResponsable(1L);
		sites.setSitInactif(1);
		sites.setSitNomFr("Sit Nom Fr");
		sites.setSitNomResponsable("Sit Nom Responsable");
		sites.setStructures(structures);

		ArrayList<Sites> sitesList = new ArrayList<>();
		sitesList.add(sites);
		when(sitesRepository.findByStructuresId((Long) any())).thenReturn(sitesList);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);
		when(sitesMapper.toDto((Sites) any())).thenThrow(new ResponseException("An error occurred"));
		//assertFalse(sitesServices.getAllSites(structuresMapper.toDto(structures))).isEmpty());
		verify(sitesRepository).findByStructuresId((Long) any());
		verify(structuresRepository).findById((Long) any());
	}

}

