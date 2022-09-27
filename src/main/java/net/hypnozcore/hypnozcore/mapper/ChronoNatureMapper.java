package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.ChronoNatureDto;
import net.hypnozcore.hypnozcore.models.ChronoNature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChronoNatureMapper extends EntityMapper<ChronoNatureDto, ChronoNature> {
}