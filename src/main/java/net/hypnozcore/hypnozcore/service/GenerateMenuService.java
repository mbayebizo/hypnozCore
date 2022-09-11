package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.mapper.ApplicationsMapper;
import net.hypnozcore.hypnozcore.mapper.FonctionsMapper;
import net.hypnozcore.hypnozcore.mapper.ModulesMapper;
import net.hypnozcore.hypnozcore.repository.ApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.FonctionsRepository;
import net.hypnozcore.hypnozcore.repository.ModulesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.FileUtils;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenerateMenuService {
    private final Logger LOGGER = LoggerFactory.getLogger(GenerateMenuService.class);
    private final ModulesRepository modulesRepository;
    private final ModulesMapper modulesMapper;
    private final FonctionsRepository fonctionsRepository;
    private final FonctionsMapper fonctionsMapper;
    private final ApplicationsMapper applicationsMapper;
    private final ApplicationsRepository applicationsRepository;
    private final StructuresRepository structuresRepository;


    public GenerateMenuService(ModulesRepository modulesRepository, ModulesMapper modulesMapper, FonctionsRepository fonctionsRepository, FonctionsMapper fonctionsMapper, ApplicationsMapper applicationsMapper, ApplicationsRepository applicationsRepository, StructuresRepository structuresRepository) {
        this.modulesRepository = modulesRepository;
        this.modulesMapper = modulesMapper;
        this.fonctionsRepository = fonctionsRepository;
        this.fonctionsMapper = fonctionsMapper;
        this.applicationsMapper = applicationsMapper;
        this.applicationsRepository = applicationsRepository;
        this.structuresRepository = structuresRepository;
    }
    public ModulesDto createDefaultModule(StructuresDto structuresDto){
        if(structuresDto.getId()==null) throw new ResponseException(RequestErrorEnum.ID_STRUCTURE_EMPTY);
        //read file
      return null;

    }

}
