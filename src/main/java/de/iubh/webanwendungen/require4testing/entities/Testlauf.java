package de.iubh.webanwendungen.require4testing.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "testlauf")
public class Testlauf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date datum;

    @ManyToOne
    @JoinColumn(name = "tester_id")
    private Benutzer tester;

    @ManyToMany(mappedBy = "testlaeufe", fetch = FetchType.EAGER)
    private Set<Testfall> testfaelle = new HashSet<>();


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Benutzer getTester() {
        return tester;
    }

    public void setTester(Benutzer tester) {
        this.tester = tester;
    }

    public Set<Testfall> getTestfaelle() {
        return testfaelle;
    }

    public void setTestfaelle(Set<Testfall> testfaelle) {
        this.testfaelle = testfaelle;
    }
}

