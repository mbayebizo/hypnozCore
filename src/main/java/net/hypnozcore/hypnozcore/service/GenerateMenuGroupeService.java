package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.models.*;
import net.hypnozcore.hypnozcore.repository.*;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenerateMenuGroupeService {
    final GroupesFonctionsRepository groupesFonctionsRepository;
    final GroupesApplicationsRepository groupesApplicationsRepository;
    final GroupesModulesRepository groupesModulesRepository;
    final UserModulesRepository userModulesRepository;
    final UserApplicationsRepository userApplicationsRepository;
    final UserFonctionsRepository userFonctionsRepository;

    public GenerateMenuGroupeService(GroupesFonctionsRepository groupesFonctionsRepository, GroupesApplicationsRepository groupesApplicationsRepository, GroupesModulesRepository groupesModulesRepository, UserModulesRepository userModulesRepository, UserApplicationsRepository userApplicationsRepository, UserFonctionsRepository userFonctionsRepository) {
        this.groupesFonctionsRepository = groupesFonctionsRepository;
        this.groupesApplicationsRepository = groupesApplicationsRepository;
        this.groupesModulesRepository = groupesModulesRepository;
        this.userModulesRepository = userModulesRepository;
        this.userApplicationsRepository = userApplicationsRepository;
        this.userFonctionsRepository = userFonctionsRepository;
    }


    public ResponseEntity<GroupesFonctions> deleteFonctionByGroupe(Long idfonction, Long idgroupe) {
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

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupesFonctionsOptional.get());

    }

    public GroupesApplications deleteGroupeApplication(long idgroupe, long idapp) {
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
        return groupesApplicationsOptional.get();

    }

    public GroupesModules deleteGroupeModule(Long idModule, Long idGroupe){
        List<UserModules> userModulesList = userModulesRepository.findByIdModulesId(idGroupe);
        if(!userModulesList.isEmpty()){
            throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
        }
        Optional<GroupesModules> groupesModulesOptional = groupesModulesRepository.findByIdModulesIdAndIdGroupesId(idModule,idGroupe);
        if(groupesModulesOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
        }
        groupesModulesRepository.deleteByModulesAndGroupes(groupesModulesOptional.get().getModules(), groupesModulesOptional.get().getGroupes());
        return groupesModulesOptional.get();
    }

    public GroupesModules addGroupesModules(Groupes groupes,Modules modules ){
        Optional<GroupesModules> groupesModulesOptional = groupesModulesRepository.findByIdModulesIdAndIdGroupesId(modules.getId(), groupes.getId());
        if(groupesModulesOptional.isPresent()){
            groupesModulesRepository.deleteByModulesAndGroupes(modules,groupes);
        }

        GroupesModules groupesModules =GroupesModules.builder()
                .id(GroupesModules.GroupesModulesPK.builder()
                        .groupesId(groupes.getId())
                        .modulesId(modules.getId())
                        .build())
                .modules(modules)
                .groupes(groupes)
                .build();

        groupesModulesRepository.saveAndFlush(groupesModules);
        return groupesModules;
    }

    public GroupesFonctions addGroupesFonctions(Groupes groupes,Fonctions fonctions) {
        Optional<GroupesFonctions> groupesFonctionsOptional = groupesFonctionsRepository.findByIdGroupesIdAndIdFonctionsId(groupes.getId(), fonctions.getId());
        if(groupesFonctionsOptional.isPresent()){
            groupesFonctionsRepository.deleteByFonctionsAndGroupes(fonctions,groupes);
        }
        GroupesFonctions groupesFonctions =GroupesFonctions.builder()
                .id(GroupesFonctions.GroupesFonctionsPK.builder()
                        .fonctionsId(fonctions.getId())
                        .groupesId(groupes.getId())
                        .build())
                .fonctions(fonctions)
                .groupes(groupes)
                .build();
        groupesFonctionsRepository.saveAndFlush(groupesFonctions);
        return groupesFonctions;
    }

    public GroupesApplications addGroupesApplications(Groupes groupes,Applications applications){
        Optional<GroupesApplications> groupesApplicationsOptional = groupesApplicationsRepository.findByIdApplicationsIdAndIdGroupesId(applications.getId(),groupes.getId());
        if(groupesApplicationsOptional.isPresent()){
            groupesApplicationsRepository.deleteByApplicationsAndGroupes(applications,groupes);
        }

        GroupesApplications groupesApplications = GroupesApplications.builder()
                .id(GroupesApplications.GroupesApplicationsPK.builder()
                        .applicationsId(applications.getId())
                        .groupesId(groupes.getId())
                        .build())
                .applications(applications)
                .groupes(groupes)
                .build();

        groupesApplicationsRepository.saveAndFlush(groupesApplications);
        return groupesApplications;
    }

}
