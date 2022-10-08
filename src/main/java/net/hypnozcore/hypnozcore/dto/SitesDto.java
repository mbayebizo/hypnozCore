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
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class SitesDto{
    Long id;
    @Size(max = 20)
    private String code;
    @Size(max = 100)
    private String libelle;
    private int inactif;
    private long sitIdResponsable;
    @Size(max = 100)
    private String sitNomResponsable;
    private long sitIdClient;
    private Long structuresId;
}