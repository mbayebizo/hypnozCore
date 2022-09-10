package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.ApplicationsDto;
import net.hypnozcore.hypnozcore.models.Applications;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationsMapper extends EntityMapper<ApplicationsDto, Applications> {
}