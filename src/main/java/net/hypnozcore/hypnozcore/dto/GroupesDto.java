package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull(message = "code ne peut pas etre null")
    @Size(min = 2, max = 50, message = "la")
    String code;
    String libelle;
    StructuresDto structures;
}