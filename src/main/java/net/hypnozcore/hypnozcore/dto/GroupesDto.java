package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;

@ApiModel("Groupe Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class GroupesDto extends AbstractDto {
    @Serial
    static final long serialVersionUID = 3001109767306041516L;
    String code;
    String libelle;
    StructuresDto structures;
}