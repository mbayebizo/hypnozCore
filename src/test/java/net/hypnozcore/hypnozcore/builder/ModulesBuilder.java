package net.hypnozcore.hypnozcore.builder;

import net.hypnozcore.hypnozcore.dto.ModulesDto;

import java.util.Collections;
import java.util.List;

public class ModulesBuilder {
    public static List<ModulesDto> getIds() {
        ModulesDto modules = new ModulesDto();
        modules.setActive("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
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
        dto.setIconClass("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setId(123L);
        dto.setLibCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setLibDesc("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        dto.setOrdre(1);
        dto.setStandart(1);
        return dto;
    }
}