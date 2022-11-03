package dstrukturen.maeuse;

import java.util.Arrays;

import dstrukturen.Queue;
import dstrukturen.Stack;

public class MausKampf {
    Queue<Maus> eingang = new Queue<Maus>();
    Queue<Maus> ausgang = new Queue<Maus>();
    Stack<Maus> stapel = new Stack<Maus>();

    public void zufallsBelegung(int anzahl) {
        for (int i = 1; i <= anzahl; i++) {
            int r = (int) (Math.random() * (20 - 1)) + 1;
            Maus m = new Maus(i, r);
            eingang.enqueue(m);
        }
    }

    public void manuelleBelegung(Queue<Maus> q) {
        while (!q.isEmpty()) {
            eingang.enqueue(q.front());
            q.dequeue();
        }
    }

    public void kampfAusfuehren() {
        while (!eingang.isEmpty() || !stapel.isEmpty()) {
            if (!eingang.isEmpty()) {
                if (stapel.isEmpty()) {
                    stapel.push(eingang.front());
                    eingang.dequeue();
                } else if (eingang.front().getStaerke() > stapel.top().getStaerke()) {
                    stapel.push(eingang.front());
                    eingang.dequeue();
                } else {
                    ausgang.enqueue(stapel.top());
                    stapel.pop();
                }
            } else {
                while (!stapel.isEmpty()) {
                    ausgang.enqueue(stapel.top());
                    stapel.pop();
                }
            }
        }

        System.out.println("Reihenfolge der Mäuse am Käse: ");
        while (!ausgang.isEmpty()) {
            System.out.println(ausgang.front().getNummer() + " (" + ausgang.front().getStaerke() + ")");
            ausgang.dequeue();
        }
    }

    public void reihenfolgeSimulieren(int[] arr) {
        Queue<Maus> teingang = new Queue<Maus>();
        Queue<Maus> tausgang = new Queue<Maus>();
        Stack<Maus> tstapel = new Stack<Maus>();

        for (int i : arr) {
            Maus m = new Maus(i, 0);
            tausgang.enqueue(m);
        }

        Arrays.sort(arr);

        for (int i : arr) {
            Maus m = new Maus(i, 0);
            teingang.enqueue(m);
        }

        for (int i = 0; i < arr.length; i++) {
            if (tstapel.isEmpty()) {
                tstapel.push(teingang.front());
            }

            while (tstapel.top().getNummer() != tausgang.front().getNummer()) {
                if (teingang.isEmpty()) {
                    System.out.println("Die Kombination ist nicht möglich!");
                    return;
                }

                if (!tstapel.isEmpty()) {
                    teingang.front().zGewonnen();
                    tstapel.top().zVerloren();
                }

                tstapel.push(teingang.front());
                teingang.dequeue();
            }

            if (!teingang.isEmpty()) {
                tstapel.top().zGewonnen();
                teingang.front().zVerloren();
            }

            tausgang.enqueue(tstapel.top());
            tausgang.dequeue();
            tstapel.pop();
        }

        System.out.println("Die Kombination ist möglich!");

        while (!tausgang.isEmpty()) {
            System.out.println(tausgang.front().getNummer() + " - Gewonnen: " + tausgang.front().getGewonnen()
                    + " Verloren: " + tausgang.front().getVerloren());
            tausgang.dequeue();
        }
    }
}