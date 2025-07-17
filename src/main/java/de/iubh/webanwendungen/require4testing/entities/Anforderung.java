package de.iubh.webanwendungen.require4testing.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "anforderung")
public class Anforderung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titel;

    @Column(length = 1000)
    private String beschreibung;

    @OneToMany(mappedBy = "anforderung",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Testfall> testfaelle = new ArrayList<>();



    public Anforderung() { }

    public Anforderung(String titel, String beschreibung) {
        this.titel = titel;
        this.beschreibung = beschreibung;
    }

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

    public List<Testfall> getTestfaelle() {
        return testfaelle;
    }

    public void addTestfall(Testfall tf) {
        if (tf != null) {
            testfaelle.add(tf);
            tf.setAnforderung(this);
        }
    }

    public void removeTestfall(Testfall tf) {
        if (tf != null && testfaelle.remove(tf)) {
            tf.setAnforderung(null);
        }
    }
}
