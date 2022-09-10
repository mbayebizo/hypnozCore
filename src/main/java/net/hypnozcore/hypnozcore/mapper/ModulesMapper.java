package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.models.Modules;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModulesMapper extends EntityMapper<ModulesDto, Modules> {
}