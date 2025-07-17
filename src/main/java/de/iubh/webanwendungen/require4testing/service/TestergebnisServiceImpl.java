package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Testergebnis;
import de.iubh.webanwendungen.require4testing.repository.TestergebnisRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TestergebnisServiceImpl implements TestergebnisService {

    @Inject
    private TestergebnisRepository repo;

    @Override
    public void save(Testergebnis ergebnis) {
        repo.save(ergebnis);
    }

    @Override
    public List<Testergebnis> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Testergebnis> getByTesterId(Long testerId) {
        return repo.findByTesterId(testerId);
    }
}
