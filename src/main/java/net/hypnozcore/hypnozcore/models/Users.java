package net.hypnozcore.hypnozcore.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "{id}")
@Builder
public class Users extends AbstractEntity {
    String civilite;
    String nom;
    String prenom;
    String patronyme;
    String codeSecret;
    Integer connexion;
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
    @Column
    String login;
    @Column
    String pwd;
    Boolean etat;
}
