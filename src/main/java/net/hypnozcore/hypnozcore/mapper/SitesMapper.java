package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.SitesDto;
import net.hypnozcore.hypnozcore.models.Sites;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SitesMapper extends EntityMapper<SitesDto, Sites> {
}