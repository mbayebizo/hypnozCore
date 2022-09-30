package net.hypnozcore.hypnozcore.builder;

import net.hypnozcore.hypnozcore.dto.StructuresDto;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class StructuresBuilder {
    public static List<Long> getIds() {
        return Collections.singletonList(123L);
    }

    public static StructuresDto getDto() {
        StructuresDto dto = new StructuresDto();
        dto.setActiviteCommerciale("Activite Commerciale");
        dto.setAdresse("Adresse");
        dto.setBilanSocail("Bilan Socail");
        dto.setCapital("Capital");
        dto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        dto.setDateFiscale(LocalDate.ofEpochDay(1L));
        dto.setDepartement("Departement");
        dto.setDescription("The characteristics of someone or something");
        dto.setEmail("jane.doe@example.org");
        dto.setFormJuridique("Form Juridique");
        dto.setId(123L);
        dto.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        dto.setLogo("Logo");
        dto.setPays("Pays");
        dto.setQualiteResponsable("Qualite Responsable");
        dto.setRaisonSocial("Raison Social");
        dto.setResponsable("Responsable");
        dto.setSigle("Sigle");
        dto.setSiteweb("Siteweb");
        dto.setTelephone("4105551212");
        dto.setTypeEntreprise(TypeEntreprise.SA);
        dto.setVille("Ville");
        dto.setZoneFiscale("Zone Fiscale");
        dto.setZoneFiscale2("Zone Fiscale2");
        return dto;
    }
}