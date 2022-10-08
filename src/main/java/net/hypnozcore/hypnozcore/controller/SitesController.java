package net.hypnozcore.hypnozcore.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.SitesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.service.SitesServices;
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

import java.util.List;

@RequestMapping("/sites")
@RestController
@Slf4j
@Api("sites")
public class SitesController {
	private final SitesServices sitesServices;

	public SitesController(SitesServices sitesServices) {
		this.sitesServices = sitesServices;
	}

	@PostMapping
	public ResponseEntity<SitesDto> save(@RequestBody @Validated SitesDto siteDto) {
		SitesDto site = sitesServices.saveSites(siteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(site);
	}
	@PutMapping("/{id}")
	public ResponseEntity<SitesDto> update(@RequestBody @Validated SitesDto sitesDto, @PathVariable("id") Long id){
		SitesDto site = sitesServices.updateSite(sitesDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(site);
	}
	@PostMapping("/findOneSite")
	public ResponseEntity<SitesDto> getOneSite(@RequestBody	SitesDto sitesDto){
		SitesDto site = sitesServices.getSites(sitesDto);
        return ResponseEntity.status(HttpStatus.OK).body(site);
	}
	@PostMapping("/findAll")
	public ResponseEntity<List<SitesDto>> findByIdAllBySite(@RequestBody StructuresDto structuresDto){
		List<SitesDto> sitesDtoList = sitesServices.getAllSites(structuresDto);
	return ResponseEntity.status(HttpStatus.OK).body(sitesDtoList);
    }

	@GetMapping("/{id}")
	public ResponseEntity<SitesDto> getOneSiteById(@PathVariable("id") Long id){
		SitesDto site = sitesServices.getSites(id);
        return ResponseEntity.status(HttpStatus.OK).body(site);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
		sitesServices.deleteSite(id);
        return ResponseEntity.status(HttpStatus.OK).build();
	}
}
