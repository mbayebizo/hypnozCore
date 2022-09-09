package net.hypnozcore.hypnozcore.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Table(name = "modules")
@Where(clause = "active <> 'N'")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Modules extends AbstractEntity{
    @Serial
    static final long serialVersionUID = -8557507909072700306L;
    String code;
    String libCode;
    String libDesc;
    String url;
    String iconClass;
    String active;
    int standart;
    int ordre;

    @Override
    public void beforePrePersit() {
        super.beforePrePersit();
        this.active = "Y";
    }
}
