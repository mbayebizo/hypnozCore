package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.EquipesDto;
import net.hypnozcore.hypnozcore.models.Equipes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipesMapper extends EntityMapper<EquipesDto, Equipes> {
}