package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.CellulesDto;
import net.hypnozcore.hypnozcore.models.Cellules;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CellulesMapper extends EntityMapper<CellulesDto, Cellules> {
}