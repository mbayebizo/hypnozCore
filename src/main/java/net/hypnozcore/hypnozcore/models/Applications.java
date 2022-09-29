package net.hypnozcore.hypnozcore.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serial;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Where(clause = "active <> 'N'")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Applications extends AbstractEntity {
    @Serial
    static final long serialVersionUID = 2657700055123057816L;
    private String code;
    private String libCode;
    private String libDesc;
    private String url;
    private String iconClass;
    String module;
    String active;
    int ordre;


    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(foreignKey = @ForeignKey(name = "mod_fk", value = ConstraintMode.NO_CONSTRAINT),
            insertable = false, updatable = false)
    @MapsId("modulesId")
    private Modules modules;

    @Override
    public void beforePrePersit() {
        super.beforePrePersit();
        this.active = "Y";
    }
}
