package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Testfall;
import de.iubh.webanwendungen.require4testing.repository.TestfallRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TestfallServiceImpl implements TestfallService {

    @Inject
    private TestfallRepository repo;

    @Override
    public List<Testfall> getAll() {
        return repo.findAll();
    }

    @Override
    public Testfall getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void add(Testfall t) {
        repo.save(t);
    }

    @Override
    public void update(Testfall t) {
        repo.update(t);
    }

    @Override
    public void remove(Long id) {
        repo.delete(id);
    }

    @Override
    public List<Testfall> getByTestlaufId(Long testlaufId) {
        return repo.findByTestlaufId(testlaufId);
    }
}
