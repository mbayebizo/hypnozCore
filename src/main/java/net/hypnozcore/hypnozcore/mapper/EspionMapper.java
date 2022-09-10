package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.EspionDto;
import net.hypnozcore.hypnozcore.models.Espion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspionMapper extends EntityMapper<EspionDto, Espion> {
}