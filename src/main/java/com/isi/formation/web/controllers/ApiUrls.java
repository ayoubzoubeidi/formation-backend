package com.isi.formation.web.controllers;

public class ApiUrls {

    // Domaine
    public final static String DOMAINE_MAIN_URL = "/domaines";
    public final static String DOMAINE_BY_ID = DOMAINE_MAIN_URL + "/{id}";

    // Formation
    public final static String FORMATION_MAIN_URL = "/formations";
    public final static String FORMATION_BY_ID = FORMATION_MAIN_URL + "/{id}";

    // Formateur
    public final static String FORMATEUR_MAIN_URL = "/formateurs";
    public final static String FORMATEUR_BY_ID = FORMATEUR_MAIN_URL + "/{id}";

    // Organisme
    public final static String ORGANISME_MAIN_URL = "/organismes";
    public final static String ORGANISME_BY_ID = ORGANISME_MAIN_URL + "/{id}";

    // Participant
    public final static String PARTICIPANT_MAIN_URL = "/participants";
    public final static String PARTICIPANT_BY_ID = PARTICIPANT_MAIN_URL + "/{id}";

    // Pays
    public final static String PAYS_MAIN_URL = "/pays";
    public final static String PAYS_BY_ID = PAYS_MAIN_URL + "/{id}";

    // Session
    public final static String SESSION_MAIN_URL = "/sessions";
    public final static String SESSION_BY_ID = SESSION_MAIN_URL + "/{id}";

    // Utilisateur
    public final static String UTILISATEUR_MAIN_URL = "/utilisateurs";
    public final static String UTILISATEUR_BY_ID = UTILISATEUR_MAIN_URL + "/{id}";
}
