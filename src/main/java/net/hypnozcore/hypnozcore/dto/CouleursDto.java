package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ApiModel("Application Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class CouleursDto extends AbstractDto{
    private String couCode;
    private String couLibelle;
    private Integer couInactif;

}