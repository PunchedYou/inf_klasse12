public class Pyramiden {
    public static void main(String[] args) {
        Pyramiden p = new Pyramiden();
        p.pyramideSpitzeOben(10);
        System.out.println();
        p.pyramideSpitzeUnten(10);
        System.out.println();
        p.gebeKaroAus(21);
    }

    public void pyramideSpitzeOben(int h) {
        for (int i = 1; i <= h; i++) {
            for (int j = 0; j <= (h - i); j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
                System.out.print(" ");
            }

            System.out.println("");
        }
    }

    public void pyramideSpitzeUnten(int h) {
        for (int i = h; i >= 1; i--) {
            for (int j = 0; j <= (h - i); j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    /*
     * 1 > 1 (+0)
     * 2 > 3 (+1)
     * 3 > 5 (+2)
     * 4 > 7 (+3)
     * 5 > 9 (+4)
     * 6 > 11 (+5)
     * 7 > 13 (+6)
     * 8 > 15 (+7)
     * 9 > 17 (+8) 16/2 > 8 + 1 = 9
     * 10 > 19 (+9) 18/2 > 9 + 1 = 10
     */

    public void gebeKaroAus(int breite) {
        int h = (breite - 3) / 2 + 1;

        pyramideSpitzeOben(h);

        for (int i = 0; i < breite; i++) {
            System.out.print("* ");
        }
        System.out.println();

        pyramideSpitzeUnten(h);
    }
}