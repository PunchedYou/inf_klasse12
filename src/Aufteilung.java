import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Aufteilung {
    private int[] buecher;
    private int anzahlbuch;
    private int anzahldeko;
    private String[] deko;

    public Aufteilung() {
        String datei = "assets/buecherregal6.txt";
        dateiEinlesen(datei);
    }

    /**
     * ! Aufgabe
     * Bücher sotieren
     * Deko-Figuren als Trennung der Abschnitte
     * Bei 4 Figuren zb max. 5 Abschnitte ||||F||F||||||F||F||||||||
     * Breite der Abschnitte egal
     * * In einem Abschnitt vom ERSTEN zum LETZEN Buch nicht größer als 3 cm bzw.
     * 30mm
     */

    public void regalEinrichten() {
        System.out.println("Anzahl der Bücher: " + anzahlbuch);
        System.out.println("Deko die einsotiert werden muss: " + anzahldeko);
        regalSotieren();

        if (lückenFinden()) {
            System.out.println("Die Sortierung ist möglich!");

            for (int i = 0; i < deko.length; i++) {
                if (deko[i] != null) {
                    System.out.println(deko[i]);
                }
            }

        } else {
            System.out.println("Die Sortierung ist nicht möglich!");
        }
    }

    private void regalSotieren() {
        for (int i = 0; i < anzahlbuch; i++) {
            int z = 0;
            for (int j = 0; j < anzahlbuch - 1 - i; j++) {
                if (buecher[j] > buecher[j + 1]) {
                    int temp = buecher[j];
                    buecher[j] = buecher[j + 1];
                    buecher[j + 1] = temp;
                    z += 1;
                }
            }
            if (z <= 1) {
                break;
            }
        }

        System.out.print("Sotierte Bücher: ");

        for (int i : buecher) {
            System.out.print("[" + i + "]");
        }

        System.out.println();
    }

    private boolean lückenFinden() {
        int x = 0;
        int z = 0;
        deko = new String[anzahldeko];

        System.out.println("#Start Lückenzähler!");

        while (x < anzahlbuch - 1) {
            for (int j = x; j <= anzahlbuch; j++) {
                if ((buecher[j] - buecher[x]) > 30) {
                    z++;
                    if (z <= anzahldeko) {
                        deko[z - 1] = "Deko " + z + " befindet zwischen dem Buch " + (j - 1) + " (Höhe: "
                                + buecher[j - 1] + ") und dem Buch " + j + " (Höhe: " + buecher[j] + ").";
                    }
                    x = j;
                    break;
                } else if (j == anzahlbuch - 1) {
                    x = j;
                    break;
                }
            }
        }
        System.out.println("#Ende Lückenzähler!");

        System.out.println("Lücken: " + z);

        if (z <= anzahldeko) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ? Ab hier kommt der File Reader!
     * 
     * @param datei
     */

    private void dateiEinlesen(String datei) {

        File file = new File(datei);

        if (!file.canRead() || !file.isFile())
            System.exit(0);

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(datei));
            String zeile;
            anzahldeko = Integer.parseInt(in.readLine().trim());
            anzahlbuch = Integer.parseInt(in.readLine().trim());
            buecher = new int[anzahlbuch]; // Array der Bücherhöhen erstellen
            int i = 0;
            while ((zeile = in.readLine()) != null) {
                buecher[i] = Integer.parseInt(zeile); // alle Bücherhöhen in das Array schreiben
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
    }
}