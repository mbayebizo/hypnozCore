package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.mapper.GroupesMapper;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@Transactional
public class GroupesServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupesServices.class);
    private final GroupesRepository groupesRepository;
    private final GroupesMapper groupesMapper;

    public GroupesServices(GroupesRepository groupesRepository, GroupesMapper groupesMapper) {
        this.groupesRepository = groupesRepository;
        this.groupesMapper = groupesMapper;
    }


    public GroupesDto save(GroupesDto groupesDto){
            validateGroupe(groupesDto);
        Groupes groupes = groupesRepository.saveAndFlush(groupesMapper.toEntity(groupesDto));
        GroupesDto grpDto =groupesMapper.toDto(groupes);
        LOGGER.debug(GroupesServices.class.getName(),HypnozCoreCostance.CREATED,grpDto);
        return grpDto;
    }

    public GroupesDto update(GroupesDto groupesDto, Long id){
        validateGroupe(groupesDto);
        try {
            var grp= groupesRepository
                    .findById(id)
                    .map(oldEntity -> groupesRepository.saveAndFlush(groupesMapper.toEntity(groupesDto)))
                    .orElseThrow(() ->  new  ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE));
            GroupesDto grpDto =groupesMapper.toDto(grp);
            LOGGER.debug(GroupesServices.class.getName(),HypnozCoreCostance.UPDATED,grpDto);
            return grpDto;

        } catch (ResponseException e) {
            log.error(e.getMessage(), e);
             throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
        }
    }


    public List<GroupesDto> list(Long sid) {
        try {
            List<Groupes> groupeList= groupesRepository.findAll().stream().filter(grp->grp.getStructuresId().equals(sid)).toList();
            List<GroupesDto> groupesDtoList = groupesMapper.toDto(groupeList);
            LOGGER.debug(GroupesServices.class.getName(),HypnozCoreCostance.FIND_LIST,groupesDtoList);
            return  groupesDtoList ;
        } catch (ResponseException e) {
            log.error(e.getMessage(), e);
            throw new ResponseException(RequestErrorEnum.LIST_EMPTY);
        }
    }

    public Optional<GroupesDto> findById(Long id) {
        try {
            Optional<Groupes> grpOptional = Optional.ofNullable(id).flatMap(groupesRepository::findById);
            GroupesDto groupesDto;
            if (grpOptional.isPresent()) {
                groupesDto = groupesMapper.toDto(grpOptional.get());
                LOGGER.debug(GroupesServices.class.getName(), HypnozCoreCostance.FIND_LIST, groupesDto);
                return Optional.of(groupesDto);
            }
            else{
                throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
            }

        } catch (ResponseException e) {
            log.error(e.getMessage(), e);
           throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
        }
    }

    public Groupes findOne(Long id) {
        try {
            return  Optional.ofNullable(id).flatMap(groupesRepository::findById).orElseThrow(()->new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE));
        } catch (ResponseException e) {
            log.error(e.getMessage(), e);
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
        }
    }
    private void validateGroupe(GroupesDto groupesDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<GroupesDto>> constraintViolations= validator.validate(groupesDto);
        if(!constraintViolations.isEmpty()){
            for (ConstraintViolation<GroupesDto> contraintes: constraintViolations) {
                if (HypnozCoreCostance.CODE_NOT_EMPTY.equals(contraintes.getMessageTemplate())){
                    throw new ResponseException(RequestErrorEnum.CODE_GROUPE_EMPTY);
                }
                if(HypnozCoreCostance.TAILLE_SIZE_INCORRECT.equals(contraintes.getMessageTemplate())){
                    throw  new ResponseException(RequestErrorEnum.SIZE_CODE_EMPTY);
                }

            }
        }
    }


}
