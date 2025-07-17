package de.iubh.webanwendungen.require4testing.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "testfall")
public class Testfall implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titel;

    private String beschreibung;

    @Column(name = "testschritte", columnDefinition = "TEXT")
    private String testschritte;

    @Column(name = "erwartetes_ergebnis")
    private String erwartetesErgebnis;

    @ManyToOne
    @JoinColumn(name = "anforderung_id")
    private Anforderung anforderung;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
      name = "testfall_testlauf",
      joinColumns = @JoinColumn(name = "testfall_id"),
      inverseJoinColumns = @JoinColumn(name = "testlauf_id")
    )
    private Set<Testlauf> testlaeufe = new HashSet<>();

 

    public Long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getTestschritte() {
        return testschritte;
    }

    public void setTestschritte(String testschritte) {
        this.testschritte = testschritte;
    }

    public String getErwartetesErgebnis() {
        return erwartetesErgebnis;
    }

    public void setErwartetesErgebnis(String erwartetesErgebnis) {
        this.erwartetesErgebnis = erwartetesErgebnis;
    }

    public Anforderung getAnforderung() {
        return anforderung;
    }

    public void setAnforderung(Anforderung anforderung) {
        this.anforderung = anforderung;
    }

    public Set<Testlauf> getTestlaeufe() {
        return testlaeufe;
    }

    public void setTestlaeufe(Set<Testlauf> testlaeufe) {
        this.testlaeufe = testlaeufe;
    }
}
