package net.hypnozcore.hypnozcore.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.ApplicationsDto;
import net.hypnozcore.hypnozcore.dto.FonctionsDto;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
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
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
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


    public GenerateMenuService(ModulesRepository modulesRepository, ModulesMapper modulesMapper, FonctionsRepository fonctionsRepository, FonctionsMapper fonctionsMapper, ApplicationsMapper applicationsMapper, ApplicationsRepository applicationsRepository, StructuresRepository structuresRepository, ModulesStructureRepository modulesStructureRepository) {
        this.modulesRepository = modulesRepository;
        this.modulesMapper = modulesMapper;
        this.fonctionsRepository = fonctionsRepository;
        this.fonctionsMapper = fonctionsMapper;
        this.applicationsMapper = applicationsMapper;
        this.applicationsRepository = applicationsRepository;
        this.structuresRepository = structuresRepository;
        this.modulesStructureRepository = modulesStructureRepository;
    }
    @SneakyThrows
    public List<Modules> createDefaultModule(Structures structures){
        if(structures.getId()==null) throw new ResponseException(RequestErrorEnum.ID_STRUCTURE_EMPTY);
        //read file
        Resource resource = new ClassPathResource("config/modules.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ModulesDto>> typeReference = new TypeReference<List<ModulesDto>>(){};
        List<ModulesDto> modulesDtoList = objectMapper.readValue(resource.getInputStream(),typeReference);
       return modulesDtoList.stream().map(modulesDto->{
           Modules modules= new Modules();
            if(modulesRepository.findByCode(modulesDto.getCode()).isEmpty()){
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

    @SneakyThrows
    public List<Applications> createDefaultApplication(List<Modules> modulesList){
        Resource resource = new ClassPathResource("config/Applications.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ApplicationsDto>> typeReference = new TypeReference<List<ApplicationsDto>>(){};
        List<ApplicationsDto> applicationsDtoList = objectMapper.readValue(resource.getInputStream(),typeReference);

        List<Applications> list = new ArrayList<>();
        for (ApplicationsDto applicationsDto : applicationsDtoList) {
           List<Applications> listApp=modulesList.stream().filter(modules -> modules.getCode().equals(applicationsDto.getModule())).map(mod -> {
               Applications applications = applicationsMapper.toEntity(applicationsDto);
               if(applicationsRepository.findByCodeAndModule(applicationsDto.getCode(),applicationsDto.getModule()).isEmpty()){
                   applications.setModulesId(mod.getId());
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

    @SneakyThrows
    public List<Fonctions> createDefaultFonctions(List<Applications> applicationsList){
        //read file
        Resource resource = new ClassPathResource("config/fonction.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<FonctionsDto>> typeReference = new TypeReference<List<FonctionsDto>>(){};
        List<FonctionsDto> fonctionsDtoList= objectMapper.readValue(resource.getInputStream(),typeReference);

        List<Fonctions> list = new ArrayList<>();
        for(FonctionsDto fonctionsDto:fonctionsDtoList){
            applicationsList.stream().filter(p-> Objects.equals(p.getModule(),applications.getModule())&& Objects.equals(p.getApplication(), applications.getCode())).map(fonctionsDto->{
                Fonctions fonctions = fonctionsMapper.toEntity(fonctionsDto);
                fonctions.setApplication(app.getCode());
                fonctions.setApplicationsId(app.getId());
                fonctions.setLibCode(FormatText.formatCode(fonctionsDto.getLibCode()));
                fonctions.setOrdre(FormatText.getOrdre(fonctionsDto.getCode()));
                repository.saveAndFlush(fonctions);
                return fonctionsMapper.toDto(fonctions);
            }).toList()
        }
    }

}
