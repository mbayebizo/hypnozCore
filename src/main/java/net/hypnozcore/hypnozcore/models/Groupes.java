package net.hypnozcore.hypnozcore.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;

@Entity
@Table(name = "groupes")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "{id}")
@Builder
@SQLDelete(sql = "UPDATE groupes SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Groupes extends AbstractEntity{
    @Serial
    static final long serialVersionUID = 1L;
    String code;
    String libelle;
    @Column(name = "structures_id")
    Long structuresId;

}
