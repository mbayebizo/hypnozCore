package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel("Application Dto")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class CellulesDto extends AbstractDto {

    private Date celDateCreat;

    private Date celDateModif;
    private long celUserCreat;
    private long celUserModif;
    @Size(max = 20)
    private String celCode;
    @Size(max = 100)
    private String celNomFr;
    @Size(max = 100)
    private String celNomUk;
    @Size(max = 100)
    private String celNomSp;
    private int celInactif;
    private double celPourcentage;
    private long celIdResponsable;
    @Size(max = 100)
    private String celNomResponsable;
    @NotNull
    private long regId;
    @NotNull
    private long secId;
    @NotNull
    private long pdvId;
    @NotNull
    private long vilId;
    @NotNull
    private long quaId;
}