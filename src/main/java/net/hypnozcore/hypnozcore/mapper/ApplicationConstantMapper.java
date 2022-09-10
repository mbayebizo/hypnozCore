package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.ApplicationConstantDto;
import net.hypnozcore.hypnozcore.models.ApplicationConstant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationConstantMapper extends EntityMapper<ApplicationConstantDto, ApplicationConstant> {
}