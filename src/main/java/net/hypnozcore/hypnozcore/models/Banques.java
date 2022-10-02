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

import javax.persistence.Column;
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
@Table(name = "banques")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE banques SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Banques extends AbstractEntity {
        @Column(name = "bnq_code")
        private String bnqCode;

        @Column(name = "bnq_iban")
        private String bnqIban;

        @Column(name = "bnq_libelle")
        private String bnqLibelle;

        @Column(name = "bnq_swift")
        private String bnqSwift;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Banques banques = (Banques) o;
        return getId() != null && Objects.equals(getId(), banques.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
