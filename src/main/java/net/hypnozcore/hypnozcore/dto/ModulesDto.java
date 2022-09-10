package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;

@ApiModel("Module Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class ModulesDto extends AbstractDto {
    @Serial
     static final long serialVersionUID = -6226646823763427686L;
     String code;
     String libCode;
     String libDesc;
     String url;
     String iconClass;
     String active;
     Integer standart;
     int ordre;
     StructuresDto structures;

    
}