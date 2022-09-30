package net.hypnozcore.hypnozcore.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.hypnozcore.hypnozcore.dto.UsersDto;
import net.hypnozcore.hypnozcore.emus.Etats;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UsersBuilder {
    public static List<Long> getIds() {
        return Collections.singletonList(123L);
    }

    public static UsersDto getDto() {
        return UsersDto.builder()
                .id(123L)
                .adresse("Adresse")
                .bp("Bp")
                .cel("Cel")
                .civilite("Civilite")
                .codeSecret("Code Secret")
                .connexion(1)
                .dateNaissance(LocalDate.ofEpochDay(1L))
                .firstLog(LocalDate.ofEpochDay(1L))
                .langue("Langue")
                .login("Login")
                .nom("Nom")
                .patronyme("Patronyme")
                .photo("alice.liddell@example.org")
                .prenom("Prenom")
                .pwd("Pwd")
                .signature("Signature")
                .telBureau("Tel Bureau")
                .telDomicile("Tel Domicile")
                .ville("Ville")
                .build();
    }
}