package de.iubh.webanwendungen.require4testing.beans;

import de.iubh.webanwendungen.require4testing.entities.Benutzer;
import de.iubh.webanwendungen.require4testing.service.BenutzerService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class BenutzerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Benutzer neuerBenutzer = new Benutzer();
    private List<Benutzer> benutzerListe = Collections.emptyList();

    @Inject
    private BenutzerService benutzerService;

    @PostConstruct
    public void init() {
        aktualisiereBenutzerListe();
    }

    public void speichern() {
        benutzerService.save(neuerBenutzer);
        neuerBenutzer = new Benutzer();
        aktualisiereBenutzerListe();
    }

    private void aktualisiereBenutzerListe() {
        benutzerListe = benutzerService.getAll();
    }

    public Benutzer getNeuerBenutzer() {
        return neuerBenutzer;
    }

    public void setNeuerBenutzer(Benutzer neuerBenutzer) {
        this.neuerBenutzer = neuerBenutzer;
    }

    public List<Benutzer> getBenutzerListe() {
        return benutzerListe;
    }
}
