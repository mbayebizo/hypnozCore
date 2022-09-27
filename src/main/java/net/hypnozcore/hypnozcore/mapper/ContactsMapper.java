package net.hypnozcore.hypnozcore.mapper;

import net.hypnozcore.hypnozcore.dto.ContactsDto;
import net.hypnozcore.hypnozcore.models.Contacts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactsMapper extends EntityMapper<ContactsDto, Contacts> {
}