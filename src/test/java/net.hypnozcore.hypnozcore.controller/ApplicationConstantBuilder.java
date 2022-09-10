package net.hypnozcore.hypnozcore.controller;

import net.hypnozcore.hypnozcore.dto.ApplicationConstantDto;

import java.util.Collections;
import java.util.List;

public class ApplicationConstantBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ApplicationConstantDto getDto() {
        ApplicationConstantDto dto = new ApplicationConstantDto();
        return dto;
    }
}