public class Sotieren {
    public String buchstabenSotieren(char a, char b, char c) {
        String s = "";

        if (a > b) {
            if (a > c) {
                if (b > c) {
                    s += (char) c + (char) b + (char) a;
                } else {
                    s += (char) b + (char) c + (char) a;
                }
            } else {
                s += (char) b + (char) a + (char) c;
            }
        } else {
            if (b > c) {
                if (a > c) {
                    s += (char) c + (char) a + (char) b;
                } else {
                    s += (char) a + (char) c + (char) b;
                }
            } else {
                s += (char) a + (char) b + (char) c;
            }
        }

        return s;
    }

    private boolean überprüfeZahl(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void gebePrimzahlenAus(int x) {
        int c = 0;

        for (int i = 2; i <= x; i++) {
            if (überprüfeZahl(i)) {
                System.out.println(i);
                c++;
            }
        }

        System.out.println();
        System.out.println("Bis " + x + " gibt es " + c + " Primzahlen.");
    }
}
