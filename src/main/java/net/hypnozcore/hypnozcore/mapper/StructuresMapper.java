package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.models.Structures;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StructuresMapper extends EntityMapper<StructuresDto, Structures> {
}