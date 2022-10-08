package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import net.hypnozcore.hypnozcore.models.Sites;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.SitesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
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

	/**
	 * Method under test: {@link SitesServices#saveSites(SitesDto)}
	 */
	@Test
	void testSaveSites() {
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
		when(sitesRepository.saveAndFlush((Sites) any())).thenReturn(sites);

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

		SitesDto sitesDto = new SitesDto();
		sitesDto.setCode("Code");
		sitesDto.setId(123L);
		sitesDto.setInactif(1);
		sitesDto.setLibelle("Libelle");
		sitesDto.setSitIdClient(1L);
		sitesDto.setSitIdResponsable(1L);
		sitesDto.setSitNomResponsable("Sit Nom Responsable");
		sitesDto.setStructuresDto(new StructuresDto());

		Structures structures2 = new Structures();
		structures2.setActiviteCommerciale("Activite Commerciale");
		structures2.setAdresse("Adresse");
		structures2.setBilanSocail("Bilan Socail");
		structures2.setCapital("Capital");
		structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures2.setDepartement("Departement");
		structures2.setDescription("The characteristics of someone or something");
		structures2.setEmail("jane.doe@example.org");
		structures2.setFlagEtat(Etats.INACTIVE);
		structures2.setFormJuridique("Form Juridique");
		structures2.setId(123L);
		structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
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

		Sites sites1 = new Sites();
		sites1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		sites1.setFlagEtat(Etats.INACTIVE);
		sites1.setId(123L);
		sites1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		sites1.setSitCode("Sit Code");
		sites1.setSitIdResponsable(1L);
		sites1.setSitInactif(1);
		sites1.setSitNomFr("Sit Nom Fr");
		sites1.setSitNomResponsable("Sit Nom Responsable");
		sites1.setStructures(structures2);
		when(sitesMapper.toDto((Sites) any())).thenReturn(sitesDto);
		when(sitesMapper.toEntity((SitesDto) any())).thenReturn(sites1);

		SitesDto sitesDto1 = new SitesDto();
		sitesDto1.setCode("Code");
		sitesDto1.setId(123L);
		sitesDto1.setInactif(1);
		sitesDto1.setLibelle("Libelle");
		sitesDto1.setSitIdClient(1L);
		sitesDto1.setSitIdResponsable(1L);
		sitesDto1.setSitNomResponsable("Sit Nom Responsable");
		sitesDto1.setStructuresDto(new StructuresDto());
		assertSame(sitesDto, sitesServices.saveSites(sitesDto1));
		verify(sitesRepository).saveAndFlush((Sites) any());
		verify(structuresRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
		verify(sitesMapper).toEntity((SitesDto) any());
	}

	/**
	 * Method under test: {@link SitesServices#saveSites(SitesDto)}
	 */
	@Test
	void testSaveSites2() {
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
		when(sitesRepository.saveAndFlush((Sites) any())).thenReturn(sites);

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
		when(sitesMapper.toEntity((SitesDto) any())).thenThrow(new ResponseException("An error occurred"));

		SitesDto sitesDto = new SitesDto();
		sitesDto.setCode("Code");
		sitesDto.setId(123L);
		sitesDto.setInactif(1);
		sitesDto.setLibelle("Libelle");
		sitesDto.setSitIdClient(1L);
		sitesDto.setSitIdResponsable(1L);
		sitesDto.setSitNomResponsable("Sit Nom Responsable");
		sitesDto.setStructuresDto(new StructuresDto());
		assertThrows(ResponseException.class, () -> sitesServices.saveSites(sitesDto));
		verify(structuresRepository).findById((Long) any());
		verify(sitesMapper).toEntity((SitesDto) any());
	}

	/**
	 * Method under test: {@link SitesServices#updateSite(SitesDto, Long)}
	 */
	@Test
	void testUpdateSite() {
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

		Sites sites1 = new Sites();
		sites1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		sites1.setFlagEtat(Etats.INACTIVE);
		sites1.setId(123L);
		sites1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		sites1.setSitCode("Sit Code");
		sites1.setSitIdResponsable(1L);
		sites1.setSitInactif(1);
		sites1.setSitNomFr("Sit Nom Fr");
		sites1.setSitNomResponsable("Sit Nom Responsable");
		sites1.setStructures(structures1);
		when(sitesRepository.saveAndFlush((Sites) any())).thenReturn(sites1);
		when(sitesRepository.findById((Long) any())).thenReturn(ofResult);

		Structures structures2 = new Structures();
		structures2.setActiviteCommerciale("Activite Commerciale");
		structures2.setAdresse("Adresse");
		structures2.setBilanSocail("Bilan Socail");
		structures2.setCapital("Capital");
		structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures2.setDepartement("Departement");
		structures2.setDescription("The characteristics of someone or something");
		structures2.setEmail("jane.doe@example.org");
		structures2.setFlagEtat(Etats.INACTIVE);
		structures2.setFormJuridique("Form Juridique");
		structures2.setId(123L);
		structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
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

		Sites sites2 = new Sites();
		sites2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites2.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		sites2.setFlagEtat(Etats.INACTIVE);
		sites2.setId(123L);
		sites2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites2.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		sites2.setSitCode("Sit Code");
		sites2.setSitIdResponsable(1L);
		sites2.setSitInactif(1);
		sites2.setSitNomFr("Sit Nom Fr");
		sites2.setSitNomResponsable("Sit Nom Responsable");
		sites2.setStructures(structures2);

		SitesDto sitesDto = new SitesDto();
		sitesDto.setCode("Code");
		sitesDto.setId(123L);
		sitesDto.setInactif(1);
		sitesDto.setLibelle("Libelle");
		sitesDto.setSitIdClient(1L);
		sitesDto.setSitIdResponsable(1L);
		sitesDto.setSitNomResponsable("Sit Nom Responsable");
		sitesDto.setStructuresDto(new StructuresDto());
		when(sitesMapper.toDto((Sites) any())).thenReturn(sitesDto);
		when(sitesMapper.toEntity((SitesDto) any())).thenReturn(sites2);

		SitesDto sitesDto1 = new SitesDto();
		sitesDto1.setCode("Code");
		sitesDto1.setId(123L);
		sitesDto1.setInactif(1);
		sitesDto1.setLibelle("Libelle");
		sitesDto1.setSitIdClient(1L);
		sitesDto1.setSitIdResponsable(1L);
		sitesDto1.setSitNomResponsable("Sit Nom Responsable");
		sitesDto1.setStructuresDto(new StructuresDto());
		assertSame(sitesDto, sitesServices.updateSite(sitesDto1, 123L));
		verify(sitesRepository).saveAndFlush((Sites) any());
		verify(sitesRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
		verify(sitesMapper).toEntity((SitesDto) any());
	}

	/**
	 * Method under test: {@link SitesServices#updateSite(SitesDto, Long)}
	 */
	@Test
	void testUpdateSite2() {
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

		Sites sites1 = new Sites();
		sites1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		sites1.setFlagEtat(Etats.INACTIVE);
		sites1.setId(123L);
		sites1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		sites1.setSitCode("Sit Code");
		sites1.setSitIdResponsable(1L);
		sites1.setSitInactif(1);
		sites1.setSitNomFr("Sit Nom Fr");
		sites1.setSitNomResponsable("Sit Nom Responsable");
		sites1.setStructures(structures1);
		when(sitesRepository.saveAndFlush((Sites) any())).thenReturn(sites1);
		when(sitesRepository.findById((Long) any())).thenReturn(ofResult);

		Structures structures2 = new Structures();
		structures2.setActiviteCommerciale("Activite Commerciale");
		structures2.setAdresse("Adresse");
		structures2.setBilanSocail("Bilan Socail");
		structures2.setCapital("Capital");
		structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		structures2.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures2.setDepartement("Departement");
		structures2.setDescription("The characteristics of someone or something");
		structures2.setEmail("jane.doe@example.org");
		structures2.setFlagEtat(Etats.INACTIVE);
		structures2.setFormJuridique("Form Juridique");
		structures2.setId(123L);
		structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
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

		Sites sites2 = new Sites();
		sites2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites2.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		sites2.setFlagEtat(Etats.INACTIVE);
		sites2.setId(123L);
		sites2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		sites2.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		sites2.setSitCode("Sit Code");
		sites2.setSitIdResponsable(1L);
		sites2.setSitInactif(1);
		sites2.setSitNomFr("Sit Nom Fr");
		sites2.setSitNomResponsable("Sit Nom Responsable");
		sites2.setStructures(structures2);
		when(sitesMapper.toDto((Sites) any())).thenThrow(new ResponseException("An error occurred"));
		when(sitesMapper.toEntity((SitesDto) any())).thenReturn(sites2);

		SitesDto sitesDto = new SitesDto();
		sitesDto.setCode("Code");
		sitesDto.setId(123L);
		sitesDto.setInactif(1);
		sitesDto.setLibelle("Libelle");
		sitesDto.setSitIdClient(1L);
		sitesDto.setSitIdResponsable(1L);
		sitesDto.setSitNomResponsable("Sit Nom Responsable");
		sitesDto.setStructuresDto(new StructuresDto());
		assertThrows(ResponseException.class, () -> sitesServices.updateSite(sitesDto, 123L));
		verify(sitesRepository).saveAndFlush((Sites) any());
		verify(sitesRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
		verify(sitesMapper).toEntity((SitesDto) any());
	}

	/**
	 * Method under test: {@link SitesServices#deleteSite(Long)}
	 */
	@Test
	void testDeleteSite() {
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
		doNothing().when(sitesRepository).deleteById((Long) any());
		when(sitesRepository.findById((Long) any())).thenReturn(ofResult);
		sitesServices.deleteSite(123L);
		verify(sitesRepository).findById((Long) any());
		verify(sitesRepository).deleteById((Long) any());
	}

	/**
	 * Method under test: {@link SitesServices#deleteSite(Long)}
	 */
	@Test
	void testDeleteSite2() {
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
		doThrow(new ResponseException("An error occurred")).when(sitesRepository).deleteById((Long) any());
		when(sitesRepository.findById((Long) any())).thenReturn(ofResult);
		assertThrows(ResponseException.class, () -> sitesServices.deleteSite(123L));
		verify(sitesRepository).findById((Long) any());
		verify(sitesRepository).deleteById((Long) any());
	}

	/**
	 * Method under test: {@link SitesServices#getSites(Long)}
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
		sitesDto.setStructuresDto(new StructuresDto());
		when(sitesMapper.toDto((Sites) any())).thenReturn(sitesDto);
		assertSame(sitesDto, sitesServices.getSites(123L));
		verify(sitesRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
	}

	/**
	 * Method under test: {@link SitesServices#getSites(Long)}
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
		assertThrows(ResponseException.class, () -> sitesServices.getSites(123L));
		verify(sitesRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
	}

	/**
	 * Method under test: {@link SitesServices#getSites(SitesDto)}
	 */
	@Test
	void testGetSites3() {
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
		sitesDto.setStructuresDto(new StructuresDto());
		when(sitesMapper.toDto((Sites) any())).thenReturn(sitesDto);

		SitesDto sitesDto1 = new SitesDto();
		sitesDto1.setCode("Code");
		sitesDto1.setId(123L);
		sitesDto1.setInactif(1);
		sitesDto1.setLibelle("Libelle");
		sitesDto1.setSitIdClient(1L);
		sitesDto1.setSitIdResponsable(1L);
		sitesDto1.setSitNomResponsable("Sit Nom Responsable");
		sitesDto1.setStructuresDto(new StructuresDto());
		assertSame(sitesDto, sitesServices.getSites(sitesDto1));
		verify(sitesRepository).findById((Long) any());
		verify(sitesMapper).toDto((Sites) any());
	}

	/**
	 * Method under test: {@link SitesServices#getSites(SitesDto)}
	 */
	@Test
	void testGetSites4() {
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
		sitesDto.setStructuresDto(new StructuresDto());
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
		assertThrows(ResponseException.class, () -> sitesServices.getAllSites(new StructuresDto()));
		verify(sitesRepository).findByStructuresId((Long) any());
		verify(structuresRepository).findById((Long) any());
	}


}

