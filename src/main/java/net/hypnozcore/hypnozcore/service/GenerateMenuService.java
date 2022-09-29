package net.hypnozcore.hypnozcore.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.*;
import net.hypnozcore.hypnozcore.mapper.ApplicationsMapper;
import net.hypnozcore.hypnozcore.mapper.FonctionsMapper;
import net.hypnozcore.hypnozcore.mapper.ModulesMapper;
import net.hypnozcore.hypnozcore.models.*;
import net.hypnozcore.hypnozcore.repository.*;
import net.hypnozcore.hypnozcore.utils.FormatText;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
public class GenerateMenuService {
    static final Logger LOGGER = LoggerFactory.getLogger(GenerateMenuService.class);
    final ModulesRepository modulesRepository;
    final ModulesMapper modulesMapper;
    final FonctionsRepository fonctionsRepository;
    final FonctionsMapper fonctionsMapper;
    final ApplicationsMapper applicationsMapper;
    final ApplicationsRepository applicationsRepository;
    final StructuresRepository structuresRepository;
    final ModulesStructureRepository modulesStructureRepository;
    final UserModulesRepository userModulesRepository;
    final UserApplicationsRepository userApplicationsRepository;
    final UserFonctionsRepository userFonctionsRepository;
    final GroupesFonctionsRepository groupesFonctionsRepository;
    final GroupesApplicationsRepository groupesApplicationsRepository;
    final GroupesModulesRepository groupesModulesRepository;


    public GenerateMenuService(ModulesRepository modulesRepository, ModulesMapper modulesMapper, FonctionsRepository fonctionsRepository, FonctionsMapper fonctionsMapper, ApplicationsMapper applicationsMapper, ApplicationsRepository applicationsRepository, StructuresRepository structuresRepository, ModulesStructureRepository modulesStructureRepository, UserModulesRepository userModulesRepository, UserApplicationsRepository userApplicationsRepository, UserFonctionsRepository userFonctionsRepository, GroupesFonctionsRepository groupesFonctionsRepository, GroupesApplicationsRepository groupesApplicationsRepository, GroupesModulesRepository groupesModulesRepository) {
        this.modulesRepository = modulesRepository;
        this.modulesMapper = modulesMapper;
        this.fonctionsRepository = fonctionsRepository;
        this.fonctionsMapper = fonctionsMapper;
        this.applicationsMapper = applicationsMapper;
        this.applicationsRepository = applicationsRepository;
        this.structuresRepository = structuresRepository;
        this.modulesStructureRepository = modulesStructureRepository;
        this.userModulesRepository = userModulesRepository;
        this.userApplicationsRepository = userApplicationsRepository;
        this.userFonctionsRepository = userFonctionsRepository;
        this.groupesFonctionsRepository = groupesFonctionsRepository;
        this.groupesApplicationsRepository = groupesApplicationsRepository;
        this.groupesModulesRepository = groupesModulesRepository;
    }

    public List<Modules> createDefaultModule(Structures structures) {
        if (structures.getId() == null) throw new ResponseException(RequestErrorEnum.ID_STRUCTURE_EMPTY);
        //read file
        Resource resource = new ClassPathResource("config/modules.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ModulesDto>> typeReference = new TypeReference<List<ModulesDto>>() {
        };
        List<ModulesDto> modulesDtoList = null;
        try {
            modulesDtoList = objectMapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new ResponseException(RequestErrorEnum.FILE_NOT_FOUND);
        }
        return modulesDtoList.stream().map(modulesDto -> {
            Modules modules = new Modules();
            if (modulesRepository.findByCode(modulesDto.getCode()).isEmpty()) {
                modules = modulesMapper.toEntity(modulesDto);
                modules.setLibCode(FormatText.formatCode(modulesDto.getLibCode()));
                modules.setOrdre(FormatText.getOrdre(modulesDto.getCode()));
                modulesRepository.saveAndFlush(modules);
                ModulesStructure modulesStructure = ModulesStructure.builder()
                        .id(ModulesStructure.ModulesStructurePK.builder()
                                .structuresId(structures.getId())
                                .modulesId(modules.getId())
                                .build())
                        .modules(modules)
                        .structures(structures)
                        .build();
                modulesStructureRepository.saveAndFlush(modulesStructure);

            }
            return modules;
        }).toList();
    }


