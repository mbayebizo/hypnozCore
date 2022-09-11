package net.hypnozcore.hypnozcore.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;

public class FileUtils {
    @SneakyThrows
    public static List<Object> readFile(String url, Object object){
        Resource resource = new ClassPathResource("config/modules.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Object>> typeReference = new TypeReference<>() {
        };
        return objectMapper.readValue(resource.getInputStream(),typeReference);

    }
}
