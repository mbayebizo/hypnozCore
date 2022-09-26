package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.ActivitesDto;
import net.hypnozcore.hypnozcore.models.Activites;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivitesMapper extends EntityMapper<ActivitesDto, Activites> {
}