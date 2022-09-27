package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.AteliersDto;
import net.hypnozcore.hypnozcore.models.Ateliers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AteliersMapper extends EntityMapper<AteliersDto, Ateliers> {
}