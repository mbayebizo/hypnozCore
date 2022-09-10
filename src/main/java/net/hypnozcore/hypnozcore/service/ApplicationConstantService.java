package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.ApplicationConstantDto;
import net.hypnozcore.hypnozcore.mapper.ApplicationConstantMapper;
import net.hypnozcore.hypnozcore.models.ApplicationConstant;
import net.hypnozcore.hypnozcore.repository.ApplicationConstantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class ApplicationConstantService {
    private final ApplicationConstantRepository repository;
    private final ApplicationConstantMapper applicationConstantMapper;

    public ApplicationConstantService(ApplicationConstantRepository repository, ApplicationConstantMapper applicationConstantMapper) {
        this.repository = repository;
        this.applicationConstantMapper = applicationConstantMapper;
    }

    public ApplicationConstantDto save(ApplicationConstantDto applicationConstantDto) {
        ApplicationConstant entity = applicationConstantMapper.toEntity(applicationConstantDto);
        return applicationConstantMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ApplicationConstantDto findById(String id) {
        return applicationConstantMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public ApplicationConstantDto update(ApplicationConstantDto applicationConstantDto, String id) {
        ApplicationConstantDto dto = findById(id);
        ApplicationConstant entity = applicationConstantMapper.toEntity(applicationConstantDto);
       BeanUtils.copyProperties(dto, entity);
        return save(applicationConstantMapper.toDto(entity));
    }
}