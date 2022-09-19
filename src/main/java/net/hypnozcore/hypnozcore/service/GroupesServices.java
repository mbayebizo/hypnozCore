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
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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


    public ResponseEntity<GroupesDto> save(GroupesDto groupesDto){
            validateGroupe(groupesDto);
        Groupes groupes = groupesRepository.saveAndFlush(groupesMapper.toEntity(groupesDto));
        return ResponseEntity.ok().body(groupesMapper.toDto(groupes));
    }

    public ResponseEntity<GroupesDto>update(GroupesDto groupesDto, Long id){
        validateGroupe(groupesDto);
        try {
            var grp= groupesRepository
                    .findById(id)
                    .map(oldEntity -> updateWithOld(oldEntity, groupesDto))
                    .orElseThrow(() ->  new  ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE));
            return ResponseEntity.status(HttpStatus.CREATED).body(groupesMapper.toDto(grp));

        } catch (ResponseException e) {
            log.error(e.getMessage(), e);
             throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
        }
    }

    private Groupes updateWithOld(Groupes oldEntity, GroupesDto groupesDto) {
        try {
            return groupesRepository.saveAndFlush(groupesMapper.toEntity(groupesDto));
        } catch (ResponseException e) {
            log.error(e.getMessage(), e);
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
        }
    }
    public ResponseEntity<List<Groupes>> list(Long sid) {
        try {
            List<Groupes> groupeList= groupesRepository.findAll().stream().filter(grp->grp.getStructuresId().equals(sid)).toList();
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(groupeList);
        } catch (ResponseException e) {
            log.error(e.getMessage(), e);
            throw new ResponseException(RequestErrorEnum.LIST_EMPTY);
        }
    }

    public ResponseEntity<Optional<GroupesDto>> findById(Long id) {
        try {

            Optional<Groupes> grpOptional = Optional.ofNullable(id).flatMap(groupesRepository::findById);
            if(grpOptional.isPresent())
                return ResponseEntity.status(HttpStatus.OK).body(Optional.of(groupesMapper.toDto(grpOptional.get())));
            else
                throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
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
