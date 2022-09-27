package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.DeviseDto;
import net.hypnozcore.hypnozcore.models.Devise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviseMapper extends EntityMapper<DeviseDto, Devise> {
}