package net.hypnozcore.hypnozcore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certification_document")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE cmm_certification_document SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class CertificationDocument extends AbstractEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cer_date_creat")
    private Date cerDateCreat;

    @Column(name = "cer_user_creat")
    private long cerUserCreat;

    @Column(name = "cer_nature")
    private int cerNature;

    @Column(name = "cer_num", length = 20)
    private String cerNum;

    @Column(name = "cer_nom_rapport", length = 100)
    private String cerNomRapport;

    @Column(name = "cer_qte")
    private int cerQte;

    @Column(name = "cer_type_tiers")
    private int cerTypeTiers;

    @Column(name = "usr_id", nullable = false)
    private Long usrId;
}
