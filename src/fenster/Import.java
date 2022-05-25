package fenster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Import {
    public Import() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Bild.txt"));
        String[] xy = reader.readLine().split(" ");
        Fenster fenster = new Fenster(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
        String bild = reader.readLine();
        fenster.bildImportieren(bild);
        reader.close();
    }
}