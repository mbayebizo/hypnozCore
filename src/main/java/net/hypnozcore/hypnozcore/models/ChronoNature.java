package net.hypnozcore.hypnozcore.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chrono_nature")
public class ChronoNature {
    @Id
    private Integer code;
    private String libelle;
    private String typeNature;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChronoNature that = (ChronoNature) o;
        return code != null && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
