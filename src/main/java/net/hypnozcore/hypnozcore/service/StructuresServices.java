package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
public class StructuresServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(StructuresServices.class);
    private final StructuresRepository repository;
    private final StructuresMapper structuresMapper;

    public StructuresServices(StructuresRepository repository, StructuresMapper structuresMapper) {
        this.repository = repository;
        this.structuresMapper = structuresMapper;
    }


    public ResponseEntity<StructuresDto> save(StructuresDto structuresDto) {
        validationSigleRaisonSocial(structuresDto);
        Structures entity = structuresMapper.toEntity(structuresDto);
        repository.saveAndFlush(entity);
        LOGGER.info("Save Structure {}",structuresMapper.toDto(entity));
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

    public ResponseEntity<StructuresDto> initConfigStructure(StructuresDto structureDto) {
        return ResponseEntity.ok().body(structureDto);
    }
}
