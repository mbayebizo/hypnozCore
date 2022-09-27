package net.hypnozcore.hypnozcore.models;

import lombok.*;
import net.hypnozcore.hypnozcore.emus.TypeAction;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "espions")
@Where(clause = "flag_etat <> 'DELETED'")
@EqualsAndHashCode(callSuper = false)
@SQLDelete(sql = "UPDATE espions SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Espion extends AbstractEntity{
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreat;
    private TypeAction espAction;
    private int espType;
    private Long espIdTiers;
    private Long usrId;
    private String username;
    private Long idDoc;
    private String nameDoc;
}
