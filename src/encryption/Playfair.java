package encryption;

import java.awt.Point;

public class Playfair {
    private char[][] square;

    // Playfair Verschlüsseln

    public String playfairCrypt(String text, String s, boolean decrypt) {
        createSquare(s);
        String res = "";
        System.out.println("Klartext/Chiffre: " + text + "\nSchlüssel: " + s + " (Decrypt? " + decrypt + ")");
        text = formatString(text);
        text = pushDuplicates(text);

        if (text.length() % 2 != 0) {
            text += "X";
        }

        for (int i = 0; i <= text.length() - 1; i += 2) {
            res += cryptPair(getPosition(text.charAt(i)), getPosition(text.charAt(i + 1)), decrypt);
        }
        System.out.println("--> " + res);
        return res;
    }

    private String cryptPair(Point a, Point b, boolean decrypt) {
        String res = "";
        int x;

        if (decrypt) {
            x = 4;
        } else {
            x = 1;
        }

        if (a.getX() == b.getX()) {
            res += square[((int) a.getY() + x) % 5][(int) a.getX()] + ""
                    + square[((int) b.getY() + x) % 5][(int) b.getX()];
        } else if (a.getY() == b.getY()) {
            res += square[(int) a.getY()][((int) a.getX() + x) % 5] + ""
                    + square[(int) b.getY()][((int) b.getX() + x) % 5];
        } else {
            res += square[(int) a.getY()][(int) b.getX()] + "" + square[(int) b.getY()][(int) a.getX()];
        }

        return res;
    }

    // Findet Doppel-Buchstaben und fügt X ein

    private String pushDuplicates(String k) {
        for (int i = 0; i < k.length() - 1; i++) {
            if (k.charAt(i) == k.charAt(i + 1)) {
                k = k.substring(0, i + 1) + 'X' + k.substring(i + 1);
            }
        }

        return k;
    }

    // Sucht Buchstaben in Quadrat

    private Point getPosition(char b) {
        Point p = new Point(0, 0);

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (square[y][x] == b) {
                    p = new Point(x, y);
                }
            }
        }

        return p;
    }

    // Erstellt das Verschlüsselungs-Quadrat

    private void createSquare(String s) {
        square = new char[5][5];
        s = formatString(s);
        s += "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        int stelle = 0;
        for (int y = 0; y < 5; y++) {
            int x = 0;
            while (x < 5) {
                if (!isInSquare(s.charAt(stelle))) {
                    square[y][x] = s.charAt(stelle);
                    x++;
                }
                stelle++;
            }
        }

        printSquare();
    }

    // Zeigt das Verschlüsselungs-Quadrat an

    private void printSquare() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(square[y][x] + "  ");
            }
            System.out.println();
        }
    }

    // Schaut ob ein Buchstabe schon im Quadrat ist

    private boolean isInSquare(char b) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (square[y][x] == b) {
                    return true;
                }
            }
        }

        return false;
    }

    // Entfernt unerwünschte Zeichen im String

    private String formatString(String w) {
        w = w.toUpperCase();
        w = w.replaceAll("[^A-Z]", "");
        w = w.replaceAll("J", "I");
        return w;
    }

    public static void main(String[] args) {
        Playfair pf = new Playfair();
        String test = pf.playfairCrypt("Dies ist ein Beispielklartext", "Mittwoch", false);
        pf.playfairCrypt(test, "Mittwoch", true);
    }
}
