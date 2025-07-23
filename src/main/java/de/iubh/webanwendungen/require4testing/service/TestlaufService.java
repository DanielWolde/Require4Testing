package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Testlauf;
import java.util.List;

public interface TestlaufService {
    List<Testlauf> getAll();
    Testlauf getById(Long id);
    void add(Testlauf t);
    void update(Testlauf t);
    void remove(Long id);

    List<Testlauf> getByTesterId(Long testerId);
}
