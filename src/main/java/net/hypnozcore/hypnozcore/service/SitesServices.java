package net.hypnozcore.hypnozcore.service;

import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.dto.SitesDto;
import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.mapper.SitesMapper;
import net.hypnozcore.hypnozcore.models.Sites;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.repository.SitesRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import net.hypnozcore.hypnozcore.utils.request.RequestErrorEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class SitesServices {
	private final SitesRepository sitesRepository;
	private final StructuresRepository structuresRepository;
	private final SitesMapper sitesMapper;

	public SitesServices(SitesRepository sitesRepository, StructuresRepository structuresRepository, SitesMapper sitesMapper) {
		this.sitesRepository = sitesRepository;
		this.structuresRepository = structuresRepository;
		this.sitesMapper = sitesMapper;
	}

	public SitesDto saveSites(SitesDto dto) {
		if (dto == null) throw new ResponseException(RequestErrorEnum.NOT_FOUND);
		if (dto.getCode() == null) throw new ResponseException(RequestErrorEnum.CODE_EMPTY);
		 structuresRepository.findById(dto.getStructuresDto().getId())
				.orElseThrow(() -> new ResponseException(RequestErrorEnum.NOT_FOUND));

		var sites = sitesMapper.toEntity(dto);
		sitesRepository.saveAndFlush(sites);
		return sitesMapper.toDto(sites);
	}

	public SitesDto updateSite(SitesDto sitesDto, Long id) {
		if (id == null) throw new ResponseException(RequestErrorEnum.NOT_FOUND);
		if (sitesDto != null) {
			Sites sites = sitesMapper.toEntity(sitesDto);
			Sites finalSites = sites;
			sites = sitesRepository.findById(id).map(oldEntity -> updateWithOld(oldEntity, finalSites))
					.orElseThrow(() -> new ResponseException(RequestErrorEnum.NOT_FOUND));
			return sitesMapper.toDto(sites);
		} else {
			throw new ResponseException(RequestErrorEnum.NOT_FOUND);
		}

	}

	private Sites updateWithOld(Sites oldEntity, Sites sites) {
		if (oldEntity.getId().equals(sites.getId())) {
			sitesRepository.saveAndFlush(sites);
		}
		return sites;
	}

	public void deleteSite(Long id) {
		if (id == null) throw new ResponseException(RequestErrorEnum.NOT_FOUND);
		var site = sitesRepository.findById(id).orElseThrow(() -> new ResponseException(RequestErrorEnum.NOT_FOUND));
		sitesRepository.deleteById(site.getId());
	}

	public SitesDto getSites(Long id) {
		if (id == null) throw new ResponseException(RequestErrorEnum.NOT_FOUND);
		var sites = sitesRepository.findById(id).orElseThrow(() -> new ResponseException(RequestErrorEnum.NOT_FOUND));
		return sitesMapper.toDto(sites);
	}

	public SitesDto getSites(SitesDto sitesDto) {
		if (sitesDto == null) throw new ResponseException(RequestErrorEnum.NOT_FOUND);
		Sites sites = sitesRepository.findById(sitesDto.getId()).orElseThrow(() -> new ResponseException(RequestErrorEnum.NOT_FOUND));
		return sitesMapper.toDto(sites);
	}

	public List<SitesDto> getAllSites(StructuresDto structuresDto) {
		if (structuresDto == null) throw new ResponseException(RequestErrorEnum.NOT_FOUND);
		Structures structures = structuresRepository.findById(structuresDto.getId()).orElseThrow(() -> new ResponseException(RequestErrorEnum.NOT_FOUND));
		return sitesRepository.findByStructuresId(structures.getId()).stream().map(sitesMapper::toDto).toList();
	}
}
