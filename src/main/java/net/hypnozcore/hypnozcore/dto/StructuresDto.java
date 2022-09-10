package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;

import java.io.Serial;
import java.time.LocalDate;

@ApiModel("Structure Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class StructuresDto extends AbstractDto {
    @Serial
    long serialVersionUID = 5570157676629231277L;
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