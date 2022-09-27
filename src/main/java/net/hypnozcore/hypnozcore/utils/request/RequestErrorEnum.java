package net.hypnozcore.hypnozcore.utils.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RequestErrorEnum {
    LIST_EMPTY(HttpStatus.NO_CONTENT, HttpStatus.BAD_REQUEST.name(),"Liste empty" ,"Liste est vide" ),

    ERROR_SIGLE(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),"sigle.error" ,"sigle.error.description" ),
    NOT_FOUND_STRUCTURE(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),"Structure Not FOUND" ,"Find Structure not found" ),
    ERROR_RAISON_SOCIAL(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "raison.social.error", "raison.social.error.description"),
    ERROR_INSERT_OR_UPDATE_IN_DATABASE(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "raison.social.error", "raison.social.error.description"),
    ID_STRUCTURE_EMPTY(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.name(),"ID Structure not Found","ID Structure not Found\"" ),
    CODE_GROUPE_EMPTY(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.name(),"Code Groupe is empty","Code Groupe is empty\"" ),
    SIZE_CODE_EMPTY(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.name(),"La taille du code est incorrect","La taille du code est incorrect\"" ),
    NOT_FOUND_GROUPE(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),"GROUPE Not FOUND" ,"Find GROUPE not found" ),
    MDP_INCORRECT(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),"Veillez donner un bon mot de passe" ,"Veillez donner un bon mot de passe" ),
    IMPOSSIBLE_DELETED(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),"Impossible de supprimer User" ,"Impossible de supprimer User" ),
    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.name(), "Lecture du ficher Incorrecte", "Lecture du ficher Incorrecte"),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.name(), "User Not FOUND" ,"Find User not found" );

    final HttpStatus httpStatus;
    final String errorCode;
    final String errorMessage;
    final String errorDescription;

    RequestErrorEnum(HttpStatus httpStatus, String errorCode, String errorMessage, String errorDescription) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public static  RequestErrorEnum loadEnumByErrorCode(String code){
        return Arrays.stream(RequestErrorEnum.values()).filter(e->e.getErrorCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
