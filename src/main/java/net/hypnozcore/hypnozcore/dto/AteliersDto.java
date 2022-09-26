package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel("Atelier Dto")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class AteliersDto extends AbstractDto {
    @Size(max = 255)
    private String atlCode;
    private Date atlDateCreat;
    private Date atlDateModif;
    private long atlIdResponsable;
    private int atlInactif;
    @Size(max = 255)
    private String atlNomFr;
    @Size(max = 255)
    private String atlNomResponsable;
    @Size(max = 255)
    private String atlNomSp;
    @Size(max = 255)
    private String atlNomUk;
    private Double atlPourcentage;
    private long atlUserCreat;
    private long atlUserModif;
    private long ligId;

}