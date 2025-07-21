Require4Testing

Unter dem Link ist die Applikation erreichbar. 
http://localhost:8080/Artikelverwaltung/overview.xhtml

- Tomcat läuft lokal auf Port 8080
- Standard-Startseite: overview.xhtml
- Datenbankname ist: artikelverwaltung

  
Tabellen und Testdaten werden automatisch vom Projekt erstellt:

- Durch persistence.xml (drop-and-create)
- Durch datenbank.sql (CREATE TABLE + INSERT)

Vorraussetzung hierfür ist das die lokale Datenbank artikelverwaltung heißt.
