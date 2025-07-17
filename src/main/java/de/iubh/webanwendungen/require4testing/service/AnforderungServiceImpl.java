package de.iubh.webanwendungen.require4testing.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import de.iubh.webanwendungen.require4testing.entities.Anforderung;
import de.iubh.webanwendungen.require4testing.repository.AnforderungRepository;

@ApplicationScoped
public class AnforderungServiceImpl implements AnforderungService {

    @Inject
    private AnforderungRepository repo;

    @Override
    @Transactional
    public Anforderung createAnforderung(Anforderung a) {
        if (a.getTitel() == null || a.getTitel().isBlank()) {
            throw new IllegalArgumentException("Titel darf nicht leer sein");
        }
        return repo.save(a);
    }

    @Override
    @Transactional
    public Anforderung updateAnforderung(Anforderung a) {
        if (a.getBeschreibung() == null || a.getBeschreibung().length() < 10) {
            throw new IllegalArgumentException("Beschreibung muss mindestens 10 Zeichen haben");
        }
        return repo.save(a);
    }

    @Override
    @Transactional
    public void removeAnforderung(Long id) {
       
        repo.delete(id);
    }

    @Override
    public Anforderung getAnforderung(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Anforderung> listAnforderungen() {
        return repo.findAll();
    }
}

