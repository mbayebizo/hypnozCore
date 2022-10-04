package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.mapper.UsersMapper;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.models.UserGroupes;
import net.hypnozcore.hypnozcore.models.UserStructures;
import net.hypnozcore.hypnozcore.models.Users;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.repository.UserGroupesRepository;
import net.hypnozcore.hypnozcore.repository.UserStructuresRepository;
import net.hypnozcore.hypnozcore.repository.UsersRepository;
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@Transactional
public class UsersServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersServices.class);
    private final UsersRepository usersRepository;
    private final GroupesRepository groupesRepository;
    private final StructuresRepository structuresRepository;
    private final UserGroupesRepository userGroupesRepository;
    private final UsersMapper usersMapper;
    private final UserStructuresRepository userStructuresRepository;

    public UsersServices(UsersRepository usersRepository, GroupesRepository groupesRepository, StructuresRepository structuresRepository, UserGroupesRepository userGroupesRepository, UsersMapper usersMapper, UserStructuresRepository userStructuresRepository) {
        this.usersRepository = usersRepository;
        this.groupesRepository = groupesRepository;
        this.structuresRepository = structuresRepository;
        this.userGroupesRepository = userGroupesRepository;
        this.usersMapper = usersMapper;
        this.userStructuresRepository = userStructuresRepository;
    }

    public UsersDto save(UsersDto usersDto) {
        Optional<Structures> structuresOptional = structuresRepository.findById(usersDto.getStructuresDto().getId());
        Optional<Groupes> groupesOptional = groupesRepository.findById(usersDto.getGroupes().getId());
        Users users = getValidUsers(usersDto,structuresOptional,groupesOptional);

        users.setPatronyme(usersDto.getNom() + " " + usersDto.getPrenom());
        usersRepository.saveAndFlush(users);

        UserStructures userStructures = UserStructures.builder()
                .id(UserStructures.UserStructuresPK.builder()
                        .structuresId(structuresOptional.get().getId())
                        .usersId(users.getId())
                        .build())
                .structures(structuresOptional.get())
                .users(users)
                .build();

        userStructuresRepository.saveAndFlush(userStructures);

        UserGroupes userGroupes = UserGroupes.builder()
                .id(UserGroupes.UserGroupesPK.builder()
                        .groupesId(groupesOptional.get().getId())
                        .usersId(users.getId())
                        .build())
                .groupes(groupesOptional.get())
                .users(users)
                .build();
        userGroupesRepository.saveAndFlush(userGroupes);
        usersDto = usersMapper.toDto(users);
        LOGGER.debug(UsersServices.class.getName(), HypnozCoreCostance.CREATED, usersDto);
        return usersDto;
    }

    private void valideUser(UsersDto usersDto) {
        if (!isvalidePassword(usersDto.getPwd())) {
            throw new ResponseException(RequestErrorEnum.MDP_INCORRECT);
        }
    }

    private boolean isvalidePassword(String pwd) {
        Pattern pattern = Pattern.compile(HypnozCoreCostance.REGEX_MDP);
        if (pwd == null) return false;
        Matcher m = pattern.matcher(pwd);
        return m.matches();
    }

    public ResponseEntity<List<UsersDto>> findUserActiveBygroupe(Long grpId) {
        List<UsersDto> usersDtoSet = userGroupesRepository.findByIdGroupesId(grpId).stream()
                .filter(ug -> ug.getUsers() != null && Objects.equals(ug.getUsers().getEtat(), Boolean.TRUE))
                .map(userGroupes -> usersMapper.toDto(userGroupes.getUsers())).toList();

        if (!usersDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(usersDtoSet);
        } else {
            throw new ResponseException(RequestErrorEnum.LIST_EMPTY);
        }
    }

    public ResponseEntity<List<UsersDto>> findUserBygroupe(Long grpId) {
        List<UsersDto> usersDtoSet = userGroupesRepository.findByIdGroupesId(grpId).stream()
                .filter(ug -> ug.getUsers() != null)
                .map(userGroupes -> usersMapper.toDto(userGroupes.getUsers())).toList();

        if (!usersDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(usersDtoSet);
        } else {
            throw new ResponseException(RequestErrorEnum.LIST_EMPTY);
        }
    }

    public ResponseEntity<List<UsersDto>> findUserActiveByStructure(Long grpId) {
        List<UsersDto> usersDtoSet = userStructuresRepository.findByIdStructuresId(grpId).stream()
                .filter(ug -> ug.getUsers() != null && Objects.equals(ug.getUsers().getEtat(), Boolean.TRUE))
                .map(userGroupes -> usersMapper.toDto(userGroupes.getUsers())).toList();

        if (!usersDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(usersDtoSet);
        } else {
            throw new ResponseException(RequestErrorEnum.LIST_EMPTY);
        }
    }

    public ResponseEntity<List<UsersDto>> findUserByStructure(Long grpId) {
        List<UsersDto> usersDtoSet = userStructuresRepository.findByIdStructuresId(grpId).stream()
                .filter(ug -> ug.getUsers() != null)
                .map(userGroupes -> usersMapper.toDto(userGroupes.getUsers())).toList();

        if (!usersDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(usersDtoSet);
        } else {
            throw new ResponseException(RequestErrorEnum.LIST_EMPTY);
        }
    }

    public ResponseEntity<UsersDto> update(UsersDto usersDto) {
        Optional<Structures> structuresOptional = structuresRepository.findById(usersDto.getStructuresDto().getId());
        Optional<Groupes> groupesOptional = groupesRepository.findById(usersDto.getGroupes().getId());
        Users users = getValidUsers(usersDto,structuresOptional,groupesOptional);
        Optional<Users> optionalUsers = usersRepository.findById(users.getId());
        if (optionalUsers.isPresent()) {
            users.setPatronyme(usersDto.getNom() + " " + usersDto.getPrenom());
            usersRepository.saveAndFlush(users);
        } else {
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }
        usersDto = usersMapper.toDto(users);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersDto);
    }



    public ResponseEntity<UsersDto> delete(Long id) {

        try {
            Optional<Users> optionalUsers = usersRepository.findById(id);
            UsersDto usersDto;

            usersDto = usersMapper.toDto(optionalUsers.orElse(null));
            userGroupesRepository.removeByIdUsersIdAllIgnoreCase(id);
            userStructuresRepository.deleteByIdUsersIdAllIgnoreCase(id);
            usersRepository.deleteById(id);
            return ResponseEntity.ok(usersDto);
        }catch (ResponseException e){
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }
    }


	public UsersDto findById(Long id) {
        Optional<Users> optionalUsers = Optional.ofNullable(usersRepository.findById(id).orElseThrow(() -> {
            log.debug("Impossible delete for id: " + id);
            return new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }));
        return optionalUsers.map(usersMapper::toDto).orElse(null);
	}

    private Users getValidUsers(UsersDto usersDto, Optional<Structures> structuresOptional, Optional<Groupes> groupesOptional) {
        valideUser(usersDto);
        Users users = usersMapper.toEntity(usersDto);

        if (structuresOptional.isEmpty()) {
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_STRUCTURE);
        }
        if (groupesOptional.isEmpty() || !Objects.equals(groupesOptional.get().getStructures().getId(), structuresOptional.get().getId())) {
            throw new ResponseException(RequestErrorEnum.NOT_FOUND_GROUPE);
        }
        return users;
    }
}
