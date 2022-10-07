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
@Table(name = "contacts")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE contacts SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Contacts extends AbstractEntity{

    private Date conDateCreat;
    private Date conDateModif;
    private long conUserCreat;
    private long conUserModif;
    private int conEtat;
    private String conNom;
    private String conPrenom;
    private String conPatronyme;
    private String conPwEspaceClient;
    private String conCivilite;
    private String conNomPays;
    private String conLangue;
    private String conFonction;
    private String conService;
    private Date conDateNaissance;
    private String conAnniversaire;
    private String conTelBur;
    private String conTelDom;
    private String conCel1;
    private String conCel2;
    private String conCel3;
    private String conFax;
    private String conAdresse;
    private String conRue;
    private String conLot;
    private String conIlot;
    private String conBatiment;
    private String conPorte;
    private String conEscalier;
    private String conAscensseur;
    private String conQuartier;
    private String conCommune;
    private String conDeparte;
    private String conZone;
    private String conBp;
    private String conCedex;
    private String conVille;
    private String conYahoo;
    private String conMsn;
    private String conSkype;
    private String conAol;
    private String conMail1;
    private String conMail2;
    private String conMail3;
    private String conMail4;
    private String conMail5;
    private String conBlog;
    private String conWeb;
    private String conObservation;
    private String conAppreciation;
    private String conNumBanque;
    private String conGuichetBanque;
    private String conCompteBanque;
    private String conCleBanque;
    private String conIban;
    private String conSwift;
    private String conJournal;
    private int conType;
    private String conCiNum;
    private String conCiPar;
    private Date conCiDateDebut;
    private Date conCiDateFin;
    private String conPhoto;
    private String conSignature;
    private String conRefBanque;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contacts contacts = (Contacts) o;
        return getId() != null && Objects.equals(getId(), contacts.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
