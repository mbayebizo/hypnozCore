package net.hypnozcore.hypnozcore.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sites")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE sites SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Sites extends AbstractEntity{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sit_date_creat")
    private Date sitDateCreat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sit_date_modif")
    private Date sitDateModif;

    @Column(name = "sit_user_creat")
    private long sitUserCreat;

    @Column(name = "sit_user_modif")
    private long sitUserModif;

    @Column(name = "sit_code", length = 20)
    private String sitCode;

    @Column(name = "sit_nom_FR", length = 100)
    private String sitNomFr;

    @Column(name = "sit_nom_UK", length = 100)
    private String sitNomUk;

    @Column(name = "sit_nom_SP", length = 100)
    private String sitNomSp;

    @Column(name = "sit_inactif")
    private int sitInactif;

    @Column(name = "sit_id_responsable")
    private long sitIdResponsable;

    @Column(name = "sit_nom_responsable", length = 100)
    private String sitNomResponsable;

    @Column(name = "sit_id_client")
    private long sitIdClient;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sites sites = (Sites) o;
        return getId() != null && Objects.equals(getId(), sites.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
