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
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignes")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE lignes SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Lignes extends AbstractEntity {
    private String code;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lignes lignes = (Lignes) o;
        return getId() != null && Objects.equals(getId(), lignes.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
