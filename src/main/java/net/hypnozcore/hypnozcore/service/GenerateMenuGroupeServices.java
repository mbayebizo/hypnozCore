package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.GroupesApplications;
import net.hypnozcore.hypnozcore.models.GroupesFonctions;
import net.hypnozcore.hypnozcore.models.GroupesModules;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.UserApplications;
import net.hypnozcore.hypnozcore.models.UserFonctions;
import net.hypnozcore.hypnozcore.models.UserModules;
import net.hypnozcore.hypnozcore.repository.GroupesApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesModulesRepository;
import net.hypnozcore.hypnozcore.repository.UserApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.UserFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.UserModulesRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class GenerateMenuGroupeServices {
	final GroupesFonctionsRepository groupesFonctionsRepository;
	final GroupesApplicationsRepository groupesApplicationsRepository;
	final GroupesModulesRepository groupesModulesRepository;
	final UserModulesRepository userModulesRepository;
	final UserApplicationsRepository userApplicationsRepository;
	final UserFonctionsRepository userFonctionsRepository;

	public GenerateMenuGroupeServices(GroupesFonctionsRepository groupesFonctionsRepository, GroupesApplicationsRepository groupesApplicationsRepository, GroupesModulesRepository groupesModulesRepository, UserModulesRepository userModulesRepository, UserApplicationsRepository userApplicationsRepository, UserFonctionsRepository userFonctionsRepository) {
		this.groupesFonctionsRepository = groupesFonctionsRepository;
		this.groupesApplicationsRepository = groupesApplicationsRepository;
		this.groupesModulesRepository = groupesModulesRepository;
		this.userModulesRepository = userModulesRepository;
		this.userApplicationsRepository = userApplicationsRepository;
		this.userFonctionsRepository = userFonctionsRepository;
	}


	public void deleteFonctionByGroupe(Long idfonction, Long idgroupe) {
		List<UserFonctions> userFonctionsList = userFonctionsRepository.findByIdFonctionsId(idfonction);
		if (!userFonctionsList.isEmpty()) {
			throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
		}
		Optional<GroupesFonctions> groupesFonctionsOptional = groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId(idgroupe, idfonction);
		if (groupesFonctionsOptional.isEmpty()) {
			throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
		}
		groupesFonctionsRepository.deleteByFonctionsAndGroupes(groupesFonctionsOptional.get().getFonctions(),
				groupesFonctionsOptional.get().getGroupes());

	}

	public void deleteGroupeApplication(long idgroupe, long idapp) {
		List<UserApplications> userApplicationsList = userApplicationsRepository.findByIdApplicationsId(idapp);
		if (!userApplicationsList.isEmpty()) {
			throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
		}
		Optional<GroupesApplications> groupesApplicationsOptional = groupesApplicationsRepository.findByIdApplicationsIdAndIdGroupesId(idapp, idgroupe);
		if (groupesApplicationsOptional.isEmpty()) {
			throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
		}

		groupesApplicationsRepository.deleteByApplicationsAndGroupes(groupesApplicationsOptional.get().getApplications(),
				groupesApplicationsOptional.get().getGroupes());
	}

	public void deleteGroupeModule(Long idModule, Long idGroupe) {
		List<UserModules> userModulesList = userModulesRepository.findByIdModulesId(idGroupe);
		if (!userModulesList.isEmpty()) {
			throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
		}
		Optional<GroupesModules> groupesModulesOptional = groupesModulesRepository.findByIdModulesIdAndIdGroupesId(idModule, idGroupe);
		if (groupesModulesOptional.isEmpty()) {
			throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
		}
		groupesModulesRepository.deleteByModulesAndGroupes(groupesModulesOptional.get().getModules(), groupesModulesOptional.get().getGroupes());
	}

	public GroupesModules addGroupesModules(@NotNull Groupes groupes, @NotNull Modules modules) {
		if (groupes.getId() == null || modules.getId() == null) throw new ResponseException(RequestErrorEnum.NULL_ENTITY);
		GroupesModules groupesModules;
		Optional<GroupesModules> groupesModulesOptional = groupesModulesRepository.findByIdModulesIdAndIdGroupesId(modules.getId(), groupes.getId());
		if (groupesModulesOptional.isEmpty()) {
			groupesModules = GroupesModules.builder()
					.id(GroupesModules.GroupesModulesPK.builder()
							.groupesId(groupes.getId())
							.modulesId(modules.getId())
							.build())
					.modules(modules)
					.groupes(groupes)
					.build();
			groupesModules = groupesModulesRepository.saveAndFlush(groupesModules);
			return groupesModules;
		}else {
			return groupesModulesOptional.get();
		}

	}

	public GroupesFonctions addGroupesFonctions(@NotNull Groupes groupes, @NotNull Fonctions fonctions) {
		if (groupes.getId() == null || fonctions.getId() == null) throw new ResponseException(RequestErrorEnum.NULL_ENTITY);

		Optional<GroupesFonctions> groupesFonctionsOptional = groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId(groupes.getId(), fonctions.getId());
		if (groupesFonctionsOptional.isEmpty()) {
			GroupesFonctions groupesFonctions = GroupesFonctions.builder()
					.id(GroupesFonctions.GroupesFonctionsPK.builder()
							.fonctionsId(fonctions.getId())
							.groupesId(groupes.getId())
							.build())
					.fonctions(fonctions)
					.groupes(groupes)
					.build();
			groupesFonctions = groupesFonctionsRepository.saveAndFlush(groupesFonctions);
			return groupesFonctions;
		}
		return groupesFonctionsOptional.get();
	}

	public GroupesApplications addGroupesApplications(Groupes groupes, Applications applications) {
		Optional<GroupesApplications> groupesApplicationsOptional = groupesApplicationsRepository.findByIdApplicationsIdAndIdGroupesId(applications.getId(), groupes.getId());
		if (groupesApplicationsOptional.isPresent()) {
			groupesApplicationsRepository.deleteByApplicationsAndGroupes(applications, groupes);
		}

		GroupesApplications groupesApplications = GroupesApplications.builder()
				.id(GroupesApplications.GroupesApplicationsPK.builder()
						.applicationsId(applications.getId())
						.groupesId(groupes.getId())
						.build())
				.applications(applications)
				.groupes(groupes)
				.build();

		groupesApplications = groupesApplicationsRepository.saveAndFlush(groupesApplications);
		return groupesApplications;
	}

}
