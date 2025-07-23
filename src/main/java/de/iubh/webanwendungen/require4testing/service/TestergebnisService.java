package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Testergebnis;
import java.util.List;

public interface TestergebnisService {

    void save(Testergebnis ergebnis);

    List<Testergebnis> getAll();

 
    List<Testergebnis> getByTesterId(Long testerId);
}

