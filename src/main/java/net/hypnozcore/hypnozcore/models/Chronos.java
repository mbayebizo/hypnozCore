package net.hypnozcore.hypnozcore.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cmm_chrono")
@Where(clause = "flag_etat <> 'DELETED'")
@EqualsAndHashCode(callSuper = false)
@SQLDelete(sql = "UPDATE chrono SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Chronos extends AbstractEntity{

    @Column(name = "chr_nature")
    private int chrNature;

    @Column(name = "chr_serie", length = 30)
    private String chrSerie;

    @Column(name = "chr_nom", length = 50)
    private String chrNom;

    @Column(name = "chr_prive")
    private int chrPrive;

    @Column(name = "chr_service", length = 20)
    private String chrService;

    @Column(name = "chr_nb_car")
    private int chrNbCar;

    @Column(name = "chr_mode")
    private int chrMode;

    @Column(name = "chr_format")
    private int chrFormat;

    @Column(name = "chr_prefixe", length = 4)
    private String chrPrefixe;

    @Column(name = "chr_num")
    private long chrNum;

    @Column(name = "chr_num_an")
    private long chrNumAn;



    @Column(name = "chr_sufixe", length = 4)
    private String chrSufixe;

    @Column(name = "chr_journal", length = 10)
    private String chrJournal;

    @Column(name = "chr_journal_od", length = 10)
    private String chrJournalOd;

    @Column(name = "chr_periode", length = 10)
    private String chrPeriode;



    @Column(name = "chr_prefixe_1", length = 4)
    private String chrPrefixe1;

    @Column(name = "chr_sufixe_1", length = 4)
    private String chrSufixe1;

    @Column(name = "chr_sufixea")
    private String chrSufixea;
}
