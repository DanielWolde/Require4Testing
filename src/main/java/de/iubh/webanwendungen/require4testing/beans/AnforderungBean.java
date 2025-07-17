package de.iubh.webanwendungen.require4testing.beans;

import java.io.Serializable;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import de.iubh.webanwendungen.require4testing.entities.Anforderung;
import de.iubh.webanwendungen.require4testing.service.AnforderungService;

@Named("anfBean")
@RequestScoped
public class AnforderungBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private AnforderungService service;

    private List<Anforderung> alleAnforderungen;
    private Anforderung neueAnforderung;

    @PostConstruct
    public void init() {
        alleAnforderungen = service.listAnforderungen();
        neueAnforderung = new Anforderung();
    }

    public String speichern() {
        service.createAnforderung(neueAnforderung);
        return "index?faces-redirect=true";
    }

    public List<Anforderung> getAlleAnforderungen() {
        return alleAnforderungen;
    }

    public Anforderung getNeueAnforderung() {
        return neueAnforderung;
    }

    public void setNeueAnforderung(Anforderung neueAnforderung) {
        this.neueAnforderung = neueAnforderung;
    }
}
