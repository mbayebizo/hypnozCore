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
public class BanquesDto extends AbstractDto {
    @Size(max = 255)
    private String bnqCode;
    @Size(max = 255)
    private String bnqIban;
    @Size(max = 255)
    private String bnqLibelle;
    @Size(max = 255)
    private String bnqSwift;

}