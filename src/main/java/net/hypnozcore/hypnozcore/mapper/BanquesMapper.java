package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.BanquesDto;
import net.hypnozcore.hypnozcore.models.Banques;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BanquesMapper extends EntityMapper<BanquesDto, Banques> {
}