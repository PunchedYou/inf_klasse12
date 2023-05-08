package fenster;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenster implements ActionListener {
    private JFrame window = new JFrame("Zufalls Farben");
    private JButton[][] button;
    // Color[] colors = { Color.BLACK, Color.WHITE };
    // Color[] colors = { Color.RED, Color. GREEN, Color.BLUE}
    Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };
    Farben f = new Farben(false);


    public static void main(String[] args) {
        Fenster f = new Fenster(100, 100);
    }


    public Fenster() {
        bildImportieren(true);
    }

    public Fenster(int x, int y) {
        createWindow(x, y);
        zufaelligeFarben();
        bildAusgeben();
    }

    private void createWindow(int x, int y) {
        button = new JButton[x][y];

        window.setSize(1000, 1000);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(button.length, button[0].length));

        int z = 1;

        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton("");
                window.add(button[i][j]);
                button[i][j].setText(Integer.toString(z));
                z++;
            }
        }

        button[0][0].addActionListener(this);
        window.setVisible(true);
    }

    public void zufaelligeFarben() {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                int r = (int) (Math.random() * colors.length);
                button[i][j].setBackground(colors[r]);
            }
        }
    }

    public String feldEinzelnEinlesen() {
        String bild = "";

        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                bild += f.getCode(button[i][j].getBackground());
            }
        }

        return bild;
    }

    public String feldGruppenEinlesen() {
        String bild = "";

        Color last = button[0][0].getBackground();
        int z = 0;

        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                if (button[i][j].getBackground().equals(last)) {
                    z++;
                } else {
                    bild += Integer.toString(z) + f.getCode(last);
                    z = 1;
                }
                last = button[i][j].getBackground();
            }
        }
        bild += Integer.toString(z) + f.getCode(last);

        return bild;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[0][0]) {
            zufaelligeFarben();
            bildAusgeben();
        }
    }

    public void bildAusgeben() {
        String einzeln = feldEinzelnEinlesen();
        String gruppen = feldGruppenEinlesen();
        System.out.println(einzeln.substring(0, 50) + "...");
        System.out.println("Gesamte Länge: " + einzeln.length());
        System.out.println(gruppen.substring(0, 50) + "...");
        System.out.println("Gesamte Länge: " + gruppen.length());
        System.out.println();
    }

    public String bildExportieren() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Bild.txt"))) {
            writer.write(button[0].length + " " + button.length);
            writer.write("\n" + feldEinzelnEinlesen());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Export war erfolgreich!";
    }

    public String bildImportieren(boolean init) {
        String pic = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("Bild.txt"))) {
            String[] size = reader.readLine().split(" ");
            if (init) {
                createWindow(Integer.parseInt(size[0]), Integer.parseInt(size[1]));
            } else if (Integer.parseInt(size[1]) != button.length || Integer.parseInt(size[0]) != button[0].length) {
                return "Datei hat die falsche Größe!";
            }
            pic = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                char c = pic.charAt(Integer.parseInt(button[i][j].getText()) - 1);
                button[i][j].setBackground(f.getColor(String.valueOf(c)));
            }
        }

        return "Import war erfolgreich!";
    }
}