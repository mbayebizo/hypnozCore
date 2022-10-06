package net.hypnozcore.hypnozcore.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.ModulesStructure;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.ApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.FonctionsRepository;
import net.hypnozcore.hypnozcore.repository.ModulesRepository;
import net.hypnozcore.hypnozcore.repository.ModulesStructureRepository;
import net.hypnozcore.hypnozcore.utils.FormatText;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
    final FonctionsRepository fonctionsRepository;
    final ApplicationsRepository applicationsRepository;
    final ModulesStructureRepository modulesStructureRepository;

    public GenerateMenuService(ModulesRepository modulesRepository, FonctionsRepository fonctionsRepository, ApplicationsRepository applicationsRepository, ModulesStructureRepository modulesStructureRepository) {
        this.modulesRepository = modulesRepository;
        this.fonctionsRepository = fonctionsRepository;
        this.applicationsRepository = applicationsRepository;
        this.modulesStructureRepository = modulesStructureRepository;
    }


    public List<Modules> createDefaultModule(Structures structures) {
        if (structures.getId() == null) throw new ResponseException(RequestErrorEnum.ID_STRUCTURE_EMPTY);
        //read file
        Resource resource = new ClassPathResource("config/modules.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Modules>> typeReference = new TypeReference<List<Modules>>() {
        };
        List<Modules> modulesDtoList = null;
        try {
            modulesDtoList = objectMapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new ResponseException(RequestErrorEnum.FILE_NOT_FOUND);
        }

        return modulesDtoList.stream().peek(modules -> {
            if (modulesRepository.findByCode(modules.getCode()).isEmpty()) {
                modules.setLibCode(FormatText.formatCode(modules.getLibCode()));
                modules.setOrdre(FormatText.getOrdre(modules.getCode()));
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
        }).toList();
    }


    public List<Applications> createDefaultApplication(List<Modules> modulesList) {
        Resource resource = new ClassPathResource("config/Applications.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Applications>> typeReference = new TypeReference<List<Applications>>() {
        };
        List<Applications> applicationsDtoList = null;
        try {
            applicationsDtoList = objectMapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new ResponseException(RequestErrorEnum.FILE_NOT_FOUND);
        }

        List<Applications> list = new ArrayList<>();
        for (Applications applications : applicationsDtoList) {
            List<Applications> listApp = modulesList.stream().filter(modules -> modules.getCode().equals(applications.getModule())).map(mod -> {
                Optional<Modules> modules = modulesRepository.findByCode(mod.getCode());

                if (applicationsRepository.findByCodeAndModule(applications.getCode(), applications.getModule()).isEmpty()) {
                    modules.ifPresent(applications::setModules);

                    applications.setLibCode(FormatText.formatCode(applications.getLibCode()));
                    applications.setOrdre(FormatText.getOrdre(applications.getCode()));
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
        TypeReference<List<Fonctions>> typeReference = new TypeReference<List<Fonctions>>() {
        };
        List<Fonctions> fonctionsDtoList = null;
        try {
            fonctionsDtoList = objectMapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new ResponseException(RequestErrorEnum.FILE_NOT_FOUND);
        }

        List<Fonctions> list = new ArrayList<>();
        for (Fonctions fonctions : fonctionsDtoList) {
            List<Fonctions> fonctionsList = applicationsList.stream().filter(p -> Objects.equals(p.getModule(),
                            fonctions.getModule()) && Objects.equals(fonctions.getApplication(), p.getCode()))
                    .map(fDto -> {

                        fonctions.setApplication(fDto.getCode());
                        fonctions.setApplicationsId(fDto.getId());
                        fonctions.setLibCode(FormatText.formatCode(fonctions.getLibCode()));
                        fonctions.setOrdre(FormatText.getOrdre(fonctions.getCode()));
                        fonctionsRepository.saveAndFlush(fonctions);
                        return fonctions;
                    }).toList();
            list.addAll(fonctionsList);
        }
        return list;
    }



}
