package de.iubh.webanwendungen.require4testing.beans;

import de.iubh.webanwendungen.require4testing.entities.Testergebnis;
import de.iubh.webanwendungen.require4testing.entities.Testfall;
import de.iubh.webanwendungen.require4testing.entities.Testlauf;
import de.iubh.webanwendungen.require4testing.entities.Benutzer;
import de.iubh.webanwendungen.require4testing.service.TestergebnisService;
import de.iubh.webanwendungen.require4testing.service.TestfallService;
import de.iubh.webanwendungen.require4testing.service.TestlaufService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Named
@ViewScoped
public class TestergebnisBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Testergebnis neuesErgebnis = new Testergebnis();
    private Long ausgewaehlterTestlaufId;
    private Long ausgewaehlterTestfallId;
    private List<Testergebnis> alleErgebnisse;

    @Inject private TestergebnisService ergebnisService;
    @Inject private TestlaufService      testlaufService;
    @Inject private TestfallService      testfallService;
    @Inject private LoginBean            loginBean;

    @PostConstruct
    public void init() {
        ladeDatenNeu();
    }

    public void ladeDatenNeu() {
        Benutzer b = loginBean.getAktuellerBenutzer();
        this.alleErgebnisse = (b != null)
            ? ergebnisService.getByTesterId(b.getId())
            : List.of();
        this.ausgewaehlterTestlaufId = null;
        this.ausgewaehlterTestfallId = null;
        this.neuesErgebnis = new Testergebnis();
    }

    public void onLaufChange() {
    }

    public void speichern() {
        if (ausgewaehlterTestlaufId != null && ausgewaehlterTestfallId != null) {
            Testlauf lauf = testlaufService.getById(ausgewaehlterTestlaufId);
            Testfall fall = testfallService.getById(ausgewaehlterTestfallId);
            neuesErgebnis.setTestlauf(lauf);
            neuesErgebnis.setTestfall(fall);
            neuesErgebnis.setErfasstAm(LocalDateTime.now());
            ergebnisService.save(neuesErgebnis);
            ladeDatenNeu();
        }
    }

    public List<Testergebnis> getAlleErgebnisse() { return alleErgebnisse; }
    public Testergebnis getNeuesErgebnis() { return neuesErgebnis; }

    public Long getAusgewaehlterTestlaufId() { return ausgewaehlterTestlaufId; }
    public void setAusgewaehlterTestlaufId(Long id) { this.ausgewaehlterTestlaufId = id; }

    public Long getAusgewaehlterTestfallId() { return ausgewaehlterTestfallId; }
    public void setAusgewaehlterTestfallId(Long id) { this.ausgewaehlterTestfallId = id; }

    public List<Testlauf> getZugewieseneTestlaeufe() {
        Benutzer b = loginBean.getAktuellerBenutzer();
        return (b != null)
             ? testlaufService.getByTesterId(b.getId())
             : List.of();
    }

    public List<Testfall> getTestfaelleDesAusgewaehltenLaufs() {
        if (ausgewaehlterTestlaufId == null) {
            return List.of();
        }
        return testfallService.getByTestlaufId(ausgewaehlterTestlaufId);
    }
}

