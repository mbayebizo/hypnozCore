package net.hypnozcore.hypnozcore.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractDto implements Serializable {
     @Serial
     static final long serialVersionUID = -5163634117644252198L;
     private Long id;
     LocalDateTime createAt;
     LocalDateTime lastModifiedAt;
     String createdBy;
     String lastModifiedBy;


}