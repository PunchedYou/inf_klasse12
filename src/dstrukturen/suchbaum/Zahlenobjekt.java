package dstrukturen.suchbaum;

/**
 * @author Sauerstein
 * @version erster Versuch mit den NRW-Klassen
 */

public class Zahlenobjekt implements ComparableContent<Zahlenobjekt> {
    private int x;

    public Zahlenobjekt(int y) {
        x = y;
    }

    public int getWert() {
        return x;
    }

    public boolean isGreater(Zahlenobjekt x) {
        return this.getWert() - x.getWert() > 0;
    }

    public boolean isLess(Zahlenobjekt x) {
        return this.getWert() - x.getWert() < 0;
    }

    public boolean isEqual(Zahlenobjekt x) {
        return this.getWert() - x.getWert() == 0;
    }

}
