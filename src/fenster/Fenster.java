package fenster;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
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
    Farben f = new Farben();

    public Fenster(int x, int y) {
        button = new JButton[x][y];
        window.setSize(1000, 1000);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(button.length, button[0].length));

        int z = 1;

        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton("");
                window.add(button[i][j]);
                button[i][j].setBackground(Color.WHITE);
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
            System.out.println(feldEinzelnEinlesen().substring(0, 10) + "...");
            System.out.println(feldEinzelnEinlesen().length());
            System.out.println(feldGruppenEinlesen().length());
            System.out.println();
        }
    }

    public void bildExportieren() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Bild.txt"));
        writer.write(button[0].length + " " + button.length);
        writer.write("\n" + feldEinzelnEinlesen());
        writer.close();
    }

    public void bildImportieren(String s) {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                char c = s.charAt(Integer.parseInt(button[i][j].getText()) - 1);
                button[i][j].setBackground(f.getColor(c));
            }
        }
    }
}