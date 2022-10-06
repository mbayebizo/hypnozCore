package net.hypnozcore.hypnozcore.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.service.UsersServices;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@Slf4j
@Api("users")
public class UsersController {
    private final UsersServices usersService;

    public UsersController(UsersServices usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<UsersDto> save(@RequestBody @Validated UsersDto usersDto) {
        UsersDto usersDtos=usersService.save(usersDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usersDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> findById(@PathVariable("id") Long id) {
        UsersDto users = usersService.findById(id);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            usersService.findById(id);
            usersService.delete(id);
            return ResponseEntity.ok().build();
        }catch (ResponseException e){
            throw  new ResponseException(RequestErrorEnum.NOT_FOUND_USER);
        }

    }


    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Validated UsersDto usersDto) {
        usersService.update(usersDto);
        return ResponseEntity.ok().build();
    }
}