package net.hypnozcore.hypnozcore.service;

import net.hypnozcore.hypnozcore.dto.Menus;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.models.UserApplications;
import net.hypnozcore.hypnozcore.models.UserFonctions;
import net.hypnozcore.hypnozcore.models.UserModules;
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
