package zellen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ZweiteGeneration implements ActionListener {
    private JFrame window = new JFrame("Eine Generation");
    JButton[][] button = new JButton[100][100];
    int count = 0;

    public ZweiteGeneration() {
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

    public static void main(String[] args) {
        ZweiteGeneration g = new ZweiteGeneration();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        g.generationenErstellen();
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

    public void generationenErstellen() {

    }

    // TODO
}