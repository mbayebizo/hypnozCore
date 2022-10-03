package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.mapper.StructuresMapper;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

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

	public StructuresDto save(StructuresDto structuresDto) {
		if (structuresDto == null) throw new ResponseException(RequestErrorEnum.NULL_ENTITY);
		validationSigleRaisonSocial(structuresDto);
		Structures entity = structuresMapper.toEntity(structuresDto);
		repository.saveAndFlush(entity);
		LOGGER.info("Save Structure {}", structuresMapper.toDto(entity));
		return structuresDto;
	}

	private void validationSigleRaisonSocial(@NotNull StructuresDto structuresDto) {
		if (structuresDto.getSigle() == null || structuresDto.getSigle().length() < 2 || structuresDto.getSigle().length() > 50) {
			throw new ResponseException(RequestErrorEnum.ERROR_SIGLE);
		}
		if (structuresDto.getRaisonSocial() == null || structuresDto.getRaisonSocial().length() < 2 || structuresDto.getRaisonSocial().length() > 150) {
			throw new ResponseException(RequestErrorEnum.ERROR_RAISON_SOCIAL);
		}
	}

	public void deleteById(Long id) {
		if(id==null) throw new ResponseException(RequestErrorEnum.ID_NULL);
		if (repository.findById(id).isEmpty()) {
			throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
		}
		repository.deleteById(id);
	}

	public StructuresDto findById(Long id) {
		if(id==null) throw new ResponseException(RequestErrorEnum.ID_NULL);
		StructuresDto structuresDto = null;
		Optional<Structures> structuresOptional = repository.findById(id);
		if (structuresOptional.isPresent()) {
			structuresDto = structuresMapper.toDto(structuresOptional.get());
			return structuresDto;
		} else {
			throw new ResponseException(RequestErrorEnum.NOT_FOUND_STRUCTURE);
		}
	}

	public StructuresDto update(@Valid StructuresDto structuresDto, @Valid Long id) {
		if(id==null) throw new ResponseException(RequestErrorEnum.ID_NULL);
		if (structuresDto == null) throw new ResponseException(RequestErrorEnum.NULL_ENTITY);
		validationSigleRaisonSocial(structuresDto);
		try {
			var grp = repository
					.findById(id)
					.map(oldEntity -> repository.saveAndFlush(structuresMapper.toEntity(structuresDto)))
					.orElseThrow(() -> new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE));
			StructuresDto strDto = structuresMapper.toDto(grp);
			LOGGER.debug(StructuresServices.class.getName(), HypnozCoreCostance.UPDATED, strDto);
			return strDto;
		} catch (ResponseException e) {
			log.error(e.getMessage(), e);
			throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
		}
	}

	public StructuresDto initConfigStructure(@Valid StructuresDto structureDto) {
		Structures structures = null;
		if (structureDto == null) throw new ResponseException(RequestErrorEnum.NULL_ENTITY);
		if (structureDto.getSigle().isEmpty() && structureDto.getSigle() == null) throw new ResponseException(RequestErrorEnum.ERROR_SIGLE);
		if (structureDto.getRaisonSocial().isEmpty() && structureDto.getRaisonSocial() == null)
			throw new ResponseException(RequestErrorEnum.ERROR_RAISON_SOCIAL);
		try {
			if (repository.findByRaisonSocialAndSigle(structureDto.getRaisonSocial(), structureDto.getSigle()).isEmpty()) {
				structures = structuresMapper.toEntity(structureDto);
				structures = repository.saveAndFlush(structures);
			} else {
				structures = repository.findByRaisonSocialAndSigle(structureDto.getRaisonSocial(), structureDto.getSigle()).orElseThrow();
			}
			List<Modules> modulesList = generateMenuService.createDefaultModule(structures);
			List<Applications> applicationsList = generateMenuService.createDefaultApplication(modulesList);
			generateMenuService.createDefaultFonctions(applicationsList);

			generateDefaultDocService.create();
			structureDto = structuresMapper.toDto(structures);
			return structureDto;
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

}
