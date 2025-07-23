package de.iubh.webanwendungen.require4testing.service;

import de.iubh.webanwendungen.require4testing.entities.Benutzer;
import de.iubh.webanwendungen.require4testing.repository.BenutzerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BenutzerServiceImpl implements BenutzerService {

    @Inject
    private BenutzerRepository benutzerRepo;

    @Override
    public List<Benutzer> getAll() {
        return benutzerRepo.findAll(); 
    }

    @Override
    public Benutzer getById(Long id) {
        return benutzerRepo.findById(id);
    }

    @Override
    public void save(Benutzer benutzer) {
        benutzerRepo.save(benutzer);
    }
}
