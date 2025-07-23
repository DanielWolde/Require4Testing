
package de.iubh.webanwendungen.require4testing.repository;

import de.iubh.webanwendungen.require4testing.entities.Testfall;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TestfallRepository {

    @Inject
    private EntityManager em;

    public void save(Testfall t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    public void update(Testfall t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Testfall t = em.find(Testfall.class, id);
        if (t != null) {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }
    }

    public Testfall findById(Long id) {
        return em.find(Testfall.class, id);
    }

    public List<Testfall> findAll() {
        return em.createQuery("SELECT t FROM Testfall t", Testfall.class)
                 .getResultList();
    }

  
    public List<Testfall> findByTestlaufId(Long testlaufId) {
        return em.createQuery(
                "SELECT tf FROM Testfall tf JOIN tf.testlaeufe tl WHERE tl.id = :lid",
                Testfall.class)
                 .setParameter("lid", testlaufId)
                 .getResultList();
    }
}
