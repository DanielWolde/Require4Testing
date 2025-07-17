package de.iubh.webanwendungen.require4testing.beans;

import de.iubh.webanwendungen.require4testing.entities.Anforderung;
import de.iubh.webanwendungen.require4testing.entities.Testfall;
import de.iubh.webanwendungen.require4testing.service.AnforderungService;
import de.iubh.webanwendungen.require4testing.service.TestfallService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class TestfallBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Testfall neuerTestfall = new Testfall();
    private Testfall ausgewaehlterTestfall;         
    private List<Testfall> testfaelle;
    private Long ausgewaehlteAnforderungId;

    @Inject
    private TestfallService service;

    @Inject
    private AnforderungService anforderungService;

    @PostConstruct
    public void init() {
        testfaelle = service.getAll();
    }

    public void speichern() {
        Anforderung a = anforderungService.getAnforderung(ausgewaehlteAnforderungId);
        neuerTestfall.setAnforderung(a);
        service.add(neuerTestfall);
        neuerTestfall = new Testfall();
        testfaelle = service.getAll();
    }

    public void bearbeiten(Testfall t) {
        this.ausgewaehlterTestfall = t;
        this.ausgewaehlteAnforderungId = t.getAnforderung() != null ? t.getAnforderung().getId() : null;
    }

    public void update() {
        if (ausgewaehlterTestfall != null && ausgewaehlteAnforderungId != null) {
            Anforderung a = anforderungService.getAnforderung(ausgewaehlteAnforderungId);
            ausgewaehlterTestfall.setAnforderung(a);
            service.update(ausgewaehlterTestfall);
        }
        ausgewaehlterTestfall = null;
        testfaelle = service.getAll();
    }

    public void loeschen(Testfall t) {
        service.remove(t.getId());
        testfaelle = service.getAll();
    }

    public List<Anforderung> getAlleAnforderungen() {
        return anforderungService.listAnforderungen();
    }

   

    public Testfall getNeuerTestfall() {
        return neuerTestfall;
    }

    public void setNeuerTestfall(Testfall neuerTestfall) {
        this.neuerTestfall = neuerTestfall;
    }

    public List<Testfall> getTestfaelle() {
        return testfaelle;
    }

    public Long getAusgewaehlteAnforderungId() {
        return ausgewaehlteAnforderungId;
    }

    public void setAusgewaehlteAnforderungId(Long ausgewaehlteAnforderungId) {
        this.ausgewaehlteAnforderungId = ausgewaehlteAnforderungId;
    }

    public Testfall getAusgewaehlterTestfall() {
        return ausgewaehlterTestfall;
    }

    public void setAusgewaehlterTestfall(Testfall ausgewaehlterTestfall) {
        this.ausgewaehlterTestfall = ausgewaehlterTestfall;
    }
}


