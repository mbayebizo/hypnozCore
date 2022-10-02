package net.hypnozcore.hypnozcore.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
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
