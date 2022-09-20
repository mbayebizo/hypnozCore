package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.time.LocalDate;

@ApiModel("User Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class UsersDto extends AbstractDto {
    @Serial
    static final long serialVersionUID = -2251460200601550695L;
    String civilite;
    String nom;
    String prenom;
    String patronyme;
    String codeSecret;
    int connexion;
    LocalDate dateNaissance;
    String langue;
    String adresse;
    String bp;
    String ville;
    String telBureau;
    String telDomicile;
    String cel;
    LocalDate lastLog;
    LocalDate firstLog;
    String photo;
    String signature;
    @Size(max = 255)
    @NotBlank(message = HypnozCoreCostance.LOGIN_NOT_EMPTY)
    String login;
    @Size(max = 255)
    String pwd;
    GroupesDto groupes;
    StructuresDto structuresDto;
    
}