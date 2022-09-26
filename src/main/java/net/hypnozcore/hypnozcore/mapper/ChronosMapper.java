package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.ChronosDto;
import net.hypnozcore.hypnozcore.models.Chronos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChronosMapper extends EntityMapper<ChronosDto, Chronos> {
}