package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.CertificationDocumentDto;
import net.hypnozcore.hypnozcore.models.CertificationDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CertificationDocumentMapper extends EntityMapper<CertificationDocumentDto, CertificationDocument> {
}