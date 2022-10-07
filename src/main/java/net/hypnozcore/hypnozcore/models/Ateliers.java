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
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ateliers")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE ateliers SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Ateliers extends AbstractEntity{
    @Column(name = "atl_code")
    private String atlCode;

    @Column(name = "atl_date_creat")
    private Date atlDateCreat;

    @Column(name = "atl_date_modif")
    private Date atlDateModif;

    @Column(name = "atl_id_responsable")
    private long atlIdResponsable;

    @Column(name = "atl_inactif")
    private int atlInactif;

    @Column(name = "atl_nom_fr")
    private String atlNomFr;

    @Column(name = "atl_nom_responsable")
    private String atlNomResponsable;

    @Column(name = "atl_nom_sp")
    private String atlNomSp;

    @Column(name = "atl_nom_uk")
    private String atlNomUk;

    @Column(name = "atl_pourcentage")
    private Double atlPourcentage;

    @Column(name = "atl_user_creat")
    private long atlUserCreat;

    @Column(name = "atl_user_modif")
    private long atlUserModif;

    @Column(name = "lig_id")
    private long ligId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ateliers ateliers = (Ateliers) o;
        return getId() != null && Objects.equals(getId(), ateliers.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