    public List<Applications> createDefaultApplication(List<Modules> modulesList) {
        Resource resource = new ClassPathResource("config/Applications.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ApplicationsDto>> typeReference = new TypeReference<List<ApplicationsDto>>() {
        };
        List<ApplicationsDto> applicationsDtoList = null;
        try {
            applicationsDtoList = objectMapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new ResponseException(RequestErrorEnum.FILE_NOT_FOUND);
        }

        List<Applications> list = new ArrayList<>();
        for (ApplicationsDto applicationsDto : applicationsDtoList) {
            List<Applications> listApp = modulesList.stream().filter(modules -> modules.getCode().equals(applicationsDto.getModule())).map(mod -> {
                Optional<Modules> modules = modulesRepository.findByCode(mod.getCode());

                Applications applications = applicationsMapper.toEntity(applicationsDto);
                if (applicationsRepository.findByCodeAndModule(applicationsDto.getCode(), applicationsDto.getModule()).isEmpty()) {
                    modules.ifPresent(applications::setModules);

                    applications.setLibCode(FormatText.formatCode(applicationsDto.getLibCode()));
                    applications.setOrdre(FormatText.getOrdre(applicationsDto.getCode()));
                    applicationsRepository.saveAndFlush(applications);
                }
                return applications;
            }).toList();
            list.addAll(listApp);
        }

        return list;

    }


    public List<Fonctions> createDefaultFonctions(List<Applications> applicationsList) {
        //read file
        Resource resource = new ClassPathResource("config/fonctions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<FonctionsDto>> typeReference = new TypeReference<List<FonctionsDto>>() {
        };
        List<FonctionsDto> fonctionsDtoList = null;
        try {
            fonctionsDtoList = objectMapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new ResponseException(RequestErrorEnum.FILE_NOT_FOUND);
        }

        List<Fonctions> list = new ArrayList<>();
        for (FonctionsDto fonctionsDto : fonctionsDtoList) {
            List<Fonctions> fonctionsList = applicationsList.stream().filter(p -> Objects.equals(p.getModule(), fonctionsDto.getModule()) && Objects.equals(fonctionsDto.getApplication(), p.getCode()))
                    .map(fDto -> {
                        Fonctions fonctions = fonctionsMapper.toEntity(fonctionsDto);
                        fonctions.setApplication(fDto.getCode());
                        fonctions.setApplicationsId(fDto.getId());
                        fonctions.setLibCode(FormatText.formatCode(fonctionsDto.getLibCode()));
                        fonctions.setOrdre(FormatText.getOrdre(fonctionsDto.getCode()));
                        fonctionsRepository.saveAndFlush(fonctions);
                        return fonctions;
                    }).toList();
            list.addAll(fonctionsList);
        }
        return list;
    }

    public ResponseEntity<List<Menus>> getRoles(UsersDto usersDto, ModulesDto modulesDto) {
        List<Menus> lmenu = new ArrayList<>();
        List<UserModules> userModules = userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc(modulesDto.getId(), usersDto.getId());
        for (UserModules um : userModules) {
            if (um.getModules().getActive().equals("Y")) {
                List<Menus> l = getMenuByUser(um);
                lmenu.addAll(l);
            }
        }
        return ResponseEntity.ok(lmenu);
    }

