package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.mapper.UsersMapper;
import net.hypnozcore.hypnozcore.repository.GroupesRepository;
import net.hypnozcore.hypnozcore.repository.UsersRepository;
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@Transactional
public class UsersServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersServices.class);
    private final UsersRepository usersRepository;
    private final GroupesRepository groupesRepository;
    private final UsersMapper usersMapper;

    public UsersServices(UsersRepository usersRepository, GroupesRepository groupesRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.groupesRepository = groupesRepository;
        this.usersMapper = usersMapper;
    }

    public ResponseEntity<UsersDto> save(UsersDto usersDto){
        valideUser(usersDto);
        return ResponseEntity.ok(null);
    }

    private void valideUser(UsersDto usersDto) {
        if(!isvalidePassword(usersDto.getPwd())){
            throw new ResponseException(ResponseException.PASSWORD_INCORRECT);
        }
    }

    private boolean isvalidePassword(String pwd) {
        Pattern pattern = Pattern.compile(HypnozCoreCostance.REGEX_PASSWORD);
        if(pwd==null) return false;
        Matcher m = pattern.matcher(pwd);
        return m.matches();
    }
}
