package dstrukturen.huffman;

import dstrukturen.Queue;
import dstrukturen.BinaryTree;

public class Huffman {
    String text;
    int[] anzahl = new int[26];
    Wurzel[] obj;
    BinaryTree<Wurzel> baum;

    public static void main(String[] args) {
        Huffman h = new Huffman("");
    }

    public Huffman(String s) {
        if (s.length() == 0) {
            s = "Dies ist ein Teststring";
        }
        System.out.println("Satz:\n" + s);
        text = s.toUpperCase().replaceAll("\\s+", "");
        zaehleZeichen();
        objekteErstellen();
        baumErstellen();
        preorderAusgabe(baum);
    }

    public void zaehleZeichen() {
        for (int i = 0; i < text.length(); i++) {
            anzahl[text.charAt(i) - 65]++;
        }

        for (int a : anzahl) {
            System.out.print(a + " ");
        }

        System.out.println();
    }

    public void objekteErstellen() {
        int z = 0;

        for (int i = 0; i < anzahl.length; i++) {
            if (anzahl[i] != 0) {
                z++;
            }
        }

        obj = new Wurzel[z];

        for (int i = 0; i < z; i++) {
            int min = Integer.MAX_VALUE;
            int pos = 0;

            for (int j = 0; j < anzahl.length; j++) {
                if (anzahl[j] != 0 && anzahl[j] < min) {
                    min = anzahl[j];
                    pos = j;
                }
            }
            obj[i] = new Wurzel((char) (pos + 65), min);
            anzahl[pos] = 0;
        }

        for (Wurzel w : obj) {
            System.out.println(w.getBuchstabe() + " - " + w.getHaufigkeit());
        }
    }

    public void baumErstellen() {
        Queue<BinaryTree<Wurzel>> q = new Queue<>();
        Queue<BinaryTree<Wurzel>> tmp = new Queue<>();

        for (int i = 0; i < obj.length; i++) {
            BinaryTree<Wurzel> bt = new BinaryTree<>(obj[i]);
            q.enqueue(bt);
        }

        for (int i = 0; i < (obj.length - 1) / 2; i++) {
            while (!q.isEmpty()) {
                BinaryTree<Wurzel> left = q.front();
                q.dequeue();
                if (!q.isEmpty()) {
                    BinaryTree<Wurzel> right = q.front();
                    q.dequeue();
                    int sum = left.getContent().getHaufigkeit() + right.getContent().getHaufigkeit();
                    tmp.enqueue(new BinaryTree<>(new Wurzel(sum), left, right));
                } else {
                    tmp.enqueue(left);
                    break;
                }
            }
            while (!tmp.isEmpty()) {
                q.enqueue(tmp.front());
                tmp.dequeue();
            }
        }

        while (!q.isEmpty()) {
            baum = q.front();
            q.dequeue();
        }
    }

    public void preorderAusgabe(BinaryTree<Wurzel> bt) {
        System.out.print("> ( " + bt.getContent().getBuchstabe() + " | " + bt.getContent().getHaufigkeit() + " ) ");
        if (!(bt.getLeftTree().isEmpty())) {
            preorderAusgabe(bt.getLeftTree());
        }
        if (!(bt.getRightTree().isEmpty())) {
            preorderAusgabe(bt.getRightTree());
        }
    }
}
