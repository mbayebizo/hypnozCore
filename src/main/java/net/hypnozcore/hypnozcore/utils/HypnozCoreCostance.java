package net.hypnozcore.hypnozcore.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class HypnozCoreCostance {
    public static  final String REGEX_0_9= "[^0-9]";
    public static  final String REGEX_PASSWORD="([A-Za-z0-9!@#$%^&*()\\-_=+{};:,<.>]{8,20})";
    public static  final String DEFAULT_DOC_SERVEUR_NAME = "hypnozcore";
    public static  final String DEFAULT_DOC_SERVEUR_STRUCTURE = "structure";
    public static  final String DEFAULT_DOC_SERVEUR_MODELS = "models";
    public static  final String DEFAULT_DOC_SERVEUR_PIECES = "pieces";
    public static  final String DEFAULT_DOC_SERVEUR_IMPRESSION = "impression";
    public static final String DIR_TEMP = "temps";
    public static final String DIR_LOG = "logs";
    public static final String STRUCTURE="/structure";
    public static final String IMAGE_LOGO="image/logos/";
    public static final String CODE_NOT_EMPTY="code ne peut pas etre null";
    public static final String TAILLE_SIZE_INCORRECT="La Taille n'est pas respecté";
    public static final String CREATED ="CREATED {0}" ;
    public static final String UPDATED ="CREATED {0}" ;
    public static final String FIND_LIST ="CREATED {0}" ;
    public static final String LOGIN_NOT_EMPTY = "Le login ne peut pas être null";


    public static void logDebug(Object o){
        log.debug("Faux {e}",o);
    }
}
