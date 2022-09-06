package dstrukturen.suchbaum;

import java.util.Arrays;

import dstrukturen.BinarySearchTree;

public class DerBaum {
    private int n;
    private BinarySearchTree<Zahlenobjekt> sb = new BinarySearchTree<>();

    public DerBaum(int tiefe) {
        baumErstellen(setArray(tiefe));

        System.out.print("Baum:  ");
        inorderAusgabe(sb);
        System.out.println("\n");
    }

    public int[] setArray(int n) {
        if (n < 1) {
            n = (int) (Math.random() * (10 - 1)) + 1;
        }

        this.n = n;

        System.out.println("Tiefe: " + n);

        int x = (int) Math.pow(2, n) - 1;

        System.out.println("Länge: " + x);

        int[] arr = new int[x];

        for (int i = 0; i < x; i++) {
            arr[i] = (int) (Math.random() * (10000 - 1)) + 1;
        }

        Arrays.sort(arr);

        System.out.print("Array: ");

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        return arr;
    }

    public void baumErstellen(int[] arr) {
        int minuend = arr.length + 1;

        for (int i = 1, j = n - 1; i <= n; i++, j--) {
            int breite = (int) Math.pow(2, (double) i - 1); // Breite in der aktuellen Ebene wird ermittelt (2^i-1)
            int zahl = minuend / (int) Math.pow(2, i); // Linke Zahl der aktuellen Ebene wird ermittelt (x-2^i)
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