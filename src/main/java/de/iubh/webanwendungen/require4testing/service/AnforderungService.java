package de.iubh.webanwendungen.require4testing.service;

import java.util.List;
import de.iubh.webanwendungen.require4testing.entities.Anforderung;

public interface AnforderungService {
    Anforderung createAnforderung(Anforderung a);
    Anforderung updateAnforderung(Anforderung a);
    void removeAnforderung(Long id);
    Anforderung getAnforderung(Long id);
    List<Anforderung> listAnforderungen();
}
