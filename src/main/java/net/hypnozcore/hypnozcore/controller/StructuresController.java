package net.hypnozcore.hypnozcore.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.service.StructuresServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/structures")
@RestController
@Slf4j
@Api("structures")
public class StructuresController {
    private final StructuresServices structuresServices;

    public StructuresController(StructuresServices structuresServices) {
        this.structuresServices = structuresServices;
    }


    @PostMapping
    public ResponseEntity<StructuresDto>  save(@RequestBody @Valid StructuresDto structuresDto) {
        StructuresDto  response = structuresServices.save(structuresDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StructuresDto> findById(@PathVariable("id") Long id) {
        StructuresDto  dto = structuresServices.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        structuresServices.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructuresDto> update(@Valid @RequestBody StructuresDto structuresDto, @PathVariable("id") Long id) {
       StructuresDto    dto = structuresServices.update(structuresDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/initSysteme")
    public ResponseEntity<StructuresDto> initSysteme(@Valid @RequestBody StructuresDto structuresDto) {
        StructuresDto  dto = structuresServices.initConfigStructure(structuresDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}