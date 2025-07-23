package de.iubh.webanwendungen.require4testing.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "benutzer")
public class Benutzer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rolle;

    @OneToMany(mappedBy = "tester", fetch = FetchType.LAZY)
    private List<Testlauf> testlaeufe;



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public List<Testlauf> getTestlaeufe() {
        return testlaeufe;
    }

    public void setTestlaeufe(List<Testlauf> testlaeufe) {
        this.testlaeufe = testlaeufe;
    }
}
