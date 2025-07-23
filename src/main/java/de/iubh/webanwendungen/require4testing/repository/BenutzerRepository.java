package de.iubh.webanwendungen.require4testing.repository;

import de.iubh.webanwendungen.require4testing.entities.Benutzer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class BenutzerRepository {

    @Inject
    private EntityManager em;

    public void save(Benutzer benutzer) {
        em.getTransaction().begin();
        em.persist(benutzer);
        em.getTransaction().commit();
    }

    public Benutzer findById(Long id) {
        return em.find(Benutzer.class, id);
    }

    public List<Benutzer> findAll() {
        return em.createQuery("SELECT b FROM Benutzer b", Benutzer.class).getResultList();
    }
}
