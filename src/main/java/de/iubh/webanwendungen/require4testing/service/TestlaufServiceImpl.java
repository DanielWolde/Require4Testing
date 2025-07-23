package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Testlauf;
import de.iubh.webanwendungen.require4testing.repository.TestlaufRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TestlaufServiceImpl implements TestlaufService {

    @Inject
    private TestlaufRepository repo;

    @Override
    public List<Testlauf> getAll() {
        return repo.findAll();
    }

    @Override
    public Testlauf getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void add(Testlauf t) {
        repo.save(t);
    }

    @Override
    public void update(Testlauf t) {
        repo.update(t);
    }

    @Override
    public void remove(Long id) {
        repo.delete(id);
    }

    @Override
    public List<Testlauf> getByTesterId(Long testerId) {
        return repo.findByTesterId(testerId);
    }
}
