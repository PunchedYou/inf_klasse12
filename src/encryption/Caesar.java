package encryption;

public class Caesar {

    // Verschiebung von Zeichen um den Wert a

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
        } else {
            return (char) (x + c + b); // Entschlüsselung
        }

    }

    /**
     * Caesar Ver- und Entschluesselung
     * k = klartext
     * s = schluessel
     * c = chiffre
     */
    public String caesarEncrypt(String k, int x) {
        String c = "";

        for (int i = 0; i < k.length(); i++) {
            c += shiftCharacter(k.charAt(i), x);
        }

        return c;
    }

    private char maxCharacter(String c) {
        c = c.toUpperCase();
        c = c.replaceAll(" ", "");
        int maxh = 0;
        char maxb = ' ';

        for (int i = 65; i < 91; i++) {
            char b = (char) i;
            int h = 0;

            for (int j = 0; j < c.length(); j++) {
                if (c.charAt(j) == b) {
                    h++;
                }
            }

            if (h > maxh) {
                maxh = h;
                maxb = b;
            }
        }

        return maxb;
    }

    public String textDecrypt(String c) {
        char b = maxCharacter(c);
        return caesarEncrypt(c, (69 - b));
    }
}