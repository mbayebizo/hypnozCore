package net.hypnozcore.hypnozcore.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "villes")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE villes SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Villes extends AbstractEntity {
    private String vilNomFr;
    private String vilNomUk;
    private String vilNomSp;
    private Integer vilInactif;
    private Double vilPourcentage;
    private Long vilIdResponsable;
    private String vilNomResponsable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Villes villes = (Villes) o;
        return getId() != null && Objects.equals(getId(), villes.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
