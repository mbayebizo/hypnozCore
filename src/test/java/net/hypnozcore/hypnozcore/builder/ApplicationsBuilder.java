package net.hypnozcore.hypnozcore.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.hypnozcore.hypnozcore.dto.ApplicationsDto;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ApplicationsBuilder {
    public static List<String> getIds() {

        return Collections.singletonList("1");
    }

    public static ApplicationsDto getDto() {
        ApplicationsDto dto = new ApplicationsDto();
        ModulesDto modules = new ModulesDto();
        modules.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        modules.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");


        dto.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        dto.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        dto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        dto.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        dto.setId(123L);
        dto.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        dto.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        dto.setModule("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        dto.setModulesDto(modules);
        dto.setOrdre(1);
        dto.setUrl("https://example.org/example");

        return dto;
    }
}