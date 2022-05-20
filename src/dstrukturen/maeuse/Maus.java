package dstrukturen.maeuse;

public class Maus {
    private int nummer;
    private int staerke;
    private int gewonnen;
    private int verloren;

    public Maus(int nummer, int staerke) {
        this.nummer = nummer;
        this.staerke = staerke;
    }

    public int getNummer() {
        return nummer;
    }

    public int getStaerke() {
        return staerke;
    }

    public int getGewonnen() {
        return gewonnen;
    }

    public int getVerloren() {
        return verloren;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public void zGewonnen() {
        this.gewonnen += 1;
    }

    public void zVerloren() {
        this.verloren += 1;
    }
}