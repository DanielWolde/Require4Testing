package de.iubh.webanwendungen.require4testing.repository;

import de.iubh.webanwendungen.require4testing.entities.Testergebnis;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TestergebnisRepository {

    @Inject
    private EntityManager em;

    public void save(Testergebnis ergebnis) {
        em.getTransaction().begin();
        em.persist(ergebnis);
        em.getTransaction().commit();
    }

    public List<Testergebnis> findAll() {
        return em.createQuery("SELECT e FROM Testergebnis e", Testergebnis.class)
                 .getResultList();
    }

    public Testergebnis findById(Long id) {
        return em.find(Testergebnis.class, id);
    }

    public List<Testergebnis> findByTesterId(Long testerId) {
        return em.createQuery(
                    "SELECT e FROM Testergebnis e WHERE e.testlauf.tester.id = :testerId",
                    Testergebnis.class)
                 .setParameter("testerId", testerId)
                 .getResultList();
    }
}
