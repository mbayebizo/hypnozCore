package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel("Application Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class SitesDto extends AbstractDto {
    private Date sitDateCreat;
    private Date sitDateModif;
    private long sitUserCreat;
    private long sitUserModif;
    @Size(max = 20)
    private String sitCode;
    @Size(max = 100)
    private String sitNomFr;
    @Size(max = 100)
    private String sitNomUk;
    @Size(max = 100)
    private String sitNomSp;
    private int sitInactif;
    private long sitIdResponsable;
    @Size(max = 100)
    private String sitNomResponsable;
    private long sitIdClient;

    }