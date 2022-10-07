package net.hypnozcore.hypnozcore.builder;

import net.hypnozcore.hypnozcore.dto.ApplicationsDto;
import net.hypnozcore.hypnozcore.dto.ModulesDto;

import java.util.Collections;
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
        modules.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        dto.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        dto.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
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