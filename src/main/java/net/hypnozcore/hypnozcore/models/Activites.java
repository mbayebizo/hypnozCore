package net.hypnozcore.hypnozcore.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activites")
//@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE activites SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Activites extends AbstractEntity {
    @Column(name = "act_date_creat")
    private Date actDateCreat;

    @Column(name = "act_date_modif")
    private Date actDateModif;

    @Column(name = "act_user_creat")
    private long actUserCreat;

    @Column(name = "act_user_modif")
    private long actUserModif;

    @Column(name = "act_code", length = 20)
    private String actCode;

    @Column(name = "act_nom_FR", length = 100)
    private String actNomFr;

    @Column(name = "act_nom_UK", length = 100)
    private String actNomUk;

    @Column(name = "act_nom_SP", length = 100)
    private String actNomSp;

    @Column(name = "act_inactif")
    private int actInactif;

    @Column(name = "act_annee_debut")
    private int actAnneeDebut;

    @Column(name = "act_annee_fin")
    private int actAnneeFin;

    @Column(name = "act_vte")
    private boolean actVte;

    @Column(name = "act_ach")
    private boolean actAch;

    @Column(name = "act_prd")
    private boolean actPrd;

    @Column(name = "act_frg")
    private boolean actFrg;

    @Column(name = "act_inv")
    private boolean actInv;

    @Column(name = "act_tva")
    private boolean actTva;

    @Column(name = "act_tax")
    private boolean actTax;

    @Column(name = "act_sal")
    private boolean actSal;

    @Column(name = "act_options")
    private int actOptions;

    @Column(name = "act_id_responsable")
    private long actIdResponsable;

    @Column(name = "act_nom_responsable", length = 100)
    private String actNomResponsable;

    @Column(name = "act_regroupement", length = 20)
    private String actRegroupement;

    @Column(name = "act_colonne", length = 20)
    private String actColonne;

    @Column(name = "act_compte_taxe", length = 20)
    private String actCompteTaxe;

    @Column(name = "act_taux_taxe")
    private double actTauxTaxe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Activites activites = (Activites) o;
        return getId() != null && Objects.equals(getId(), activites.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
