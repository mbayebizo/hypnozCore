package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.TiersDto;
import net.hypnozcore.hypnozcore.models.Tiers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TiersMapper extends EntityMapper<TiersDto, Tiers> {
}