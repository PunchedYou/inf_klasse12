import java.util.Scanner;

public class CharShift {
    String k = "";

    public CharShift() {
        k = " ";
        Scanner sc = new Scanner(System.in);
        while (!k.equals("")) {
            k = sc.nextLine();
            System.out.println(decryptMessage());
        }
        sc.close();
    }

    public static void main(String[] args) {
        CharShift cs = new CharShift();
        cs.decryptMessage();
    }

    public String decryptMessage() {
        String c = "";
        int offset = 0;
        System.out.println("   " + offset);
        for (int i = 0; i < k.length(); i++) {
            c += "" + shiftCharacter(k.charAt(i), offset);
            offset = k.charAt(i) * 2;
            System.out.println(k.charAt(i) + "  " + offset);
        }
        return c;
    }

    public char shiftCharacter(char c, int x) {
        int b = 0;

        if (c > 96 && c < 123) { // Kleinbuchstaben (97-122)
            if (c + x > 122 || c + x < 97) {
                b = 26;
            }
        } else if (c > 64 && c < 91) { // Großbuchstaben (65-90)
            if (c + x > 90 || c + x < 65) {
                b = 26;
            }
        } else { // Andere Symbole
            return c;
        }

        if (x >= 0) {
            return (char) (x + c - b); // Verschlüsselung
        } else if (x <= 0) {
            return (char) (x + c + b); // Entschlüsselung
        } else {
            return c;
        }
    }
}