package net.hypnozcore.hypnozcore.models;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "groupes_chronos", indexes = {
        @Index(name = "idx_groupesfonctions_unq", columnList = "chronos_id, groupes_id", unique = true)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupeChronos implements Persistable<GroupeChronos.GroupeChronosPK> {
    @Id
    private GroupeChronos.GroupeChronosPK id;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(foreignKey = @ForeignKey(name = "chr_fk", value = ConstraintMode.NO_CONSTRAINT),
            insertable = false, updatable = false)
    @MapsId("chronosId")
    private Chronos chronos;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(foreignKey = @ForeignKey(name = "grp_fk", value = ConstraintMode.NO_CONSTRAINT),
            insertable = false, updatable = false)
    @MapsId("groupesId")
    private Groupes groupes;

    @Transient
    private boolean isNew = true;

    @Override
    public boolean isNew() {
        return isNew;
    }

    @PrePersist
    @PostLoad
    protected void markNotNew() {
        this.isNew = false;
    }


    @Embeddable
    @EqualsAndHashCode
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class GroupeChronosPK implements Serializable {
        private Long chronosId;
        private Long groupesId;

    }
}
