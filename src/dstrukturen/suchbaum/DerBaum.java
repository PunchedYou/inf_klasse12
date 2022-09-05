package dstrukturen.suchbaum;

import java.util.Arrays;

import dstrukturen.BinarySearchTree;

public class DerBaum {
    private int tiefe;
    private BinarySearchTree<Zahlenobjekt> sb = new BinarySearchTree<>();

    public DerBaum() {
        baumErstellen(setArray(4));
        System.out.println();
        inorderAusgabe(sb);
    }

    public static void main(String[] args) {
        DerBaum b = new DerBaum();
    }

    public int[] setArray(int tiefe) {
        if (tiefe < 1) {
            tiefe = (int) (Math.random() * 10) + 1;
        }

        this.tiefe = tiefe;

        System.out.println("Tiefe: " + tiefe);

        int x = (int) Math.pow(2, tiefe) - 1;

        System.out.println("Arraylänge: " + x);

        int[] arr = new int[x];

        for (int i = 0; i < x; i++) {
            arr[i] = (int) (Math.random() * 10000) + 1;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        return arr;
    }

    public void baumErstellen(int[] arr) {
        int minuend = arr.length + 1;

        for (int i = 1, j = tiefe - 1; i <= tiefe; i++, j--) {
            int breite = (int) Math.pow(2, (double) i - 1); // Breite in der aktuellen Ebene wird ermittelt (2^i-1)
            int zahl = minuend / (int) Math.pow(2, i); // Linke Zahl der aktuellen Ebene wird ermittelt
            sb.insert(new Zahlenobjekt(arr[zahl - 1]));
            for (int k = 1; k < breite; k++) {
                zahl += 2 * (int) Math.pow(2, j); // Nächste Zahl wird berechnet (2*2^n)
                sb.insert(new Zahlenobjekt(arr[zahl - 1]));
            }
        }
    }

    public void inorderAusgabe(BinarySearchTree<Zahlenobjekt> sb) {
        if (!(sb.getLeftTree().isEmpty())) {
            inorderAusgabe(sb.getLeftTree());
        }
        System.out.print(sb.getContent().getWert() + " ");
        if (!(sb.getRightTree().isEmpty())) {
            inorderAusgabe(sb.getRightTree());
        }
    }
}
