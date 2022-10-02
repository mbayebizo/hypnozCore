package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@ApiModel("Application Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class ContactsDto extends AbstractDto {
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

}