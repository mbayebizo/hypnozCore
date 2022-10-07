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
import net.hypnozcore.hypnozcore.emus.TypeAction;

import java.util.Date;

@ApiModel()
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class EspionDto extends AbstractDto {
    private Date dateCreat;
    private TypeAction espAction;
    private int espType;
    private Long espIdTiers;
    private Long usrId;
    private String username;
    private Long idDoc;
    private String nameDoc;

}