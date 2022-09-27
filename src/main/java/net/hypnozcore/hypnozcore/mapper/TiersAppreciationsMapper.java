package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.TiersAppreciationsDto;
import net.hypnozcore.hypnozcore.models.TiersAppreciations;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TiersAppreciationsMapper extends EntityMapper<TiersAppreciationsDto, TiersAppreciations> {
}