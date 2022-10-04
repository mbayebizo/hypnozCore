package net.hypnozcore.hypnozcore.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.service.GroupesServices;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

@RequestMapping("/groupes")
@RestController
@Slf4j
@Api("groupes")
public class GroupesController {
	private final GroupesServices groupesServices;

	public GroupesController(GroupesServices groupesServices) {
		this.groupesServices = groupesServices;
	}
 @PostMapping
    public ResponseEntity<GroupesDto> save(@RequestBody @Validated GroupesDto groupesDto) {
        GroupesDto grpDto=groupesServices.save(groupesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(grpDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupesDto> findById(@PathVariable("id") Long id) {
        GroupesDto groupes = groupesServices.findById(id).orElse(null);
        return ResponseEntity.ok(groupes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
       try {
           groupesServices.findById(id);
           groupesServices.deleteById(id);
           return ResponseEntity.ok().build();
       }catch (ResourceNotFoundException e){
           throw new ResourceNotFoundException();
       }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated GroupesDto groupesDto, @PathVariable("id") Long id) {
        groupesServices.update(groupesDto, id);
        return ResponseEntity.ok().build();
    }
}
