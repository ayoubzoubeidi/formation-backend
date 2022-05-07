package com.isi.formation.services;

import com.isi.formation.domain.*;
import com.isi.formation.repository.FormationRepository;
import com.isi.formation.repository.ParticipantRepository;
import com.isi.formation.repository.SessionRepository;
import com.isi.formation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

       /* userRepository.saveAndFlush(
                ApplicationUser.builder().username("ayoub").password(passwordEncoder.encode("ayoub")).role(Role.builder()
                        .authority(Authority.builder().permission("read.all").build()).build()).build()
        );


        var formateur1 = Formateur.builder().nom("Mohssen").prenom("Double Feuille").tel("58671198").build();

        var session1 = sessionRepository.save(Session.builder().dateDebut(new Date()).dateFin(new Date(2023, Calendar.FEBRUARY, 15))
                .formateur(formateur1).build());


        var domaine1 = Domaine.builder().libelle("Informatique").build();

        var formation = formationRepository.save(
                Formation.builder()
                        .titre("Angular")
                        .session(session1)
                        .domaine(domaine1)
                        .duree(5)
                        .build()
        );

        session1.setFormation(formation);*/


         Participant participant = participantRepository.saveAndFlush(Participant.builder()
                .nom("Ayoub").prenom("Zoubeidi").tel("58671198").email("ayoub@Zoubeidi.fr").build());

        var participant2 = participantRepository.saveAndFlush(Participant.builder()
                .nom("Mohssen").prenom("Double FEUILLE").tel("21111128").email("mohssen@pates.fr").build());

/*

        var participant = participantRepository.findAll().get(0);

        sessionRepository.findAll().forEach(session -> {
            participant.getSessions().add(session);
            session.getParticipants().add(participant);
            sessionRepository.saveAndFlush(session);
        });
*/

    }
}
