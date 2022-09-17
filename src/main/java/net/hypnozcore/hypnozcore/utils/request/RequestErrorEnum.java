package net.hypnozcore.hypnozcore.utils.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RequestErrorEnum {
    ERROR_SIGLE(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),"sigle.error" ,"sigle.error.description" ),
    NOT_FOUND_STRUCTURE(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),"Structure Not FOUND" ,"Find Structure not found" ),
    ERROR_RAISON_SOCIAL(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "raison.social.error", "raison.social.error.description"),
    ERROR_INSERT_OR_UPDATE_IN_DATABASE(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "raison.social.error", "raison.social.error.description"),
    ID_STRUCTURE_EMPTY(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.name(),"ID Structure not Found","ID Structure not Found\"" ),
    CODE_GROUPE_EMPTY(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.name(),"Code Groupe is empty","Code Groupe is empty\"" )
    ;

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
