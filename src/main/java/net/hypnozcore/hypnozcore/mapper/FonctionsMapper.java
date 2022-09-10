package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.FonctionsDto;
import net.hypnozcore.hypnozcore.models.Fonctions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FonctionsMapper extends EntityMapper<FonctionsDto, Fonctions> {
}