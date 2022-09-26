package net.hypnozcore.hypnozcore.models;

import lombok.*;
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
@AllArgsConstructor
@Table(name = "regions")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE regions SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Regions extends AbstractEntity {
    private String code;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Regions regions = (Regions) o;
        return getId() != null && Objects.equals(getId(), regions.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}