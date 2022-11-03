package dstrukturen.maeuse;

import dstrukturen.Queue;

public class Test {
    public static void main(String[] args) {
        final long timeStart = System.currentTimeMillis();

        Test t = new Test();
        t.kampfTesten(); // Kampf wird mit mit festen Stärken getestet

        MausKampf mk = new MausKampf();
        mk.zufallsBelegung(5);
        mk.kampfAusfuehren(); // Kampf wird mit zufällligen Stärken getestet

        int[] arr1 = { 7, 6, 5, 4, 3, 2, 8, 9, 1 }; // Ja
        mk.reihenfolgeSimulieren(arr1);
        int[] arr2 = { 1, 3, 4, 6, 7, 10, 9, 11, 12, 8, 5, 2 }; // Ja
        mk.reihenfolgeSimulieren(arr2);
        int[] arr3 = { 4, 5, 3, 1, 2, 6 }; // Nein
        mk.reihenfolgeSimulieren(arr3); // Eine vorgegebene Reihenfolge wird getestet/simuliert

        final long timeEnd = System.currentTimeMillis();
        System.out.println("Zeit des Programms: " + (timeEnd - timeStart) + "ms");
    }

    public void kampfTesten() {
        int[] arr = { 10, 5, 1, 7, 4 }; // Hier Stärken der Mäuse angeben
        Queue<Maus> q = new Queue<Maus>();

        for (int i = 0; i < arr.length; i++) {
            Maus m = new Maus(i + 1, arr[i]);
            q.enqueue(m);
        }

        MausKampf k = new MausKampf();
        k.manuelleBelegung(q);
        k.kampfAusfuehren();
    }
}