    private List<Menus> getMenuByUser(UserModules userModules) {
        List<Menus> menusList = new ArrayList<>();
        if (userModules != null && userModules.getId() != null && userModules.getId().getUsersId() != null
                && userModules.getId().getModulesId() != null) {
            List<UserApplications> userApplicationsList = userApplicationsRepository.
                    findByIdUsersIdAndApplicationsModulesId(userModules.getId().getUsersId(), userModules.getId().getModulesId());
            for (UserApplications userApplications : userApplicationsList) {
                if (userApplications.getId() != null) {
                    Menus menus = Menus.builder()
                            .id(userApplications.getId().getApplicationsId())
                            .title(userApplications.getApplications().getLibCode())
                            .routerLink(userApplications.getApplications().getUrl())
                            .icon(userApplications.getApplications().getIconClass())
                            .active(userApplications.getApplications().getActive().equals("Y"))
                            .parentId(0)
                            .build();
                    List<UserFonctions> userFonctionsList = userFonctionsRepository
                            .findByIdUsersIdAndFonctionsApplicationsId(userApplications.getId().getUsersId(), userApplications.getId().getApplicationsId());
                    if (!userFonctionsList.isEmpty()) {
                        menus.setHasSubMenu(true);
                        menusList.add(menus);
                        userFonctionsList.stream().filter(userFonctions -> ((userFonctions.getFonctions().isUsed()) && ("M".equals(userFonctions.getFonctions().getType()))))
                                .forEach(userFonction -> {
                                    Menus mf = Menus.builder()
                                            .id(Objects.requireNonNull(userFonction.getId()).getFonctionsId())
                                            .title(userFonction.getFonctions().getLibCode())
                                            .routerLink(userFonction.getFonctions().getUrl())
                                            .icon(userFonction.getFonctions().getIconClass())
                                            .active(userFonction.getFonctions().getActive().equals("Y"))
                                            .parentId(menus.getId())
                                            .build();
                                    menusList.add(mf);
                                });
                    } else {
                        menus.setHasSubMenu(false);
                        menusList.add(menus);
                    }
                }

            }
        }
        return menusList;
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

    public ResponseEntity<GroupesApplications> deleteGroupeApplication(long idgroupe, long idapp) {
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
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupesApplicationsOptional.get());

    }

    public ResponseEntity<GroupesModules> deleteGroupeModule(Long idModule, Long idGroupe){
        List<UserModules> userModulesList = userModulesRepository.findByIdModulesId(idGroupe);
        if(!userModulesList.isEmpty()){
            throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
        }
        Optional<GroupesModules> groupesModulesOptional = groupesModulesRepository.findByIdModulesIdAndIdGroupesId(idModule,idGroupe);
        if(groupesModulesOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.LIST_NOT_EMPTY);
        }
        groupesModulesRepository.deleteByModulesAndGroupes(groupesModulesOptional.get().getModules(), groupesModulesOptional.get().getGroupes());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupesModulesOptional.get());
    }

    public ResponseEntity<UserFonctions> deleteUserFonction(Long usrId,Long foncId){
        Optional<UserFonctions> userFonctionsOptional = userFonctionsRepository.findByIdFonctionsIdAndIdUsersId(foncId,usrId);
        if (userFonctionsOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }

        userFonctionsRepository.deleteByFonctionsAndUsers(userFonctionsOptional.get().getFonctions(), userFonctionsOptional.get().getUsers());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userFonctionsOptional.get());
    }

    public ResponseEntity<UserApplications> deleteUserApplication(Long usrId,Long appId){
        Optional<UserApplications> userApplicationsOptional = userApplicationsRepository.findByIdApplicationsIdAndIdUsersId(appId,usrId);
        if(userApplicationsOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }

        userApplicationsRepository.deleteByApplicationsAndUsers(userApplicationsOptional.get().getApplications(),
                userApplicationsOptional.get().getUsers());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userApplicationsOptional.get());
    }

    public ResponseEntity<UserModules> deleteUserModules(Long usrId,Long modId){
        Optional<UserModules> userModulesOptional = userModulesRepository.findByIdModulesIdAndIdUsersId(modId,usrId);
        if(userModulesOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }
        userModulesRepository.deleteByModulesAndUsers(userModulesOptional.get().getModules(), userModulesOptional.get().getUsers());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userModulesOptional.get());
    }
}
