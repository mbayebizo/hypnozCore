package net.hypnozcore.hypnozcore.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.ApplicationConstantDto;
import net.hypnozcore.hypnozcore.service.ApplicationConstantService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/application-constant")
@RestController
@Slf4j
@Api("application-constant")
public class ApplicationConstantController {
    private final ApplicationConstantService applicationConstantService;

    public ApplicationConstantController(ApplicationConstantService applicationConstantService) {
        this.applicationConstantService = applicationConstantService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ApplicationConstantDto applicationConstantDto) {
        applicationConstantService.save(applicationConstantDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationConstantDto> findById(@PathVariable("id") String id) {
        ApplicationConstantDto applicationConstant = applicationConstantService.findById(id);
        return ResponseEntity.ok(applicationConstant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try{
            applicationConstantService.deleteById(id);
        }catch (ResourceNotFoundException e){
            log.error("Unable to delete non-existent data！"+ e);
        }
        return ResponseEntity.ok().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ApplicationConstantDto applicationConstantDto, @PathVariable("id") String id) {
        applicationConstantService.update(applicationConstantDto, id);
        return ResponseEntity.ok().build();
    }


}