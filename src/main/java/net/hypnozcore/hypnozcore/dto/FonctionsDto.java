package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serial;

@ApiModel("Fonction Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class FonctionsDto extends AbstractDto {
    @Serial
    static final long serialVersionUID = 6553296754537262814L;
    String code;
    String libCode;
    String libDesc;
    String type;
    String url;
    String iconClass;
    String actions;
    String application;
    String module;
    String active;
    int ordre;
    boolean used;


}