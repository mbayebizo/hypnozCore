package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.UsersMapper;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.models.UserGroupes;
import net.hypnozcore.hypnozcore.models.UserStructures;
import net.hypnozcore.hypnozcore.models.Users;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.repository.UserGroupesRepository;
import net.hypnozcore.hypnozcore.repository.UserStructuresRepository;
import net.hypnozcore.hypnozcore.repository.UsersRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UsersServices.class})
@ExtendWith(SpringExtension.class)
class UsersServicesTest {
	@MockBean
	private GroupesRepository groupesRepository;

	@MockBean
	private StructuresRepository structuresRepository;

	@MockBean
	private UserGroupesRepository userGroupesRepository;

	@MockBean
	private UserStructuresRepository userStructuresRepository;

	@MockBean
	private UsersMapper usersMapper;

	@MockBean
	private UsersRepository usersRepository;

	@Autowired
	private UsersServices usersServices;

	/**
	 * Method under test: {@link UsersServices#save(UsersDto)}
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
		Optional<Groupes> ofResult = Optional.of(groupes);
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);

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
		Optional<Structures> ofResult1 = Optional.of(structures1);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult1);

		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		UsersDto usersDto = mock(UsersDto.class);
		when(usersDto.getPwd()).thenReturn("Pwd");
		when(usersDto.getGroupes()).thenReturn(groupesDto);
		when(usersDto.getStructuresDto()).thenReturn(new StructuresDto());
		assertThrows(ResponseException.class, () -> usersServices.save(usersDto));
		verify(groupesRepository).findById((Long) any());
		verify(structuresRepository).findById((Long) any());
		verify(usersDto).getPwd();
		verify(usersDto).getGroupes();
		verify(usersDto).getStructuresDto();
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveBygroupe(Long)}
	 */
	@Test
	void testFindUserActiveBygroupe() {
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(new ArrayList<>());
		assertThrows(ResponseException.class, () -> usersServices.findUserActiveBygroupe(123L));
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveBygroupe(Long)}
	 */
	@Test
	void testFindUserActiveBygroupe2() {
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

		UserGroupes.UserGroupesPK userGroupesPK = new UserGroupes.UserGroupesPK();
		userGroupesPK.setGroupesId(123L);
		userGroupesPK.setUsersId(123L);

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserGroupes userGroupes = new UserGroupes();
		userGroupes.setGroupes(groupes);
		userGroupes.setId(userGroupesPK);
		userGroupes.setNew(true);
		userGroupes.setUsers(users);

		ArrayList<UserGroupes> userGroupesList = new ArrayList<>();
		userGroupesList.add(userGroupes);
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(userGroupesList);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		ResponseEntity<List<UsersDto>> actualFindUserActiveBygroupeResult = usersServices.findUserActiveBygroupe(123L);
		assertTrue(actualFindUserActiveBygroupeResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserActiveBygroupeResult.getStatusCode());
		assertTrue(actualFindUserActiveBygroupeResult.getHeaders().isEmpty());
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
		verify(usersMapper).toDto((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveBygroupe(Long)}
	 */
	@Test
	void testFindUserActiveBygroupe3() {
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

		UserGroupes.UserGroupesPK userGroupesPK = new UserGroupes.UserGroupesPK();
		userGroupesPK.setGroupesId(123L);
		userGroupesPK.setUsersId(123L);

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserGroupes userGroupes = new UserGroupes();
		userGroupes.setGroupes(groupes);
		userGroupes.setId(userGroupesPK);
		userGroupes.setNew(true);
		userGroupes.setUsers(users);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
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
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);

		UserGroupes.UserGroupesPK userGroupesPK1 = new UserGroupes.UserGroupesPK();
		userGroupesPK1.setGroupesId(123L);
		userGroupesPK1.setUsersId(123L);

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");

		UserGroupes userGroupes1 = new UserGroupes();
		userGroupes1.setGroupes(groupes1);
		userGroupes1.setId(userGroupesPK1);
		userGroupes1.setNew(true);
		userGroupes1.setUsers(users1);

		ArrayList<UserGroupes> userGroupesList = new ArrayList<>();
		userGroupesList.add(userGroupes1);
		userGroupesList.add(userGroupes);
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(userGroupesList);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		ResponseEntity<List<UsersDto>> actualFindUserActiveBygroupeResult = usersServices.findUserActiveBygroupe(123L);
		assertTrue(actualFindUserActiveBygroupeResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserActiveBygroupeResult.getStatusCode());
		assertTrue(actualFindUserActiveBygroupeResult.getHeaders().isEmpty());
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
		verify(usersMapper, atLeast(1)).toDto((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveBygroupe(Long)}
	 */
	@Test
	void testFindUserActiveBygroupe4() {
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

		UserGroupes.UserGroupesPK userGroupesPK = new UserGroupes.UserGroupesPK();
		userGroupesPK.setGroupesId(123L);
		userGroupesPK.setUsersId(123L);

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");
		UserGroupes userGroupes = mock(UserGroupes.class);
		when(userGroupes.getUsers()).thenReturn(users1);
		doNothing().when(userGroupes).setGroupes((Groupes) any());
		doNothing().when(userGroupes).setId((UserGroupes.UserGroupesPK) any());
		doNothing().when(userGroupes).setNew(anyBoolean());
		doNothing().when(userGroupes).setUsers((Users) any());
		userGroupes.setGroupes(groupes);
		userGroupes.setId(userGroupesPK);
		userGroupes.setNew(true);
		userGroupes.setUsers(users);

		ArrayList<UserGroupes> userGroupesList = new ArrayList<>();
		userGroupesList.add(userGroupes);
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(userGroupesList);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		ResponseEntity<List<UsersDto>> actualFindUserActiveBygroupeResult = usersServices.findUserActiveBygroupe(123L);
		assertTrue(actualFindUserActiveBygroupeResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserActiveBygroupeResult.getStatusCode());
		assertTrue(actualFindUserActiveBygroupeResult.getHeaders().isEmpty());
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
		verify(userGroupes, atLeast(1)).getUsers();
		verify(userGroupes).setGroupes((Groupes) any());
		verify(userGroupes).setId((UserGroupes.UserGroupesPK) any());
		verify(userGroupes).setNew(anyBoolean());
		verify(userGroupes).setUsers((Users) any());
		verify(usersMapper).toDto((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveBygroupe(Long)}
	 */
	@Test
	void testFindUserActiveBygroupe5() {
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

		UserGroupes.UserGroupesPK userGroupesPK = new UserGroupes.UserGroupesPK();
		userGroupesPK.setGroupesId(123L);
		userGroupesPK.setUsersId(123L);

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");
		Users users1 = mock(Users.class);
		when(users1.getEtat()).thenReturn(false);
		doNothing().when(users1).setCreatedBy((String) any());
		doNothing().when(users1).setCreatedDate((Date) any());
		doNothing().when(users1).setFlagEtat((Etats) any());
		doNothing().when(users1).setId((Long) any());
		doNothing().when(users1).setLastModifiedBy((String) any());
		doNothing().when(users1).setLastModifiedDate((Date) any());
		doNothing().when(users1).setAdresse((String) any());
		doNothing().when(users1).setBp((String) any());
		doNothing().when(users1).setCel((String) any());
		doNothing().when(users1).setCivilite((String) any());
		doNothing().when(users1).setCodeSecret((String) any());
		doNothing().when(users1).setConnexion((Integer) any());
		doNothing().when(users1).setDateNaissance((LocalDate) any());
		doNothing().when(users1).setEtat((Boolean) any());
		doNothing().when(users1).setFirstLog((LocalDate) any());
		doNothing().when(users1).setLangue((String) any());
		doNothing().when(users1).setLastLog((LocalDate) any());
		doNothing().when(users1).setLogin((String) any());
		doNothing().when(users1).setNom((String) any());
		doNothing().when(users1).setPatronyme((String) any());
		doNothing().when(users1).setPhoto((String) any());
		doNothing().when(users1).setPrenom((String) any());
		doNothing().when(users1).setPwd((String) any());
		doNothing().when(users1).setSignature((String) any());
		doNothing().when(users1).setTelBureau((String) any());
		doNothing().when(users1).setTelDomicile((String) any());
		doNothing().when(users1).setVille((String) any());
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");
		UserGroupes userGroupes = mock(UserGroupes.class);
		when(userGroupes.getUsers()).thenReturn(users1);
		doNothing().when(userGroupes).setGroupes((Groupes) any());
		doNothing().when(userGroupes).setId((UserGroupes.UserGroupesPK) any());
		doNothing().when(userGroupes).setNew(anyBoolean());
		doNothing().when(userGroupes).setUsers((Users) any());
		userGroupes.setGroupes(groupes);
		userGroupes.setId(userGroupesPK);
		userGroupes.setNew(true);
		userGroupes.setUsers(users);

		ArrayList<UserGroupes> userGroupesList = new ArrayList<>();
		userGroupesList.add(userGroupes);
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(userGroupesList);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		assertThrows(ResponseException.class, () -> usersServices.findUserActiveBygroupe(123L));
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
		verify(userGroupes, atLeast(1)).getUsers();
		verify(userGroupes).setGroupes((Groupes) any());
		verify(userGroupes).setId((UserGroupes.UserGroupesPK) any());
		verify(userGroupes).setNew(anyBoolean());
		verify(userGroupes).setUsers((Users) any());
		verify(users1).getEtat();
		verify(users1).setCreatedBy((String) any());
		verify(users1).setCreatedDate((Date) any());
		verify(users1).setFlagEtat((Etats) any());
		verify(users1).setId((Long) any());
		verify(users1).setLastModifiedBy((String) any());
		verify(users1).setLastModifiedDate((Date) any());
		verify(users1).setAdresse((String) any());
		verify(users1).setBp((String) any());
		verify(users1).setCel((String) any());
		verify(users1).setCivilite((String) any());
		verify(users1).setCodeSecret((String) any());
		verify(users1).setConnexion((Integer) any());
		verify(users1).setDateNaissance((LocalDate) any());
		verify(users1).setEtat((Boolean) any());
		verify(users1).setFirstLog((LocalDate) any());
		verify(users1).setLangue((String) any());
		verify(users1).setLastLog((LocalDate) any());
		verify(users1).setLogin((String) any());
		verify(users1).setNom((String) any());
		verify(users1).setPatronyme((String) any());
		verify(users1).setPhoto((String) any());
		verify(users1).setPrenom((String) any());
		verify(users1).setPwd((String) any());
		verify(users1).setSignature((String) any());
		verify(users1).setTelBureau((String) any());
		verify(users1).setTelDomicile((String) any());
		verify(users1).setVille((String) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserBygroupe(Long)}
	 */
	@Test
	void testFindUserBygroupe() {
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(new ArrayList<>());
		assertThrows(ResponseException.class, () -> usersServices.findUserBygroupe(123L));
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserBygroupe(Long)}
	 */
	@Test
	void testFindUserBygroupe2() {
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

		UserGroupes.UserGroupesPK userGroupesPK = new UserGroupes.UserGroupesPK();
		userGroupesPK.setGroupesId(123L);
		userGroupesPK.setUsersId(123L);

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserGroupes userGroupes = new UserGroupes();
		userGroupes.setGroupes(groupes);
		userGroupes.setId(userGroupesPK);
		userGroupes.setNew(true);
		userGroupes.setUsers(users);

		ArrayList<UserGroupes> userGroupesList = new ArrayList<>();
		userGroupesList.add(userGroupes);
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(userGroupesList);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		ResponseEntity<List<UsersDto>> actualFindUserBygroupeResult = usersServices.findUserBygroupe(123L);
		assertTrue(actualFindUserBygroupeResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserBygroupeResult.getStatusCode());
		assertTrue(actualFindUserBygroupeResult.getHeaders().isEmpty());
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
		verify(usersMapper).toDto((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserBygroupe(Long)}
	 */
	@Test
	void testFindUserBygroupe3() {
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

		UserGroupes.UserGroupesPK userGroupesPK = new UserGroupes.UserGroupesPK();
		userGroupesPK.setGroupesId(123L);
		userGroupesPK.setUsersId(123L);

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserGroupes userGroupes = new UserGroupes();
		userGroupes.setGroupes(groupes);
		userGroupes.setId(userGroupesPK);
		userGroupes.setNew(true);
		userGroupes.setUsers(users);

		Structures structures1 = new Structures();
		structures1.setActiviteCommerciale("Activite Commerciale");
		structures1.setAdresse("Adresse");
		structures1.setBilanSocail("Bilan Socail");
		structures1.setCapital("Capital");
		structures1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		structures1.setDateFiscale(LocalDate.ofEpochDay(1L));
		structures1.setDepartement("Departement");
		structures1.setDescription("The characteristics of someone or something");
		structures1.setEmail("jane.doe@example.org");
		structures1.setFlagEtat(Etats.INACTIVE);
		structures1.setFormJuridique("Form Juridique");
		structures1.setId(123L);
		structures1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		structures1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
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
		LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setFlagEtat(Etats.INACTIVE);
		groupes1.setId(123L);
		groupes1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
		groupes1.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
		groupes1.setLibelle("Libelle");
		groupes1.setStructures(structures1);

		UserGroupes.UserGroupesPK userGroupesPK1 = new UserGroupes.UserGroupesPK();
		userGroupesPK1.setGroupesId(123L);
		userGroupesPK1.setUsersId(123L);

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");

		UserGroupes userGroupes1 = new UserGroupes();
		userGroupes1.setGroupes(groupes1);
		userGroupes1.setId(userGroupesPK1);
		userGroupes1.setNew(true);
		userGroupes1.setUsers(users1);

		ArrayList<UserGroupes> userGroupesList = new ArrayList<>();
		userGroupesList.add(userGroupes1);
		userGroupesList.add(userGroupes);
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(userGroupesList);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		ResponseEntity<List<UsersDto>> actualFindUserBygroupeResult = usersServices.findUserBygroupe(123L);
		assertTrue(actualFindUserBygroupeResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserBygroupeResult.getStatusCode());
		assertTrue(actualFindUserBygroupeResult.getHeaders().isEmpty());
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
		verify(usersMapper, atLeast(1)).toDto((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserBygroupe(Long)}
	 */
	@Test
	void testFindUserBygroupe4() {
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

		UserGroupes.UserGroupesPK userGroupesPK = new UserGroupes.UserGroupesPK();
		userGroupesPK.setGroupesId(123L);
		userGroupesPK.setUsersId(123L);

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");
		UserGroupes userGroupes = mock(UserGroupes.class);
		when(userGroupes.getUsers()).thenReturn(users1);
		doNothing().when(userGroupes).setGroupes((Groupes) any());
		doNothing().when(userGroupes).setId((UserGroupes.UserGroupesPK) any());
		doNothing().when(userGroupes).setNew(anyBoolean());
		doNothing().when(userGroupes).setUsers((Users) any());
		userGroupes.setGroupes(groupes);
		userGroupes.setId(userGroupesPK);
		userGroupes.setNew(true);
		userGroupes.setUsers(users);

		ArrayList<UserGroupes> userGroupesList = new ArrayList<>();
		userGroupesList.add(userGroupes);
		when(userGroupesRepository.findByIdGroupesId((Long) any())).thenReturn(userGroupesList);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		ResponseEntity<List<UsersDto>> actualFindUserBygroupeResult = usersServices.findUserBygroupe(123L);
		assertTrue(actualFindUserBygroupeResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserBygroupeResult.getStatusCode());
		assertTrue(actualFindUserBygroupeResult.getHeaders().isEmpty());
		verify(userGroupesRepository).findByIdGroupesId((Long) any());
		verify(userGroupes, atLeast(1)).getUsers();
		verify(userGroupes).setGroupes((Groupes) any());
		verify(userGroupes).setId((UserGroupes.UserGroupesPK) any());
		verify(userGroupes).setNew(anyBoolean());
		verify(userGroupes).setUsers((Users) any());
		verify(usersMapper).toDto((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveByStructure(Long)}
	 */
	@Test
	void testFindUserActiveByStructure() {
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(new ArrayList<>());
		assertThrows(ResponseException.class, () -> usersServices.findUserActiveByStructure(123L));
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveByStructure(Long)}
	 */
	@Test
	void testFindUserActiveByStructure2() {
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));

		UserStructures.UserStructuresPK userStructuresPK = new UserStructures.UserStructuresPK();
		userStructuresPK.setStructuresId(123L);
		userStructuresPK.setUsersId(123L);

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

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserStructures userStructures = new UserStructures();
		userStructures.setId(userStructuresPK);
		userStructures.setNew(true);
		userStructures.setStructures(structures);
		userStructures.setUsers(users);

		ArrayList<UserStructures> userStructuresList = new ArrayList<>();
		userStructuresList.add(userStructures);
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(userStructuresList);
		ResponseEntity<List<UsersDto>> actualFindUserActiveByStructureResult = usersServices
				.findUserActiveByStructure(123L);
		assertTrue(actualFindUserActiveByStructureResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserActiveByStructureResult.getStatusCode());
		assertTrue(actualFindUserActiveByStructureResult.getHeaders().isEmpty());
		verify(usersMapper).toDto((Users) any());
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveByStructure(Long)}
	 */
	@Test
	void testFindUserActiveByStructure3() {
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));

		UserStructures.UserStructuresPK userStructuresPK = new UserStructures.UserStructuresPK();
		userStructuresPK.setStructuresId(123L);
		userStructuresPK.setUsersId(123L);

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

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserStructures userStructures = new UserStructures();
		userStructures.setId(userStructuresPK);
		userStructures.setNew(true);
		userStructures.setStructures(structures);
		userStructures.setUsers(users);

		UserStructures.UserStructuresPK userStructuresPK1 = new UserStructures.UserStructuresPK();
		userStructuresPK1.setStructuresId(123L);
		userStructuresPK1.setUsersId(123L);

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

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");

		UserStructures userStructures1 = new UserStructures();
		userStructures1.setId(userStructuresPK1);
		userStructures1.setNew(true);
		userStructures1.setStructures(structures1);
		userStructures1.setUsers(users1);

		ArrayList<UserStructures> userStructuresList = new ArrayList<>();
		userStructuresList.add(userStructures1);
		userStructuresList.add(userStructures);
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(userStructuresList);
		ResponseEntity<List<UsersDto>> actualFindUserActiveByStructureResult = usersServices
				.findUserActiveByStructure(123L);
		assertTrue(actualFindUserActiveByStructureResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserActiveByStructureResult.getStatusCode());
		assertTrue(actualFindUserActiveByStructureResult.getHeaders().isEmpty());
		verify(usersMapper, atLeast(1)).toDto((Users) any());
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveByStructure(Long)}
	 */
	@Test
	void testFindUserActiveByStructure4() {
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));

		UserStructures.UserStructuresPK userStructuresPK = new UserStructures.UserStructuresPK();
		userStructuresPK.setStructuresId(123L);
		userStructuresPK.setUsersId(123L);

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

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");
		UserStructures userStructures = mock(UserStructures.class);
		when(userStructures.getUsers()).thenReturn(users1);
		doNothing().when(userStructures).setId((UserStructures.UserStructuresPK) any());
		doNothing().when(userStructures).setNew(anyBoolean());
		doNothing().when(userStructures).setStructures((Structures) any());
		doNothing().when(userStructures).setUsers((Users) any());
		userStructures.setId(userStructuresPK);
		userStructures.setNew(true);
		userStructures.setStructures(structures);
		userStructures.setUsers(users);

		ArrayList<UserStructures> userStructuresList = new ArrayList<>();
		userStructuresList.add(userStructures);
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(userStructuresList);
		ResponseEntity<List<UsersDto>> actualFindUserActiveByStructureResult = usersServices
				.findUserActiveByStructure(123L);
		assertTrue(actualFindUserActiveByStructureResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserActiveByStructureResult.getStatusCode());
		assertTrue(actualFindUserActiveByStructureResult.getHeaders().isEmpty());
		verify(usersMapper).toDto((Users) any());
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
		verify(userStructures, atLeast(1)).getUsers();
		verify(userStructures).setId((UserStructures.UserStructuresPK) any());
		verify(userStructures).setNew(anyBoolean());
		verify(userStructures).setStructures((Structures) any());
		verify(userStructures).setUsers((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserActiveByStructure(Long)}
	 */
	@Test
	void testFindUserActiveByStructure5() {
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));

		UserStructures.UserStructuresPK userStructuresPK = new UserStructures.UserStructuresPK();
		userStructuresPK.setStructuresId(123L);
		userStructuresPK.setUsersId(123L);

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

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");
		Users users1 = mock(Users.class);
		when(users1.getEtat()).thenReturn(false);
		doNothing().when(users1).setCreatedBy((String) any());
		doNothing().when(users1).setCreatedDate((Date) any());
		doNothing().when(users1).setFlagEtat((Etats) any());
		doNothing().when(users1).setId((Long) any());
		doNothing().when(users1).setLastModifiedBy((String) any());
		doNothing().when(users1).setLastModifiedDate((Date) any());
		doNothing().when(users1).setAdresse((String) any());
		doNothing().when(users1).setBp((String) any());
		doNothing().when(users1).setCel((String) any());
		doNothing().when(users1).setCivilite((String) any());
		doNothing().when(users1).setCodeSecret((String) any());
		doNothing().when(users1).setConnexion((Integer) any());
		doNothing().when(users1).setDateNaissance((LocalDate) any());
		doNothing().when(users1).setEtat((Boolean) any());
		doNothing().when(users1).setFirstLog((LocalDate) any());
		doNothing().when(users1).setLangue((String) any());
		doNothing().when(users1).setLastLog((LocalDate) any());
		doNothing().when(users1).setLogin((String) any());
		doNothing().when(users1).setNom((String) any());
		doNothing().when(users1).setPatronyme((String) any());
		doNothing().when(users1).setPhoto((String) any());
		doNothing().when(users1).setPrenom((String) any());
		doNothing().when(users1).setPwd((String) any());
		doNothing().when(users1).setSignature((String) any());
		doNothing().when(users1).setTelBureau((String) any());
		doNothing().when(users1).setTelDomicile((String) any());
		doNothing().when(users1).setVille((String) any());
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");
		UserStructures userStructures = mock(UserStructures.class);
		when(userStructures.getUsers()).thenReturn(users1);
		doNothing().when(userStructures).setId((UserStructures.UserStructuresPK) any());
		doNothing().when(userStructures).setNew(anyBoolean());
		doNothing().when(userStructures).setStructures((Structures) any());
		doNothing().when(userStructures).setUsers((Users) any());
		userStructures.setId(userStructuresPK);
		userStructures.setNew(true);
		userStructures.setStructures(structures);
		userStructures.setUsers(users);

		ArrayList<UserStructures> userStructuresList = new ArrayList<>();
		userStructuresList.add(userStructures);
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(userStructuresList);
		assertThrows(ResponseException.class, () -> usersServices.findUserActiveByStructure(123L));
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
		verify(userStructures, atLeast(1)).getUsers();
		verify(userStructures).setId((UserStructures.UserStructuresPK) any());
		verify(userStructures).setNew(anyBoolean());
		verify(userStructures).setStructures((Structures) any());
		verify(userStructures).setUsers((Users) any());
		verify(users1).getEtat();
		verify(users1).setCreatedBy((String) any());
		verify(users1).setCreatedDate((Date) any());
		verify(users1).setFlagEtat((Etats) any());
		verify(users1).setId((Long) any());
		verify(users1).setLastModifiedBy((String) any());
		verify(users1).setLastModifiedDate((Date) any());
		verify(users1).setAdresse((String) any());
		verify(users1).setBp((String) any());
		verify(users1).setCel((String) any());
		verify(users1).setCivilite((String) any());
		verify(users1).setCodeSecret((String) any());
		verify(users1).setConnexion((Integer) any());
		verify(users1).setDateNaissance((LocalDate) any());
		verify(users1).setEtat((Boolean) any());
		verify(users1).setFirstLog((LocalDate) any());
		verify(users1).setLangue((String) any());
		verify(users1).setLastLog((LocalDate) any());
		verify(users1).setLogin((String) any());
		verify(users1).setNom((String) any());
		verify(users1).setPatronyme((String) any());
		verify(users1).setPhoto((String) any());
		verify(users1).setPrenom((String) any());
		verify(users1).setPwd((String) any());
		verify(users1).setSignature((String) any());
		verify(users1).setTelBureau((String) any());
		verify(users1).setTelDomicile((String) any());
		verify(users1).setVille((String) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserByStructure(Long)}
	 */
	@Test
	void testFindUserByStructure() {
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(new ArrayList<>());
		assertThrows(ResponseException.class, () -> usersServices.findUserByStructure(123L));
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserByStructure(Long)}
	 */
	@Test
	void testFindUserByStructure2() {
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));

		UserStructures.UserStructuresPK userStructuresPK = new UserStructures.UserStructuresPK();
		userStructuresPK.setStructuresId(123L);
		userStructuresPK.setUsersId(123L);

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

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserStructures userStructures = new UserStructures();
		userStructures.setId(userStructuresPK);
		userStructures.setNew(true);
		userStructures.setStructures(structures);
		userStructures.setUsers(users);

		ArrayList<UserStructures> userStructuresList = new ArrayList<>();
		userStructuresList.add(userStructures);
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(userStructuresList);
		ResponseEntity<List<UsersDto>> actualFindUserByStructureResult = usersServices.findUserByStructure(123L);
		assertTrue(actualFindUserByStructureResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserByStructureResult.getStatusCode());
		assertTrue(actualFindUserByStructureResult.getHeaders().isEmpty());
		verify(usersMapper).toDto((Users) any());
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserByStructure(Long)}
	 */
	@Test
	void testFindUserByStructure3() {
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));

		UserStructures.UserStructuresPK userStructuresPK = new UserStructures.UserStructuresPK();
		userStructuresPK.setStructuresId(123L);
		userStructuresPK.setUsersId(123L);

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

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		UserStructures userStructures = new UserStructures();
		userStructures.setId(userStructuresPK);
		userStructures.setNew(true);
		userStructures.setStructures(structures);
		userStructures.setUsers(users);

		UserStructures.UserStructuresPK userStructuresPK1 = new UserStructures.UserStructuresPK();
		userStructuresPK1.setStructuresId(123L);
		userStructuresPK1.setUsersId(123L);

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

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");

		UserStructures userStructures1 = new UserStructures();
		userStructures1.setId(userStructuresPK1);
		userStructures1.setNew(true);
		userStructures1.setStructures(structures1);
		userStructures1.setUsers(users1);

		ArrayList<UserStructures> userStructuresList = new ArrayList<>();
		userStructuresList.add(userStructures1);
		userStructuresList.add(userStructures);
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(userStructuresList);
		ResponseEntity<List<UsersDto>> actualFindUserByStructureResult = usersServices.findUserByStructure(123L);
		assertTrue(actualFindUserByStructureResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserByStructureResult.getStatusCode());
		assertTrue(actualFindUserByStructureResult.getHeaders().isEmpty());
		verify(usersMapper, atLeast(1)).toDto((Users) any());
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findUserByStructure(Long)}
	 */
	@Test
	void testFindUserByStructure4() {
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));

		UserStructures.UserStructuresPK userStructuresPK = new UserStructures.UserStructuresPK();
		userStructuresPK.setStructuresId(123L);
		userStructuresPK.setUsersId(123L);

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

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");

		Users users1 = new Users();
		users1.setAdresse("Adresse");
		users1.setBp("Bp");
		users1.setCel("Cel");
		users1.setCivilite("Civilite");
		users1.setCodeSecret("Code Secret");
		users1.setConnexion(1);
		users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setDateNaissance(LocalDate.ofEpochDay(1L));
		users1.setEtat(true);
		users1.setFirstLog(LocalDate.ofEpochDay(1L));
		users1.setFlagEtat(Etats.INACTIVE);
		users1.setId(123L);
		users1.setLangue("Langue");
		users1.setLastLog(LocalDate.ofEpochDay(1L));
		users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
		users1.setLogin("Login");
		users1.setNom("Nom");
		users1.setPatronyme("Patronyme");
		users1.setPhoto("alice.liddell@example.org");
		users1.setPrenom("Prenom");
		users1.setPwd("Pwd");
		users1.setSignature("Signature");
		users1.setTelBureau("Tel Bureau");
		users1.setTelDomicile("Tel Domicile");
		users1.setVille("Ville");
		UserStructures userStructures = mock(UserStructures.class);
		when(userStructures.getUsers()).thenReturn(users1);
		doNothing().when(userStructures).setId((UserStructures.UserStructuresPK) any());
		doNothing().when(userStructures).setNew(anyBoolean());
		doNothing().when(userStructures).setStructures((Structures) any());
		doNothing().when(userStructures).setUsers((Users) any());
		userStructures.setId(userStructuresPK);
		userStructures.setNew(true);
		userStructures.setStructures(structures);
		userStructures.setUsers(users);

		ArrayList<UserStructures> userStructuresList = new ArrayList<>();
		userStructuresList.add(userStructures);
		when(userStructuresRepository.findByIdStructuresId((Long) any())).thenReturn(userStructuresList);
		ResponseEntity<List<UsersDto>> actualFindUserByStructureResult = usersServices.findUserByStructure(123L);
		assertTrue(actualFindUserByStructureResult.hasBody());
		assertEquals(HttpStatus.OK, actualFindUserByStructureResult.getStatusCode());
		assertTrue(actualFindUserByStructureResult.getHeaders().isEmpty());
		verify(usersMapper).toDto((Users) any());
		verify(userStructuresRepository).findByIdStructuresId((Long) any());
		verify(userStructures, atLeast(1)).getUsers();
		verify(userStructures).setId((UserStructures.UserStructuresPK) any());
		verify(userStructures).setNew(anyBoolean());
		verify(userStructures).setStructures((Structures) any());
		verify(userStructures).setUsers((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#update(UsersDto)}
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
		when(groupesRepository.findById((Long) any())).thenReturn(ofResult);

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
		Optional<Structures> ofResult1 = Optional.of(structures1);
		when(structuresRepository.findById((Long) any())).thenReturn(ofResult1);

		GroupesDto groupesDto = new GroupesDto();
		groupesDto.setCode("Code");
		groupesDto.setId(123L);
		groupesDto.setLibelle("Libelle");
		groupesDto.setStructures(new StructuresDto());
		UsersDto usersDto = mock(UsersDto.class);
		when(usersDto.getPwd()).thenReturn("Pwd");
		when(usersDto.getGroupes()).thenReturn(groupesDto);
		when(usersDto.getStructuresDto()).thenReturn(new StructuresDto());
		assertThrows(ResponseException.class, () -> usersServices.update(usersDto));
		verify(groupesRepository).findById((Long) any());
		verify(structuresRepository).findById((Long) any());
		verify(usersDto).getPwd();
		verify(usersDto).getGroupes();
		verify(usersDto).getStructuresDto();
	}

	/**
	 * Method under test: {@link UsersServices#delete(Long)}
	 */
	@Test
	void testDelete() {
		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");
		Optional<Users> ofResult = Optional.of(users);
		when(usersRepository.findById((Long) any())).thenReturn(ofResult);
		doNothing().when(usersRepository).deleteById((Long) any());
		when(userGroupesRepository.removeByIdUsersIdAllIgnoreCase((Long) any())).thenReturn(1L);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		when(userStructuresRepository.deleteByIdUsersIdAllIgnoreCase((Long) any())).thenReturn(1L);
		ResponseEntity<UsersDto> actualDeleteResult = usersServices.delete(123L);
		assertTrue(actualDeleteResult.hasBody());
		assertEquals(HttpStatus.OK, actualDeleteResult.getStatusCode());
		assertTrue(actualDeleteResult.getHeaders().isEmpty());
		verify(usersRepository).findById((Long) any());
		verify(usersRepository).deleteById((Long) any());
		verify(userGroupesRepository).removeByIdUsersIdAllIgnoreCase((Long) any());
		verify(usersMapper).toDto((Users) any());
		verify(userStructuresRepository).deleteByIdUsersIdAllIgnoreCase((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#delete(Long)}
	 */
	@Test
	void testDelete2() {
		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");
		Optional<Users> ofResult = Optional.of(users);
		when(usersRepository.findById((Long) any())).thenReturn(ofResult);
		doNothing().when(usersRepository).deleteById((Long) any());
		when(userGroupesRepository.removeByIdUsersIdAllIgnoreCase((Long) any())).thenReturn(1L);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		when(userStructuresRepository.deleteByIdUsersIdAllIgnoreCase((Long) any()))
				.thenThrow(new ResponseException("An error occurred"));
		assertThrows(ResponseException.class, () -> usersServices.delete(123L));
		verify(usersRepository).findById((Long) any());
		verify(userGroupesRepository).removeByIdUsersIdAllIgnoreCase((Long) any());
		verify(usersMapper).toDto((Users) any());
		verify(userStructuresRepository).deleteByIdUsersIdAllIgnoreCase((Long) any());
	}

	/**
	 * Method under test: {@link UsersServices#findById(Long)}
	 */
	@Test
	void testFindById() {
		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");
		Optional<Users> ofResult = Optional.of(users);
		when(usersRepository.findById((Long) any())).thenReturn(ofResult);
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		usersServices.findById(123L);
		verify(usersRepository).findById((Long) any());
		verify(usersMapper).toDto((Users) any());
	}

	/**
	 * Method under test: {@link UsersServices#findById(Long)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testFindById2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   net.hypnozcore.hypnozcore.utils.exceptions.ResponseException: An error occurred
		//       at java.util.Optional.map(Optional.java:260)
		//       at net.hypnozcore.hypnozcore.service.UsersServices.findById(UsersServices.java:186)
		//   In order to prevent findById(Long)
		//   from throwing ResponseException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   findById(Long).
		//   See https://diff.blue/R013 to resolve this issue.

		Users users = new Users();
		users.setAdresse("Adresse");
		users.setBp("Bp");
		users.setCel("Cel");
		users.setCivilite("Civilite");
		users.setCodeSecret("Code Secret");
		users.setConnexion(1);
		users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
		users.setDateNaissance(LocalDate.ofEpochDay(1L));
		users.setEtat(true);
		users.setFirstLog(LocalDate.ofEpochDay(1L));
		users.setFlagEtat(Etats.INACTIVE);
		users.setId(123L);
		users.setLangue("Langue");
		users.setLastLog(LocalDate.ofEpochDay(1L));
		users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
		users.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
		users.setLogin("Login");
		users.setNom("Nom");
		users.setPatronyme("Patronyme");
		users.setPhoto("alice.liddell@example.org");
		users.setPrenom("Prenom");
		users.setPwd("Pwd");
		users.setSignature("Signature");
		users.setTelBureau("Tel Bureau");
		users.setTelDomicile("Tel Domicile");
		users.setVille("Ville");
		Optional<Users> ofResult = Optional.of(users);
		when(usersRepository.findById((Long) any())).thenReturn(ofResult);
		when(usersMapper.toDto((Users) any())).thenThrow(new ResponseException("An error occurred"));
		usersServices.findById(123L);
	}

	/**
	 * Method under test: {@link UsersServices#findById(Long)}
	 */
	@Test
	void testFindById3() {
		when(usersRepository.findById((Long) any())).thenReturn(Optional.empty());
		when(usersMapper.toDto((Users) any())).thenReturn(mock(UsersDto.class));
		assertThrows(ResponseException.class, () -> usersServices.findById(123L));
		verify(usersRepository).findById((Long) any());
	}
}

