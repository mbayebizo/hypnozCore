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
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;

@ApiModel("Groupe Dto")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class GroupesDto {
    @Serial
    static final long serialVersionUID = 3001109767306041516L;
    Long id;
    @NotNull(message = HypnozCoreCostance.CODE_NOT_EMPTY)
    @Size(min = 2, max = 50, message = HypnozCoreCostance.TAILLE_SIZE_INCORRECT)
    String code;
    String libelle;
    StructuresDto structures;
}