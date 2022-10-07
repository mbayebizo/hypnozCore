package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;

import java.time.LocalDate;

@ApiModel("Structure Dto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class StructuresDto {
    Long id;
    String raisonSocial;
    String sigle;
    String description;
    String zoneFiscale;
    String zoneFiscale2;
    LocalDate dateFiscale;
    TypeEntreprise typeEntreprise;
    String bilanSocail;
    String formJuridique;
    String adresse;
    String ville;
    String departement;
    String pays;
    String telephone;
    String email;
    String siteweb;
    String logo;
    String activiteCommerciale;
    String responsable;
    String qualiteResponsable;
    String capital;
    
}