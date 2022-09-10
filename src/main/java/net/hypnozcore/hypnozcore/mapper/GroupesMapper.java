package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.GroupesDto;
import net.hypnozcore.hypnozcore.models.Groupes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupesMapper extends EntityMapper<GroupesDto, Groupes> {
}