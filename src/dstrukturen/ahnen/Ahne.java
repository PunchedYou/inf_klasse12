package dstrukturen.ahnen;

public class Ahne {
    private String vorname;
    private String nachname;
    private char geschlecht;

    public Ahne(String vorname, String nachname, char geschlecht) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public char getGeschlecht() {
        return geschlecht;
    }
}