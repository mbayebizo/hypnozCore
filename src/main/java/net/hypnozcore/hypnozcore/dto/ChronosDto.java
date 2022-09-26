package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;

@ApiModel("Application Dto")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class ChronosDto extends AbstractDto {
    private int chrNature;
    @Size(max = 30)
    private String chrSerie;
    @Size(max = 50)
    private String chrNom;
    private int chrPrive;
    @Size(max = 20)
    private String chrService;
    private int chrNbCar;
    private int chrMode;
    private int chrFormat;
    @Size(max = 4)
    private String chrPrefixe;
    private long chrNum;
    private long chrNumAn;

}