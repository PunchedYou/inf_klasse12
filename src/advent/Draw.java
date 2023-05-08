package advent;

import java.util.Scanner;

public class Draw {
    static char[][] field;
    static int width;
    static int height;
    static int px = 0;
    static int py = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] size = sc.nextLine().split(" ");
        width = Integer.parseInt(size[0]);
        height = Integer.parseInt(size[1]);
        field = new char[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                field[y][x] = '-';
            }
        }

        int n = sc.nextInt();
        String line;

        for (int i = 0; i <= n; i++) {
            line = sc.nextLine();

            if (line.startsWith("m")) {
                move(line.split(" ")[1]);
            } else if (line.startsWith("s")) {
                set(line.split(" ")[1]);
            } else if (line.startsWith("c")) {
                set("-");
            }
        }

        sc.close();
        print();
    }

    public static void move(String d) {
        if (d.equals("right")) {
            px++;
            if (px > width) {
                px -= width;
            }
        } else if (d.equals("left")) {
            px--;
            if (px < 0) {
                px += width;
            }
        } else if (d.equals("up")) {
            py--;
            if (py < 0) {
                py += height;
            }
        } else if (d.equals("down")) {
            py++;
            if (px > height) {
                px -= height;
            }
        }
    }

    public static void set(String c) {
        field[py][px] = c.charAt(0);
    }

    public static void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < height; x++) {
                System.out.print(field[y][x]);
            }
            System.out.println();
        }
    }
}
