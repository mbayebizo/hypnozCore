package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.VillesDto;
import net.hypnozcore.hypnozcore.models.Villes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VillesMapper extends EntityMapper<VillesDto, Villes> {
}