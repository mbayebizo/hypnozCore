package net.hypnozcore.hypnozcore.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.service.StructuresServices;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/structures")
@RestController
@Slf4j
@Api("structures")
public class StructureController {
    private final StructuresServices structuresServices;

    public StructureController(StructuresServices structuresServices) {
        this.structuresServices = structuresServices;
    }


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated StructuresDto structuresDto) {
        structuresServices.save(structuresDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructuresDto> findById(@PathVariable("id") Long id) {
        StructuresDto applicationConstant = structuresServices.findById(id);
        return ResponseEntity.ok(applicationConstant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try{
            structuresServices.deleteById(id);
        }catch (ResourceNotFoundException e){
            log.error("Unable to delete non-existent data！"+ e);
        }
        return ResponseEntity.ok().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated StructuresDto structuresDto, @PathVariable("id") Long id) {
        structuresServices.update(structuresDto, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/initSysteme")
    public ResponseEntity<StructuresDto> initSystement(@RequestBody StructuresDto structuresDto){
        return  structuresServices.initConfigStructure(structuresDto);
    }
}