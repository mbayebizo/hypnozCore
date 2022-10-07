package net.hypnozcore.hypnozcore.models;

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
@Entity
@Builder
@NoArgsConstructor
@Table(name = "tiers")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE tiers SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Tiers extends AbstractEntity {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tiers tiers = (Tiers) o;
        return getId() != null && Objects.equals(getId(), tiers.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
