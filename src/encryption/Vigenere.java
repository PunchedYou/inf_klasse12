package encryption;

public class Vigenere {
    Caesar caesar = new Caesar();

    // Vigenere Ver- und Entschluesselung
    public String vigenereEncrypt(String k, String s) {
        s = s.toUpperCase();
        k = k.replaceAll(" ", "");
        s = s.replaceAll(" ", "");
        String c = "";

        for (int i = 0, a = 0; i < k.length(); i++, a++) {
            if (a == s.length()) {
                a = 0;
            }
            c += caesar.shiftCharacter(k.charAt(i), s.charAt(a) - 65);
        }

        return c;
    }

    public String vigenereDecrypt(String k, String s) {
        s = s.toUpperCase();
        k = k.replaceAll(" ", "");
        s = s.replaceAll(" ", "");
        String c = "";

        for (int i = 0, a = 0; i < k.length(); i++, a++) {
            if (a == s.length()) {
                a = 0;
            }
            c += caesar.shiftCharacter(k.charAt(i), -(s.charAt(a)) + 65);
        }

        return c;
    }
}
