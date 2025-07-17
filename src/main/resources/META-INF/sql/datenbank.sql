INSERT INTO benutzer (name, rolle) VALUES ('Max Mustermann', 'Requirements Engineer');
INSERT INTO benutzer (name, rolle) VALUES ('Erika Mustermann', 'Testmanager');
INSERT INTO benutzer (name, rolle) VALUES ('Hans Müller', 'Testfallersteller');

INSERT INTO anforderung (titel, beschreibung) VALUES ('Login Feature', 'Benutzer kann sich einloggen.');
INSERT INTO anforderung (titel, beschreibung) VALUES ('Registrierung Feature', 'Benutzer kann sich registrieren.');
INSERT INTO anforderung (titel, beschreibung) VALUES ('Passwort zurücksetzen', 'Benutzer kann Passwort zurücksetzen.');

INSERT INTO testfall (titel, beschreibung, erwartetes_ergebnis, anforderung_id) VALUES ('Login funktioniert', 'Erfolgreich mit gültigen Daten einloggen', 'Erfolgreich eingeloggt', 1);
INSERT INTO testfall (titel, beschreibung, erwartetes_ergebnis, anforderung_id) VALUES ('Login fehlgeschlagen', 'Mit ungültigem Passwort einloggen', 'Fehler angezeigt', 1);
INSERT INTO testfall (titel, beschreibung, erwartetes_ergebnis, anforderung_id) VALUES ('Registrierung funktioniert', 'Neuen Benutzer anlegen', 'Eintrag in Benutzer-Tabelle', 2);

INSERT INTO testlauf (name, datum, tester_id) VALUES ('Regression Lauf', '2025-07-15', 3);
INSERT INTO testlauf (name, datum, tester_id) VALUES ('Smoke Test Suite', '2025-07-16', 3);

INSERT INTO testfall_testlauf (testfall_id, testlauf_id) VALUES (1, 1);
INSERT INTO testfall_testlauf (testfall_id, testlauf_id) VALUES (2, 1);
INSERT INTO testfall_testlauf (testfall_id, testlauf_id) VALUES (3, 2);

