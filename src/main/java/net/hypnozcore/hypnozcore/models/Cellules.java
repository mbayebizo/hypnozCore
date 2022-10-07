package net.hypnozcore.hypnozcore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cellules")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE cellules SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Cellules extends AbstractEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cel_date_creat")
    private Date celDateCreat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cel_date_modif")
    private Date celDateModif;

    @Column(name = "cel_user_creat")
    private long celUserCreat;

    @Column(name = "cel_user_modif")
    private long celUserModif;

    @Column(name = "cel_code", length = 20)
    private String celCode;

    @Column(name = "cel_nom_FR", length = 100)
    private String celNomFr;

    @Column(name = "cel_nom_UK", length = 100)
    private String celNomUk;

    @Column(name = "cel_nom_SP", length = 100)
    private String celNomSp;

    @Column(name = "cel_inactif")
    private int celInactif;

    @Column(name = "cel_pourcentage")
    private double celPourcentage;

    @Column(name = "cel_id_responsable")
    private long celIdResponsable;

    @Column(name = "cel_nom_responsable", length = 100)
    private String celNomResponsable;

    @Column(name = "reg_id", nullable = false)
    private long regId;

    @Column(name = "sec_id", nullable = false)
    private long secId;

    @Column(name = "pdv_id", nullable = false)
    private long pdvId;

    @Column(name = "vil_id", nullable = false)
    private long vilId;

    @Column(name = "qua_id", nullable = false)
    private long quaId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cellules cellules = (Cellules) o;
        return getId() != null && Objects.equals(getId(), cellules.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
