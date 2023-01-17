package advent;

import java.util.Scanner;

public class Wbaume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Wbaume w = new Wbaume();
        w.baueBaum(sc.nextInt());
        sc.close();
    }

    public void baueBaum(int n) {
        for (int i = 0; i <= n - 2; i++) {
            System.out.print(" ");
        }
        System.out.println("XX");

        for (int i = 2; i <= n + 1; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i - 1; j++) {
                System.out.print("/");
            }

            for (int j = 1; j <= i - 1; j++) {
                System.out.print("\\");
            }

            System.out.println("");
        }

        for (int i = 0; i <= n - 2; i++) {
            System.out.print(" ");
        }
        System.out.println("||");
    }
}
