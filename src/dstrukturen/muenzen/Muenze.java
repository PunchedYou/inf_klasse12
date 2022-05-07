package dstrukturen.muenzen;

import java.util.Random;

public class Muenze {
    private int wert;

    public Muenze(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int a) {
        wert = a;
    }

    public void randomWert() {
        int[] arr = { 10, 20, 50, 100, 200 };
        Random r = new Random();
        wert = arr[r.nextInt(arr.length)];
    }
}
