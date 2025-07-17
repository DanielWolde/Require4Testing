package de.iubh.webanwendungen.require4testing.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Testergebnis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;  
    private String kommentar;

    @Column(nullable = false)
    private LocalDateTime erfasstAm = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "testfall_id", nullable = false)
    private Testfall testfall;

    @ManyToOne
    @JoinColumn(name = "testlauf_id")
    private Testlauf testlauf;



    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public LocalDateTime getErfasstAm() {
        return erfasstAm;
    }

    public void setErfasstAm(LocalDateTime erfasstAm) {
        this.erfasstAm = erfasstAm;
    }

    public Testfall getTestfall() {
        return testfall;
    }

    public void setTestfall(Testfall testfall) {
        this.testfall = testfall;
    }

    public Testlauf getTestlauf() {
        return testlauf;
    }

    public void setTestlauf(Testlauf testlauf) {
        this.testlauf = testlauf;
    }
}
