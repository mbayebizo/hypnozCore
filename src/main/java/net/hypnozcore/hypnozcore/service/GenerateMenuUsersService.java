package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.Menus;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.models.*;
import net.hypnozcore.hypnozcore.repository.UserApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.UserFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.UserModulesRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class GenerateMenuUsersService {
    final UserModulesRepository userModulesRepository;
    final UserApplicationsRepository userApplicationsRepository;
    final UserFonctionsRepository userFonctionsRepository;

    public GenerateMenuUsersService(UserModulesRepository userModulesRepository, UserApplicationsRepository userApplicationsRepository, UserFonctionsRepository userFonctionsRepository) {
        this.userModulesRepository = userModulesRepository;
        this.userApplicationsRepository = userApplicationsRepository;
        this.userFonctionsRepository = userFonctionsRepository;
    }
    public List<Menus> getRoles(UsersDto usersDto, ModulesDto modulesDto) {
        List<Menus> lmenu = new ArrayList<>();
        List<UserModules> userModules = userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc(modulesDto.getId(), usersDto.getId());
        for (UserModules um : userModules) {
            if (um.getModules().getActive().equals("Y")) {
                List<Menus> l = getMenuByUser(um);
                lmenu.addAll(l);
            }
        }
        return lmenu;
    }

    public List<Menus> getMenuByUser(UserModules userModules) {
        List<Menus> menusList = new ArrayList<>();
        if (userModules != null  && userModules.getUsers()!= null
                && userModules.getModules()!= null) {
            List<UserApplications> userApplicationsList = userApplicationsRepository.
                    findByIdUsersIdAndApplicationsModulesId(userModules.getUsers().getId(), userModules.getModules().getId());
            for (UserApplications userApplications : userApplicationsList) {
                if (userApplications!= null && userApplications.getApplications()!=null) {
                    Menus menus = Menus.builder()
                            .id(userApplications.getApplications().getId())
                            .title(userApplications.getApplications().getLibCode())
                            .routerLink(userApplications.getApplications().getUrl())
                            .icon(userApplications.getApplications().getIconClass())
                            .active(userApplications.getApplications().getActive().equals("Y"))
                            .parentId(0)
                            .build();
                    List<UserFonctions> userFonctionsList = userFonctionsRepository
                            .findByIdUsersIdAndFonctionsApplicationsId(userApplications.getUsers().getId(), userApplications.getApplications().getId());
                    if (!userFonctionsList.isEmpty()) {
                        menus.setHasSubMenu(true);
                        menusList.add(menus);
                        userFonctionsList.stream().filter(userFonctions -> ((userFonctions.getFonctions().isUsed())
                                        && ("M".equals(userFonctions.getFonctions().getType()))))
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

    public UserFonctions deleteUserFonction(Long usrId,Long foncId){
        Optional<UserFonctions> userFonctionsOptional = userFonctionsRepository.findByIdFonctionsIdAndIdUsersId(foncId,usrId);
        if (userFonctionsOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }

        userFonctionsRepository.deleteByFonctionsAndUsers(userFonctionsOptional.get().getFonctions(), userFonctionsOptional.get().getUsers());
        return userFonctionsOptional.get();
    }

    public UserApplications deleteUserApplication(Long usrId,Long appId){
        Optional<UserApplications> userApplicationsOptional = userApplicationsRepository.findByIdApplicationsIdAndIdUsersId(appId,usrId);
        if(userApplicationsOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }

        userApplicationsRepository.deleteByApplicationsAndUsers(userApplicationsOptional.get().getApplications(),
                userApplicationsOptional.get().getUsers());
        return userApplicationsOptional.get();
    }

    public UserModules deleteUserModules(Long usrId,Long modId){
        Optional<UserModules> userModulesOptional = userModulesRepository.findByIdModulesIdAndIdUsersId(modId,usrId);
        if(userModulesOptional.isEmpty()){
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }
        userModulesRepository.deleteByModulesAndUsers(userModulesOptional.get().getModules(), userModulesOptional.get().getUsers());
        return userModulesOptional.get();
    }

    public UserModules addUserModules(Users users, Modules modules) {
        Optional<UserModules> userModulesOptional= userModulesRepository.findByIdModulesIdAndIdUsersId(modules.getId(), users.getId());
        if(userModulesOptional.isPresent()){
            userModulesRepository.deleteByModulesAndUsers(modules,users);
        }
        UserModules userModules = UserModules.builder()
                .id(UserModules.UserModulesPK.builder()
                        .modulesId(modules.getId())
                        .usersId(users.getId())
                        .build())
                .modules(modules)
                .users(users)
                .build();
        userModulesRepository.saveAndFlush(userModules);
        return userModules;
    }

    public UserFonctions addUserFonction(Users users,Fonctions fonctions){
        Optional<UserFonctions> userFonctionsOptional = userFonctionsRepository.findByIdFonctionsIdAndIdUsersId(fonctions.getId(),users.getId());
        if(userFonctionsOptional.isPresent()){
            userFonctionsRepository.deleteByFonctionsAndUsers(fonctions,users);
        }
        UserFonctions userFonctions = UserFonctions.builder()
                .id(UserFonctions.UserFonctionsPK.builder()
                        .fonctionsId(fonctions.getId())
                        .usersId(users.getId())
                        .build())
                .fonctions(fonctions)
                .users(users)
                .build();
        userFonctionsRepository.saveAndFlush(userFonctions);
        return userFonctions;
    }

    public UserApplications addUsersApplications(Users users,Applications applications){
        Optional<UserApplications> userApplicationsOptional = userApplicationsRepository.findByIdApplicationsIdAndIdUsersId(applications.getId(), users.getId());
        if (userApplicationsOptional.isPresent()){
            userApplicationsRepository.deleteByApplicationsAndUsers(applications,users);
        }

        UserApplications userApplications = UserApplications.builder()
                .id(UserApplications.UserApplicationsPK.builder()
                        .applicationsId(applications.getId())
                        .usersId(users.getId())
                        .build())
                .users(users)
                .applications(applications)
                .build();
        userApplicationsRepository.saveAndFlush(userApplications);
        return userApplications;
    }
}
