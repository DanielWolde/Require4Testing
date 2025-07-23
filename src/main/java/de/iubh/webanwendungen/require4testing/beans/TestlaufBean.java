package de.iubh.webanwendungen.require4testing.beans;

import de.iubh.webanwendungen.require4testing.entities.Benutzer;
import de.iubh.webanwendungen.require4testing.entities.Testfall;
import de.iubh.webanwendungen.require4testing.entities.Testlauf;
import de.iubh.webanwendungen.require4testing.service.BenutzerService;
import de.iubh.webanwendungen.require4testing.service.TestfallService;
import de.iubh.webanwendungen.require4testing.service.TestlaufService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class TestlaufBean {

    private Testlauf neuerTestlauf = new Testlauf();
    private List<Long> ausgewaehlteTestfallIds = new ArrayList<>();
    private Long testerId;

    @Inject private TestlaufService testlaufService;
    @Inject private TestfallService testfallService;
    @Inject private BenutzerService benutzerService;

    public void speichern() {
     
        Set<Testfall> tfSet = ausgewaehlteTestfallIds.stream()
            .map(testfallService::getById)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
        neuerTestlauf.setTestfaelle(tfSet);

        if (testerId != null) {
            Benutzer tester = benutzerService.getById(testerId);
            neuerTestlauf.setTester(tester);
        }

   
        testlaufService.add(neuerTestlauf);

      
        for (Testfall tf : tfSet) {
            tf.getTestlaeufe().add(neuerTestlauf);
            testfallService.update(tf);
        }

        // 5) Reset
        neuerTestlauf = new Testlauf();
        ausgewaehlteTestfallIds.clear();
        testerId = null;
    }

   
    public List<Testlauf> getTestlaeufe() {
        return testlaufService.getAll();
    }

    public List<Testfall> getAlleTestfaelle() {
        return testfallService.getAll();
    }

    public List<Benutzer> getAlleTester() {
        return benutzerService.getAll();
    }

    public Testlauf getNeuerTestlauf() {
        return neuerTestlauf;
    }
    public void setNeuerTestlauf(Testlauf t) {
        this.neuerTestlauf = t;
    }

    public List<Long> getAusgewaehlteTestfallIds() {
        return ausgewaehlteTestfallIds;
    }
    public void setAusgewaehlteTestfallIds(List<Long> ids) {
        this.ausgewaehlteTestfallIds = ids;
    }

    public Long getTesterId() {
        return testerId;
    }
    public void setTesterId(Long id) {
        this.testerId = id;
    }
}
