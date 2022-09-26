package net.hypnozcore.hypnozcore.models;

import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "modele_courriers")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE modele_courriers SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Models  extends AbstractEntity{
    private String code;
}
