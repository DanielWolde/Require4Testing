package de.iubh.webanwendungen.require4testing.producer;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Singleton
public class EntityManagerProducer {

  private final EntityManagerFactory emf =
		  Persistence.createEntityManagerFactory("RequirePU");


  @Produces @ApplicationScoped
  public EntityManagerFactory produceEmf() {
    return emf;
  }

  @Produces
  public EntityManager produceEm(EntityManagerFactory emf) {
    return emf.createEntityManager();
  }

  public void closeEm(@Disposes EntityManager em) {
    if (em.isOpen()) em.close();
  }

  @PreDestroy
  public void closeEmf() {
    if (emf.isOpen()) emf.close();
  }
}
