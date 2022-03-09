package zellen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ErsteGeneration implements ActionListener {
    private JFrame window = new JFrame("Eine Generation");
    JButton[][] button = new JButton[100][100];
    int count = 0;

    public ErsteGeneration() {
        // Instanzvariable initialisieren
        window.setSize(1000, 1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(button.length, button[0].length));

        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton("");
                window.add(button[i][j]);
                button[i][j].setBackground(Color.WHITE);
                button[i][j].addActionListener(this);
            }
        }
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                if (e.getSource() == button[i][j]) {
                    if (button[i][j].getBackground() == Color.WHITE) {
                        button[i][j].setBackground(Color.BLACK);
                    } else if (button[i][j].getBackground() == Color.BLACK) {
                        button[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        }
    }

    public void nummeriere() {
        for (int i = 0; i < button.length; i++) {
            for (int z = 0; z < button[i].length; z++) {
                JButton b = button[i][z];
                if (b.getBackground() == Color.white) {
                    b.setText("Stelle: " + (z));
                }
            }
        }
    }

    public void generationErstellen() {
        if (button[0][1].getBackground() == Color.BLACK) {
            button[1][0].setBackground(Color.BLACK);
        }
        for (int i = 1; i < button[0].length - 1; i++) {
            if ((button[0][i - 1].getBackground() == Color.BLACK) != (button[0][i + 1]
                    .getBackground() == Color.BLACK)) {
                button[1][i].setBackground(Color.BLACK);
            }
        }
        if (button[0][button[0].length - 2].getBackground() == Color.BLACK) {
            button[1][button[0].length - 1].setBackground(Color.BLACK);
        }
    }

    public void generationenErstellen() {
        for (int y = 0; y < button.length - 1; y++) {
            if (button[y][1].getBackground() == Color.BLACK) {
                button[y + 1][0].setBackground(Color.BLACK);
            }
            for (int i = 1; i < button[y].length - 1; i++) {
                if ((button[y][i - 1].getBackground() == Color.BLACK) != (button[y][i + 1]
                        .getBackground() == Color.BLACK)) {
                    button[y + 1][i].setBackground(Color.BLACK);
                }
            }
            if (button[y][button[0].length - 2].getBackground() == Color.BLACK) {
                button[y + 1][button[0].length - 1].setBackground(Color.BLACK);
            }
        }
    }
}