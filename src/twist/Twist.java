package twist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class Twist {
    private String dateiName;
    String s = "";

    public Twist() {
        dateiName = "twistIN.txt";
        File file = new File(dateiName);
        if (!file.canRead() || !file.isFile()) {
            System.exit(0);
        }
        dateiEinlesen();
    }

    public static void main(String[] args) {
        Twist t = new Twist();
        t.woerterTwisten();
    }

    public void woerterTwisten() {
        // Wörter auf Array aufspalten
        s = s.trim();
        String[] sl = s.split("\\s+");
        String f = "";

        // Wörter durchlaufen
        for (int i = 0; i < sl.length; i++) {
            sl[i] = sl[i].trim();

            if (sl[i].length() < 3) {
                f += sl[i] + " ";
                continue;
            }

            String a = "";
            String b = "";

            // Zeichen vorne
            while (zeichenTest(sl[i].charAt(0))) {
                a += Character.toString(sl[i].charAt(0));
                StringBuilder sb = new StringBuilder(sl[i]);
                sb.deleteCharAt(0);
                sl[i] = sb.toString();
            }

            // Zeichen hinten
            while (zeichenTest(sl[i].charAt(sl[i].length() - 1))) {
                b += Character.toString(sl[i].charAt(sl[i].length() - 1));
                StringBuilder sb = new StringBuilder(sl[i]);
                sb.deleteCharAt((sl[i].length() - 1));
                sl[i] = sb.toString();
            }

            // erster Buchstabe wird angehängt
            f += a + sl[i].charAt(0);

            // mittlerere Buchstaben werden getwistet
            int[] zufall = zufaelligeZahl(sl[i].length() - 2);

            for (int g = 0; g < sl[i].length() - 2; g++) {
                f += sl[i].charAt(zufall[g]);
            }

            // letzter Buchstabe wird angehängt
            f += sl[i].charAt(sl[i].length() - 1) + b;

            f += " ";
        }

        dateiErstellen(f);
    }

    private int[] zufaelligeZahl(int max) {
        int[] zahlen = new int[max];

        for (int i = 0, g = 1; i < zahlen.length; i++, g++) {
            zahlen[i] = g;
        }

        for (int i = 0; i < zahlen.length; i++) {
            int pos = (int) (Math.random() * zahlen.length);

            int temp = zahlen[i];
            zahlen[i] = zahlen[pos];
            zahlen[pos] = temp;
        }

        return zahlen;
    }

    private boolean zeichenTest(char c) {
        if ((c > 96 && c < 123) || c > 64 && c < 91) {
            return false;
        } else { // Andere Symbole
            return true;
        }
    }

    private void dateiEinlesen() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(dateiName));

            String zeile = null;

            while ((zeile = in.readLine()) != null) {
                s += zeile + " ";
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dateiErstellen(String f) {
        String s = f;

        try {
            File output = new File("twistOUT.txt");

            if (!output.exists()) {
                output.createNewFile();
            }

            OutputStream stream = new FileOutputStream(output);

            try {
                stream.write(s.getBytes());
                stream.close();
                System.out.println("> twistOUT.txt gespeichert! <");

            } catch (IOException e) {
                e.printStackTrace();

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}