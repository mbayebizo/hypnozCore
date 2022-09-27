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
public class VillesDto extends AbstractDto{
    private String vilNomFr;
    private String vilNomUk;
    private String vilNomSp;
    private Integer vilInactif;
    private Double vilPourcentage;
    private Long vilIdResponsable;
    private String vilNomResponsable;

}