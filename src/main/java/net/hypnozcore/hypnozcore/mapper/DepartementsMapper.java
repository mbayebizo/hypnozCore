package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.DepartementsDto;
import net.hypnozcore.hypnozcore.models.Departements;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartementsMapper extends EntityMapper<DepartementsDto, Departements> {
}