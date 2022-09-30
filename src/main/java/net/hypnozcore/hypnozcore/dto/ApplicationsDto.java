package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;

@ApiModel("Application Dto")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class ApplicationsDto extends AbstractDto {
    @Serial
    static final long serialVersionUID = -7308031832373933178L;
    String code;
    String libCode;
    String libDesc;
    String url;
    String iconClass;
    String module;
    String active;
    int ordre;
    ModulesDto modulesDto;
}