package dstrukturen.dynarray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import dstrukturen.DynArray;

public class ZeilenweiseAuslesen {
    String dateiName;
    DynArray<String> dynarr = new DynArray<>();

    ZeilenweiseAuslesen(String dateiName) {
        this.dateiName = dateiName;
        File file = new File(dateiName);
        if (!file.canRead() || !file.isFile()) {
            System.exit(0);
        }
        dateiLesen();
        aufgabeLoesen();
    }

    public void dateiLesen() {
        try (BufferedReader in = new BufferedReader(new FileReader(dateiName))) {
            int i = 0;
            String line;
            while ((line = in.readLine()) != null) {
                dynarr.append(line);
                i++;
            }
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aufgabeLoesen() {
        for (int i = 0; i < dynarr.getLength(); i++) {
            System.out.println(dynarr.getItem(i));
        }

        for (int i = 0; i < dynarr.getLength(); i++) {
            for (int j = i + 1; j < dynarr.getLength(); j++) {
                

            }
        }
    }
}
