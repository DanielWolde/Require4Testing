package de.iubh.webanwendungen.require4testing.beans;

import de.iubh.webanwendungen.require4testing.entities.Benutzer;
import de.iubh.webanwendungen.require4testing.service.BenutzerService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long selectedUserId;
    private Benutzer aktuellerBenutzer;

    @Inject private BenutzerService benutzerService;

    public String changeUser() {
        if (selectedUserId != null) {
            aktuellerBenutzer = benutzerService.getById(selectedUserId);
        }
        return "testergebnisse.xhtml?faces-redirect=true";
    }

    public List<Benutzer> getAllBenutzer() {
        return benutzerService.getAll();
    }

    public Long getSelectedUserId() {
        return selectedUserId;
    }
    public void setSelectedUserId(Long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public Benutzer getAktuellerBenutzer() {
        return aktuellerBenutzer;
    }

    public boolean istEingeloggt() {
        return aktuellerBenutzer != null;
    }

    public String logout() {
        aktuellerBenutzer = null;
        return "login.xhtml?faces-redirect=true";
    }
}
