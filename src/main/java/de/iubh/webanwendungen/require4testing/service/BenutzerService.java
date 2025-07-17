package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Benutzer;
import java.util.List;

public interface BenutzerService {
    List<Benutzer> getAll(); 
    Benutzer getById(Long id);
    void save(Benutzer benutzer);
}
