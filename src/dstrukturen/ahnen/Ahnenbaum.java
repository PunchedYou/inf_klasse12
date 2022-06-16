package dstrukturen.ahnen;

import dstrukturen.BinaryTree;

public class Ahnenbaum {
    BinaryTree<Ahne> baum;

    public Ahnenbaum() {
        baumErstellen();
        System.out.print("\nPreoder: ");
        preorderAusgabe(baum);
        System.out.print("\nPostorder: ");
        postorderAusgabe(baum);
        System.out.print("\nInorder: ");
        inorderAusgabe(baum);
        System.out.println("\nAnzahl der Knoten: " + zaehleKnoten(baum) + 1);
    }

    public void baumErstellen() {
        Ahne lisa = new Ahne("Lisa", "Simpson", 'w');
        Ahne marge = new Ahne("Marge", "Simpson", 'w');
        Ahne homer = new Ahne("Homer", "Simpson", 'm');
        Ahne jacqueline = new Ahne("Jacqueline", "Bouvier", 'w');
        Ahne clancy = new Ahne("Clancy", "Bouvier", 'm');
        Ahne mona = new Ahne("Mona", "Simpson", 'w');
        Ahne abraham = new Ahne("Abraham J.", "Simpson", 'm');

        BinaryTree<Ahne> b1 = new BinaryTree<>(jacqueline);
        BinaryTree<Ahne> b2 = new BinaryTree<>(clancy);
        BinaryTree<Ahne> b3 = new BinaryTree<>(marge, b1, b2);
        BinaryTree<Ahne> b4 = new BinaryTree<>(mona);
        BinaryTree<Ahne> b5 = new BinaryTree<>(abraham);
        BinaryTree<Ahne> b6 = new BinaryTree<>(homer, b4, b5);
        baum = new BinaryTree<>(lisa, b3, b6);
    }

    public void preorderAusgabe(BinaryTree<Ahne> bt) {
        System.out.print(bt.getContent().getVorname() + " " + bt.getContent().getNachname() + "; ");
        if (!(bt.getLeftTree().isEmpty())) {
            preorderAusgabe(bt.getLeftTree());
        }
        if (!(bt.getRightTree().isEmpty())) {
            preorderAusgabe(bt.getRightTree());
        }
    }

    public void postorderAusgabe(BinaryTree<Ahne> bt) {
        if (!(bt.getLeftTree().isEmpty())) {
            preorderAusgabe(bt.getLeftTree());
        }
        if (!(bt.getRightTree().isEmpty())) {
            preorderAusgabe(bt.getRightTree());
        }
        System.out.print(bt.getContent().getVorname() + " " + bt.getContent().getNachname() + "; ");
    }

    public void inorderAusgabe(BinaryTree<Ahne> bt) {
        if (!(bt.getLeftTree().isEmpty())) {
            preorderAusgabe(bt.getLeftTree());
        }
        System.out.print(bt.getContent().getVorname() + " " + bt.getContent().getNachname() + "; ");
        if (!(bt.getRightTree().isEmpty())) {
            preorderAusgabe(bt.getRightTree());
        }
    }

    public int zaehleKnoten(BinaryTree<Ahne> bt) {
        int z = 0;
        if (!bt.getLeftTree().isEmpty()) {
            z += zaehleKnoten(bt.getLeftTree());
            z++;
        }
        if (!bt.getRightTree().isEmpty()) {
            z += zaehleKnoten(bt.getRightTree());
            z++;
        }
        return z;
    }
}