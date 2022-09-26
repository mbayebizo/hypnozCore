package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.CouleursDto;
import net.hypnozcore.hypnozcore.models.Couleurs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CouleursMapper extends EntityMapper<CouleursDto, Couleurs> {
}