package dstrukturen.biber;

import dstrukturen.Queue;
import dstrukturen.Stack;

// Seite 64; Aufgabe 3c; 10.05.22
public class Aufgabe {
    Queue<Biber> biber = new Queue<>();
    Stack<Teller> teller = new Stack<>();
    int laenge;

    public Aufgabe(int laenge) {
        this.laenge = laenge;
    }

    public static void main(String[] args) {
        Aufgabe a = new Aufgabe(20);
        a.erzeugeGleichheit();
        System.out.println(a.ueberpruefeGleichheit());
    }

    public void setSchlange() {
        for (int i = 0; i < laenge; i++) {
            Biber b = new Biber(getRandom());
            biber.enqueue(b);
        }
    }

    public void setStapel() {
        for (int i = 0; i < laenge; i++) {
            Teller t = new Teller(getRandom());
            teller.push(t);
        }
    }

    public boolean ueberpruefeGleichheit() {
        while (!biber.isEmpty() && !teller.isEmpty()) {
            if (biber.front().getGroesse() == teller.top().getTiefe()) {
                biber.dequeue();
                teller.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public void erzeugeGleichheit() {
        int[] match = new int[laenge];
        for (int i = 0; i < laenge; i++) {
            int rand = getRandom();
            Biber b = new Biber(rand);
            biber.enqueue(b);
            match[i] = rand;
            System.out.print(rand);
        }

        System.out.println();

        for (int i = (laenge - 1); i >= 0; --i) {
            System.out.print(match[i]);
            Teller t = new Teller(match[i]);
            teller.push(t);
        }

        System.out.println();
    }

    public int getRandom() {
        if (Math.random() < 0.5) {
            return 0;
        } else {
            return 1;
        }
    }
}
