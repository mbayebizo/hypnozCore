package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.FileUtils;
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;
import net.hypnozcore.hypnozcore.utils.OsUtils;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
public class StructuresServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(StructuresServices.class);
    private final StructuresRepository repository;
    private final StructuresMapper structuresMapper;
    private final GenerateMenuService generateMenuService;
    private final GenerateDefaultDocService generateDefaultDocService;

    public StructuresServices(StructuresRepository repository, StructuresMapper structuresMapper, GenerateMenuService generateMenuService, GenerateDefaultDocService generateDefaultDocService) {
        this.repository = repository;
        this.structuresMapper = structuresMapper;
        this.generateMenuService = generateMenuService;
        this.generateDefaultDocService = generateDefaultDocService;
    }


    public ResponseEntity<StructuresDto> save(StructuresDto structuresDto) {
        validationSigleRaisonSocial(structuresDto);
        Structures entity = structuresMapper.toEntity(structuresDto);
        repository.saveAndFlush(entity);
        LOGGER.info("Save Structure {}", structuresMapper.toDto(entity));
        return ResponseEntity.ok(structuresMapper.toDto(entity));
    }

    private void validationSigleRaisonSocial(@NotNull StructuresDto structuresDto) {
        if (structuresDto.getSigle().length() < 2 || structuresDto.getSigle().length() > 50) {
            throw new ResponseException(RequestErrorEnum.ERROR_SIGLE);
        }
        if (structuresDto.getRaisonSocial().length() < 2 || structuresDto.getRaisonSocial().length() > 150) {
            throw new ResponseException(RequestErrorEnum.ERROR_RAISON_SOCIAL);
        }
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public StructuresDto findById(long id) {
        return structuresMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public StructuresDto update(StructuresDto structuresDto, Long id) {
        StructuresDto data = findById(id);
        Structures entity = structuresMapper.toEntity(structuresDto);
        BeanUtils.copyProperties(data, entity);
        return save(structuresMapper.toDto(entity)).getBody();
    }

    public ResponseEntity<StructuresDto> initConfigStructure(StructuresDto structureDto) throws ResponseException {
        Structures structures = null;

        if (repository.findByRaisonSocialAndSigle(structureDto.getRaisonSocial(), structureDto.getSigle()).isEmpty()) {
            structures = structuresMapper.toEntity(structureDto);
            structures = repository.saveAndFlush(structures);
        } else {
            structures = repository.findByRaisonSocialAndSigle(structureDto.getRaisonSocial(), structureDto.getSigle()).orElseThrow();
        }
        List<Modules> modulesList = generateMenuService.createDefaultModule(structures);
        List<Applications> applicationsList = generateMenuService.createDefaultApplication(modulesList);
        generateMenuService.createDefaultFonctions(applicationsList);
        try {
            generateDefaultDocService.create();
        } catch (Exception e) {
            throw new ResponseException(e.getMessage());
        }
        structureDto = structuresMapper.toDto(structures);
        return ResponseEntity.ok().body(structureDto);
    }

    public String uploadLogoSociete(MultipartFile file, Long strid, String logo) {
        String pathImage = OsUtils.getOsHomeDir();
        if (FileUtils.existed(pathImage) && !FileUtils.existed(pathImage + HypnozCoreCostance.STRUCTURE + strid + HypnozCoreCostance.IMAGE_LOGO))
            FileUtils.mkdir(pathImage + HypnozCoreCostance.STRUCTURE + strid +  HypnozCoreCostance.IMAGE_LOGO);

        String extension = Objects.requireNonNull(file.getOriginalFilename()).substring(".".lastIndexOf(file.getOriginalFilename()) + 1);
        Path rootLocation = Paths.get(pathImage + HypnozCoreCostance.STRUCTURE  + strid +  HypnozCoreCostance.IMAGE_LOGO + logo + '.' + extension);
        try {
            if (FileUtils.existed(rootLocation.toFile().getPath())) {
                FileUtils.deleteFile(rootLocation.toFile().getPath());
            }
            Files.copy(file.getInputStream(), rootLocation);
            return rootLocation.toFile().getPath();
        } catch (Exception e) {
            return null;
        }
    }
}
