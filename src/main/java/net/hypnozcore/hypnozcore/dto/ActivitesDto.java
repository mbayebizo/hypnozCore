package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel("Activite Dto")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class ActivitesDto extends AbstractDto {
    private Date actDateCreat;

    private Date actDateModif;
    private long actUserCreat;
    private long actUserModif;
    @Size(max = 20)
    private String actCode;
    @Size(max = 100)
    private String actNomFr;
    @Size(max = 100)
    private String actNomUk;
    @Size(max = 100)
    private String actNomSp;
    private int actInactif;
    private int actAnneeDebut;
    private int actAnneeFin;
    private boolean actVte;
    private boolean actAch;
    private boolean actPrd;
    private boolean actFrg;
    private boolean actInv;
    private boolean actTva;
    private boolean actTax;
    private boolean actSal;
    private int actOptions;
    private long actIdResponsable;
    @Size(max = 100)
    private String actNomResponsable;
    @Size(max = 20)
    private String actRegroupement;
    @Size(max = 20)
    private String actColonne;
    @Size(max = 20)
    private String actCompteTaxe;
    private double actTauxTaxe;

}