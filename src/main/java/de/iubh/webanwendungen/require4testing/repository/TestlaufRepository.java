package de.iubh.webanwendungen.require4testing.repository;

import de.iubh.webanwendungen.require4testing.entities.Testlauf;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TestlaufRepository {

    @Inject
    private EntityManager em;

    public void save(Testlauf t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    public void update(Testlauf t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Testlauf t = em.find(Testlauf.class, id);
        if (t != null) {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }
    }

    public Testlauf findById(Long id) {
        return em.find(Testlauf.class, id);
    }

    public List<Testlauf> findAll() {
        return em.createQuery("SELECT t FROM Testlauf t", Testlauf.class)
                 .getResultList();
    }


    public List<Testlauf> findByTesterId(Long testerId) {
        return em.createQuery(
                "SELECT tl FROM Testlauf tl WHERE tl.tester.id = :uid",
                Testlauf.class)
                 .setParameter("uid", testerId)
                 .getResultList();
    }
}
