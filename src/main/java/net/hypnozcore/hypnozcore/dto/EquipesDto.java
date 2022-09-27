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
public class EquipesDto extends AbstractDto {
    private Integer equType;
    private String equCode;
    private String equNomFr;
    private Integer equInactif;
    private Integer equQuart;
    private Integer equHeureDebut;
    private Integer equHeureFin;
    private Integer equMinuteDebut;
    private Integer equMinuteFin;
    private Integer equStock;
}