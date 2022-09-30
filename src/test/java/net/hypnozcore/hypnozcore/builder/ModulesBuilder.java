package net.hypnozcore.hypnozcore.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.models.Modules;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ModulesBuilder {
    public static List<ModulesDto> getIds() {
        ModulesDto modules = new ModulesDto();
        modules.setActive("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        modules.setIconClass("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLibCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");
        return Collections.singletonList(modules);
    }

    public static ModulesDto getDto() {
        ModulesDto dto = new ModulesDto();
        dto.setActive("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        dto.setIconClass("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setId(123L);
        dto.setLibCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setLibDesc("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setOrdre(1);
        dto.setStandart(1);
        return dto;
    }
}