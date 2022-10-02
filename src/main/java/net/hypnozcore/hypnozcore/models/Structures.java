package net.hypnozcore.hypnozcore.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "structures")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@Builder
public class Structures extends AbstractEntity{
    @Serial
    static final long serialVersionUID = -563840516246290525L;
    String raisonSocial;
    String sigle;
    @Lob
    String description;
    String zoneFiscale;
    String zoneFiscale2;
    LocalDate dateFiscale;
    @Enumerated(EnumType.STRING)
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
    @Lob
    String logo;
    private String activiteCommerciale;
    private String responsable;
    private String qualiteResponsable;
    private String capital;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Structures that = (Structures) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
