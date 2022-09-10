package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel()
@Data
public class ApplicationConstantDto extends AbstractDto {
    private String code;
    private String libelle;
    private String nature;
    private boolean uesed;


}