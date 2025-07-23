package de.iubh.webanwendungen.require4testing.repository;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;

import de.iubh.webanwendungen.require4testing.entities.Anforderung;

@ApplicationScoped
public class AnforderungRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("RequirePU");

    public Anforderung findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Anforderung.class, id);
        } finally {
            em.close();
        }
    }

    public List<Anforderung> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Anforderung a", Anforderung.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public Anforderung save(Anforderung a) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (a.getId() == null) {
                em.persist(a);
            } else {
                a = em.merge(a);
            }
            tx.commit();
            return a;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Anforderung a = em.find(Anforderung.class, id);
            if (a != null) {
                em.remove(a);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
