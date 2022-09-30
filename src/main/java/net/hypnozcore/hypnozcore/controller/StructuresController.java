package net.hypnozcore.hypnozcore.controller;

import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.service.StructuresServices;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/structures")
@RestController
@Slf4j
@Api("structures")
public class StructuresController {
    private final StructuresServices structuresServices;

    public StructuresController(StructuresServices structuresServices) {
        this.structuresServices = structuresServices;
    }

    @SneakyThrows(ResponseException.class)
    @PostMapping
    public ResponseEntity<StructuresDto> save(@RequestBody @Validated StructuresDto structuresDto) {
        StructuresDto response =structuresServices.save(structuresDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @SneakyThrows(ResponseException.class)
    @GetMapping("/{id}")
    public ResponseEntity<StructuresDto> findById(@PathVariable("id") Long id) {
        StructuresDto applicationConstant = structuresServices.findById(id);
        return ResponseEntity.ok(applicationConstant);
    }
    @SneakyThrows(ResponseException.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            structuresServices.deleteById(id);
        } catch (ResourceNotFoundException e) {
            log.error("Unable to delete non-existent data！" + e);
        }
        return ResponseEntity.ok().build();
    }

    @SneakyThrows(ResponseException.class)
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated StructuresDto structuresDto, @PathVariable("id") Long id) {
        structuresServices.update(structuresDto, id);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows(ResponseException.class)
    @PostMapping("/initSysteme")
    public ResponseEntity<StructuresDto> initSystement(@RequestBody StructuresDto structuresDto) {
        return ResponseEntity.ok().build();
    }
}