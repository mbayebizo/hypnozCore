package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.models.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper extends EntityMapper<UsersDto, Users> {
}