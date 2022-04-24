package com.isi.formation.services;

import com.isi.formation.domain.*;
import com.isi.formation.repository.FormationRepository;
import com.isi.formation.repository.ParticipantRepository;
import com.isi.formation.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

//@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final FormationRepository formationRepository;
    private final SessionRepository sessionRepository;
    private final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
      /*  formationRepository.deleteAll();
        formationRepository.saveAndFlush(
                Formation.builder()
                        .titre("JavaScript")
                        .session(Session.builder().dateDebut(new Date()).dateFin(new Date(2023, Calendar.FEBRUARY, 15))
                                .formateur(Formateur.builder().nom("Mohssen").prenom("Double Feuille").tel("58671198").build()).build())
                        .domaine(Domaine.builder().libelle("Informatique").build())
                        .duree(5)
                        .build()
        );
        formationRepository.saveAndFlush(
                Formation.builder()
                        .titre("JAVA")
                        .session(Session.builder().dateDebut(new Date()).dateFin(new Date(2023, Calendar.FEBRUARY, 15))
                                .formateur(Formateur.builder().nom("ALI").prenom("Single Feuille").tel("21111128").build()).build())
                        .domaine(Domaine.builder().libelle("Informatique").build())
                        .duree(5)
                        .build()
        );
        formationRepository.saveAndFlush(
                Formation.builder()
                        .titre("FILE7A")
                        .session(Session.builder().dateDebut(new Date()).dateFin(new Date(2023, Calendar.FEBRUARY, 15))
                                .formateur(Formateur.builder().nom("GERDA").prenom("HMIDI").tel("5858585858").build()).build())
                        .domaine(Domaine.builder().libelle("NJARA").build())
                        .duree(5)
                        .build()
        );*/

        /*Participant participant = participantRepository.saveAndFlush(Participant.builder()
                .nom("Ayoub").prenom("Zoubeidi").tel("58671198").email("ayoub@Zoubeidi.fr").build());

        var participant2 = participantRepository.saveAndFlush(Participant.builder()
                .nom("Mohssen").prenom("Double FEUILLE").tel("21111128").email("mohssen@pates.fr").build());*/


  /*      var participant = participantRepository.findAll().get(0);

        sessionRepository.findAll().forEach(session -> {
            participant.getSessions().add(session);
            session.getParticipants().add(participant);
            sessionRepository.saveAndFlush(session);
        });
*/

    }
}
