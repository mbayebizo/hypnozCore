package net.hypnozcore.hypnozcore.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import java.io.Serial;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    Long modulesId;
    String active;
    int ordre;


    @Override
    public void beforePrePersit() {
        super.beforePrePersit();
        this.active = "Y";
    }
}
