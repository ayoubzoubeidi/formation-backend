package com.isi.formation.dao;

import com.isi.formation.domain.Formateur;
import com.isi.formation.domain.Formation;
import com.isi.formation.domain.Participant;
import com.isi.formation.domain.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SessionDaoImpl implements SessionDao {

    private final EntityManagerFactory emf;

    @Override
    public Session createSession(Session session) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            session.setFormation(setFormationId(session.getFormation()));
            session.setFormation(em.getReference(Formation.class, session.getFormation().getId()));
            session.setFormateur(em.getReference(Formateur.class, session.getFormateur().getId()));
            Set<Participant> participants = new HashSet<>();
            for (Participant p : session.getParticipants()) {
                participants.add(em.getReference(Participant.class, p.getId()));
            }
            session.setParticipants(participants);
            em.persist(session);
            em.flush();
            em.clear();
            em.getTransaction().commit();
            return session;
        } finally {
            em.close();
        }
    }

    private Formation setFormationId(Formation formation) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UUID> query =  em.createQuery("SELECT f.id FROM Formation f WHERE " +
                    "f.titre = :titre",UUID.class);
            query.setParameter("titre", formation.getTitre());
            UUID id = query.getSingleResult();
            formation.setId(id);
            return formation;
        } finally {
            em.close();
        }
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
