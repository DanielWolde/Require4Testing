// src/main/java/de/iubh/webanwendungen/require4testing/service/TestfallService.java
package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Testfall;
import java.util.List;

public interface TestfallService {
    List<Testfall> getAll();
    Testfall getById(Long id);
    void add(Testfall t);
    void update(Testfall t);
    void remove(Long id);

    List<Testfall> getByTestlaufId(Long testlaufId);
}
