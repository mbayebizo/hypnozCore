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
public class CertificationDocumentDto extends AbstractDto {

    private Date cerDateCreat;
    private long cerUserCreat;
    private int cerNature;
    @Size(max = 20)
    private String cerNum;
    @Size(max = 100)
    private String cerNomRapport;
    private int cerQte;
    private int cerTypeTiers;
    @NotNull
    private Long usrId;
}