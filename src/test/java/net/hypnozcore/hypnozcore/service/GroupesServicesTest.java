package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.GroupesMapper;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GroupesServices.class})
@ExtendWith(SpringExtension.class)
class GroupesServicesTest {
	@MockBean
	private GroupesMapper groupesMapper;

	@MockBean
	private GroupesRepository groupesRepository;

	@Autowired
	private GroupesServices groupesServices;

	@MockBean
	private StructuresRepository structuresRepository;

	/**
	 * Method under test: {@link GroupesServices#save(GroupesDto)}
	 */
	@Test
	void testSave() {
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		when(groupesRepository.saveAndFlush((Groupes) any())).thenReturn(groupes);

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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);

		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		when(groupesMapper.toDto((Groupes) any())).thenReturn(groupesDto);
		when(groupesMapper.toEntity((GroupesDto) any())).thenReturn(groupes1);

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
		Optional<Structures> ofResult = Optional.of(structures2);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);

		GroupesDto groupesDto1 = new GroupesDto();
		groupesDto1.setCode("Code");
		groupesDto1.setId(123L);
		groupesDto1.setLibelle("Libelle");
		groupesDto1.setStructures(new StructuresDto());
		assertSame(groupesDto, groupesServices.save(groupesDto1));
		verify(groupesRepository).saveAndFlush((Groupes) any());
		verify(groupesMapper).toDto((Groupes) any());
		verify(groupesMapper).toEntity((GroupesDto) any());
		verify(structuresRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link GroupesServices#save(GroupesDto)}
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		when(groupesRepository.saveAndFlush((Groupes) any())).thenReturn(groupes);

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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);
		when(groupesMapper.toDto((Groupes) any())).thenThrow(new ResponseException("An error occurred"));
		when(groupesMapper.toEntity((GroupesDto) any())).thenReturn(groupes1);

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
		Optional<Structures> ofResult = Optional.of(structures2);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult);

		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		assertThrows(ResponseException.class, () -> groupesServices.save(groupesDto));
		verify(groupesRepository).saveAndFlush((Groupes) any());
		verify(groupesMapper).toDto((Groupes) any());
		verify(groupesMapper).toEntity((GroupesDto) any());
		verify(structuresRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link GroupesServices#update(GroupesDto, Long)}
	 */
	@Test
	void testUpdate() {
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		Optional<Groupes> ofResult = Optional.of(groupes);

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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);
		when(groupesRepository.saveAndFlush((Groupes) any())).thenReturn(groupes1);
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);

		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());

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

		Groupes groupes2 = new Groupes();
		groupes2.setCode("Code");
		groupes2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes2.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		groupes2.setFlagEtat(Etats.INACTIVE);
		groupes2.setId(123L);
		groupes2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes2.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		groupes2.setLibelle("Libelle");
		groupes2.setStructures(structures2);
		when(groupesMapper.toDto((Groupes) any())).thenReturn(groupesDto);
		when(groupesMapper.toEntity((GroupesDto) any())).thenReturn(groupes2);

		GroupesDto groupesDto1 = new GroupesDto();
		groupesDto1.setCode("Code");
		groupesDto1.setId(123L);
		groupesDto1.setLibelle("Libelle");
		groupesDto1.setStructures(new StructuresDto());
		assertSame(groupesDto, groupesServices.update(groupesDto1, 123L));
		verify(groupesRepository).saveAndFlush((Groupes) any());
		verify(groupesRepository).findById((Long) any());
		verify(groupesMapper).toDto((Groupes) any());
		verify(groupesMapper).toEntity((GroupesDto) any());
	}

	/**
	 * Method under test: {@link GroupesServices#update(GroupesDto, Long)}
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		Optional<Groupes> ofResult = Optional.of(groupes);

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

		Groupes groupes1 = new Groupes();
		groupes1.setCode("Code");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);
		when(groupesRepository.saveAndFlush((Groupes) any())).thenReturn(groupes1);
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);
		when(groupesMapper.toDto((Groupes) any())).thenThrow(new ResponseException("An error occurred"));
		when(groupesMapper.toEntity((GroupesDto) any())).thenThrow(new ResponseException("An error occurred"));

		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		assertThrows(ResponseException.class, () -> groupesServices.update(groupesDto, 123L));
		verify(groupesRepository).findById((Long) any());
		verify(groupesMapper).toEntity((GroupesDto) any());
	}

	/**
	 * Method under test: {@link GroupesServices#listByStructure(Long)}
	 */
	@Test
	void testListByStructure() {
		when(groupesRepository.findAll()).thenReturn(new ArrayList<>());
		ArrayList<GroupesDto> groupesDtoList = new ArrayList<>();
		when(groupesMapper.toDto((List<Groupes>) any())).thenReturn(groupesDtoList);
		List<GroupesDto> actualListByStructureResult = groupesServices.listByStructure(1L);
		assertSame(groupesDtoList, actualListByStructureResult);
		assertTrue(actualListByStructureResult.isEmpty());
		verify(groupesRepository).findAll();
		verify(groupesMapper).toDto((List<Groupes>) any());
	}

	/**
	 * Method under test: {@link GroupesServices#listByStructure(Long)}
	 */
	@Test
	void testListByStructure2() {
		when(groupesRepository.findAll()).thenReturn(new ArrayList<>());
		when(groupesMapper.toDto((List<Groupes>) any())).thenThrow(new ResponseException("An error occurred"));
		assertThrows(ResponseException.class, () -> groupesServices.listByStructure(1L));
		verify(groupesRepository).findAll();
		verify(groupesMapper).toDto((List<Groupes>) any());
	}

	/**
	 * Method under test: {@link GroupesServices#listByStructure(Long)}
	 */
	@Test
	void testListByStructure3() {
		Structures structures = new Structures();
		structures.setActiviteCommerciale("FIND LIST {0}");
		structures.setAdresse("FIND LIST {0}");
		structures.setBilanSocail("FIND LIST {0}");
		structures.setCapital("FIND LIST {0}");
		structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures.setDepartement("FIND LIST {0}");
		structures.setDescription("The characteristics of someone or something");
		structures.setEmail("jane.doe@example.org");
		structures.setFlagEtat(Etats.INACTIVE);
		structures.setFormJuridique("FIND LIST {0}");
		structures.setId(123L);
		structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setLogo("FIND LIST {0}");
		structures.setPays("FIND LIST {0}");
		structures.setQualiteResponsable("FIND LIST {0}");
		structures.setRaisonSocial("FIND LIST {0}");
		structures.setResponsable("FIND LIST {0}");
		structures.setSigle("FIND LIST {0}");
		structures.setSiteweb("FIND LIST {0}");
		structures.setTelephone("4105551212");
		structures.setTypeEntreprise(TypeEntreprise.SA);
		structures.setVille("FIND LIST {0}");
		structures.setZoneFiscale("FIND LIST {0}");
		structures.setZoneFiscale2("FIND LIST {0}");

		Groupes groupes = new Groupes();
		groupes.setCode("FIND LIST {0}");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("FIND LIST {0}");
		groupes.setStructures(structures);

		ArrayList<Groupes> groupesList = new ArrayList<>();
		groupesList.add(groupes);
		when(groupesRepository.findAll()).thenReturn(groupesList);
		ArrayList<GroupesDto> groupesDtoList = new ArrayList<>();
		when(groupesMapper.toDto((List<Groupes>) any())).thenReturn(groupesDtoList);
		List<GroupesDto> actualListByStructureResult = groupesServices.listByStructure(1L);
		assertSame(groupesDtoList, actualListByStructureResult);
		assertTrue(actualListByStructureResult.isEmpty());
		verify(groupesRepository).findAll();
		verify(groupesMapper).toDto((List<Groupes>) any());
	}

	/**
	 * Method under test: {@link GroupesServices#listByStructure(Long)}
	 */
	@Test
	void testListByStructure4() {
		Structures structures = new Structures();
		structures.setActiviteCommerciale("FIND LIST {0}");
		structures.setAdresse("FIND LIST {0}");
		structures.setBilanSocail("FIND LIST {0}");
		structures.setCapital("FIND LIST {0}");
		structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures.setDepartement("FIND LIST {0}");
		structures.setDescription("The characteristics of someone or something");
		structures.setEmail("jane.doe@example.org");
		structures.setFlagEtat(Etats.INACTIVE);
		structures.setFormJuridique("FIND LIST {0}");
		structures.setId(123L);
		structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setLogo("FIND LIST {0}");
		structures.setPays("FIND LIST {0}");
		structures.setQualiteResponsable("FIND LIST {0}");
		structures.setRaisonSocial("FIND LIST {0}");
		structures.setResponsable("FIND LIST {0}");
		structures.setSigle("FIND LIST {0}");
		structures.setSiteweb("FIND LIST {0}");
		structures.setTelephone("4105551212");
		structures.setTypeEntreprise(TypeEntreprise.SA);
		structures.setVille("FIND LIST {0}");
		structures.setZoneFiscale("FIND LIST {0}");
		structures.setZoneFiscale2("FIND LIST {0}");

		Groupes groupes = new Groupes();
		groupes.setCode("FIND LIST {0}");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("FIND LIST {0}");
		groupes.setStructures(structures);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("FIND LIST {0}");
		structures1.setAdresse("FIND LIST {0}");
		structures1.setBilanSocail("FIND LIST {0}");
		structures1.setCapital("FIND LIST {0}");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(6L));
		structures1.setDepartement("FIND LIST {0}");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("FIND LIST {0}");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setLogo("FIND LIST {0}");
		structures1.setPays("FIND LIST {0}");
		structures1.setQualiteResponsable("FIND LIST {0}");
		structures1.setRaisonSocial("FIND LIST {0}");
		structures1.setResponsable("FIND LIST {0}");
		structures1.setSigle("FIND LIST {0}");
		structures1.setSiteweb("FIND LIST {0}");
		structures1.setTelephone("4105551212");
		structures1.setTypeEntreprise(TypeEntreprise.SA);
		structures1.setVille("FIND LIST {0}");
		structures1.setZoneFiscale("FIND LIST {0}");
		structures1.setZoneFiscale2("FIND LIST {0}");

		Groupes groupes1 = new Groupes();
		groupes1.setCode("FIND LIST {0}");
		groupes1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("FIND LIST {0}");
		groupes1.setStructures(structures1);

		ArrayList<Groupes> groupesList = new ArrayList<>();
		groupesList.add(groupes1);
		groupesList.add(groupes);
		when(groupesRepository.findAll()).thenReturn(groupesList);
		ArrayList<GroupesDto> groupesDtoList = new ArrayList<>();
		when(groupesMapper.toDto((List<Groupes>) any())).thenReturn(groupesDtoList);
		List<GroupesDto> actualListByStructureResult = groupesServices.listByStructure(1L);
		assertSame(groupesDtoList, actualListByStructureResult);
		assertTrue(actualListByStructureResult.isEmpty());
		verify(groupesRepository).findAll();
		verify(groupesMapper).toDto((List<Groupes>) any());
	}

	/**
	 * Method under test: {@link GroupesServices#listByStructure(Long)}
	 */
	@Test
	void testListByStructure5() {
		Structures structures = new Structures();
		structures.setActiviteCommerciale("FIND LIST {0}");
		structures.setAdresse("FIND LIST {0}");
		structures.setBilanSocail("FIND LIST {0}");
		structures.setCapital("FIND LIST {0}");
		structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures.setDepartement("FIND LIST {0}");
		structures.setDescription("The characteristics of someone or something");
		structures.setEmail("jane.doe@example.org");
		structures.setFlagEtat(Etats.INACTIVE);
		structures.setFormJuridique("FIND LIST {0}");
		structures.setId(123L);
		structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		structures.setLogo("FIND LIST {0}");
		structures.setPays("FIND LIST {0}");
		structures.setQualiteResponsable("FIND LIST {0}");
		structures.setRaisonSocial("FIND LIST {0}");
		structures.setResponsable("FIND LIST {0}");
		structures.setSigle("FIND LIST {0}");
		structures.setSiteweb("FIND LIST {0}");
		structures.setTelephone("4105551212");
		structures.setTypeEntreprise(TypeEntreprise.SA);
		structures.setVille("FIND LIST {0}");
		structures.setZoneFiscale("FIND LIST {0}");
		structures.setZoneFiscale2("FIND LIST {0}");

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
		structures1.setId(1L);
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
		Groupes groupes = mock(Groupes.class);
		when(groupes.getStructures()).thenReturn(structures1);
		doNothing().when(groupes).setCreatedBy((String) any());
		doNothing().when(groupes).setCreatedDate((Date) any());
		doNothing().when(groupes).setFlagEtat((Etats) any());
		doNothing().when(groupes).setId((Long) any());
		doNothing().when(groupes).setLastModifiedBy((String) any());
		doNothing().when(groupes).setLastModifiedDate((Date) any());
		doNothing().when(groupes).setCode((String) any());
		doNothing().when(groupes).setLibelle((String) any());
		doNothing().when(groupes).setStructures((Structures) any());
		groupes.setCode("FIND LIST {0}");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("FIND LIST {0}");
		groupes.setStructures(structures);

		ArrayList<Groupes> groupesList = new ArrayList<>();
		groupesList.add(groupes);
		when(groupesRepository.findAll()).thenReturn(groupesList);
		ArrayList<GroupesDto> groupesDtoList = new ArrayList<>();
		when(groupesMapper.toDto((List<Groupes>) any())).thenReturn(groupesDtoList);
		List<GroupesDto> actualListByStructureResult = groupesServices.listByStructure(1L);
		assertSame(groupesDtoList, actualListByStructureResult);
		assertTrue(actualListByStructureResult.isEmpty());
		verify(groupesRepository).findAll();
		verify(groupes).getStructures();
		verify(groupes).setCreatedBy((String) any());
		verify(groupes).setCreatedDate((Date) any());
		verify(groupes).setFlagEtat((Etats) any());
		verify(groupes).setId((Long) any());
		verify(groupes).setLastModifiedBy((String) any());
		verify(groupes).setLastModifiedDate((Date) any());
		verify(groupes).setCode((String) any());
		verify(groupes).setLibelle((String) any());
		verify(groupes).setStructures((Structures) any());
		verify(groupesMapper).toDto((List<Groupes>) any());
	}

	/**
	 * Method under test: {@link GroupesServices#findById(Long)}
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		Optional<Groupes> ofResult = Optional.of(groupes);
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);

		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		when(groupesMapper.toDto((Groupes) any())).thenReturn(groupesDto);
		assertTrue(groupesServices.findById(123L).isPresent());
		verify(groupesRepository).findById((Long) any());
		verify(groupesMapper).toDto((Groupes) any());
	}

	/**
	 * Method under test: {@link GroupesServices#findById(Long)}
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		Optional<Groupes> ofResult = Optional.of(groupes);
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);
		when(groupesMapper.toDto((Groupes) any())).thenThrow(new ResponseException("An error occurred"));
		assertThrows(ResponseException.class, () -> groupesServices.findById(123L));
		verify(groupesRepository).findById((Long) any());
		verify(groupesMapper).toDto((Groupes) any());
	}

	/**
	 * Method under test: {@link GroupesServices#findOne(Long)}
	 */
	@Test
	void testFindOne() {
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		Optional<Groupes> ofResult = Optional.of(groupes);
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);
		assertSame(groupes, groupesServices.findOne(123L));
		verify(groupesRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link GroupesServices#findOne(Long)}
	 */
	@Test
	void testFindOne2() {
		when(groupesRepository.findById((Long) any())).thenReturn(Optional.empty());
		assertThrows(ResponseException.class, () -> groupesServices.findOne(123L));
		verify(groupesRepository).findById((Long) any());
	}

	/**
	 * Method under test: {@link GroupesServices#deleteById(Long)}
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

		Groupes groupes = new Groupes();
		groupes.setCode("Code");
		groupes.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setFlagEtat(Etats.INACTIVE);
		groupes.setId(123L);
		groupes.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		groupes.setLibelle("Libelle");
		groupes.setStructures(structures);
		Optional<Groupes> ofResult = Optional.of(groupes);
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);
		doNothing().when(groupesRepository).deleteById((Long) any());
		groupesServices.deleteById(123L);
		verify(groupesRepository).findById((Long) any());
		verify(groupesRepository).deleteById((Long) any());
	}
}

